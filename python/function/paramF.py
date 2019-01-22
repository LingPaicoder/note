#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

# 1. 位置参数
def power(x):
    return x * x

print(power(3))

# 2. 默认参数
def power(x, n = 2):
    s = 1
    while n > 0:
        n -= 1
        s = s * x
    return s

print(power(3))
print(power(3, 3))

# SyntaxError: non-default argument follows default argument
'''
def tpower(n = 2, x):
    return power(x, n)

print(tpower(3, 2))
'''

def enroll(name, gender, age=5, city='BeiJing'):
    print('name:', name)
    print('gender:', gender)
    print('age:', age)
    print('city:', city)

enroll('Bob', 'M', 3)
enroll('Adam', 'M', city='TianJin')

# 定义默认参数要牢记一点：默认参数必须指向不变对象
# 错误示例
def add_end(L = []):
    L.append('END')
    return L
print(add_end([1, 2, 3]))

print(add_end())
print(add_end())
print(add_end())

def m_add_end(L = None):
    if L is None:
        L = []
    L.append('END')
    return L
print(m_add_end())
print(m_add_end())
print(m_add_end())

# 3. 可变参数
def calc(*numbers):
    sum = 0
    for n in numbers:
        sum = sum + n * n
    return sum
print(calc(1, 2, 3))
nums = [1, 2, 3]
print(calc(*nums))

# 4. 关键字参数
def person(name, age, **kw):
    print('name:', name, 'age:', age, 'other:', kw)

person('Michael', 39)
person('Bob', 23, city='BeiJing', gender='M')
extra = {'city': 'BeiJing', 'job': 'Engineer'}
person('Jack', 32, **extra)

# 5. 命名关键字参数
def person(name, age, *, city, job):
    print(name, age, city, job)

person('Jack', 24, city="BeiJing", job="Engineer")
# TypeError: person() takes 2 positional arguments but 4 were given 
# person('Jack', 24, 'bj', 'enginner')

# 5. 参数组合
# 参数定义的顺序必须是：必选参数、默认参数、可变参数、命名关键字参数、关键字参数
def f1(a, b, c=0, *args, **kw):
    print('a =', a, 'b =', b, 'c =', c, 'args =', args, 'kw =', kw)

def f2(a, b, c=0, *, d, **kw):
    print('a =', a, 'b =', b, 'c =', c, 'd =', d, 'kw =', kw)

f1(1, 2)
f1(1, 2, c = 3)
f1(1, 2, 3, 'a', 'b')
f1(1, 2, 3, 'a', 'b', x = 1)
f2(1, 2, d = 8, ext = None, num = 3)

args = (1, 2, 3, 4)
kw = {'d': 99, 'x': '#'}
f1(*args, **kw)
args = (1, 2, 3)
kw = {'d': 88, 'x': '#'}
f2(*args, **kw)

# 对于任意函数，都可以通过类似func(*args, **kw)的形式调用它，
# 无论它的参数是如何定义的

