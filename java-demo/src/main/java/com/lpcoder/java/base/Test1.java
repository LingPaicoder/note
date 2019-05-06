package com.lpcoder.java.base;

/**
 * @author liurenpeng
 * @date Created in 19-4-11
 */
public class Test1 {

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.print(100);
        System.out.println(apple.name);
        Fruit fruit = apple;
        fruit.print(100);
        System.out.println(fruit.name);

        /**
         * 输出：
         * Apple:100
         * Apple
         * Apple:100
         * Fruit
         */
    }

    public static class Fruit {
        public String name = "Fruit";

        public void print(int num) {
            System.out.println("Fruit:" + num);
        }
    }

    public static class Apple extends Fruit {
        public String name = "Apple";

        @Override
        public void print(int num) {
            System.out.println("Apple:" + num);
        }
    }

}
