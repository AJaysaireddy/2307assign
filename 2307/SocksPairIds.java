import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SocksPairIds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of socks pair IDs: ");
        int n = scanner.nextInt();

        int[] arrNum = new int[n];

        System.out.println("Enter the socks pair IDs: ");
        for (int i = 0; i < n; i++) {
            arrNum[i] = scanner.nextInt();
        }

        HashMap<Integer, Integer> sockPairCountMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int sockId = arrNum[i];

            if (!sockPairCountMap.containsKey(sockId)) {
                sockPairCountMap.put(sockId, 1);
            } else {
                sockPairCountMap.put(sockId, sockPairCountMap.get(sockId) + 1);
            }
        }

        int countOfSingularSocks = 0;

        for (int sockId: sockPairCountMap.keySet()) {
            if (sockPairCountMap.get(sockId) % 2 != 0) {
                countOfSingularSocks++;
            }
        }

        System.out.println("Count of singular socks: " + countOfSingularSocks);
    }
}
