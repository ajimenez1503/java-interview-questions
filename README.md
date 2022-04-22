# java interview questions

Interview questions solved in Java.
1. [Exercise 1](#exercise-1)
2. [Exercise 2](#exercise-2)

## Exercise 1

#### Description

Find the second max number in a list of integer.

##### Signature:

```java
Integer find2Max(ArrayList<Integer> list);
```

##### Scenario 1

- Input {}
- Output: Exception

##### Scenario 2

- Input {1,2,3}
- Output 2

## Exercise 2

#### Description

Find the number of times the following conditions became true in a list of integer.

```
i -j == list[i] - list[j]
```

##### Signature:

```java
Integer count(ArrayList<Integer> list);
```

##### Scenario 1

- Input {}
- Output: Exception

##### Scenario 2

- Input {1,2,3}
- Output 9
- Description: 9 times
    - If `i = 0, j = 0`
    - If `i = 1, j = 1`
    - If `i = 2, j = 2`
    - If `i = 0, j = 1`
    - If `i = 1, j = 0`
    - If `i = 1, j = 2`
    - If `i = 2, j = 1`
    - If `i = 0, j = 2`
    - If `i = 2, j = 0`