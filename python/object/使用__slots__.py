#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

class Student(object):
    pass

s = Student()
s.name = 'Michael'
print(s.name)

def set_age(self, age):
    self.age = age

# 给实例绑定方法
from types import MethodType
s.set_age = MethodType(set_age, s)
s.set_age(23)
print(s.age)

s2 = Student()
# 失败
# s2.set_age(25)

# 给Class绑定方法
def set_score(self, score):
    self.score = score

Student.set_score = set_score
s2.set_score(199)
print(s2.score)

class Student(object):
    __slots__ = ('name', 'age') # 用tuple定义允许绑定的属性名称

s = Student()
s.name = 'Michael'
print(s.name)
s.age = 3
print(s.age)
# s.score = 100
# print(s.score)

# __slots__只对当前类起作用，对子类无效
# 除非在子类中也定义__slots__，这样，子类实例允许定义的属性就是自身的__slots__加上父类的__slots__
class GranduateStudent(Student):
    pass

g = GranduateStudent()
g.score = 100
print(g.score)
