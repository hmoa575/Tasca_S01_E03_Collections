# Tasca S01 E03 - Java Collections

Practice project for Sprint 1 - Task S01 E03 focused on Java Collections, file handling, sorting, and console interaction.

---

## Overview

This repository contains a set of Java exercises designed to practice the most common collection types from `java.util`, including:

- `ArrayList`
- `HashSet`
- `HashMap`
- `ListIterator`

The project also includes:
- object comparison with `equals()` and `hashCode()`
- sorting with `Comparable` and `Comparator`
- file reading and writing
- console-based interaction with the user

---

## Tech Stack

- Java
- Maven
- IntelliJ IDEA

---

## Project Structure

```text
src
├── main
│   └── java
│       ├── level01exercise01
│       ├── level01exercise02
│       ├── level01exercise03
│       ├── level02exercise01
│       ├── level02exercise02
│       └── level03...
└── test
    └── java
        └── ...
```

---

## Exercises

### Level 1

#### Exercise 1 — Duplicates
Work with `ArrayList` and `HashSet` to:
- create `Month` objects
- insert missing elements in the correct position
- verify ordering
- prevent duplicates
- iterate using `for` and `Iterator`

#### Exercise 2 — ListIterator
Practice list traversal by:
- creating a `List<Integer>`
- reversing the values into a second list
- using `ListIterator`

#### Exercise 3 — Capital Game
Build a console quiz game that:
- reads countries and capitals from `countries.txt`
- stores them in a `HashMap<String, String>`
- asks the user 10 random questions
- calculates the final score
- saves results into `classificacio.txt`

---

### Level 2

#### Exercise 1 — HashSet Without Exact Duplicates
Create a `Restaurant` class and override:
- `equals()`
- `hashCode()`

Goal:
- allow restaurants with the same name if their score is different
- prevent exact duplicates in a `HashSet`

#### Exercise 2 — Multiple Sorting
Sort `Restaurant` objects:
- alphabetically by name
- by score in descending order when names are equal

Implemented with:
- `Comparable`
- or `Comparator`

---

### Level 3

#### Exercise 1 — Person Manager with Sorting
Read people from a CSV file and allow sorting by:
- first name
- last name
- DNI

Menu-based console application with multiple sorting options.

---

## How to Run

Clone from  https://github.com/hmoa575/Tasca_S01_E03_Collections

### Option IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Configure the correct JDK
3. Run the desired `Main` class


---

## Resources

Some exercises depend on external files, for example:

- `countries.txt`
- `classificacio.txt`

Recommended location for input resources:

```text
src/main/resources/
```
