import java.util.Scanner;

public class ExceptionDemo {

    static class ErrorCatch {
        int trigger = 0;

        void bad() {
            try {
                System.out.println("Entering a letter will start the error propagation, fix me by entering a number");
                Scanner sc = new Scanner(System.in);
                trigger = sc.nextInt(); // unchecked exception occurred
            } catch (Exception bad) { // code to catch the error happens here and moves to next sequence
                stillNotFixed(); // exception propagated to stillNotFixed
            }
        }

        void stillNotFixed() {
            try {
                System.out.println("Enter a letter again to keep moving down the stack, or a number to fix it");
                Scanner sc = new Scanner(System.in);
                trigger = sc.nextInt(); // unchecked exception occurred
            } catch (Exception stillBad) { // code to catch the error again and move onto the next sequence
                fix(); // exception propagated to fix()
            }
        }

        void fix() {
            try {
                System.out.println("Third times a charm, enter another letter to catch the problem, or enter a number here");
                Scanner sc = new Scanner(System.in);
                trigger = sc.nextInt(); // unchecked exception occurred
            } catch (Exception fix) { // this code catches the error again, but since there is not another
                //redirection, it moves on to the next line of code which is the normal flow text at the end.
                System.out.println("I caught the problem, you entered a letter");
                System.out.println("We can continue now\n");
            }
        }
    }
    public static void main(String[] args)  {
        ErrorCatch obj = new ErrorCatch();
        obj.bad();
        System.out.println("Normal flow...");
    }
}