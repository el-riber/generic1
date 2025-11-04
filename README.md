
# Java Generics 1 — Assignment

## 🎯 Objective
Learn to implement and use **Generics in Java** to enhance **type safety** and **flexibility** in your code.

This project demonstrates:
- Generic classes and methods  
- Bounded type parameters  
- Generic interfaces and implementations  
- Type wildcards (`?`, `? extends`)  
- Practical use of generics in real applications  

---

## 🧱 Project Structure
```

Generic1/
├─ src/
│  └─ main/
│     └─ java/
│        └─ genericsdemo/
│           ├─ Box.java
│           ├─ NumberBox.java
│           ├─ Processor.java
│           ├─ StringProcessor.java
│           ├─ Library.java
│           └─ Main.java
└─ README.md

````

---

## ⚙️ How to Compile and Run

### 1️⃣ Compile
Open **PowerShell** or **Command Prompt** in the project folder and run:
```bash
javac -d out src\main\java\genericsdemo\*.java
````

### 2️⃣ Run

After successful compilation, run:

```bash
java -cp out genericsdemo.Main
```

If you are using **VS Code**, you can also click the ▶️ **Run** button on `Main.java`.

---

## 📚 Part 1 — Understanding Generics

### ✅ Generic Class: `Box<T>`

A class that can hold any data type safely.

```java
Box<Integer> intBox = new Box<>(42);
Box<String> strBox = new Box<>("Hello Generics");
```

### ✅ Generic Method

A method that works for any type:

```java
public static <U> void printBox(Box<U> box)
```

### ✅ Bounded Type Parameters: `NumberBox<T extends Number>`

Only accepts numeric types:

```java
NumberBox<Integer> n1 = new NumberBox<>(10);
NumberBox<Double> n2 = new NumberBox<>(3.14);
```

---

## ⚙️ Part 2 — Advanced Usage of Generics

### ✅ Generic Interface: `Processor<T>`

Defines a single method `process()`.

### ✅ Implementation: `StringProcessor`

Implements `Processor<String>` and reverses input strings:

```java
Processor<String> processor = new StringProcessor();
System.out.println(processor.process("Generics are powerful!"));
```

### ✅ Type Wildcards: `Box<? extends Number>`

Allows methods to handle boxes of any subclass of `Number`:

```java
NumberBox.printNumberBox(new NumberBox<>(5.5));
```

---

## 💼 Part 3 — Practical Application

### ✅ Generic Class: `Library<T>`

A generic library that manages any type of items (Books, DVDs, etc.).
Features:

* `add()` — Add an item
* `removeByName()` — Remove an item by its name
* `findByName()` — Search by name
* `listAll()` — Show all items

Example:

```java
Library<Book> bookLibrary = new Library<>(book -> book.title);
bookLibrary.add(new Book("Clean Code", "Robert C. Martin"));
```

---

## 🧪 Test Cases for Demonstration Video

### 🧩 Normal Test Cases

| # | Test                                     | Expected Output                |
| - | ---------------------------------------- | ------------------------------ |
| 1 | Store and retrieve using `Box<Integer>`  | Prints stored integer          |
| 2 | Reverse string using `StringProcessor`   | Displays reversed string       |
| 3 | Add, find, and remove in `Library<Book>` | Correct item found and removed |

### ⚠️ Edge Test Cases

| # | Test                                         | Expected Output           |
| - | -------------------------------------------- | ------------------------- |
| 1 | Empty `Box<String>`                          | Prints "Box holds: null"  |
| 2 | `StringProcessor.process(null)`              | Returns `null` safely     |
| 3 | Remove non-existing item from `Library<Dvd>` | Returns `false`, no crash |

---

## 🧩 Extra Credit Opportunity

To earn **up to +5% extra credit**, you can:

* Add a **simple text menu (CLI)** for user interaction
* Implement a **Swing or JavaFX GUI** to manage `Library` items
* Add advanced generic use cases like sorting or filtering with streams

Be sure to submit a short **document explaining your enhancements** and why they’re substantial.

---

## 📂 Submission Requirements

* ✅ Push your complete project to a **public GitHub repository**
* ✅ Include this **README.md**
* ✅ Submit a **demo video** showing:

  * The program running successfully
  * 3 normal + 3 edge test cases passing

---

## 🏁 Example Output

```
intBox.get() = 42
stringBox.get() = Hello Generics
Box holds: 42
Box holds: Hello Generics
nbInt = Box{10}
nbDouble = Box{3.1415}
NumberBox holds (as double): 10.0
NumberBox holds (as double): 3.1415
Original: Generics are powerful!
Reversed: !lufrewop era scireneG
Books: [Book{Clean Code by Robert C. Martin}, Book{Effective Java by Joshua Bloch}]
Find 'Clean Code': Book{Clean Code by Robert C. Martin}
Remove 'Effective Java': true
Books after removal: [Book{Clean Code by Robert C. Martin}]
```

---

### 🧑‍💻 Author

**Elida Ribeiro**
North Seattle College — *Application Development Program*
Date: November 3, 2025


