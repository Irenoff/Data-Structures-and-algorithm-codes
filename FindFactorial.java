public class FindFactorial {
    public static int Factorial(int n) {
        if (n == 1)
            return 1;
        else
            return n * Factorial(n - 1); // Corrected the method name
    }

    public static void main(String[] args) {
        int result = Factorial(5); // Corrected the method name
        System.out.println("Factorial is " + result);
    }
}