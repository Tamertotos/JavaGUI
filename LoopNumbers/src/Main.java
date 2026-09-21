public class Main {

    public static void main(String[] args) {
        System.out.println("2 is " + (isPrimaryNumber(2) ? "a primary": "not a primary ") + " number");
        System.out.println("3 is " + (isPrimaryNumber(3) ? "a primary": "not a primary ") + " number");
        System.out.println("6 is " + (isPrimaryNumber(6) ? "a primary": "not a primary ") + " number");
        System.out.println("-------------");
        System.out.println("153 is " + (isNarcissisticNumber(153) ? "a narcissistic":"not a narcissistic") + " number");
        System.out.println("111 is " + (isNarcissisticNumber(111) ? "a narcissistic":"not a narcissistic") + " number");
        System.out.println("-------------");
        System.out.println("factorial of 5 is equal to " + factorial(5));
        System.out.println("factorial of 6 is equal to " + factorial(6));
        System.out.println("-------------");
        System.out.println("10th number of fibonacci sequence is " + fibonacciSequence(10));
    }

    public static boolean isPrimaryNumber(int number){

        if (number < 2) return false;

        for (int i = 2; i <= number / 2; i ++){
            if (number % i == 0){
                return false;
            }
        }

        return true;
    }

    public static boolean isNarcissisticNumber(int number){

        String num = Integer.toString(number);
        int digits = num.length();

        int sum = 0;
        for (char element: num.toCharArray()){
            int digit = (int) element - '0';
            sum += (int)Math.pow(digit,digits);
        }

        return number == sum;
    }

    public static int factorial(int number) {
        if (number == 1){
            return 1;
        }
        return number * factorial(number-1);
    }

    public static int fibonacciSequence(int number){
        if (number <= 2) return 1;

        return fibonacciSequence(number - 1) + fibonacciSequence(number - 2);
    }

}
