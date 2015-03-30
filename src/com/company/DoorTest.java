package com.company;

/**
 * Created by Admin on 30.03.15.
 */
public class DoorTest {
    public static void main(String[] args) {
        Door d = new Door(100);
        Door l = new Door(5);
        int q = d.height;
        int w = l.height;


        if (d.isOpened) {
            System.out.println("You're welcome.");
        }
        else {
            System.out.println("Sorry.");
        }

        d.open();
        d.print();

    }
}
