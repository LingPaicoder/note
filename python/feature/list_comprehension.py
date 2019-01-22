#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

# 列表生成式
print(list(range(1, 11)))

print([x * x for x in range(1, 11)])

print([x * x for x in range(1, 11) if x % 2 == 0])

print([m + n for m in 'ABC' for n in 'ABC'])

# 列出当前目录下所有的文件和文件名
import os
print([d for d in os.listdir('.')])

d = {'x': 'A', 'y': 'B', 'z': 'C'}
print([k + '=' + v for k, v in d.items()])

L = ['Hello', 'World', 'IBM', 18, 'Apple']
print([s.lower() for s in L if isinstance(s, str)])
