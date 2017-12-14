from PIL import Image
import math

#Tamanio de la imagen
rangoX = 650
rangoY = 650

im = Image.new('RGBA', (rangoX, rangoY), (255, 255, 255, 0)) 

swap = lambda x: (x[1], x[0])
sign = lambda x: (1, -1) [x < 0]

#funcion que pone el pixel y verifica que no esta afuera del rango
def putPixelWithoutError(x, y, color):
    if(0<=x<rangoX and 0<=y<rangoY):
        im.putpixel((x, y), color)

#Coloca el pixel sin transformar y ademas hace las transformaciones a ese pixel y luego lo coloca transformado
def putPixelTransform(atc, x, y, color):
    putPixelWithoutError(x, y, color)
    puntoATransformar=[x,y]
    puntoTransformado = atc.transform(puntoATransformar)
    putPixelWithoutError(puntoTransformado[0], puntoTransformado[1], color)


class GeometricElement:
    def show(self, im):
        pass

#La clase linea es la unica que admite las transformaciones (por ahora)
class Line(GeometricElement):
    def __init__(self, x0, y0, x1, y1, atc, color = (0, 0, 0)):
        self.x0 = x0
        self.y0 = y0
        self.x1 = x1
        self.y1 = y1
        self.color = color
        self.atc = atc
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
            putPixelTransform(self.atc, x, y, self.color)
            if inc >= 0:
                x += incXi
                y += incYi
                inc += incI
            else:
                x += incXr
                y += incYr
                inc += incR
        putPixelTransform(self.atc, x, y, self.color)
        #im.show(im)


def drawCirc(xc, yc, x, y, color, atc):
    putPixelTransform(atc, xc+x, yc+y, color)
    putPixelTransform(atc, xc-x, yc+y, color)
    putPixelTransform(atc, xc+x, yc-y, color)
    putPixelTransform(atc, xc-x, yc-y, color)
    putPixelTransform(atc, xc+y, yc+x, color)
    putPixelTransform(atc, xc-y, yc+x, color)
    putPixelTransform(atc, xc+y, yc-x, color)
    putPixelTransform(atc, xc-y, yc-x, color)


class Circle(GeometricElement):
    def __init__(self, xc, yc, ra, atc,color = (0, 0, 0)):
        self.xc = xc
        self.yc = yc
        self.ra = ra
        self.color = color
        self.atc = atc
    def show(self, im):
        x, y = 0, self.ra
        d = 3 - 2 * self.ra
        while y >= x:
            drawCirc(self.xc, self.yc, x, y, self.color, self.atc)
            x += 1
            if d > 0:
                y -= 1
                d += 4 * (x -y) + 10
            else:
                d += 4 * x + 6
            drawCirc(self.xc, self.yc, x, y, self.color, self.atc)
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

def line(x0, y0, x1, y1, atc):
    global escena
    lineaNueva = Line(x0, y0, x1, y1, atc)
    escena.add(lineaNueva)
    
def circ(cx, cy, r, atc):
    global escena
    circuloNuevo = Circle(cx, cy, r, atc)
    escena.add(circuloNuevo)

def show():
    global escena
    escena.show(im)

#Funcion para crear cuadrados
#x0 y0 es el vertice superior izquierdo, x1 y1 es el vertice inferior derecho
def cuadrado(x0,y0,x1,y1, atc):
    #Los nombro distinto para no perderme
    a=x0
    b=y0
    c=x1
    d=y1
    line(a,b,c,b, atc)
    line(a,b,a,d, atc)
    line(a,d,c,d, atc)
    line(c,b,c,d, atc)

#//////////////////////////////////////////////////////////////////////////////////////////
#Matrices

def creaMatriz(n,m):
    matriz = []
    for i in range(n):
        a = [0]*m
        matriz.append(a)
    return matriz

def dibujaMatriz(M):
    for i in range(len(M)):
        print '[',
        for j in range(len(M[i])):
            print '{:>3s}'.format(str(M[i][j])),
        print ']'

