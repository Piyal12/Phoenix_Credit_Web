package utils;

import java.util.Random;

public class JavaUtility {
    public static int getRandomNum(){
        Random random=new Random();
        int randomNum = random.nextInt(1000);
        return randomNum;
    }
}
