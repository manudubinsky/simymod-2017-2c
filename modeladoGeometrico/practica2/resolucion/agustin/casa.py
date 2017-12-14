#!/usr/bin/python

from PIL import Image
from AffineTransf import *
from GeometricElement import *

casa = Scene()
casa.add(Polygon([(50, 250), (400, 250), (400, 450), (50, 450)], (0, 0, 0), (200, 200, 200)))
casa.add(Polygon([(225, 100), (40, 250), (410, 250)], (255, 0, 0), (255, 0, 0)))
casa.add(Polygon([(110, 320), (190, 320), (190, 450), (110, 450)], (0, 0, 0), (255, 255, 255)))
casa.add(Polygon([(220, 320), (350, 320), (350, 380), (220, 380)], (0, 0, 0), (0, 200, 180)))
casa.add(Line((275,320), (275,380)))
casa.add(Circle((150, 350), 15, (255, 0, 255)))

casa1 = casa.clone()

img = Image.new('RGBA', (500, 500), (255, 255, 255, 0)) 
casa.draw(img)
img.show()

sa = Scale(.5)
img = Image.new('RGBA', (500, 500), (255, 255, 255, 0)) 
casa.transform(sa)
casa.draw(img)
img.show()

tr = Translation((200, 200))
img = Image.new('RGBA', (500, 500), (255, 255, 255, 0)) 
casa.transform(tr)
casa.draw(img)
img.show()

co = Composite()
co.add(Translation((-100, -100)))
co.add(Rotation(-20))
img = Image.new('RGBA', (500, 500), (255, 255, 255, 0)) 
casa.transform(co)
casa.draw(img)
img.show()  

co = Composite()
co.add(Scale((1.5)))
co.add(Translation((200, -100)))
co.add(Rotation(30)) 

img = Image.new('RGBA', (750, 750), (230, 230, 230, 0)) 
casa1.transform(co)
casa1.draw(img)
img.show()

img = Image.new('RGBA', (750, 750), (230, 230, 230, 0)) 
casa1.transform(co)
casa1.draw(img)
img.show()
