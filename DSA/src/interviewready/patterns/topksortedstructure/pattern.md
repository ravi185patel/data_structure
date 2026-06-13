# Top K from Sorted Structures Pattern

## Core Idea

When the input is **already sorted** (or partially sorted) and you need the **Top K / Kth** elements, avoid generating every possible combination.

> **Explore only the next best candidate using a Priority Queue (Heap).**

Typical Data Structures:

* Min Heap (`PriorityQueue`)
* Max Heap
* K-Way Merge
* Binary Search + Heap
* BFS on Sorted States

---

# Pattern Recognition

If the problem mentions:

* K smallest
* K largest
* K closest
* Merge K sorted lists
* Sorted rows/columns
* Kth smallest
* Kth largest
* Top K combinations
* K highest sums
* K pairs with smallest sums

Think:

```text
           Already Sorted Structure
                     │
                     ▼
          Explore only necessary nodes
                     │
                     ▼
             Priority Queue (Heap)
                     │
                     ▼
          O(K log N) instead of O(N²)
```

---

# Pattern 1: Merge K Sorted Lists

**LeetCode 23**

## Visualization

```text
L1 : 1 4 7

L2 : 2 5 8

L3 : 3 6 9

Heap:
1 2 3

Pop 1
Push 4

Heap:
2 3 4

Pop 2
Push 5

Heap:
3 4 5
```

### Complexity

```text
Time:  O(N log K)
Space: O(K)
```

---

# Pattern 2: Kth Smallest Element in Sorted Matrix

**LeetCode 378**

## Matrix

```text
1   5   9

10 11 13

12 13 15
```

Initial Heap

```text
1
10
12
```

Pop 1

Push Right

```text
5
10
12
```

Pop 5

Push Right

```text
9
10
12
```

Continue until K pops.

### Complexity

```text
Time:  O(K log N)
Space: O(N)

N = Number of Rows
```

---

# Pattern 3: K Pairs With Smallest Sum

**LeetCode 373**

```text
nums1

1 7 11

nums2

2 4 6
```

Possible sums

```text
1+2 = 3
1+4 = 5
1+6 = 7

7+2 = 9

11+2 = 13
```

Don't generate all pairs.

Initial Heap

```text
(1,2)
(7,2)
(11,2)
```

Pop

```text
1+2

Push

1+4
```

Only explore the next possible candidate.

### Complexity

```text
Time:  O(K log N)
Space: O(N)
```

---

# Pattern 4: Find K Closest Elements

**LeetCode 658**

```text
1 2 3 4 5

x = 3

Closest Order

3
2
4
1
5
```

Possible Solutions:

* Binary Search + Two Pointers ⭐ (Preferred)
* Heap

### Complexity

```text
Time: O(log N + K)
```

---

# Pattern 5: K Closest Points to Origin

**LeetCode 973**

Distances

```text
(1,3)

√10

(2,1)

√5

(0,2)

√4
```

Maintain:

```text
Max Heap (Size K)

if heap size > K

remove farthest point
```

### Complexity

```text
Time:  O(N log K)
Space: O(K)
```

---

# Pattern 6: Top K Frequent Elements

**LeetCode 347**

```text
1 1 1 2 2 3

Frequency

1 → 3

2 → 2

3 → 1
```

Maintain

```text
Min Heap

Size = K
```

### Complexity

```text
Time:  O(N log K)
Space: O(K)
```

---

# Pattern 7: Kth Largest Element in Array

**LeetCode 215**

```text
3 2 1 5 6 4

K = 2

Min Heap (Size = 2)

3

3 2

remove 2

3 5

remove 3

5 6

remove 5

Heap:
6 5

Answer = 5
```

### Complexity

```text
Time:  O(N log K)
Space: O(K)
```

---

# Pattern 8: Kth Smallest Prime Fraction

**LeetCode 786**

```text
1 2 3 5

Fractions

1/5

1/3

1/2

2/5

2/3

3/5
```

Do NOT generate every fraction.

Initialize Heap

```text
1/5

2/5

3/5
```

Expand only the next candidate after each pop.

### Complexity

```text
Time: O(K log N)
```

---

# Pattern 9: Smallest Range Covering K Lists

**LeetCode 632**

```text
1 4 7

2 5 8

3 6 9
```

Maintain

```text
Heap

1
2
3

Current Max = 3

Range

[1,3]

Pop 1

Push 4

Current Max = 4

Range

[2,4]
```

