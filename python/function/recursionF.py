#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

def fact(n):
    if n == 1:
        return 1
    return n * fact(n - 1)

n = fact(1)
print(n)
n = fact(5)
print(n)

print(fact(100))
# RecursionError: maximum recursion depth exceeded in comparison
# print(fact(1000))

# 尾递归优化：(Python解释器不支持尾递归优化)
# 尾递归是指，在函数返回的时候，调用自身，并且，return语句不能包含表达式
# 这样，编译器或者解释器就可以把尾递归做优化，使递归本身无论调用多少次，
# 都只占用一个栈帧，不会出现栈溢出的情况
# 另外，尾递归和循环实际上是等价的，没有循环的语言只能通过尾递归实现循环

def fact(n):
    return fact_iter(n, 1)

def fact_iter(num, product):
    if num == 1:
        return product
    return fact_iter(num - 1, num * product)

fact(1000)
