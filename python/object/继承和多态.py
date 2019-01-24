#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'
'继承和多态'

class Animal(object):
    def run(self):
        print('Animal is running ...')

class Dog(Animal):
    def run(self):
        print('Dog is running ...')
    def eat(self):
        print('Dog is eating meat ...')

class Cat(Animal):
    pass

dog = Dog()
dog.run()
dog.eat()

print(isinstance(dog, Animal))

def run_twice(animal):
    animal.run()
    animal.run()

run_twice(Animal())
run_twice(Dog())