Classic Google interview problem.

### Complexity

```text
Time: O(N log K)
```

---

# Pattern 10: K-th Smallest Pair Distance

**LeetCode 719**

Not a pure heap problem.

Pattern:

```text
Binary Search

        +

Sliding Window Counting
```

### Complexity

```text
Time: O(N log W)

W = Max Distance
```

---

# Master Decision Tree

```text
                        Need Top K?
                              │
                ┌─────────────┴─────────────┐
                │                           │
          Unsorted Array             Already Sorted
                │                           │
                ▼                           ▼
         Heap (Size K)                K-Way Merge
         O(N log K)                Priority Queue
                                          │
                  ┌───────────────────────┼──────────────────────┐
                  │                       │                      │
                  ▼                       ▼                      ▼
          Merge K Lists          Sorted Matrix          Sorted Arrays
                  │                       │                      │
                  ▼                       ▼                      ▼
             O(N log K)             O(K log N)             O(K log N)
```

---

# Quick Recognition Table

| Problem Type                | Best Technique                 |
| --------------------------- | ------------------------------ |
| Merge K Sorted Lists        | Min Heap                       |
| Kth Largest in Array        | Min Heap (Size K)              |
| Top K Frequent              | HashMap + Min Heap             |
| K Closest Points            | Max Heap                       |
| K Closest Elements          | Binary Search + Two Pointers   |
| K Smallest Pair Sums        | Min Heap                       |
| Kth Smallest Matrix         | Min Heap / Binary Search       |
| Smallest Range K Lists      | Min Heap                       |
| Kth Smallest Prime Fraction | Min Heap                       |
| Kth Smallest Pair Distance  | Binary Search + Sliding Window |

---

# Must-Do LeetCode List

| Problem                               | LC No. | Difficulty |
| ------------------------------------- | ------ | ---------- |
| Kth Largest Element in a Stream       | 703    | Easy       |
| Kth Largest Element in an Array       | 215    | Medium     |
| Top K Frequent Elements               | 347    | Medium     |
| K Closest Points to Origin            | 973    | Medium     |
| Find K Pairs with Smallest Sums       | 373    | Medium     |
| Find K Closest Elements               | 658    | Medium     |
| Merge K Sorted Lists                  | 23     | Hard       |
| Kth Smallest Element in Sorted Matrix | 378    | Hard       |
| Smallest Range Covering K Lists       | 632    | Hard       |
| K-th Smallest Prime Fraction          | 786    | Hard       |
| K-th Smallest Pair Distance           | 719    | Hard       |

---

# Interview Heuristic

Whenever you see:

* Multiple sorted lists
* Multiple sorted arrays
* Sorted matrix
* Already sorted streams
* Need only Top K answers

Think:

```text
Don't generate everything.

Generate only the next best candidate.

Use:
    ✓ Priority Queue
    ✓ K-Way Merge
    ✓ Heap Expansion

Target Complexity:

O(K log N)

instead of

O(N²)
```

## Golden Rule

> **If the data is already sorted, let the sorting work for you. Explore only the frontier using a heap instead of enumerating every possible answer.**

# Top K from Sorted Structures Pattern (Heap + Frontier Expansion)

> **This is NOT the normal Heap pattern.**
>
> The key idea is:
>
> **The data is already sorted, so never generate all possibilities. Explore only the current frontier using a Priority Queue.**

---

# Pattern Recognition

If the problem contains:

* Multiple sorted arrays
* Multiple sorted lists
* Sorted matrix
* Row-wise sorted matrix
* Row & column sorted matrix
* K smallest pairs
* K smallest fractions
* Merge K sorted structures
* K best combinations
* K smallest sums

Think:

```text
Already Sorted Structure
          │
          ▼
 Don't Generate Everything
          │
          ▼
  Explore Only Frontier
          │
          ▼
      Priority Queue
          +
 Next Candidate Generation
```

---

# Core Idea

Instead of:

```java
generate all combinations
sort them
take first k
```

Use:

```text
Initialize Heap

        │

        ▼

Pop Best Candidate

        │

        ▼

Generate ONLY Next Valid Candidate

        │

        ▼

Push Into Heap

Repeat K Times
```

This is called **Lazy Expansion**.

---

# Generic Template

```java
// Step 1
Push initial frontier into heap

while (k-- > 0) {

    Node current = pq.poll();

    // answer or kth answer

    // Step 2
    Generate next valid neighbor(s)

    // Step 3
    Push into heap
}
```

