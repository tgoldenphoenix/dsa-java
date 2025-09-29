package com.anhao.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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

class LRUCache {
  // capacity of the cache
  private int capacity;
  private Map<Integer, LinkedListNode> cache;
  // LinkedList stores the order of the cached item
  // front is most recent, tail is least recent
  private LinkedList<LinkedListNode> lruList;

  class LinkedListNode {
    // key-value pair
    int key;
    int value;

    // constructor
    LinkedListNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
  // constructor
  public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new HashMap<>();
    lruList = new LinkedList<>();
  }

  public int get(int key) {
    if (cache.containsKey(key)) {
      LinkedListNode node = cache.get(key);
      lruList.remove(node);
      // add to the front
      lruList.addFirst(node);
      return node.value;
    }
    return -1;
  }
  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      // update an existing cache item's value
      LinkedListNode node = cache.get(key);
      lruList.remove(node);
      // update new value for the node
      node.value = value;
      lruList.addFirst(node);
    } else {
      // add a new value to the cache
      if (cache.size() >= capacity) {
        // If the cache already at its max capacity, we must delete the least recently use item
        LinkedListNode node = lruList.removeLast();
        cache.remove(node.key);
      }
      LinkedListNode node = new LinkedListNode(key, value);
      lruList.addFirst(node);
      cache.put(key, node);
    }
  }
}
