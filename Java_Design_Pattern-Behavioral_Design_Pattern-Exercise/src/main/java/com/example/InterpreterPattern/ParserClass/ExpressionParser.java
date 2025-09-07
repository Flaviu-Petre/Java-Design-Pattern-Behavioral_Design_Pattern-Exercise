package com.example.InterpreterPattern.ParserClass;

import com.example.InterpreterPattern.ConcreteExpressionClasses.*;
import com.example.InterpreterPattern.Interface.Expression;

public class ExpressionParser {

    public Expression parse(String expression) {
        expression = expression.replaceAll("\\s+", "");
        return parseExpression(expression);
    }

    private Expression parseExpression(String expr) {
        int operatorIndex = findLastOperator(expr);

        if (operatorIndex == -1) {
            return new NumberExpression(Integer.parseInt(expr));
        }

        String leftPart = expr.substring(0, operatorIndex);
        String operator = expr.substring(operatorIndex, operatorIndex + 1);
        String rightPart = expr.substring(operatorIndex + 1);

        Expression leftExpression = parseExpression(leftPart);
        Expression rightExpression = parseExpression(rightPart);

        switch (operator) {
            case "+":
                return new AdditionExpression(leftExpression, rightExpression);
            case "-":
                return new SubtractionExpression(leftExpression, rightExpression);
            case "*":
                return new MultiplicationExpression(leftExpression, rightExpression);
            case "/":
                return new DivisionExpression(leftExpression, rightExpression);
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    private int findLastOperator(String expr) {
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                return i;
            }
        }
        return -1;
    }
}
