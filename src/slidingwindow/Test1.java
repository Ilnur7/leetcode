package slidingwindow;

import java.util.List;
import java.util.ArrayList;

class Animal {
    void feed() {
        System.out.println("Feeding an animal...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Meowing...");
    }
}

class Tiger extends Cat {
    void rrrr() {
        System.out.println("RRRRR...");
    }
}

public class Test1 {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        List<Dog> dogs = new ArrayList<>();
        List<Cat> tigers = new ArrayList<>();
        tigers.add(new Tiger());
        tigers.add(new Cat());

        //feedAnimals(animals);
        //feedAnimals(dogs);
        feedAnimals(tigers);
    }

    public static void feedAnimals(List<? super Cat> animals) {
        //animals.add(new Object());
        Object object = animals.get(0);
        //Animal cat2 = animals.get(1);
        //animals.add(new Animal()); // Добавление собаки допустимо
        //animals.add(new Animal()); // Добавление животного недопустимо, так как это может нарушить типизацию списка dogs

        for (Object obj : animals) {
            ((Animal) obj).feed();
        }
    }
}
