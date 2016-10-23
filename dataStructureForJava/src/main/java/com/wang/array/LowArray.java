package com.wang.array;

class LowArray {
    private double[] a;

    LowArray(int size) {
        a = new double[size];
    }

    public void setElement(int index, double value) {
        a[index] = value;
    }

    public double getElement(int index) {
        return a[index];
    }
}

class LowArrayApp {
    public static void main(String[] args) {
        LowArray arr = new LowArray(100);
        arr.setElement(0, 77);
        arr.setElement(1, 99);
        arr.setElement(2, 44);
        arr.setElement(3, 55);
        arr.setElement(4, 22);
        arr.setElement(5, 88);
        arr.setElement(6, 11);
        arr.setElement(7, 0);
        arr.setElement(8, 66);
        arr.setElement(9, 33);
        int searchKey = 26;
        for (int i = 0; i < 10; i++) {
            System.out.println(arr.getElement(i) + " ");
        }
        System.out.println("");

    }
}


