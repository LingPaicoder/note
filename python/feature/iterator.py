#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

from collections import Iterable
from collections import Iterator

print(isinstance([], Iterable))
print(isinstance([], Iterator))

# Iterable：可迭代对象：可以直接作用于for循环的对象
# Iterator：迭代器：可以被next()函数调用并不断返回下一个值的对象，它表示的是一个惰性计算的队列

# iter()函数可以吧Iterable变成Iterator
print(isinstance(iter([]), Iterator))

