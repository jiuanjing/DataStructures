package com.wang.array;

class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr = new HighArray(maxSize);

        arr.insert(0);
        arr.insert(22);
        arr.insert(55);
        arr.insert(33);
        arr.insert(66);
        arr.insert(11);
        arr.insert(44);
        arr.insert(77);
        arr.insert(99);
        arr.insert(88);

        arr.display();

        int searchKey = 35;
        if (arr.find(searchKey) != -1)
            System.out.println("found " + searchKey);
        else
            System.out.println("can't find " + searchKey);
        arr.delete(0);
        arr.delete(55);
        arr.delete(99);
        arr.display();
    }
}

public class HighArray {
    private double[] a;
    private int nElem;

    public HighArray(int max) {
        a = new double[max];
        nElem = 0;
    }

    public void display() {
        for (int j = 0; j < nElem; j++) {
            System.out.println(a[j] + " ");
        }
        System.out.println("");
    }

    public void insert(double value) {
        a[nElem] = value;
        nElem++;
    }

    public boolean delete(double value) {
        int j;
        for (j = 0; j < nElem; j++) {
            if (value == a[j]) break;
        }
        if (j == nElem) {
            return false;
        } else {
            System.arraycopy(a, j + 1, a, j, nElem - j);
            nElem--;
            return true;
        }
    }

    public int find(double searchKey) {
        int lowerBound = 0;
        int upperBound = nElem - 1;
        int curIndex;

        while (true) {
            curIndex = (lowerBound + upperBound) / 2;
            if (a[curIndex] == searchKey)
                return curIndex;
            else if (lowerBound > upperBound)
                return nElem;
            else {
                if (a[curIndex] < searchKey)
                    lowerBound = curIndex + 1;
                else
                    upperBound = curIndex - 1;
            }
        }
    }
}
