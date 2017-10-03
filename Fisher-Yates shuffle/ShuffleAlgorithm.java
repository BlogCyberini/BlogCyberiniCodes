/*
 * Code by Henrique Felipe
 * Website: https://blogcyberini.blogspot.com/
 * January 2015
 * 
 * Fisher–Yates shuffle
 */

import java.util.Random;

public class ShuffleAlgorithm {
    //Tests
    public static void main(String[] args) {
        int g[] = {1, 2, 3, 4, 5, 6};
        shuffle(g);
        for (int i = 0; i < g.length; i++) {
            System.out.print(g[i] + " ");
        }
    }
    //It shuffles the elements of the specified vector (Fisher-Yates/Durstenfeld).
    public static void shuffle(int[] a) {
        Random rnd = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            int randomNumber = rnd.nextInt(i + 1);
            swap(a, i, randomNumber);
        }
    }
    //This method exchanges the element in the index 'i' with the element in the index 'j'.
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
