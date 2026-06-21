package com.calculator;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MathService {

    /**
     * Evaluates a mathematical string expression using the exp4j library.
     * @param expressionText The string from the calculator display
     * @return The calculated double result
     * @throws RuntimeException if the expression is invalid
     */
    public static double evaluate(String expressionText) {

        // Pre-process the string for common calculator quirks
        // (Optional: If users type "X%", I can replace it with "(X/100)" before parsing)
        String cleanExpression = expressionText.replace("%", "/100");

        try {
            // Build and evaluate the expression using exp4j
            Expression expression = new ExpressionBuilder(cleanExpression)
                    .build();

            return expression.evaluate();

        } catch (IllegalArgumentException | ArithmeticException e) {
            // Catch parsing errors (e.g., mismatched parentheses, missing operands)
            // I throw a generic exception here so the UI knows to print "Error"
            throw new RuntimeException("Invalid mathematical expression", e);
        }
    }
}