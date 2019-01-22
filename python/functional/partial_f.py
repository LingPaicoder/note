#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

print(int('12345'))

print(int('12345', base=8))

print(int('12345', base=16))

def int2(x, base = 2):
    return int(x, base)

print(int2('1000000'))

# 偏函数
import functools
int2 = functools.partial(int, base = 2)
print(int2('1010101'))
print(int2('12345', base=10))

# 当函数的参数个数太多，需要简化时，使用functools.partial可以创建一个新的函数，
# 这个新函数可以固定住原函数的部分参数，从而在调用时更简单。
