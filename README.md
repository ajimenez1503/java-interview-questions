# java interview questions

Interview questions solved in Java.
1. [Exercise 1 - Find second max](#exercise-1)
2. [Exercise 2 - Count `i -j == list[i] - list[j]`](#exercise-2)
3. [Exercise 3 - URL Tracking Parameters](#exercise-3)

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