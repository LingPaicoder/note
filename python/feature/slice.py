#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

L = ['Michael', 'Sarah', 'Tracy', 'Bob', 'Jack']
print(L[0:3])
print(L[:3])
print(L[-2:])

L = list(range(100))
print(L[:10])
print(L[-10:])

print(L[:10:2])
print(L[::5])

print(L[:])

print((0, 1, 2, 3, 4, 5)[:3])
print('ABCDEFG'[:3])
print('ABCDEFG'[::2])
