package Lesson4;

public class Function {
    public static double tringleSquare(double a, double b, double c) {
        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }
    public static void isNegative(double a) throws NegativeValueOfParameterException {
        if (a < 0) {
            throw new NegativeValueOfParameterException();
        }

    }

    public static void main(String[] args) {
        System.out.println(tringleSquare(10, 10,10));
    }
}
