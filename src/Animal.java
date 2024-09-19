import java.util.Scanner;

public class Animal {
    protected String color;
    protected String name;
    protected int age;

    public Animal(String color, String name, int age) {
        this.color = color;
        this.name = name;
        this.age = age;
    }

    public void makeSound(){
        System.out.println("Животное издает звук");
    }

}

class Dog extends Animal{
    private String breed;
    public Dog(String color, String name,int age, String breed){
        super(color, name, age);
        this.breed = breed;
    }


    @Override
    public void makeSound(){
        System.out.println("Собака лает");
    }

    public static Dog[] InputDogs(int size){
        Dog[] mas = new Dog[size];
        System.out.println("введите стаю из "+size+" из доги");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < mas.length; i++) {
            System.out.println("введите color,name, age, порода");
            String color = scanner.next(); String name = scanner.next(); int age = scanner.nextInt(); String breed = scanner.next();
            mas[i] = new Dog(color, name, age, breed);
        }
        return mas;
    }
}

class Cat extends Animal{
    public Cat(String color, String name,int age){
        super(color, name, age);
    }


    @Override
    public void makeSound(){
        System.out.println("Кошка говорит:: мяу");
    }

    public static Cat[] InputCats(int size){
        Cat[] mas = new Cat[size];
        System.out.println("введите прайд из "+size+" гордых котов");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < mas.length; i++) {
            System.out.println("введите color,name, age");
            String color = scanner.next(); String name = scanner.next(); int age = scanner.nextInt();
            mas[i] = new Cat(color, name, age);
        }
        return mas;
    }
}

