#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

class Student(object):
    name = 'student'
    def __init__(self, name):
        self.name = name

s = Student('Bob')
s.score = 90

print(s.score)
print(s.name)
print(Student('Temp').name)
print(Student.name)

del s.name
print(s.name)
