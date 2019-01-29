#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

from hello import Hello
h = Hello()
h.hello()
h.hello('World')
print(type(Hello))
print(type(h))

def fn(self, name = 'world'):
    print('hello, %s.' % name)

MHello = type('MHello', (object,), dict(hello = fn))
mh = MHello()
mh.hello()
mh.hello('World')
print(type(mh))

class ListMetaclass(type):
    def __new__(cls, name, bases, attrs):
        attrs['add'] = lambda self, value: self.append(value)
        return type.__new__(cls, name, bases, attrs)

class MyList(list, metaclass=ListMetaclass):
    pass

L = MyList()
L.add(1)
print(L)

