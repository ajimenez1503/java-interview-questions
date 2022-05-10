package org.example;

class CustomPair {
    private int key;
    private int value;

    // standard getters and setters
    void setValue(int key, int value) {
        this.key = key;
        this.value = value;
    }

    int getKey() {
        return key;
    }

    int getValue() {
        return value;
    }

    void set(CustomPair copy) {
        this.key = copy.getKey();
        this.value = copy.getValue();
    }
}

public class Exercise9 {

    static public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0) {
            return new int[0];
        }
        if (nums.length == 1) {
            return nums;
        }
        if (k == 1) {
            return nums;
        }

        if (nums.length == 2) {
            return new int[]{Math.max(nums[0], nums[1])};
        }
        int[] result = new int[nums.length + 1 - k];
        CustomPair max1 = new CustomPair();
        CustomPair max2 = new CustomPair();

        int j = 0; // Index for result
        int i = 0; // Index for nums

        // Find max1 and max2 from 0 to 1
        if (nums[0] >= nums[1]) {
            max1.setValue(0, nums[0]);
            max2.setValue(1, nums[1]);
        } else {
            max1.setValue(1, nums[1]);
            max2.setValue(0, nums[0]);
        }

        // Find max1 and max2 from 0 to k
        for (i = 2; i < k; i++) {
            if (nums[i] >= max1.getValue()) {
                max2.set(max1);
                max1.setValue(i, nums[i]);
            } else if (nums[i] >= max2.getValue()) {
                max2.setValue(i, nums[i]);
            }
        }
        result[j++] = max1.getValue();

        //
        for (i = k; i < nums.length; i++) {
            if (max1.getKey() == i - k) {
                if (nums[i] >= max1.getValue()) {
                    max1.setValue(i, nums[i]);
                    // keep max2
                } else if (nums[i] >= max2.getValue()) {
                    max1.setValue(i, nums[i]);
                    // keep max2
                } else {
                    max1.set(max2);
                    max2.setValue(i, nums[i]);
                }
            } else if (max2.getKey() == i - k) {
                if (nums[i] >= max1.getValue()) {
                    max2.set(max1);
                    max1.setValue(i, nums[i]);
                } else if (nums[i] >= max2.getValue()) {
                    // keep max1
                    max2.setValue(i, nums[i]);
                } else {
                    // keep max1
                    max2.setValue(i, nums[i]);
                }
            } else if (nums[i] >= max1.getValue()) {
                max2.set(max1);
                max1.setValue(i, nums[i]);
            } else if (nums[i] >= max2.getValue()) {
                // keep max1
                max2.setValue(i, nums[i]);
            }
            result[j++] = max1.getValue();
        }
        return result;
    }
}