---

# Pattern 1: K-Way Merge

## Example

```
List1

1 4 7

List2

2 5 8

List3

3 6 9
```

Initial Heap

```
1
2
3
```

Pop

```
1
```

Push

```
4
```

Heap

```
2
3
4
```

Pop

```
2
```

Push

```
5
```

Continue...

## Complexity

```
Time  : O(N log K)

Space : O(K)
```

### Problems

* LC 23 - Merge K Sorted Lists
* Merge K Sorted Arrays

---

# Pattern 2: Lazy Expansion

## Example

LC 373 - K Smallest Pair Sums

```
nums1

1 7 11

nums2

2 4 6
```

Wrong approach

```
1+2
1+4
1+6

7+2
7+4
7+6

11+2
11+4
11+6
```

Generate only:

Initial

```
(1,2)

(7,2)

(11,2)
```

Pop

```
(1,2)
```

Generate only

```
(1,4)
```

Pop

```
(1,4)
```

Generate

```
(1,6)
```

Never generate unnecessary pairs.

## Complexity

```
Time : O(K log N)
```

---

# Pattern 3: Matrix Frontier Expansion

## Example

LC 378

```
1   5   9

10 11 13

12 13 15
```

Initial Heap

```
1

10

12
```

Pop

```
1
```

Push

```
5
```

Heap

```
5

10

12
```

Only the frontier is explored.

## Complexity

```
Time : O(K log N)
```

---

# Pattern 4: Graph Style Expansion + Visited

Sometimes one node creates multiple neighbors.

Example

```
1  2  3

4  5  6

7  8  9
```

Pop

```
1
```

Generate

```
2

4
```

Later

```
5
```

can be reached from multiple paths.

Need

```
visited[][]
```

Pattern

```
Priority Queue

      +

Visited Set

      +

Frontier Expansion
```

Typical problems:

* LC 1439
* Sorted matrix variations

---

# Mental Model

```
Sorted Space

                1

         2              4

      3      5      6      8

    7
```

We do **NOT** traverse everything.

We always expand only the current minimum frontier.

---

# Master Decision Tree

```
                        Top K
                          │

          ┌───────────────┴───────────────┐

          │                               │

      Unsorted Data               Already Sorted Data

          │                               │

          ▼                               ▼

      Heap Pattern              Heap + Frontier Expansion

                                          │

                   ┌──────────────────────┼─────────────────────┐

                   │                      │                     │

                   ▼                      ▼                     ▼

              K-Way Merge          Lazy Expansion        Matrix Expansion

                   │                      │                     │

                   ▼                      ▼                     ▼

            next element            next combination      right/down

                                                 │

                                                 ▼

                                           Sometimes

                                           + Visited Set
```

---

# Complexity Summary

| Pattern                | Complexity |
| ---------------------- | ---------- |
| K-Way Merge            | O(N log K) |
| K Smallest Pair Sum    | O(K log N) |
| Kth Smallest Matrix    | O(K log N) |
| Smallest Range K Lists | O(N log K) |
| Kth Smallest Fraction  | O(K log N) |
| Matrix State Expansion | O(K log N) |

---

# Problems That Belong ONLY To This Pattern

## K-Way Merge

* LC 23 - Merge K Sorted Lists
* Merge K Sorted Arrays

---

## Heap + Lazy Expansion

* LC 373 - K Smallest Pair Sums
* LC 786 - K-th Smallest Prime Fraction

---

## Heap + Matrix Frontier

* LC 378 - Kth Smallest Element in Sorted Matrix

---

## Heap + K-Way Merge

* LC 632 - Smallest Range Covering K Lists

---

## Heap + State Expansion + Visited

* LC 1439 - Find the Kth Smallest Sum of a Matrix With Sorted Rows

---

## Binary Search on Sorted Answer Space (Related Variant)

* LC 719 - K-th Smallest Pair Distance
* LC 2040 - Kth Smallest Product of Two Sorted Arrays

---

# Golden Rule

> **The input is already sorted.**
>
> **Do not generate every possible answer.**
>
> **Maintain only the frontier in a Priority Queue and lazily expand the next valid candidate.**

## One-Line Interview Heuristic

```
Sorted Structure
        +
Priority Queue
        +
Frontier Expansion
        +
(Optional) Visited Set

=> O(K log N) instead of O(N²)
```
