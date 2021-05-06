package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Map<String, int[]> students = new HashMap<String, int[]>();

        students.put(randomString(6), new int[]{new Random().nextInt(12) + 1, new Random().nextInt(12) + 1, new Random().nextInt(12) + 1});
        students.put(randomString(6), new int[]{new Random().nextInt(12) + 1, new Random().nextInt(12) + 1, new Random().nextInt(12) + 1});
        students.put(randomString(6), new int[]{new Random().nextInt(12) + 1, new Random().nextInt(12) + 1, new Random().nextInt(12) + 1});
        students.put(randomString(6), new int[]{new Random().nextInt(12) + 1, new Random().nextInt(12) + 1, new Random().nextInt(12) + 1});
        students.put(randomString(6), new int[]{new Random().nextInt(12) + 1, new Random().nextInt(12) + 1, new Random().nextInt(12) + 1});
        students.put(randomString(6), new int[]{new Random().nextInt(12) + 1, new Random().nextInt(12) + 1, new Random().nextInt(12) + 1});
        students.put(randomString(6), new int[]{new Random().nextInt(12) + 1, new Random().nextInt(12) + 1, new Random().nextInt(12) + 1});
        students.put(randomString(6), new int[]{new Random().nextInt(12) + 1, new Random().nextInt(12) + 1, new Random().nextInt(12) + 1});
        students.put(randomString(6), new int[]{new Random().nextInt(12) + 1, new Random().nextInt(12) + 1, new Random().nextInt(12) + 1});
        students.put(randomString(6), new int[]{new Random().nextInt(12) + 1, new Random().nextInt(12) + 1, new Random().nextInt(12) + 1});
        students.put(randomString(6), new int[]{new Random().nextInt(12) + 1, new Random().nextInt(12) + 1, new Random().nextInt(12) + 1});
        students.put(randomString(6), new int[]{new Random().nextInt(12) + 1, new Random().nextInt(12) + 1, new Random().nextInt(12) + 1});
        students.put(randomString(6), new int[]{new Random().nextInt(12) + 1, new Random().nextInt(12) + 1, new Random().nextInt(12) + 1});
        students.put(randomString(6), new int[]{new Random().nextInt(12) + 1, new Random().nextInt(12) + 1, new Random().nextInt(12) + 1});

        for (Map.Entry<String, int[]> item : students.entrySet()){
            System.out.println(item.getKey() + ": "+ Arrays.toString(item.getValue()));
        }
        System.out.println();

        for (Map.Entry<String, int[]> item : students.entrySet()) {
            if (abs_1(item.getValue()) < 4.0) {
                System.out.print(item.getKey() + ": "+ Arrays.toString(item.getValue()));
//                for (int i = 0; i < item.getValue().length; i++) {
//                    System.out.print(item.getValue()[i] + ", ");
//                }
                System.out.printf("\n");
            }
        }
    }

    public static double abs_1(int x[]) {
        int res = 0;
        for (int i = 0; i < x.length; i++)
            res += x[i];
        return res / x.length;
    }

    public static String randomString(int n) {
        int leftLimit = 97;
        int rightLimit = 122;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(n);
        buffer.append((char) (65 + (int) (random.nextFloat() * (90 - 65 + 1))));
        for (int i = 1; i < n; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }
}
