#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

print(list(map(lambda x: x * x, [1, 2, 3, 4, 5])))

f = lambda x : x * x
print(f(3))

def build(x, y):
    return lambda : x * x + y * y
print(build(1, 3))
f = build(1, 3)
print(f())
