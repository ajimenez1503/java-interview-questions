package org.example;

import java.util.Arrays;

public class Exercise5 {


    static public int coinChangeImpl1(int[] coins, int amount) {
        int i = 1;
        int childResult = -1;
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins, 0, coins.length);
        while (i <= coins.length && coins[coins.length - i] > amount) {
            i++;
        }
        while (i <= coins.length) {
            childResult = coinChangeImpl1(coins, amount - coins[coins.length - i]);
            if (childResult == -1) {
                i++;
            } else {
                return 1 + childResult;
            }
        }
        return -1;
    }

    static public int coinChangeImpl2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins, 0, coins.length);
        int memoize[] = new int[amount + 1];
        Arrays.fill(memoize, -2);
        return coinChangeImpl2Internal(memoize, coins, amount);
    }

    static public int coinChangeImpl2Internal(int[] memoize, int[] coins, int amount) {
        int i = 1;
        int childResult = -1;
        if (amount == 0) {
            return 0;
        }
        while (i <= coins.length && coins[coins.length - i] > amount) {
            i++;
        }
        while (i <= coins.length) {
            int newAmount = amount - coins[coins.length - i];
            if (memoize[newAmount] == -2) {
                memoize[newAmount] = coinChangeImpl2Internal(memoize, coins, newAmount);
            }
            if (memoize[newAmount] == -1) {
                i++;
            } else {
                return 1 + memoize[newAmount];
            }
        }
        return -1;
    }
}
