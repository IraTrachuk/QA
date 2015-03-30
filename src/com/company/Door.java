package com.company;

/**
 * Created by Admin on 30.03.15.
 */
public class Door {

    public int height;
    public boolean isOpened;

    public Door (int h) {
        height = h;
        isOpened = false;
    }

    public void open() {
        isOpened = true;
        System.out.println("Please come in.");
    }

    public void print() {
        if (isOpened) {
            System.out.println("The door is opened");
        }
        else {
            System.out.println("The door is closed");
        }
        System.out.println("The door's height is " + height);
    }


}

