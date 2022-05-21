# CS 515-B Fundamentals of Computing
# hw7.py submitted by Chaitanya Pawar

import math
import random as r

class Date:
    def __init__(self, m, d, y):
        self.month = m
        self.day = d
        self.year = y
    
    def __str__(self):
        if self.month > 9:
            m = str(self.month)
        else:
            m = "0"+str(self.month)
        if self.day > 9:
            d = str(self.day)
        else:
            d = "0"+str(self.day)
        return m + "/" + d + "/" + str(self.year)
    
    def __eq__(self, other):
        if isinstance(other, Date):
            return self.month == other.month and self.day == other.day and self.year == other.year

        return False
    
    def isLeapYear(self):
        return self.year % 4 == 0 and (self.year % 100 != 0 or self.year % 400 == 0)
    
    def isBefore(self, d2):
        if self.year == d2.year:
            if self.month == d2.month:
                if self.day == d2.day:
                    return False
                elif self.day < d2.day:
                    return True
                elif self.day > d2.day:
                    return False
            elif self.month > d2.month:
                return False
            elif self.month < d2.month:
                return True
        elif self.year > d2.year:
            return False
        elif self.year < d2.year:
            return True
        
        return False

    def tomorrow(self):
        DIM = [0,31,28,31,30,31,30,31,31,30,31,30,31]
        daysForThisMonth = DIM[self.month]

        if self.month == 2 and Date.isLeapYear(self):
            daysForThisMonth = 29
        
        self.day += 1

        if self.day > daysForThisMonth:
            self.month += 1
            self.day = 1
        
        if self.month > 12:
            self.year += 1
            self.month = 1
        
        return self

    def dayOfWeek(self):
        """
        Using Zeller Algorithm... Referred from https://datagenetics.com/blog/november12019/index.html
        used the formula using inbuilt math function
        """
        DOW = ['Saturday', 'Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday']
        m = self.month
        d = self.day
        y = self.year

        # From March to February, change the month to run from 3 to 14 days.
        if m <=2:
            m += 12

        # If it is January or February, change the year.
        if self.month <= 2:
            y -= 1
        
        dow = (d + math.floor((13 * (m + 1)) / 5) + y + math.floor(y / 4) - math.floor(y / 100) + math.floor(y / 400)) % 7

        return DOW[dow]


    def daysApart(self, other):
        DIM = [31,28,31,30,31,30,31,31,30,31,30,31]
        # initializing count using year and day for d1
        a = self.year * 365 + self.day
        #adding days for months in given date
        for i in range(0, self.month - 1):
            a += DIM[i]
        #adding
        a += Date.isLeapYear(self)

        b = other.year * 365 + other.day

        for i in range(0, other.month - 1):
            b += DIM[i]
        
        b += Date.isLeapYear(other)
        
        return abs(b - a)

class QuantumDate(Date):
    def __init__(self, m, d, y):
        super().__init__(m, d, y)
    
    def __str__(self):
        return super().__str__()
    
    def __eq__(self, other):
        return super().__eq__(other)

    def isLeapYear(self):
        return QuantumDate.randomise(self)
    
    def tomorrow(self):
        return self
    
    def dayOfWeek(self):
        return super().dayOfWeek()
    
    def isBefore(self, d2):
        return super().isBefore(d2)
    
    def daysApart(self, other):
        return super().daysApart(other)
    
    def randomise(self):
        self.month = r.randint(1, 12)
        self.day = r.randint(1, 31)
        self.year = r.randint(1900, 2100)
        if self.month == 2 and self.year == Date.isLeapYear:
            self.year = [r.randint(1900, 2100) for i in range(0, 10)]
        
        date = QuantumDate(self.month, self.day, self.year)
        return date
    
print("Q1. Verify the constructor and string methods work")
d = Date(11, 4, 2021)
print(d)
print("")

print("Q2. Create the equal operator")
d1 = Date(1, 1, 2000)
d2 = Date(1, 1, 2000)
d3 = Date(1, 1, 2001)
print(d1 == d2)
print(d1 == d3)
print("")

print("Q3. Write a leap year function")
d1 = Date(1,1,1900)
d2 = Date(1,1,2020)
d3 = Date(1,1,2000)
print(d1.isLeapYear())
print(d2.isLeapYear())
print(d3.isLeapYear())
print("")

print("Q4. Write a before function")
d1 = Date(2,1,2000)
d2 = Date(1,1,2001)
print(d1.isBefore(d2))
print(d2.isBefore(d1))
print(d1.isBefore(d1))
print("")

print("Q5. Write a tomorrow function")
d = Date(12, 30, 2010)
print(d)
print(d.tomorrow())
d = Date(2, 28, 2011)
print(d.tomorrow())
print(d.tomorrow())
print("")

print("Q6. Write a day of the week function")
d = Date(11, 4, 2021)
print(d.dayOfWeek())
print("")

print("Q7. Create a days apart function")
d1 = Date(1, 1, 2021)
d2 = Date(1, 10, 2021)
print(d1.daysApart(d2))
print(d2.daysApart(d1))
print("")

print("Q8. Create a Sub-Class Quantum-Date")
print(QuantumDate.randomise(QuantumDate))
print("")