#Entra matriz A nxm y B mxk
#Sale matriz C nxk
def productoMatrices(A,B):
    fila_A = len(A)
    columna_A = len(A[0])
    fila_B = len(B)
    columna_B = len (B[0])
    
    #Verifica si nxm mxk (m==m)
    if columna_A != fila_B:
        print ('None')
        return
    
    #Se crea matriz nxk
    C = creaMatriz(fila_A, columna_B)
    fila_C = len(C)
    columna_C = len(C[0])

    #Se rellena la matriz del producto de A y B
    for i in range(fila_C):
        for j in range(columna_C):
            for k in range(columna_A):
                C[i][j] += A[i][k]*B[k][j]
    return C

     
#//////////////////ejercicio2///////////////////////////////////////////


def transformGradosARadianes(grados):
    radianes=((grados%360) * math.pi / 180)
    return radianes

class AffineTransf: # clase base de las transformaciones afines
    def transform(self, p): # transforma el Point p
        pass

class Translation(AffineTransf):
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def transform(self, p):
        resultante = [[p[0]+self.x], [p[1]+self.y], [1]]
        print ("Matriz resultante: ", resultante)
        print("Dibujada: ")
        dibujaMatriz(resultante)
        return resultante

def redondearMatriz(matriz):
    fila_M = len(matriz)
    columna_M = len(matriz[0])
    for i in range(fila_M):
        for j in range(columna_M):
            if(matriz[i][j] < 0):
                matriz[i][j]=-1*matriz[i][j]
            matriz[i][j]=int(round(matriz[i][j]))
    return matriz

class Rotation(AffineTransf):
    def __init__(self, omega):
        self.omega = omega #omega es el angulo en grados
    def transform(self, p):
        omegaEnRadianes = transformGradosARadianes(self.omega)
        rotacionA = [[math.cos(omegaEnRadianes), -math.sin(omegaEnRadianes), 0], [math.sin(omegaEnRadianes), math.cos(omegaEnRadianes), 0], [0, 0, 1]]
        puntoActual = [[p[0]], [p[1]], [1]]
        resultante=redondearMatriz(productoMatrices(rotacionA, puntoActual))
        print ("Matriz resultante: ", resultante)
        print("Dibujada: ")
        dibujaMatriz(resultante)
        return resultante

class Scale(AffineTransf):
    def __init__(self, lamda):
        self.lamda = lamda #lamda es el coeficiente de escalamiento
    def transform(self, p):
        escalarA = [[self.lamda, 0, 0], [0, self.lamda, 0], [0, 0, 1]]
        puntoActual = [[p[0]], [p[1]], [1]]
        resultante=productoMatrices(escalarA, puntoActual)
        print ("Matriz resultante: ", resultante)
        print("Dibujada: ")
        dibujaMatriz(resultante)
        return resultante

class AffineTransfComposite(AffineTransf): # modela un producto de transformaciones: es un container de AffineTransf
    def __init__(self):
        self.listaTransformaciones=[]
        self.posicion=0
    def add(self, trans): # agregar un AffineTransf al container
        self.listaTransformaciones.append(trans)
        self.posicion=self.posicion + 1
    def transform(self, p):
        for i in range(len(self.listaTransformaciones)):
            matrizNueva=self.listaTransformaciones[i].transform(p)
            p=[matrizNueva[0][0],matrizNueva[1][0]]
        return p


#///////////////////////////////////////////////////////////////////////////////////////////////


#///////////////////////////////////////////////////////////////////////////////////////////////
comp = AffineTransfComposite()
trans = Translation(50,50) # Traslado x e y
rot = Rotation(75) # Quiero rotarlo x grados
scal = Scale(2) # Quiero escalarlo por x
comp.add(trans)
comp.add(rot)
comp.add(scal)
new()
circ(200,80,10,comp)
cuadrado(100,100,300,250,comp)
line(100,100,200,50,comp)
line(200,50,300,100,comp)
show()

#///////////////////////////////////////////////////////////////////////////////////////////////

"""while True:
    try:
        cmd = raw_input('>')
        if (cmd == "exit"):
            break
        else:
            print eval(cmd)
    except:
        print "Error"
        """
        
