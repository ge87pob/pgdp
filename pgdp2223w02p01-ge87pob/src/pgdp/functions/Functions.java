package pgdp.functions;

public class Functions {

    public static void main(String[] args) {

        int hoch3 = cube(2);
        System.out.println(hoch3);

        int durchschnitt = average(2,3,4);
        System.out.println(durchschnitt);

        boolean pythagoras = isPythagoreanTriple(3,5,5);
        System.out.println(pythagoras);

    }

    public static int square(int n) {
        return n*n;
    }

    public static int sumOfSquares(int a, int b) {
        int aSquared = square(a);
        int bSquared = square(b);

        return aSquared + bSquared;
    }


    public static int cube(int n) {
        // TODO
        n = n*n*n;
        return n;
    }

    public static int average(int a, int b, int c) {
        // TODO
        int sum = a+b+c;
        return sum/3;
    }

    public static boolean isPythagoreanTriple(int a, int b, int c) {
        // TODO: Benutze in dieser Methode keine arithmetischen Operatoren (i.e. +, -, *, /, % etc.)!
        return sumOfSquares(a, b) == square(c);


    }

}
