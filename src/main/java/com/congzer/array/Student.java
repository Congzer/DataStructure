package com.congzer.array;

public class Student {

    private String name;

    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    @Override
    public String toString() {

        return String.format("Student(name: %s, scope: %s)", name, scope);
    }

    public static void main(String[] args) {

        Array<Student> a = new Array<>();
        a.addLast(new Student("A", 100));
        a.addLast(new Student("B", 100));
        a.addLast(new Student("C", 99));

        System.out.println(a);
        a.remove(1);
        System.out.println(a);
        a.add(1, new Student("M", 99));
        System.out.println(a);
    }
}