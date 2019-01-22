#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

L = [x * x for x in range(10)]
print(L)

g = (x * x for x in range(10))
print(g)

print(next(g))
print(next(g))
print(next(g))
print(next(g))
print(next(g))
print(next(g))
print(next(g))
print(next(g))
print(next(g))
print(next(g))

g = (x * x for x in range(10))
for n in g:
    print(n)

def fib(max):
    n, a, b = 0, 0, 1
    while n < max:
        print(b)
        a, b = b, a + b
        n = n + 1
    return 'done'

fib(6)

# 如果一个函数定义中包含yield关键字，那么这个函数就不再是一个普通函数，而是一个generator
def g_fib(max):
    n, a, b = 0, 0, 1
    while n < max:
        yield b
        a, b = b, a + b
        n = n + 1
    return 'done'

f = g_fib
print(f)
f = g_fib(6)
print(f)

def odd():
    print('step 1')
    yield 1
    print('step 2')
    yield 3
    print('step 3')
    yield 5
o = odd()

print(next(o))

for n in g_fib(6):
    print(n)

g = g_fib(6)
while True:
    try:
        x = next(g)
        print('g:', x)
    except StopIteration as e:
        print('Generator return value:', e.value)
        break

# 普通函数和generator函数的区别：
# 普通函数->调用则直接返回结果
# generator函数->'调用'实际返回的是一个generator对象

