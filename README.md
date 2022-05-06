# java interview questions

Interview questions solved in Java.
1. [Exercise 1 - Find second max](#exercise-1)
2. [Exercise 2 - Count `i -j == list[i] - list[j]`](#exercise-2)
3. [Exercise 3 - URL Tracking Parameters](#exercise-3)
4. [Exercise 4 - Load Balancer](#exercise-4)
5. [Exercise 5 - Coin Change](#exercise-5)
6. [Exercise 6 - Word Pattern](#exercise-6)

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

## Exercise 3

#### Description
URL Tracking Parameters

When sharing links to social media, URLs must be modified to ensure engagement and/or visitors
can be associated with that particular social page or post. Publishers will typically add URL query
parameter key-value pairs with keys of utm_source, utm_medium and utm_campaign. These
key-value pairs are represented as `[key]=[value]` in the URL, and multiple pairs are separated
by an ampersand `&`.

Create a java implementation that can update a URL given the required tracking parameters and whether such new
parameters should be added in the query or fragment  component.
Existing parameters should be left unchanged, i.e. remain in either query or fragment

##### Additional requirements:
1. The input URL may already contain any number of query and fragment parameters,
   including none, that must be preserved in the resulting URL, unless overwritten by new
   parameters with the same key.
2. The same “key” cannot exist in both query and fragment URL components. If there is such
   a conflict, prioritise the newer parameter location.
3. The value of a key-value pair may be empty. In such cases include the key but omit the “=”
   (e.g. https://example.com?key1=value1&key2&key3=value3)

##### Scenario 1
- Input - URL: `https://www.telegraph.co.uk/theatre/what-to-see/renaming-colston-hall-dreary-failure-imagination/`
- Input - key-value:

| Key          | Value     |
|--------------|-----------|
| utm_source   | Facebook  |
| utm_campaign | test      |
| utm_medium   | Social    |
 
- Output `https://www.telegraph.co.uk/theatre/what-to-see/renaming-colston-hall-dreary-failure-imagination/?
  utm_source=Facebook&utm_campaign=test&utm_medium=Social`

## Exercise 4

#### Description

Create a load balancer with the following requirements:
- Register instances
  - It should be possible to register an instance, identified by an address.
  - Each address should be unique, it should not be possible to register the same address more than once.
  - Load balancer should accept up to 10 addresses.
- Random invocation
  - Develop an algorithm that, when invoking the Load Balancer's get() method multiple times, should return one
  backend-instance choosing between the registered ones randomly. 

## Exercise 5

ou are given an integer array `coins` representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1`.

You may assume that you have an infinite number of each kind of coin.

##### Example 1:

```
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
```

##### Example 2:

```
Input: coins = [2], amount = 3
Output: -1
```

##### Example 3:

```
Input: coins = [1], amount = 0
Output: 0
```
##### Constraints:
- `1 <= coins.length <= 12`
- `1 <= coins[i] <= 231 - 1`
- `0 <= amount <= 104`

## Exercise 6

Given a `pattern` and a string `s`, find if `s` follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in `pattern` and a non-empty word in s.

##### Example 1:

```
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
```

##### Example 2:

```
Input: pattern = "abba", s = "dog cat cat fish"
Output: false
```

##### Example 3:

```
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
```
##### Constraints:
- `1 <= pattern.length <= 300`
- `pattern` contains only lower-case English letters.
- `1 <= s.length <= 3000`
- `s` contains only lowercase English letters and spaces ' '.
- `s` does not contain any leading or trailing spaces.
- All the words in s are separated by a single space.