package com.lpcoder.guide.stackAndQueue;

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

        queue.pollAll();
        System.out.println(queue.pets);

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

    public Pet pollDog() {
        if (dogs.isEmpty()) {
            throw new RuntimeException("dog queue is empty");
        }
        Pet dog = dogs.poll();
        pets.remove(dog);
        return dog;
    }

    public Pet pollCat() {
        if (cats.isEmpty()) {
            throw new RuntimeException("cat queue is empty");
        }
        Pet cat = cats.poll();
        pets.remove(cat);
        return cat;
    }

    public Pet pollAll() {
        if (pets.isEmpty()) {
            throw new RuntimeException("pet queue is empty");
        }
        Pet pet = pets.remove(0);
        if (pet instanceof Cat) {
            cats.poll();
        } else {
            dogs.poll();
        }
        return pet;
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
