#Guangyu Yan
#CSCI1913
#SPRING 2018
#LAB01

import math
import types

#Part1 Representation

def left(e):
    return e[0]
def op(e):
    return e[1]
def right(e):
    return e[2]


#Part 2 Implementation
def isInside(a,b):
    if type(b) == tuple:
        return isInside(a,right(b)) or isInside(a,left(b))
    else:
        return b == a
def solving(a,c):
    if a == left(c):
        return c
    else:
        if op(left(c)) == "/":
            return solvingDivide(a,c)
        elif op(left(c)) == "*":
            return solvingMultiply(a,c)
        elif op(left(c)) == "+":
            return solvingAdd(a,c)
        elif op(left(c)) == "-":
            return solvingSubtract(a,c)
        else:
            return None
#Operators
#+
def solvingAdd(a,c):
    l = left(c)
    r = right(c)
    if isInside(a,left(l)):
        newc = (left(l), "=", (r,"-",right(l)))
    else:
        newc = (right(l),"=", (r,"-",left(l)))
    return solving(a,newc)
#-
def solvingSubtract(a,c):
    l = left(c)
    r = right(c)
    if isInside(a,left(l)):
        newc = (left(l), "=", (r,"+",right(l)))
    else:
        newc = (right(l),"=",(r,"+",left(l)))
    return solving(a,newc)
#*
def solvingMultiply(a,c):
    l = left(c)
    r = right(c)
    if isInside(a,left(l)):
        newc = (left(l), "=", (r,"/",right(l)))
    else:
        newc = (right(l),"=",(r,"/",left(l)))
    return solving(a,newc)
#/
def solvingDivide(a,c):
    l = left(c)
    r = right(c)
    if isInside(a,left(l)):
        newc = (left(l), "=", (r,"*",right(l)))
    else:
        newc = (right(l),"=",(r,"*",left(l)))
    return solving(a,newc)
                
#Solving Part
def solve(a,c):
    if isInside(a, right(c)):
        return solving(a,(right(c),op(c),left(c)))
    elif isInside(a,left(c)):
        return solving(a,c)
    else:
        return None

#Test case
#
#  TESTS. Test the equation solver for CSci 1913 Lab 1.
#
#    James Moen
#    22 Jan 17
#
#  Every test is followed by a comment which shows what must be printed if your
#  code works correctly. It also shows how many points the test is worth, for a
#  total of 35 possible points.
#

print(isInside('x', 'x'))                          #  True   1 point
print(isInside('x', 'y'))                          #  False  1 point
print(isInside('x', ('x', '+', 'y')))              #  True   2 points
print(isInside('x', ('a', '+', 'b')))              #  False  2 points
print(isInside('+', ('a', '+', 'b')))              #  False  2 points
print(isInside('x', (('m', '*', 'x'), '+', 'b')))  #  True   2 points

print(solve('x', (('a', '+', 'x'), '=', 'c')))
#  ('x', '=', ('c', '-', 'a'))  2 points

print(solve('x', (('x', '+', 'b'), '=', 'c')))
#  ('x', '=', ('c', '-', 'b'))  2 points

print(solve('x', (('a', '-', 'x'), '=', 'c')))
#  ('x', '=', ('a', '-', 'c'))  2 points

print(solve('x', (('x', '-', 'b'), '=', 'c')))
#  ('x', '=', ('c', '+', 'b'))  2 points

print(solve('x', (('a', '*', 'x'), '=', 'c')))
#  ('x', '=', ('c', '/', 'a'))  2 points

print(solve('x', (('x', '*', 'b'), '=', 'c')))
#  ('x', '=', ('c', '/', 'b'))  2 points

print(solve('x', (('a', '/', 'x'), '=', 'c')))
#  ('x', '=', ('a', '/', 'c'))  2 points

print(solve('x', (('x', '/', 'b'), '=', 'c')))
#  ('x', '=', ('c', '*', 'b'))  2 points

print(solve('y', ('y', '=', (('m', '*', 'x'), '+', 'b'))))
# ('y', '=', (('m', '*', 'x'), '+', 'b'))  2 points

print(solve('x', ('y', '=', (('m', '*', 'x'), '+', 'b'))))
# ('x', '=', (('y', '-', 'b'), '/', 'm'))  2 points

print(solve('a', (('b', '+', 'c'), '=', ('d', '*', (('a', '/', 'e'), '-', 'f')))))
# ('a', '=', (((('b', '+', 'c'), '/', 'd'), '+', 'f'), '*', 'e'))  5 points


#my Result:
##============== RESTART: /Users/christasen/Desktop/1913_lab1.py ==============
##True
##False
##True
##False
##False
##True
##('x', '=', ('c', '-', 'a'))
##('x', '=', ('c', '-', 'b'))
##('x', '=', ('c', '+', 'a'))
##('x', '=', ('c', '+', 'b'))
##('x', '=', ('c', '/', 'a'))
##('x', '=', ('c', '/', 'b'))
##('x', '=', ('c', '*', 'a'))
##('x', '=', ('c', '*', 'b'))
##('y', '=', (('m', '*', 'x'), '+', 'b'))
##('x', '=', (('y', '-', 'b'), '/', 'm'))
##('a', '=', (((('b', '+', 'c'), '/', 'd'), '+', 'f'), '*', 'e'))
