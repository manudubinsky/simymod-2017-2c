
from sys import maxint

swap = lambda x: (x[1], x[0])
sign = lambda x: (1, -1) [x < 0]

class Arista:
    def __init__(self, yMax, xYmin, mi):
        self.yMax = yMax
        self.xYmin = xYmin
        self.mi = mi
        self.str = "Arista (yMax:%s xYmin:%s mi:%s)" % (self.yMax, self.xYmin, self.mi)
    def __repr__(self):
        return self.str
    def __str__(self):
        return self.str
    def updateXYmin(self):
        self.xYmin += self.mi

def putPixelWithoutError(im, (x, y), color):
    (w_size, h_size) = im.size
    if(0 <= x < w_size and 0 <= y < h_size):
        im.putpixel((x, y), color)

def linea(im, (x1, y1), (x2, y2), color = (0, 0, 0)):
    dx, dy = x2 - x1, y2 - y1
    incXi, incYi = sign(dx), sign(dy)
    dx, dy = abs(dx), abs(dy)
    incXr, incYr = 0, 0
    if dx < dy:
        incYr = incYi
        dx, dy = swap((dx, dy))
    else:
        incXr = incXi
    x, y = x1, y1
    incR = 2 * dy
    inc = incR - dx
    incI = inc - dx
    while x != x2 or y != y2:
        putPixelWithoutError(im, (x, y), color)
        if inc >= 0:
            x += incXi
            y += incYi
            inc += incI
        else:
            x += incXr
            y += incYr
            inc += incR
    putPixelWithoutError(im, (x, y), color)

def drawCirc(im, (xc, yc), x, y, color):
    putPixelWithoutError(im, (xc+x, yc+y), color)
    putPixelWithoutError(im, (xc-x, yc+y), color)
    putPixelWithoutError(im, (xc+x, yc-y), color)
    putPixelWithoutError(im, (xc-x, yc-y), color)
    putPixelWithoutError(im, (xc+y, yc+x), color)
    putPixelWithoutError(im, (xc-y, yc+x), color)
    putPixelWithoutError(im, (xc+y, yc-x), color)
    putPixelWithoutError(im, (xc-y, yc-x), color)

def circulo(im, c, ra, color = (0, 0, 0)):
    x, y = 0, ra
    d = 3 - 2 * ra
    while y >= x:
        drawCirc(im, c, x, y, color)
        x += 1
        if d > 0:
            y -= 1
            d += 4 * (x -y) + 10
        else:
            d += 4 * x + 6
        drawCirc(im, c, x, y, color)

def drawPolygon(im, pu, color = (0, 0, 0)):
    for p1, p2 in zip(pu[:], pu[1::] + pu[:1:]):
        linea(im, p1, p2, color)


def fillPolygon(im, pu, color = (0, 0, 0)):
    activos = []
    aristas = {}
    for (x1, y1), (x2, y2) in zip(pu[:], pu[1::] + pu[:1:]):
        if y2 != y1:
            mi = (x2 - x1) / ((y2 - y1) * 1.0) if x2 != x1 else 0.0
            if y1 > y2:
                li = y2
                ar = Arista(y1, x2, mi)
            else:
                li = y1
                ar = Arista(y2, x1, mi)
            if li not in aristas:
                aristas[li] = []
            aristas[li].append(ar)
    (w_size, h_size) = im.size
    for li in range (min(aristas), h_size):
        if li in aristas:
            for bk in aristas[li]:
                activos.append(Arista(bk.yMax, bk.xYmin, bk.mi))
        activos[:] = sorted([bk for bk in activos if not bk.yMax == li], key = lambda ar: ar.xYmin)
        x1 = -maxint
        x2 = -maxint
        ymax1 = 0
        ymax2 = 0
        count = 0
        fill = False;
        for ar in activos:
            if count % 2 == 0:
                x1 = int(round(ar.xYmin))
                ymax1 = ar.yMax
                if x1 == x2:
                    if (x1 == ymax1 and x2 != ymax2) or (x1 != ymax1 and x2 == ymax2):
                        x2 = x1
                        ymax2 = ymax1
                    else:
                        count += 1
                else:
                    count += 1
            else:
                x2 = int(round(ar.xYmin))
                ymax2 = ar.yMax
                fill = False;
                if x1 == x2:
                    if (x1 == ymax1 and x2 != ymax2) or (x1 != ymax1 and x2 == ymax2):
                        x2 = x1
                        ymax2 = ymax1
                    else:
                        fill = True
                        count += 1
                else:
                    fill = True
                    count += 1
                if fill:
                    linea(im, (x1, li), (x2, li), color)
            ar.updateXYmin()
