#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

# 把一个变量a赋值给另一个变量b
# 实际上是把变量b指向变量a所指向的数据
# 注意:不是指向变量a!
a = 'ABC'
b = a
a = 'XYZ'
print(b)

# 精确除
print('10 / 3 :', 10 / 3)
# 地板除: 只取结果的整数部分
print('10 // 3 :', 10 // 3)


# python中常量用全部大写的变量名表示
# 但这只是约定 无法阻止修改
PI = 3.14
print(PI)
PI = 3
print(PI)
