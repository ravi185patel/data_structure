# Minimum Operations to Make Elements Within K Subarrays Equal

## Difficulty

**Hard**

## Core Idea

For every subarray of size `k`:

1. Find the **median**.
2. Calculate:

```text
Σ |nums[i] - median|
```

The median minimizes the sum of absolute differences.

---

## Pattern Classification

```text
Sliding Window
      |
      v
Need Median?
      |
      +---- No  -> Regular Sliding Window
      |
      +---- Yes
              |
              v
      Need Dynamic Median
              |
              +---- Insert Only
              |          |
              |          v
              |    Two Heaps (PriorityQueue)
              |
              +---- Insert + Delete
                         |
                         v
                TreeMap / Multiset
                or
                Lazy Deletion Heaps
```

---

## Data Structure Selection

### Case 1: Median of Data Stream

Problem:

* Numbers only arrive.
* No removals.

Use:

```java
PriorityQueue<Integer> maxHeap;
PriorityQueue<Integer> minHeap;
```

Examples:

* Find Median from Data Stream (295)

Complexity:

```text
Insert : O(log n)
Median : O(1)
```

---

### Case 2: Sliding Window Median

Problem:

* Insert new element.
* Remove old element.
* Maintain median.

Use:

```java
TreeMap<Integer,Integer>
```

or

```java
Two Heaps + Lazy Deletion
```

Examples:

* Sliding Window Median (480)
* Minimum Operations to Make Elements Within K Subarrays Equal (3422)

Complexity:

```text
Insert : O(log k)
Delete : O(log k)
Median : O(1)
```

---

## Patterns Learned

### ✅ Sliding Window

Process all subarrays of size `k`.

### ✅ Median Minimizes L1 Distance

For:

```text
Σ |a[i] - x|
```

Optimal:

```text
x = median
```

---

### ✅ Two Heaps

Maintain:

```text
Left Half
Median
Right Half
```

---

### ✅ TreeMap as Multiset

Java alternative to C++ multiset.

Supports:

* Insert
* Delete
* Duplicates
* Ordered access

---

### ✅ Running Sum Optimization

Maintain:

```java
leftSum
rightSum
```

Cost:

```java
cost =
median * leftSize - leftSum
+
rightSum - median * rightSize
```

---

### ✅ Dynamic Median Maintenance

As the window slides:

```text
Remove old element
Add new element
Rebalance
Update median
```

---

## Time Complexity

### Brute Force

```text
O(n * k log k)
```

### Optimized

```text
O(n log k)
```

### Space

```text
O(k)
```

---

## Related Problems

### Median

1. Find Median from Data Stream (295)
2. Sliding Window Median (480)

### Median + Cost

3. Best Meeting Point (296)
4. Min Moves to Equal Array Elements II (462)
5. Minimum Operations to Make Elements Within K Subarrays Equal (3422)

---

## Interview Takeaway

Whenever you see:

```text
Minimum operations to make elements equal
```

and cost is:

```text
|a - b|
```

Think:

```text
MEDIAN
```

Then ask:

```text
Need dynamic median?
      |
      +---- Insert Only -> Two Heaps
      |
      +---- Insert + Delete -> TreeMap / Multiset
```
