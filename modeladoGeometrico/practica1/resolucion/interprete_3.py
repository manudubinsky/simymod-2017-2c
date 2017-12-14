from PIL import Image

rangoX = 512
rangoY = 512

im = Image.new('RGBA', (rangoX, rangoY), (255, 255, 255, 0)) 

swap = lambda x: (x[1], x[0])
sign = lambda x: (1, -1) [x < 0]

def putPixelWithoutError(x, y, color):
    if(1<=x<=rangoX and 1<=y<=rangoY):
        im.putpixel((x, y), color)

class GeometricElement:
    def show(self, im):
        pass

class Line(GeometricElement):
    def __init__(self, x0, y0, x1, y1, color = (0, 0, 0)):
        self.x0 = x0
        self.y0 = y0
        self.x1 = x1
        self.y1 = y1
        self.color = color
    def show(self, im):
        dx = self.x1 - self.x0
        dy = self.y1 - self.y0
        incXi, incYi = sign(dx), sign(dy)
        dx, dy = abs(dx), abs(dy)
        incXr, incYr = 0, 0
        if dx < dy:
            incYr = incYi
            dx, dy = swap((dx, dy))
        else:
            incXr = incXi
        x, y = self.x0, self.y0
        incR = 2 * dy
        inc = incR - dx
        incI = inc - dx
        while x != self.x1 or y != self.y1:
            putPixelWithoutError(x, y, self.color)
            if inc >= 0:
                x += incXi
                y += incYi
                inc += incI
            else:
                x += incXr
                y += incYr
                inc += incR
        putPixelWithoutError(x, y, self.color)
        #im.show(im)


def drawCirc(xc, yc, x, y, color):
    putPixelWithoutError(xc+x, yc+y, color);
    putPixelWithoutError(xc-x, yc+y, color);
    putPixelWithoutError(xc+x, yc-y, color);
    putPixelWithoutError(xc-x, yc-y, color);
    putPixelWithoutError(xc+y, yc+x, color);
    putPixelWithoutError(xc-y, yc+x, color);
    putPixelWithoutError(xc+y, yc-x, color);
    putPixelWithoutError(xc-y, yc-x, color);


class Circle(GeometricElement):
    def __init__(self, xc, yc, ra, color = (0, 0, 0)):
        self.xc = xc
        self.yc = yc
        self.ra = ra
        self.color = color
    def show(self, im):
        x, y = 0, self.ra
        d = 3 - 2 * self.ra
        while y >= x:
            drawCirc(self.xc, self.yc, x, y, self.color)
            x += 1
            if d > 0:
                y -= 1
                d += 4 * (x -y) + 10
            else:
                d += 4 * x + 6
            drawCirc(self.xc, self.yc, x, y, self.color)
        #im.show(im)

class Scene(GeometricElement):
    def __init__(self):
        #myImage = Image.new('RGBA', (500, 500), (255, 255, 255, 0))
        #self.myImage = myImage
        pass
        
    def add (self, geoElem):
        geoElem.show(im)

    def show(self, im):
        im.show(im)
        
global escena

def new():
    global escena
    escena = Scene()
    return "Escena creada con exito"

def line(x0, y0, x1, y1):
    print "holanga"
    global escena
    print "holanga 2"
    lineaNueva = Line(x0, y0, x1, y1)
    print "holanga 3"
    escena.add(lineaNueva)
    print "holanga 4"
    
def circ(cx, cy, r):
    global escena
    circuloNuevo = Circle(cx, cy, r)
    escena.add(circuloNuevo)

def show():
    global escena
    escena.show(im)

while True:
    try:
        cmd = raw_input('>')
        if (cmd == "exit"):
            break
        else:
            print eval(cmd)
    except:
        print "Error"

