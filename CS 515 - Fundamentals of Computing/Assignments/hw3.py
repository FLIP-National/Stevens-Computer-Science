# 
# ## CS 515
# ## Homework 3
# 

# ### 1. Conditionals
# 

# (1) Write a function that converts all units of time into seconds.
# The input is a list that indicates [days, hours, minutes, seconds]. 
# The list should at least includes the seconds element, other elements are optional.


def convert_time(alist):
    """
        Functions to converts time into seconds.

        Examples:
            [5]:     5
            [1,5]:     65
            [1,2,3]:    3723

        Returns: converted seconds.
        
        Parameter: a list
        Precondition: a list has at least one element
    """
    if (len(alist) == 1):
        return alist[0] # Prints Seconds
    elif (len(alist) == 2):
        return (alist[0] * 60) + alist[1] # Converts Minutes into seconds
    elif (len(alist) == 3):
        return (alist[0] * 3600) + (alist[1] * 60) + alist[2] # Converts hours into seconds
    elif (len(alist) == 4):
        return (alist[0] * 3600 * 24) + (alist[1] * 3600) + (alist[2] * 60) + alist[3] # Converts days into seconds
    else:
        s = "please enter valid time for conversion"
        return s


# ### 2. Testing
 
# Here is a function that is not working properly due to the special precondition. 
# Please use introcs.assert_equals() to test the result and indicate what is the problem of this function.
# Then, fix the function so it works correctly!!!
# Use introcs.assert_equals() again to make sure the input qualifies the precondition and test your result again. 
# (consider what n.find(' ') will return if the input is invalid)


def last_name_first(n):
    """
        A single, non-working function.

        The function in this module has a bug (in the sense that it does not satisfy its specification). This allows us to show off debugging.

        Returns: copy of n but in the form 'last-name, first-name'

        Parameter n: the person's name
        Precondition: n is in the form 'first-name last-name'
        with one or more blanks between the two names no spaces in <first-name> or <last-name>
    """
    li = n.split(' ')
    # assert len(li) == 2, 'The name is not in the format <first-name last-name>'
    if len(li) != 2:
        return 'The name is not in the format <first-name last-name>'
    end_first = n.find(' ')
    first = n[:end_first]
    last = n[end_first + 1:]

    return last + ', ' + first


# ### 3. Control Flow

# Function sortnum(). 
# This function takes three numbers as input and sorts the number from small to large (ascending order) 
# and returns the numbers. 
# Using only simple variables and if statements, you should be able to get this to work; 
# a loop is not needed (And SHOULD NOT BE USED!).



def sortnum(alist):
    """ 
        Returns: a list contains three numbers in ascending order. 
        Example: 
        >>>sortnum([2,1,3]) 
        >>>[1,2,3]

        Precondition: alist is a list that contains three numbers. 

    """
    alist.sort() # alist.sort(reverse = True) for decending order
    return alist

# ### 4. Challenge

# Write a function to anglicize the integers n where 0<n<1000,
# for example, if the input is 5, the output should be 'five', if the input is 33,
# the output should be 'thirty three'.


def anglicize(n):
    """
        Functions to anglicize integers in the range 1..999

        The primary function in this module is anglicize(). This is a
        great module to help you understand conditions.

        Examples:
            3:      "three"
            45:     "forty five"
            100:    "one hundred"
            127:    "one hunded twenty seven"
        Returns: English equiv of n.

        Parameter: the integer to anglicize
        Precondition: n in 1..999
    """
    if n > 100:
        return anglicize100to999(n)
    elif n > 19:
        return anglicize20to99(n)
    return "" + anglicize1to19(n)


def anglicize1to19(n):
    """
        Returns: English equivalent of n.

        Parameter: the integer to anglicize
        Precondition: n in 1..19
    """
    numbers = ['', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight',
               'nine', 'ten', 'eleven', 'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen']
    return numbers[n]


def anglicize20to99(n):
    """
        Returns: English equiv of n.

        Parameter: the integer to anglicize
        Precondition: n in 20..99
    """

    number=["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"]
    nty=["","","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninty"]

    d=[0,0]
    i=0
    while n>0:
        d[i]=n%10
        i+=1
        n=n//10
    num=""
    if d[1] != 0:
        num += nty[d[1]] + " " + number[d[0]]
    return num


def anglicize100to999(n):
    """
        Returns: English equiv of n.

        Parameter: the integer to anglicize
        Precondition: n in 100..999
    """
    # Anglicize the first three digits

    number=["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"]
    tenss=["Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
    nty=["","","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninty"]

    d=[0,0,0]
    i=0
    while n>0:
        d[i]=n%10
        i+=1
        n=n//10
    num=""
    if d[2]!=0:
        num+=number[d[2]]+" Hundred "
    if d[1] != 0:
        if (d[1] == 1):
            num += tenss[d[0]]
        else:
            num += nty[d[1]] + " " + number[d[0]]
    else:
        if d[0] != 0:
            num += number[d[0]]

    return num


def tens(n):
    """
        Returns: tens-word for n

        Parameter: the integer to anglicize
        Precondition: n in 2..9
    """
    #####Your code refer to anglicize1to19(n) #####
    if n == 0:
        return "zero"
    if n > 10:
        n /= 10
        n = int(n)
        if n % 10 == 0:
            return "zero"
        return anglicize1to19(n % 10)
    else:
        return anglicize1to19(n)

print("Q1. Converting time into seconds")
print(convert_time([5]))
print(convert_time([1,5]))
print(convert_time([1,2,3]))
print("")
print("Q2. Testing")
name = "Chaitanya Pawar"
print(last_name_first(name))
print("")
print("Q3. Control Flow")
print(sortnum([2,1,3]))
print("")
print("Q4. Chellange")
n = 220
print(str(n)+" in words is : "+str(anglicize(n).title()))
print("The number at tens place is : "+str(tens(n).title()))