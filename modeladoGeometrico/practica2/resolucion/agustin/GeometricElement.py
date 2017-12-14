# -*- coding: iso-8859-1 -*-

from ImageFunc import *
from AffineTransf import *

# Clase GeometricElement - Clase base para figuras geometricas
# --------------------------------------------
class GeometricElement:
    def __init__(self, color):
        self.color = color

    def transform(self, tr):
        pass

    def draw(self, im):
        pass


# Clase Line - Clase que grafica un segmento de recta
# --------------------------------------------
class Line(GeometricElement): 
    def __init__(self, p1, p2, color = (0, 0, 0)): # Punto 1 --- Punto 2
        GeometricElement.__init__(self, color)
        self.p1 = p1
        self.p2 = p2
 
    def clone(self):
        return Line(self.p1, self.p2, self.color)

    def transform(self, tr):
        self.p1 = tr.transform(self.p1)
        self.p2 = tr.transform(self.p2)

    def draw(self, im):
        linea(im, self.p1, self.p2, self.color)


# Clase Circle - Clase que grafica una circunferencia
# --------------------------------------------
class Circle(GeometricElement):
    def __init__(self, c, r, color = (0, 0, 0)): # c es el centro r el radio
        GeometricElement.__init__(self, color)
        self.c = c
        self.r = r
 
    def clone(self):
        return Circle(self.c, self.r, self.color)

    def transform(self, tr):
        self.c = tr.transform(self.c)
        if isinstance(tr, Scale):
            self.r = tr.transform((self.r, self.r))[0]
        elif isinstance(tr, Composite):
            for trans in filter(lambda t: isinstance(t, Scale), tr.composite)[::-1]:
                self.r = trans.transform((self.r, self.r))[0]

    def draw(self, im):
        circulo(im, self.c, self.r, self.color)


# Clase Polygon - Clase que grafica un Poligono
# --------------------------------------------
class Polygon(GeometricElement):
    def __init__(self, e, color = (0, 0, 0), fill = None): # e son los puntos, color el borde y si fill != None lo rellena
        GeometricElement.__init__(self, color)
        self.e = e
        self.fill = fill

    def clone(self):
        return Polygon(self.e, self.color, self.fill)

    def transform(self, tr):
        self.e = map(lambda p : tr.transform(p), self.e)

    def draw(self, im):
        if self.fill != None:
            fillPolygon(im, self.e, self.fill)
        drawPolygon(im, self.e, self.color)


# Clase Scene - Clase modelo de una escena
# es un container de objetos geométricos 
# --------------------------------------------
class Scene(GeometricElement):
    def __init__(self):
        self.scene = []
 
    def add(self, geoElem): # agregar un GeometricElement a la escena
        self.scene.append(geoElem)
 
    def clone(self):
        sc = Scene()
        for geoElem in self.scene:
            sc.add(geoElem.clone())
        return sc

    def transform(self, tr):
        for geoElem in self.scene:
            geoElem.transform(tr)

    def draw(self, im):
        for geoElem in self.scene:
            geoElem.draw(im)

