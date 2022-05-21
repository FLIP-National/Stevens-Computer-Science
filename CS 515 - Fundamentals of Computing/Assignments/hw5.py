# CS 515-B Fundamentals of Computing
# hw4.py submitted by Chaitanya Pawar
import numpy as np

def runningAverage(L):
    i = 1
    avg = []
    cum_sum = np.cumsum(L)
    while i <= len(L):
        win_avg = round(cum_sum[i-1] / i, 2)
        avg.append(win_avg)
        i += 1
    return avg


print("Q1. Calculate the running average")
print(runningAverage([1, 2, 3, 4, 5]))
print("")


def customFilter(f, L):
    return [x for x in L if f(x)]


def customMap(f, *L):
    result = []
    if len(L) > 0:
        minl = min(len(subseq) for subseq in L)
        for i in range(minl):
            result.append(f(*[subseq[i] for subseq in L]))
    return result

def double(n):
    return 2 * n

def isEven(n):
    return n % 2 == 0

print("Q2. Recreate map and filter")
print(customMap(double, [1,2,3]))
print(customFilter(isEven,[1,2,3]))
print("")

def removeAdjDuplicates(L):
  a = []
  for item in L:
    if len(a):
      if a[-1] != item:
        a.append(item)
    else: a.append(item)        
  return a

print("Q3. Remove Adjacent Duplicates")
print(removeAdjDuplicates([1,1,2,3,4,1,5,5,5,5,5]))
print("")

def flatten(L):
    flat = []
    while L:
        e = L.pop()
        if type(e) == list:
            L.extend(e)
        else:
            flat.append(e)
    flat.sort()
    return flat

print("Q4. Flatten")
print(flatten([1,2,[3,4],5,[6,[7,8]]]))