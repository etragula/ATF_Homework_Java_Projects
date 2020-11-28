package com.test;

import java.util.ArrayList;

public class Box implements methodsForBox {
    private final ArrayList <Candy> array = new ArrayList<>();

    public int getTotalWeight() {
        int boxWeight = 0;
        for (Candy el : array)
            boxWeight += el.getWeigth();
        return (boxWeight);
    }

    public int getTotalPrice() {
        int boxPrice = 0;
        for (Candy el : array)
            boxPrice += el.getPrice();
        return (boxPrice);
    }

    @Override
    public void showTotalWeight() {
        System.out.println("Total weight = " + getTotalWeight());
    }

    @Override
    public void showTotalPrice() {
        System.out.println("Total price = " + getTotalPrice());
    }

    @Override
    public void candyInfo() {
        int i = 0;
        for (Candy el : array) {
            System.out.println(i + ". " + "Name -- " + el.getName() + " \nPrice --" + el.getPrice() + " \nWeight -- " + el.getWeigth() + " \nDescription -- " + el.getDescrip());
            i++;
        }
    }

    @Override
    public void addCandy(Candy el) {
        array.add(el);
    }

    @Override
    public void deleteCandy(int index) {
        if (index > array.size() - 1 || index < 0) {
            throw new IllegalArgumentException();
        }
        array.remove(index);
    }

    @Override
    public void deleteLastCandy() {
        array.remove(array.size() - 1);
    }

    public void weightOptimize(int target) {
        int i;
        int boxWeight;
        int index = 0;
        boxWeight = getTotalWeight();
        if (target < 0 || target >= boxWeight)
            throw new IllegalArgumentException();
        while (boxWeight > target) {
            i = 2147483647;
            for (Candy el : array) {
                if (i >= el.getWeigth()) {
                    i = el.getWeigth();
                    index = array.indexOf(el);
                }
            }
            deleteCandy(index);
            boxWeight -= i;
        }
    }

    public void priceOptimize(int target) {
        int i;
        int index = 0;
        int boxPrice;
        boxPrice = getTotalPrice();
        if (target < 0 || target >= boxPrice)
            throw new IllegalArgumentException();
        while (boxPrice > target) {
            i = 2147483647;
            for (Candy el : array) {
                if (i >= el.getWeigth()) {
                    i = el.getWeigth();
                    index = array.indexOf(el);
                }
            }
            deleteCandy(index);
            boxPrice -= i;
        }
    }

}
