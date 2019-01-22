#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

names = ['Michael', 'Bob', 'Tracy']
for name in names:
    print(name)

sum = 0
for i in list(range(101)):
    sum = sum + i
print(sum)

sum = 0
n = 99
while n > 0:
    sum += n
    n -= 2
print(sum)

sum = 0
n = 99
while n > 0:
    sum = sum + n
    n = n - 2
print(sum)

n = 1
while n <= 100:
    print(n)
    n += 1
print('END')

n = 1
while n <= 100:
    if n > 10:
        break
    print(n)
    n += 1
print('END')

n = 0
while n < 10:
    n += 1
    if n % 2 == 0:
       continue 
    print(n)
