#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

ironMam = {'name':'tony', 'age':23, 'gender':'mele'}
print(ironMam)
print(ironMam['name'])

d = {'Michael':95, 'Bob':75, 'Tracy':85}
print(d)
print(d['Bob'])
print('Tom' in d)
print('Bob' in d)
# KeyError
# print(d['Tom'])
print(d.get('Tom'))
print(d.get('Tom', -1))
d.pop('Bob')
print(d)

# ---set
s = set([1, 2, 3])
print(s)
s = set([1, 1, 2, 3])
print(s)
s.add(4)
print(s)
s.remove(4)
print(s)

s1 = set([1, 2, 3])
s2 = set([2, 3, 4])
print(s1 & s2)
print(s1 | s2)

# set 和 dict的key 都只能放不可变对象，如果放入可变对象(例如list)会报错
# TypeError
# s.add([1, 2, 3])

s.add((1, 2, 3))
print(s)
# TypeError
# s.add((4, 5, [6, 7]))
# print(s)
