#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

def m_abs(x):
    if not isinstance(x, (int, float)):
        raise TypeError('bad operand type')
    if x >= 0:
        return x
    else:
        return -x

print(m_abs(-1))

def nop():
    pass
nop()

# m_abs('test')

import math
def move(x, y, step, angle=0):
    nx = x + step * math.cos(angle)
    ny = y - step * math.sin(angle)
    return nx, ny

mx, my = move(100, 100, 60, math.pi / 6)
print(mx, my)

mr = move(100, 100, 60, math.pi / 6)
print(mr)
