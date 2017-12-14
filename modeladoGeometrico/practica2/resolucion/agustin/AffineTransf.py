# -*- coding: iso-8859-1 -*-

import math
from MatrixFunc import *

# Clase AffineTransf - Clase base de las transformaciones afines
# --------------------------------------------
class AffineTransf: 
    def __init__(self, matrix):
        self.matrix = matrix

    def rad(self, g): # transforma los grados g en radianes
        return (g % 360) * math.pi / 180

    def grad(self, r): # transforma los radianes r en grados
        return (r % (2 * math.pi)) * 180 / math.pi

    def transform(self, p): # transforma el Point p
        (x, y) = p
        trans = matrix_operate(self.matrix, [x, y, 1])
        return (int(round(trans[0])), int(round(trans[1])))


# Clase Translation - Clase para Traslacion
# --------------------------------------------
class Translation(AffineTransf): 
    def __init__(self, (x, y)): # (x, y) es el offset
        AffineTransf.__init__(self, [[1, 0, x], [0, 1, y], [0, 0, 1]])


# Clase Rotation - Clase para Rotacion
# --------------------------------------------
class Rotation(AffineTransf): 
    def __init__(self, alfa):  # alfa es el ángulo en grados de la rotacion
        omega = self.rad(alfa)
        AffineTransf.__init__(self, [[math.cos(omega), -math.sin(omega), 0], [math.sin(omega), math.cos(omega), 0], [0, 0, 1]])


# Clase Scale - Clase para Escalamiento
# --------------------------------------------
class Scale(AffineTransf):
    def __init__(self, lamda): #lamda es el coeficiente de escalamiento
        AffineTransf.__init__(self, [[lamda, 0, 0], [0, lamda, 0], [0, 0, 1]])


# Clase Composite - Clase que modela un producto de transformaciones
# es un container de AffineTransf
# --------------------------------------------
class Composite(AffineTransf): 
    def __init__(self):
        self.composite = []

    def add(self, trans): # agregar un AffineTransf al container
        self.composite.append(trans)

    def transform(self, p): # aplica las transformaciones al punto p (en orden inverso a como fueron agregadas con "add")
        for trans in self.composite[::-1]:
            p = trans.transform(p)
        return p

