package com.anhao.algorithms;

import java.util.Arrays;

class Solution {
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    // three pointers
    int p = m+n-1;
    int p1 = m-1;
    int p2 = n-1;

    while (p1 >= 0 && p2 >= 0) {
      if (nums1[p1] > nums2[p2]) {
        nums1[p] = nums1[p1];
        p--;
        p1--;
      } else {
        nums1[p] = nums2[p2];
        p--;
        p2--;
      }
    }

    while (p2 >=0) {
      nums1[p]=nums2[p2];
      p2--;
      p--;
    }
  }
}

public class LeetCodeDebug {
  public static void main(String[] args) {
    int[] nums1 = new int[]{4,5,6,0,0,0};
    int[] nums2 = new int[]{1,2,3};

    Solution.merge(nums1, 3, nums2, 3);
    System.out.println(Arrays.toString(nums1));
  }
}
