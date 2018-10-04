package com.alevel;

public class Main {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,3,4,8, 9, 9, 9, 3};
        int numbers = 0;
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (array[j] == array[i]) {
                    count++;
                }
            }
            if (count == 0) {
                numbers++;
            }

        }
        System.out.println(numbers);
    }
}
