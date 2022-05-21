def pad(s, n, ch):
    if len(s) < n:
        temp = ch*(n-len(s))
        s = temp + s
    return s

print(pad('hello', 7, '0'))
print(pad('hello', 3, '0'))