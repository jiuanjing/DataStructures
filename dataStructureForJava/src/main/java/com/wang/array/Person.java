package com.wang.array;

class ClassDataArray {

    private Person a[];
    private int nElem;

    public void insert(String last, String first, int age) {
        a[nElem] = new Person(last, first, age);
        nElem++;
    }

    public boolean delete(String searchName) {
        int i;
        for (i = 0; i < nElem; i++) {
            if (a[i].getLastName().equals(searchName)) {
                break;
            }
        }
        if (i == nElem) {
            return false;
        } else {
            for (int j = i; j < nElem; j++) {
                a[j] = a[j + 1];
            }
            nElem--;
            return true;
        }
    }

    public Person find(String searchName) {
        int i;
        for (i = 0; i < nElem; i++) {
            if (a[i].getLastName().equals(searchName)) {
                break;
            }
        }
        return i == nElem ? null : a[i];
    }

    public ClassDataArray(int max) {
        a = new Person[max];
        nElem = 0;
    }

    public void display() {
        for (int i = 0; i < nElem; i++) {
            a[i].toString();
        }
    }
}

//data items as class objects
public class Person {
    private String lastName;
    private String firstName;
    private int age;

    public String getLastName() {
        return lastName;
    }

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
