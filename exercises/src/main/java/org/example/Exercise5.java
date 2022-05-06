package org.example;

import java.util.Arrays;

public class Exercise5 {


    static public int coinChangeImpl1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins, 0, coins.length);
        return coinChangeImpl1Internal(coins, amount);
    }

    static public int coinChangeImpl1Internal(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > amount) {
                break;
            }
            int tmpResult = coinChangeImpl1Internal(coins, amount - coin);
            if (tmpResult != -1) {
                result = Math.min(result, 1 + tmpResult);
            }
        }
        return result != Integer.MAX_VALUE ? result : -1;
    }

    static public int coinChangeImpl2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins, 0, coins.length);
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        return coinChangeImpl2Internal(dp, coins, amount);
    }

    static public int coinChangeImpl2Internal(int[] dp, int[] coins, int amount) {
        if (dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        }

        for (int coin : coins) {
            if (coin > amount) {
                break;
            }
            int result = coinChangeImpl2Internal(dp, coins, amount - coin);
            if (result != -1) {
                dp[amount] = Math.min(dp[amount], 1 + result);
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    static public int coinChangeImpl3(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins, 0, coins.length);
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) {
                    break;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
