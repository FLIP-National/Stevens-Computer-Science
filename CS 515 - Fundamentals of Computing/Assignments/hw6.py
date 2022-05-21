# CS 515-B Fundamentals of Computing
# hw6.py submitted by Chaitanya Pawar

def spiral(L):
    top = 0
    down = len(L) - 1
    left = 0
    right = len(L[0]) - 1
    result = []
    directonForElements = 0
    while top <= down and left <= right:
        # Getting elements from top-left upto top-right
        if directonForElements == 0:
            for i in range(left, right + 1):
                result.append(L[top][i])
            top += 1

        # Getting elements from top-right upto bottom-right        
        if directonForElements == 1:
            for i in range(top, down + 1):
                result.append(L[i][right])
            right -= 1
        
        # Getting elements from bottom-right upto bottom-left
        if directonForElements == 2:
            for i in range(right, left - 1, -1):
                result.append(L[down][i])
            down -= 1
        
        # Getting elements from bottom-left upto top-left
        if directonForElements == 3:
            for i in range(down, top - 1, -1):
                result.append(L[i][left])
            left += 1
        
        #Setting elements in single list 
        directonForElements = (directonForElements + 1) % 4
    return result

print("Q1. Write a spiral functions")
print(spiral([[1,2],[3,4]]))
print(spiral([[1,2,3],[4,5,6],[7,8,9]]))
print("")

def inverter(D):
    invertedDict = {}
    for key, value in D.items():
        if value in invertedDict:
            invertedDict[value].append(key)
        else:
            invertedDict[value]=[key]
    return invertedDict

print("Q2. Write a Dictionary Inverter")
print(inverter({1:'a', 2:'b', 3:'c'}))
print(inverter({1:'a', 2:'a', 3:'b'}))
print("")

def matrixMultiply(A,B):
    try:
        output = [[sum(a * b for a, b in zip(A_row, B_col))
        for B_col in zip(*B)]
        for A_row in A]

        return output
    except ArithmeticError:
        return "There's an Arithmetic error as dimensions of matrices are incompatible"


print("Q3. Matrix Multiplication")
print(matrixMultiply([[1,2,3],[4,5,6]],[[1,2],[3,4],[5,6]]))
print("")

def twoSum(L,t):
    Li = []
    for a in range(len(L)):
        for b in range(a + 1, len(L)):
            if L[a] + L[b] == t:
                Li.append((L[a],L[b]))
    return Li

print("Q4. Two-Sum")
print(twoSum([1,2,3,4,5], 4))
print(twoSum([1,2,2,3,4,5], 4))
print("")