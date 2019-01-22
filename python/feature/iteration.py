#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

d = {'a': 1, 'b': 2, 'c': 3}
for key in d:
    print(key)

for value in d.values():
    print(value)

for key, value in d.items():
    print('key:', key, 'value:', value)

for char in 'ABC':
    print(char)

from collections import Iterable
print(isinstance('abc', Iterable))
print(isinstance([1, 2, 3], Iterable))
print(isinstance(123, Iterable))

for i, value in enumerate(['a', 'b', 'c']):
    print('i:', i, 'value:', value)

for x, y in [(1, 'a'), (2, 'b'), (3, 'c')]:
    print('x:', x, 'y:', y)
