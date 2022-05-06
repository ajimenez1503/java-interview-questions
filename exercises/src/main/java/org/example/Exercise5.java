package org.example;

import java.util.Arrays;

public class Exercise5 {

    
    static public int coinChange(int[] coins, int amount) {
        int i = 1;
        int childResult = -1;
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins, 0, coins.length);
        while (i <= coins.length && coins[coins.length - i] > amount) {
            i++;
        }
        while (childResult == -1 && i <= coins.length) {
            childResult = coinChange(coins, amount - coins[coins.length - i]);
            if (childResult == -1) {
                i++;
                continue;
            } else {
                return 1 + childResult;
            }
        }
        return -1;
    }
}
