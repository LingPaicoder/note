#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

print(abs(-10))
print(abs)

f = abs
print(f)
print(f(-12))

def add(x, y, f):
    return f(x) + f(y)
print(add(-5, 6, abs))

# map
def f(x):
    return x * x

r = map(f, [1, 2, 3, 4, 5])
print(list(r))

print(list(map(str, [1, 2, 3, 4, 5])))

# reduce
from functools import reduce
def add(x, y):
    return x + y
print(reduce(add, [1, 3, 5, 7, 9]))

# filter
print(list(filter(lambda n: n % 2 == 1, [1, 2, 3, 4, 5, 6, 7, 8, 9])))


def _odd_iter():
    n = 1
    while True:
        n = n + 2
        yield n

def _not_divisible(n):
    return lambda x: x % n > 0

def primes():
    yield 2
    it = _odd_iter()
    while True:
        n = next(it)
        yield n
        it = filter(_not_divisible(n), it)

for n in primes():
    if n < 1000:
        print(n)
    else:
        break

# sorted
print(sorted([34, 53, 2, 21, 5]))
print(sorted([23, -3, 53, -123], key=abs))
print(sorted(['bob', 'about', 'Zoo', 'Credit']))
print(sorted(['bob', 'about', 'Zoo', 'Credit'], key = str.lower))
print(sorted(['bob', 'about', 'Zoo', 'Credit'], key = str.lower, reverse = True))

