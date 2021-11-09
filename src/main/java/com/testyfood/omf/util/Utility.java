package com.testyfood.omf.util;

import java.util.Random;

public class Utility {
    public static int getRandomNumber(){
        Random rnd = new Random();
        return  rnd.nextInt(999999);
    }
}
