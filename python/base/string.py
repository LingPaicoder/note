#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

# ord(): 获取字符的整数表示
print('ord("A") :', ord('A'))
print('ord("中") :', ord('中'))

# chr(): 把编码转为对应的字符
print('chr(66) :', chr(66))
print('chr(25991) :', chr(25991))

# 如果知道字符的整数编码 还可以用十六进制这么写str
print(r'\u4e2d\u6587 :', '\u4e2d\u6587')

# 以Unicode表示的str通过encode()方法可以编码为指定的bytes
print(r'"ABC".encode("ascii") :', "ABC".encode("ascii"))
print(r'"中文".encode("utf-8") :', "中文".encode("utf-8"))
# 下面的代码会报错
# print(r'"中文".encode("ascii") :', "中文".encode("ascii"))

# decode()方法可以把bytes变为str
print('b\'ABC\'.decode(\'ascii\') :', b'ABC'.decode('ascii'))
print('b\'\\xe4\\xb8\\xad\\xe6\\x96\\x87\'.decode(\'utf-8\') :', b'\xe4\xb8\xad\xe6\x96\x87'.decode('utf-8'))

# len()可计算str的字符数, 如果计算的是bytes,则是字节数
print(len('ABC'))
print(len('中文'.encode('utf-8')))

# str格式化
print('Hello, %s' % 'World')
print('Hi, %s, you have $%d.' % ('Michael', 1000))
print('%2d-%02d' % (3, 1))
print('%.2f' % 3.1415926)
# todo: 这么输出的原因是
print('%.20f' % 3.1415926)
print('growth rate: %d %%' % 7)
