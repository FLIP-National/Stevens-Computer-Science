#Chaitanya Pawar

def selection_sort(L):
    for i in range(len(L)-1):
        min_i = i
        for j in range(i+1, len(L)-1):
            if L[j] < L[min_i]:
                min_i = j
        L[i], L[min_i] = L[min_i], L[i]

L = [3, 1, 41, 59, 26, 53, 59]
print(L)
selection_sort(L)
print(L)