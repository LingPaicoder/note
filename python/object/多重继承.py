#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

class Animal(object):
    pass

class Mammal(Animal):
    pass

class Bird(Animal):
    pass

# -----
class Runnalbe(object):
    def run(self):
        print('Running...')

class Flyable(object):
    def fly(self):
        print('Flying...')

# -----

class Dog(Mammal, Runnalbe):
    pass

class Bat(Mammal, Flyable):
    pass

class Parrot(Bird, Flyable):
    pass

class Ostrich(Bird, Runnalbe):
    pass


dog = Dog()
dog.run()
bat = Bat()
bat.fly()
