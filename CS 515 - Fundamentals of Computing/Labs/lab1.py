def countWords(L):
    newList = list(map(lambda x:L.count(x),L))
    return newList

print(countWords(['hey', 'hi', 'Mark', 'hi', 'mark']))
print(countWords([1,1,1,1,2]))