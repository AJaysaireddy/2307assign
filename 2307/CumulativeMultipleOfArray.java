import java.util.Arrays;
import java.util.Scanner;

public class CumulativeMultipleOfArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int cumulativeMultiple = 1;

        for (int i = 0; i < n; i++) {
            try {
                cumulativeMultiple *= arr[i];
            } catch (ArithmeticException e) {
                System.out.println("The element at index " + i + " is 0.");
                break;
            }
        }

        if (cumulativeMultiple != 0) {
            System.out.println("The cumulative multiple of the array is " + cumulativeMultiple);
        }
    }
}
