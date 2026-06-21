# Aesthetic Scientific Calculator

A robust, stylish, and fully functional scientific calculator built in **Java Swing**. This project features a custom pastel aesthetic, a robust external math parser, keyboard support, and a modern Look and Feel.

---

## Table of Contents
1. [Features](#features)
2. [Project Structure](#project-structure)
3. [Usage Guide](#usage-guide)
4. [Technical Details](#technical-details)
5. [Roadmap](#roadmap)

---

## Features

### Visuals & UI
* **Custom Theme:** A unique minimalist aesthetic using a Cream background (250, 246, 242), Pastel Pink, Sage Green, and Taupe text.
* **Rounded Buttons:** Custom-painted `JButton` components using 2D graphics and antialiasing for a modern, soft look.
* **Responsive Layout:** Uses `BorderLayout` and `GridLayout` to maintain structure.

### Mathematical Capabilities
* **Basic Operations:** Addition, Subtraction, Multiplication, Division.
* **Scientific Functions:** Sine, Cosine, Tangent, Logarithm (base 10), Natural Log (log2), Exponents (`^`).
* **Order of Operations:** Fully respects mathematical precedence (PEMDAS) using the exp4j library.
* **Robust Error Handling:** Safely catches mismatched parentheses or invalid syntax, displaying a clean "Error" state rather than crashing.

### Utility Features
* **Modern UI Framework:** Utilizes FlatLaf (Light Theme) to remove outdated Java borders and provide a native application feel.
* **Keyboard Support:** Type numbers and operators directly without clicking.
* **Executable Build:** Packaged via Maven Assembly Plugin into a single, easily runnable `.jar` file.

---

## Project Structure

The code is organized into **4 separate files** to ensure clean architecture and maintainability:

| File | Description |
| :--- | :--- |
| **`Main.java`** | **The Entry Point.** Initializes the FlatLaf theme and safely launches the application on the Swing Event Dispatch Thread (EDT). |
| **`CalculatorUI.java`** | **The Frontend.** Handles the window creation, button layout, custom color mapping, and user click listeners. |
| **`MathService.java`** | **The Backend.** Wraps the `exp4j` library to clean input strings, build mathematical expressions, and return evaluated results. |
| **`RoundedButton.java`** | **Custom Component.** A custom class extending `JButton` that overrides `paintComponent` to draw smooth, rounded corners and hover states. |

---

## Usage Guide

### 1. Typing vs. Clicking
* **Clicking:** Use your mouse to click the on-screen buttons.
* **Typing:** The calculator listens to keyboard input.
  * **Type numbers** (`0-9`) and operators (`+`, `-`, `*`, `/`, `^`).
  * Press **`Enter`** to calculate the result (`=`).
  * Press **`Esc`** to clear the screen (`C`).
  * Press **`Backspace`** to delete the last character (if focusing the text field).

### 2. Math Evaluation
* Expressions are evaluated in their entirety when pressing equals, allowing for complex nested equations.
  * *Example:* `(5+5)*2` = `20`
  * *Example:* `sin(0)+1` = `1.0`

### 3. Running the App
* Build the project using Maven (`mvn clean install`).
* Run the standalone executable generated in your target folder: `java -jar target/ScientificCalculator-1.0-SNAPSHOT-jar-with-dependencies.jar`

---

## Technical Details

### The Math Parser
Instead of using a basic JavaScript engine or a manual parser, this project uses the **exp4j** library in `MathService.java` for efficient, safe evaluation.
1.  **Pre-processing:** Reads and cleans the string (e.g., replaces `%` with `/100`).
2.  **Expression Builder:** Converts the string into a logical math tree handling nested factors and terms.
3.  **Function Handling:** Automatically processes keywords like "sin" or "log" and applies the correct mathematical operations.

---

## Roadmap

Current status of requested features:

- [x] **Integrate exp4j:** (Replaced manual parsing for better stability).
- [x] **Apply FlatLaf:** (Modernized UI, removing default Swing look).
- [x] **Apply Custom Theme:** (Implemented pastel colors and RoundedButtons throughout UI).
- [x] **Configure Maven Assembly:** (Generates a runnable JAR with dependencies included).

---

* Created by [Noor]