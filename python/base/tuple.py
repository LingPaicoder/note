#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

classmates = ('Michael', 'Bob', 'Tracy')
print(classmates)

classmates = ()
print(classmates)

# 当元组只有一个元素时，为了与数学公式中的小括号进行区分，元素后面必须加一个逗号
classmates = (1,)
print(classmates)

# python是"按值传递"的，而不是"按引用传递的"
t = ('a', 'b', ['A', 'B'])
print(t)
t[2][0] = 'X'
t[2][1] = 'Y'
print(t)
