#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

classmates = ['Michael', 'Bob', 'Tracy']
print(classmates)
print(len(classmates))
print(classmates[0])
print(classmates[-1])

classmates.append('Adam')
print(classmates)

classmates.insert(1, 'Jack')
print(classmates)

classmates.pop()
print(classmates)

classmates[1] = 'Sarah'
print(classmates)

L = ['Apple', 123, True]
print(L)

s = ['python', 'java', ['asp', 'php'], 'schema']
print(s)
print(len(s))
print(s[2][1])

s = []
print(len(s))
