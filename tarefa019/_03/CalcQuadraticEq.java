package org.example._03;

import java.text.DecimalFormat;

public class CalcQuadraticEq {

    public void calcQuadraticEq(double a, double b, double c) {
        double D = b * b - 4 * a * c;

        if (D > 0) {
            double x1 = (-b - Math.sqrt(D)) / (2 * a);
            double x2 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println("Roots: x1 = " + formatDouble(x1) + ", x2 = " + formatDouble(x2));
        } else if (D == 0) {
            double x = -b / (2 * a);
            System.out.println("Root: x = " + formatDouble(x));
        } else {
            System.out.println("Equation has no real roots.");
        }
    }

    private String formatDouble(double value) {
        DecimalFormat df = new DecimalFormat("#.#####");
        return df.format(value);
    }
}

