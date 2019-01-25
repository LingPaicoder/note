#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

print(type(123))
print(type('123'))
print(type(None))
print(type(abs))

import types

def fn():
    pass

print(types.FunctionType == type(fn))
print(types.BuiltinFunctionType == type(abs))
print(types.LambdaType == type(lambda x: x))
print(types.GeneratorType == type((x for x in range(10))))

print(isinstance('a', str))
print(isinstance(b'b', bytes))

print(isinstance([1, 2, 3], (list, tuple)))
print(isinstance((1, 2, 3), (list, tuple)))

print(dir('ABC'))

print(len('ABC'))
print('ABC'.__len__())

class MyDog(object):
    def __len__(self):
        return 100

dog = MyDog()
print(len(dog))

print('ABC'.lower())

