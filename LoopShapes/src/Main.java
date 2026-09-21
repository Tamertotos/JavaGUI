public class Main {

    public static void main(String[] args) {

        //Starter1
        System.out.println("Starter1");
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < i + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }


        //Starter2
        System.out.println("\nStarter2");
        int column = 6;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < column; j++){
                if(j % 2 == 0 && i % 2 == 0){
                    System.out.print("*");
                } else if (j % 2 != 0 && i % 2 != 0){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        //Shape1
        System.out.println("\nShape1");
        for (int i = 0; i < 4; i++){
            for (int j= 0; j < 4 - i ; j++){
                System.out.print(" ");
            }

            for (int k = 0; k < i + 1; k++){
                System.out.print("*");
            }

            for (int l = 0; l < i; l++){
                System.out.print("*");
            }

            System.out.println();
        }

        //Shape2
        System.out.println("\nShape2");
        for (int i = 0; i < 4; i++){
            for (int j= 0; j < 4 - i ; j++){
                System.out.print(" ");
            }

            for (int k = 0; k < i + 1; k++){
                System.out.print("*");
            }

            for (int l = 0; l < i; l++){
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < i + 2 ; j++){
                System.out.print(" ");
            }

            for (int k = 0; k < 3 - i; k++){
                System.out.print("*");
            }

            for (int l = 0; l < 2 - i; l++ ){
                System.out.print("*");
            }
            System.out.println();
        }


        //Shape3
        System.out.println("\nShape3");
        for (int i = 0; i < 4; i++){

            for (int j = 0; j < i; j++){
                System.out.print(" ");
            }

            for (int k = 0; k < 4 - i ; k++){
                System.out.print("*");
            }

            for (int l = 0; l < 3 - i; l++){
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = 0; i < 3; i++){

            for (int j = 0;  j < 2 - i; j++){
                System.out.print(" ");
            }

            for (int k = 0; k < i + 2; k++){
                System.out.print("*");
            }

            for (int l = 0; l < i + 1; l++){
                System.out.print("*");
            }

            System.out.println();
        }



        //Shape4
        System.out.println("\nShape4");
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 6; j++){
                if (i == 0 || i == 4 || j == 0 || j == 5){
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


        //Shape5
        System.out.println("\nShape5");
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if (i == 0 || i == 5 || j == 0 || j == 5 || i == j){
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


        //Shape6
        System.out.println("\nShape6");
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if (i == 0 || i == 5 || j == 0 || j == 5 || i == j ||  j + i == 5){
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

   }
}
