
## 📌 Task 1: Writing Methods with GitHub Copilot

### Calculator Class (Model in MVC)

```java
public class Calculator {
    private int value;

    // Reset calculator to zero
    public void reset() {
        value = 0;
    }

    // This method adds a positive integer to the calculator. If the integer is negative, throw an exception.
    public void add(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        value += number;
    }

    public int getValue() {
        return value;
    }
}
```

### Temporary Main Method

```java
public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.reset();
        calc.add(5);
        calc.add(10);
        System.out.println("Current value: " + calc.getValue());

        try {
            calc.add(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
```

### How Copilot Was Used
- **Signature only**: Writing just the method signature and letting Copilot generate the body.(for repetitive methods like getters, setters, test variables...)
- **Signature + first line**: Starting with a conditional, Copilot completed the rest.(for more sophisticated, task-specific algorithms like raise-exception clauses)
- **Comment-driven**: Writing a descriptive comment, Copilot generated the method body automatically. (to quickly scaffold entire classes with basic properties and methods, like test code in main program)

---
## README link
https://github.com/FPTSTUDEN/HelloWorld17/blob/main/src/main/java/e4/README.md
---

## ⚖️ Evaluation of GitHub Copilot

### Benefits
- **Speed**: Quickly generates method bodies and explanations, saving time.
- **Consistency**: Ensures code follows common patterns and best practices.
- **Delegation**: Developer's role shifts to planning targets and review the generated code, saving time and effort on delivering high-quality code.

### Drawbacks
- **Over-reliance**: Risk of accepting suggestions without fully understanding them.(avoided by self-reviewing the code)
- **Generic output**: Sometimes produces boilerplate code that may not fit unique project needs.(avoided by elaborate planning and careful prompting)

---

## 📝 Conclusion
GitHub Copilot is highly applicable to my coding style when I need **speed and structure**. It helps with repetitive tasks and documentation, but I must remain critical of its output to ensure correctness and adaptability. The balance is using Copilot as a **coding assistant**, not a replacement for either the **core program's logic** or **the developer's understanding**.