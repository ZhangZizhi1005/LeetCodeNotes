## 747. Largest Number At Least Twice of Others

---

链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/

---

|tag|level|best time|best space|
|---|---|---|---|
|Array|easy|O(n)|O(min(n,k))|

---

> **Description:** In a given integer array nums, there is always exactly one largest element.
Find whether the largest element in the array is at least twice as much as every other number in the array.
If it is, return the index of the largest element, otherwise return -1.


- Example1:
```
    Input: nums = [3, 6, 1, 0]
    Output: 1
```
- Example2:
```
    Input: nums = [1, 2, 3, 4]
    Output: -1
```