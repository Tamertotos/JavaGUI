public class Main {
    public static void main(String[] args) {

        //A
        int num = 25;
        int originalNumber = num;
        int divisor = 7;
        while (num > divisor){
            num -= divisor;
        }

        System.out.println(originalNumber + "%" + divisor + "=" + num);
        System.out.println("------------------------");

        //B
        int a = 36;
        int originalA = a;
        int b = 9;
        int originalB = b;
        while (a!=b){
            if (a > b){
                a -= b;
            } else {
                b -= a;
            }
        }
        System.out.println("GCD of (" + originalA + "," + originalB + ") is " + a);
        System.out.println("------------------------");
        //C
        findRoots(2,-4,-2);


        System.out.println("\n------------------------");
        //D-E
        int[] arr = {5,-6,11,0,98,-7};
        int maxElement = arr[0];
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > maxElement){
                maxIndex = i;
                maxElement = arr[i];
            }
        }
        System.out.println("The maximum element in the array is " + maxElement);
        System.out.println("The index of the maximum element is " + maxIndex);
    }


    public static void findRoots(double a, double b, double c){
        double discriminant = b*b - 4 * a * c;
        double root1, root2;
        System.out.printf("The discriminant is %.2f", discriminant);
        if (discriminant > 0){
             root1 = (-b + Math.sqrt(discriminant)) / (2*a);
             root2 = (-b - Math.sqrt(discriminant)) / (2*a);
            System.out.printf("\nx1 = %.2f , x2 = %.2f ", root1,root2);
        } else if (discriminant == 0){
             root1 = root2 = (-b + Math.sqrt(discriminant)) / (2*a);
            System.out.printf("\nx1 = %.2f , x2 = %.2f ", root1,root2);
        } else {
            double real = -b / (2*a);
            double imaginary = Math.sqrt(-discriminant) / (2*a);
            System.out.printf("\nx1 = %.2f+%.2fi ", real,imaginary);
            System.out.printf("\nx2 = %.2f-%.2fi ", real,imaginary);
        }


    }
}
