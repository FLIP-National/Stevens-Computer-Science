# CS 515-B Fundamentals of Computing
# hw4.py submitted by Chaitanya Pawar

# Creating function to calculate sum of elements in array
# Preconditions - an array is passed to find its sum 
def _sumofarr(arr):
    sumofarr = 0
    for i in arr:
        # Adding each elements in array
        sumofarr = sumofarr+i
    return(sumofarr)


""" def dot(L, K):
    return _sumofarr(
        # using zip() to pass iterator of tuples where the first item in each passed iterator 
        # is paired together, and then the second item in each passed iterator are paired together 
        # and so on.
        x*y for x, y in zip(L, K)
    ) """

def dot(L, K):
    if L == [] and K == []:
        return 0
    elif L == []:
        return float('-inf')
    elif K == []:
        return float('-inf')
    else:
        return L[0] * K[0] + dot(L[1:], K[1:])
    

def explode(S):
    # Creating empty string str(i) and using it to strip the string as elements in array
    a = [str(i) for i in S.strip()]
    return a

def index(e, L):
    return indexHelper(e, L, 0)

def indexHelper(e, L, ind):
    if L == []:
        return ind
    elif e == L[0]:
        return ind
    else:
        return indexHelper(e, L[1:], ind+1)

def deepReverse(L):
    # if given list is empty return the list
    if L == []:
        return L
    # avoiding maximum recurssion depth with type(L)
    elif type(L) == int:
        return L
    else:
    # recursively reverisng the list
        return deepReverse(L[1:]) + [deepReverse(L[0])]


print("Q1. Implement the Dot Product")
print(dot([5, 3], [6, 4]))
print("")
print("Q2. Write a String Explosion function")
print(explode('spam'))
print(explode(''))
print("")
print("Q3. Write your own index function")
print()
print(index(42, [ 55, 77, 42, 12, 42, 100 ]))
print(index(42, range(0,100)))
print(index('hi', [ 'hello', 42, True ]))
print(index('hi', [ 'well', 'hi', 'there' ]))
print(index(' ', 'outer exploration'))
print("")
print("Q4. Write a deep reversal function")
print(deepReverse([1, 2, 3]))
print(deepReverse([1, [2, 3], 4]))
print(deepReverse([1, [2, [3, 4], [5, [6, 7], 8]]]))