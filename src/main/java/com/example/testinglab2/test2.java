package com.example.testinglab2;

public class test2 {
    public int FindMax(int[] array) {
        int size = array.length;
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }
    public int FindMin(int[] array) {
        int size = array.length;
        int min = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }
}
