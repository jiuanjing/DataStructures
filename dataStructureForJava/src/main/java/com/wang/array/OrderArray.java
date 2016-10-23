package com.wang.array;

class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrderArray arr = new OrderArray(maxSize);

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

        int searchKey = 55;
        if (arr.find(searchKey) != arr.size()) {
            System.out.println("found " + searchKey);
        } else {
            System.out.println("can't find " + searchKey);
        }
        arr.display();

        arr.delete(0);
        arr.delete(55);
        arr.delete(66);
        arr.display();
    }
}

public class OrderArray {
    private double a[];
    private int nElem;

    public void display() {
        for (int j = 0; j < nElem; j++) {
            System.out.println(a[j] + " ");
        }
        System.out.println("");
    }

    public void insert(double value) {
        int j;
        //将插入值和数组中的每个值进行比较
        //直到有比其大的值时停止
        for (j = 0; j < nElem; j++) {
            if (a[j] > value)
                break;
        }

//        System.arraycopy(a, j, a, j + 1, nElem - j);
        //将数组的值都向前移动一位
        for (int k = nElem; k > j; k--)
            a[k] = a[k - 1];
        //将空出来的位置赋给插入值
        a[j] = value;
        //数值的实际值加1
        nElem++;
    }

    public boolean delete(double value) {
        int j = find(value);
        if (j == nElem) return false;
        else {
            System.arraycopy(a, j + 1, a, j, nElem - j);
            nElem--;
            return true;
        }
    }

    public int find(double searchKey) {
        //二分查找
        int lowerBound = 0;
        int upperBound = nElem - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return nElem;
            } else {
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }

    public int size() {
        return nElem;
    }

    public OrderArray(int max) {
        a = new double[max];
        nElem = 0;
    }
}
