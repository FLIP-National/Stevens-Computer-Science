# CS 515-B Fundamentals of Computing
# hw8.py submitted by Chaitanya Pawar

import random
import time

def random_numbers_generator(num=1000, min=0, max=10000):
    """
    Returns num of random elements

    Precondition: num, min, max should be int, max should bigger than num

    Example:
    random_numbers_generator(num=3), return [645, 23, 7512]
    random_numbers_generator(num=3, min=0, max=10), return [5, 3, 1]
    random_numbers_generator(num=3, min=5, max=10), return [6, 9, 7]

    """
    random_list = []
    for i in range(0, num):
        n = random.randint(min, max)
        random_list.append(n)
    return random_list

print("Q1. Implement random_numbers_generator")
print(random_numbers_generator(num=3))
print(random_numbers_generator(num=3, min=0, max=10))
print(random_numbers_generator(num=3, min=5, max=10))
print("")

def shuffle_list(a_list):
    random.shuffle(a_list)
    return a_list

def insertion_sort(random_list):
    """
    Returns random_list and sorted_list

    Example: 
    insertion_sort([645, 23, 7512]), return [645,23,7512], [23,645,7512]
    insertion_sort([5, 3, 1]), return [5, 3, 1], [1, 3, 5]
    insertion_sort([6, 9, 7]), return [6, 9, 7], [6, 7, 9]
    
    """
    for i in range(1,len(random_list)):
        a = random_list[i]
        j = i - 1
        while j >= 0 and a < random_list[j]:
            random_list[j+1] = random_list[j]
            j -= 1
        random_list[j + 1] = a
    return random_list


print("Q2. Implement Insertion Sort")
print(insertion_sort([645, 23, 7512]))
print(insertion_sort([5, 3, 1]))
print(insertion_sort([6, 9, 7]))
print("")

def Quick_sort_first(random_list):
    """
    Returns random_list and sorted_list

    Example: 
    Quick_sort_first([645, 23, 7512]), return [645,23,7512], [23,645,7512]
    Quick_sort_first([5, 3, 1]), return [5, 3, 1], [1, 3, 5]
    Quick_sort_first([6, 9, 7]), return [6, 9, 7], [6, 7, 9]
    
    """
    if random_list == []:
        return []
    
    pivot = random_list[0:1]
    left = Quick_sort_first([x for x in random_list[1:] if x < random_list[0]])
    right = Quick_sort_first([x for x in random_list[1:] if x >= random_list[0]])
    return left + pivot + right

print("Q3. Implement Quick Sort First")
print(Quick_sort_first([645, 23, 7512]))
print(Quick_sort_first([5, 3, 1]))
print(Quick_sort_first([6, 9, 7]))
print("")

def Quick_sort_random(random_list):
    """
    Returns random_list and sorted_list

    Example: 
    Quick_sort_random([645, 23, 7512]), return [645,23,7512], [23,645,7512]
    Quick_sort_random([5, 3, 1]), return [5, 3, 1], [1, 3, 5]
    Quick_sort_random([6, 9, 7]), return [6, 9, 7], [6, 7, 9]
    
    """
    def sort(lst, l, r):
        # base case
        if r <= l:
            return

        # choose random pivot
        pivot_index = random.randint(l, r)

        # move pivot to first index
        lst[l], lst[pivot_index] = lst[pivot_index], lst[l]

        # partition
        i = l
        for j in range(l+1, r+1):
            if lst[j] < lst[l]:
                i += 1
                lst[i], lst[j] = lst[j], lst[i]

        # place pivot in proper position
        lst[i], lst[l] = lst[l], lst[i]

        # sort left and right partitions
        sort(lst, l, i-1)
        sort(lst, i+1, r)
    
    if random_list is None or len(random_list) < 2:
        return
    
    sort(random_list, 0 , len(random_list) - 1)

print("Q4. Implement Quick Sort")
print(Quick_sort_first([645, 23, 7512]))
print(Quick_sort_first([5, 3, 1]))
print(Quick_sort_first([6, 9, 7]))
print("")

print("Q.5 Compare three sorting algorithms")
Start = time.time()
Random_list = random_numbers_generator(num=0, max=100000*10)
print('Generating random list, time {}'.format(time.time()- Start))

Start = time.time()
sorted_list = insertion_sort(Random_list)
print('Sort random list by insertion, time {}'.format(time.time()- Start))

Start = time.time()
sorted_list = Quick_sort_first(Random_list)
print('Sort random list by Quick Sort using the first as pivot, time {}'.format(time.time()- Start))

Start = time.time()
print('Sort random list by Quick Sort using a random num as pivot, time {}'.format(time.time()- Start))
print("")