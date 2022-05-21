# CS 515-B Fundamentals of Computing
# HW1.py submitted by Chaitanya Pawar

from cs515 import filter

# Temperature Conversion functions
def cToF(t):
    return (t * 9/5) + 32

def fToC(t):
    return (t - 32) * 5/9

# Arithmetic Operations
def addTwoNumbers(a,b):
    return a + b

def multiplyTwoNumbers(a,b):
    return a * b

def calculate(a):
    return (a * a) + 2

# Strings Filter
def longStrings(L):
    return filter(lambda x : len(x) > 5 , L)

def doubleStrings(L):
    return [ele + ele for ele in L]

print("Q1. Write temperature converting functions")
print(cToF(54))
print(fToC(54))
print("")
print("Q2. Write a series of Mathematical Functions for addition and multiplication")
print("")
print(addTwoNumbers(2, 4))
print(multiplyTwoNumbers(2, 4))
print(calculate(2))
print("")
print("Q3. Test out map() and filter()")
print("")
print("using list L = ['a','b','abcde', 'abcdef'] for longStrings(L) function")
print(longStrings(['a','b','abcde', 'abcdef']))
print("")
print("using list L = ['a','b','cc'] for doubleStrings(L) function")
print(doubleStrings(['a','b','cc']))
print("")
print("End of Program...")