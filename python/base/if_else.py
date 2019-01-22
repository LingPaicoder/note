#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

age = 3
if age >= 18:
    print('your age is ', age)
    print('adult')
else:
    print('your age is ', age)
    print('teenager')

age = 3
if age >= 18:
    print('adult')
elif age > 6:
    print('teenager')
else:
    print('kid')

x = []
if x:
    print('x has element')
else:
    print('x not have element')

birthStr = input('birth:')
birth = int(birthStr)
if birth < 2000:
    print('00前')
else:
    print('00后')
