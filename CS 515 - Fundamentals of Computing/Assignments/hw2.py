# CS 515-B Fundamentals of Computing
# hw2.py submitted by Chaitanya Pawar

def correctName(txt):
    return txt.title()

print("Q1. Write a name correcting function")
print("")
print(correctName('jared bass'))
print(correctName('FRANKLIN SHACK'))
print(correctName('jOE sMITH'))
print("")

def stringShortener(s,n):
    return s[:n]

print("Q2. String Editing")
print("")
print(stringShortener('jared bass', 4))
print(stringShortener('franklin', 100))
print("")

def changeList(L, n):
    lis1 = []
    if(0 <= n <len(L)):
        lis1.append(L[n])
        lis2 = L + lis1
        return lis2
    else: 
        return "index is not in range of list"
print("Q3. List manipulation")
print("")
print(changeList([1,2,3,4,5], 0))