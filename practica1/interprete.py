#!/usr/bin/python
# -*- coding: utf-8 -*-

def p(n):
	return n * 2

while True:
	try:
		cmd = raw_input('> ')
		if (cmd == "exit"):
			break
		else:
			print eval(cmd)
	except:
		print "Error"
