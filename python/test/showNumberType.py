#!/usr/bin/env python3
#-*- coding: utf-8 -*-
__authon__ = 'liurenpeng'

class ShowNumberType(object):
    def __init__(self):
        self.showInt()

    def showInt(self):
        print(u"###显示整型###")
        print(u"十进制的整型")
        print("%-20d,%-20d,%-20d" %(-10000,0,10000))

if __name__ == '__main__':
    showNum = ShowNumberType()
