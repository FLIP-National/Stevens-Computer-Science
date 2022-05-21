# CS 515-B Fundamentals of Computing
# hw9.py submitted by Chaitanya Pawar

import math
import numpy as np

def twoMaxes(L):
    twoMaxsList = []
    twoMaxNumbers = np.array(L)
    rowMax = np.amax(twoMaxNumbers, axis = 1)
    columnMax = np.amax(twoMaxNumbers, axis = 0)
    twoMaxsList.append(list(rowMax))
    twoMaxsList.append(list(columnMax))
    return twoMaxsList

print("Q1. The Max of Rows and Columns")
inputList = [[1,2], [3,4]]
L = twoMaxes(inputList)
print(L)
print("")

def dictionaryCollector(L):
    dictCollector = {}
    sumOfIntegers = sum(int(i) for i in L if type(i) == int)
    joinStrings = ''.join(str(i) for i in L if type(i) == str)
    dictCollector = {'int': sumOfIntegers, 'string': joinStrings}
    return dictCollector

print("Q2. Accumulate in a Dictionary")
L = [True, 1, 4, 5, 'hello', 10, '10', 'world']
d = dictionaryCollector(L)
print(d)
print("")

def separateNumbers(L):
    if not L:
        return [], []
    oddNumbers, evenNumbers = separateNumbers(L[1:])
    if L[0] % 2:
        return [[L[0], *oddNumbers], evenNumbers]
    else:
        return [oddNumbers, [L[0], *evenNumbers]]
    

print("Q3. Write a recursive separator")
inputList = [1,2,3,4,5,6,7,8,9,10]
L = separateNumbers(inputList)
print(L)
print("")

class Circle(object):
    def __init__(self, radius):
        self.radius = radius

    def __str__(self):
        return "Radius: " + str(self.radius)
    
    def area(self):
        return math.pi * self.radius * self.radius

class Sphere(Circle):
    def area(self):
        return 4 * math.pi * self.radius ** 2
    
    def volume(self):
        return 4 / 3 * math.pi * self.radius ** 3

print("Q4. Subclases")
c = Circle(3)
s = Sphere(4)
print(c)
print(s)
print(c.area())
print(s.area())
print(s.volume())
print("")

def preciseDivision(a,b):
    try:
        return a / b
    except ZeroDivisionError:
        return float(math.inf)
    except:
        return None

print("Q5. Precise Division function")
a = 22
b = 7
print(preciseDivision(a, b))