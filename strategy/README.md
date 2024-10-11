# Strategy Design Pattern

## 🧠 Purpose and Intent
The Strategy design pattern's mission is to define a family of algorithms, encapsulate them, and make them interchangeable. This allows clients to dynamically change the algorithm they use without altering the client code.

## 🔑 Also Known As
The Policy Pattern

## 📝 In Simple Terms
The Strategy pattern gives you the flexibility to pick an algorithm at runtime. Instead of cluttering your code with many variations, you can cleanly separate them into different classes and select the best fit when needed.

## 📖 What Wikipedia Says
_In computer programming, the strategy pattern (also known as the policy pattern) is a behavioral software design pattern that enables selecting an algorithm at runtime._

## 🌍 Real-World Analogy
Imagine you’re booking a trip. You can choose to travel by car, bus, train, or plane. The travel method is your strategy. Instead of hard-coding the mode of transport into your plan, you can change it depending on availability, cost, or convenience—each option is an interchangeable travel strategy!

## 💡 When Should You Use It?

* When you have multiple algorithms or solutions for a problem.
* When you want to avoid long conditional (`if-else`, `switch-case`) statements.
* When your algorithm choices need to be flexible and selected at runtime.
* When you want to adhere to the open/closed principle, allowing new algorithms to be added without modifying existing code.

## 🚀 Real-World Uses in Software

* **Payment Gateways:** A system can allow different payment methods (credit card, PayPal, bank transfer), where each payment method is a strategy.
* **Sorting Algorithms:** You can use a Strategy pattern to select between different sorting algorithms like bubble sort, quicksort, or mergesort based on the size or nature of the data.

## 🛠️ Structure

Here’s a simplified UML diagram for the Strategy pattern:

```
+----------------------+             +--------------------+
|        Context       |             |      Strategy      |
|----------------------|<------------|--------------------|
| - strategy: Strategy |             | + algorithm():void |
| + setStrategy()      |             +--------------------+
| + executeAlgorithm() |                  /         \
+----------------------+                 /           \
                                        /             \
                         +--------------------+  +--------------------+
                         |  ConcreteStrategyA |  |  ConcreteStrategyB |
                         |--------------------|  |--------------------|
                         | + algorithm():void |  | + algorithm():void |
                         +--------------------+  +--------------------+
```
* **Context:** Maintains a reference to a Strategy object. This is the class that clients interact with.
* **Strategy:** An interface defining a common method (algorithm() in this case) that all concrete strategies must implement.
* **Concrete Strategies (A and B):** These are the different implementations of the algorithm. The client can choose any of these at runtime based on the current need.

#### **Explanation**

The key idea is that the Context class doesn't implement the algorithm directly; instead, it relies on a Strategy object to execute the required algorithm. The Strategy interface is implemented by different ConcreteStrategy classes, allowing the system to switch between algorithms flexibly.

The Context class will call setStrategy() to set the appropriate strategy, and then execute the algorithm by calling executeAlgorithm().

## ⚖️ Pros and Cons

### **Advantages:**

* **Better Maintainability:** Each algorithm lives in its own class, making it easy to manage and extend.
* **Adheres to SOLID Principles:** Especially the Open/Closed Principle (open for extension, closed for modification).
* **Runtime Flexibility:** Easily swap strategies at runtime without major code changes.

### **Disadvantages:**

* **Class Explosion:** Each strategy needs its own class, which can clutter the codebase if there are many algorithms.
* **Client Complexity:** The client needs to be aware of all available strategies and how to select them.

## 🔗 How It Connects with Other Patterns

* **Factory Pattern:** Often works hand-in-hand with Strategy to create instances of different strategies based on user input or configuration.
* **State Pattern:** Similar to Strategy, but while the Strategy pattern switches algorithms explicitly, the State pattern changes behavior dynamically depending on the object's state.
* **Decorator Pattern:** Both patterns modify behavior, but while Decorator wraps additional responsibilities around objects, Strategy swaps the underlying algorithm entirely.