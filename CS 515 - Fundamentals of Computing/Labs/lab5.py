def transpose(l1):
    l1 = [[row[i] for row in l1] for i in range(len(l1[0]))]
    return l1
 
print(transpose([[1,2],[3,4],[5,6]]))