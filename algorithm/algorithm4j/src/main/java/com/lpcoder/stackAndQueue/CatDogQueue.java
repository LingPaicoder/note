package com.lpcoder.stackAndQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liurenpeng
 * @date Created in 19-2-12
 */
public class CatDogQueue {

    private List<Pet> pets;
    private Queue<Dog> dogs;
    private Queue<Cat> cats;

    public CatDogQueue() {
        pets = new LinkedList<>();
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }

    public static void main(String[] args) {
        CatDogQueue queue = new CatDogQueue();
        queue.add(new Dog());
        queue.add(new Dog());
        queue.add(new Cat());
        queue.add(new Dog());
        queue.add(new Cat());
        System.out.println("---debug start---");
        System.out.println(queue.pets);
        System.out.println("---debug end---");

        //queue.pollAll();

        /*queue.pollDog();
        System.out.println(queue.pets);*/

        queue.pollCat();
        System.out.println(queue.pets);

        System.out.println(queue.isEmpty());
        System.out.println(queue.isCatEmpty());
        System.out.println(queue.isDogEmpty());
    }

    public void add(Pet pet) {
        pets.add(pet);
        if (pet instanceof Dog) {
            dogs.add((Dog) pet);
        } else {
            cats.add((Cat) pet);
        }
    }

    public void pollDog() {
        while (!dogs.isEmpty()) {
            Pet firstDog = dogs.poll();
            pets.remove(firstDog);
            System.out.println(firstDog.getType());
        }
    }

    public void pollCat() {
        while (!cats.isEmpty()) {
            Pet firstCat = cats.poll();
            pets.remove(firstCat);
            System.out.println(firstCat.getType());
        }
    }

    public void pollAll() {
        while (!pets.isEmpty()) {
            Pet firstPet = pets.remove(0);
            if (firstPet instanceof Cat) {
                cats.poll();
            } else {
                dogs.poll();
            }
            System.out.println(firstPet.getType());
        }
    }

    public boolean isEmpty() {
        return pets.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogs.isEmpty();
    }

    public boolean isCatEmpty() {
        return cats.isEmpty();
    }

    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return "Pet{" +
                    "type='" + type + '\'' +
                    '}';
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }
}
