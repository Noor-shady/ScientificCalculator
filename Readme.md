# 🌸 Pink Scientific Calculator

A robust, stylish, and fully functional scientific calculator built in **Java Swing**. This project features a custom Pink/White/Black aesthetic, a recursive mathematical parser, keyboard support, and a history log.

---

## 📖 Table of Contents
1. [Features](#-features)
2. [Project Structure](#-project-structure)
3. [Usage Guide](#-usage-guide)
4. [Technical Details](#-technical-details)
5. [Roadmap](#-roadmap)

---

## ✨ Features

### 🎨 Visuals & UI
* **Custom Theme:** A unique aesthetic using `PINK_COLOR (255, 130, 253)`, Black text, and White backgrounds.
* **Rounded Buttons:** Custom-painted `JButton` components for a modern, soft look.
* **Responsive Layout:** Uses `BorderLayout` and `GridLayout` to maintain structure.

### 🧮 Mathematical Capabilities
* **Basic Operations:** Addition, Subtraction, Multiplication, Division.
* **Scientific Functions:** Sine, Cosine, Tangent, Logarithm (base 10), Natural Log (ln), Exponents (`^`).
* **Order of Operations:** Fully respects mathematical precedence (PEMDAS) using a recursive descent parser.
* **Scientific Notation:** Automatically formats extremely large or small results (e.g., `1.23E8`).

### 🛠 Utility Features
* **History Sidebar:** A scrollable side panel that logs every calculation and result.
* **Keyboard Support:** Type numbers and operators directly without clicking.
* **Mode Toggle:** Switch between **Degrees (DEG)** and **Radians (RAD)** for trigonometric functions.

---

## 📂 Project Structure

The code is organized into **4 separate files** to ensure clean architecture and maintainability:

| File | Description |
| :--- | :--- |
| **`Main.java`** | **The Entry Point.** It launches the application on the Swing Event Dispatch Thread (EDT) to ensure thread safety. |
| **`CalculatorUI.java`** | **The Frontend.** Handles the window creation, button layout, colors, listeners, and the History sidebar. |
| **`MathService.java`** | **The Backend.** Contains the "brain" of the calculator. It parses strings (e.g., "5+sin(90)") and returns raw `double` values. |
| **`RoundedButton.java`** | **Custom Component.** A custom class extending `JButton` that overrides `paintComponent` to draw smooth, rounded corners. |

---

## 🎮 Usage Guide

### 1. Typing vs. Clicking
* **Clicking:** Use your mouse to click the on-screen buttons.
* **Typing:** The calculator listens to keyboard input.
    * **Type numbers** (`0-9`) and operators (`+`, `-`, `*`, `/`, `^`).
    * Press **`Enter`** to calculate the result (`=`).
    * Press **`Esc`** to clear the screen (`AC`).
    * Press **`Backspace`** to delete the last character (if focusing the text field).

### 2. Trigonometry (DEG vs RAD)
* By default, the calculator starts in **DEG (Degree)** mode.
* Click the **DEG/RAD** toggle button in the top-left corner to switch.
    * *Example in DEG:* `sin(90)` = `1.0`
    * *Example in RAD:* `sin(1.57)` ≈ `1.0`

### 3. Viewing History
* The sidebar on the right automatically updates after every successful calculation.
* It displays the **Equation** followed by the **Result**.
* Use the scroll bar if the history becomes too long.

---

## ⚙ Technical Details

### The Math Parser
Instead of using a basic library like `JavaScript engine`, this project uses a custom **Recursive Descent Parser** in `MathService.java`.
1.  **Tokenizer:** Reads the string character by character.
2.  **Expression/Term/Factor:** breaks down the math into logical chunks (e.g., multiplication is processed before addition).
3.  **Function Handling:** Detects keywords like "sin" or "log" and applies the correct `Math` library function based on the current DEG/RAD state.

---

## 🗺 Roadmap

Current status of requested features:

- [x] **Add keyboard support:** (Type directly without clicking).
- [x] **Add a "History" sidebar:** (View past calculations).
- [x] **Toggle between Degree/Radian mode:** (Affects sin/cos/tan).
- [x] **Add scientific notation display:** (Handles large outputs).
- [x] **Apply Custom Pink Theme:** (Implemented throughout UI).

---

* Created by [Noor] 