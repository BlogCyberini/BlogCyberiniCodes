package com.blogspot.inimushawa;

public class Algoritmos {

    public static Double delta(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public static Double x1(double a, double b, double c) {
        Double delta = delta(a, b, c);
        if (delta < 0 || a == 0) {
            return null;
        }
        return (-b + Math.sqrt(delta)) / (2 * a);
    }

    public static Double x2(double a, double b, double c) {
        Double delta = delta(a, b, c);
        if (delta < 0 || a == 0) {
            return null;
        }
        return (-b - Math.sqrt(delta)) / (2 * a);
    }

    public static String calc(double a, double b, double c) {
        Double x1 = x1(a, b, c);
        if (x1 == null) {
            return "Solução indeterminada no conjunto dos Números Reais ou valor do coeficiente \"a\" igual a zero!";
        }
        Double x2 = x2(a, b, c);
        return String.format("A solução da equaçãoo �:\nX1 = %s\nX2 = %s", x1.toString(), x2.toString());
    }
}
