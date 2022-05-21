# Chaitanya Pawar

def divide(a, b):
    try:
        if isinstance(a & b, int):
            return a/b
    except:
        'None'

print(divide(4, 2))
print(divide(4.2, 2))
print(divide(4, 0))