package com.test;

public class Main {
    public static void main(String[] args) {
        Box box = new Box();
        box.addCandy(new Belochka("1", 1,1,"smth"));
        box.addCandy(new Belochka("2", 2,2,"smth"));
        box.addCandy(new Belochka("3", 3,3,"smth"));
        box.addCandy(new Belochka("4", 4,4,"smth"));
        box.addCandy(new Karakum("5", 5,5,"smth"));
        box.addCandy(new Karakum("6", 6,6,"smth"));
        box.addCandy(new Karakum("7", 7,7,"smth"));
        box.addCandy(new Karakum("8", 8,8,"smth"));
        box.deleteLastCandy();
        box.deleteCandy(0);
        box.showTotalWeight();
        box.weightOptimize(25);
        box.priceOptimize(24);
        box.showTotalPrice();
        box.showTotalWeight();
        box.candyInfo();
    }

}
