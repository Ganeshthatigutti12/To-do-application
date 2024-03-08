import java.util.*;

public class TokenShopping {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of arrays
        int n = scanner.nextInt();

        // Input array tokens
        int[] tokens = new int[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = scanner.nextInt();
        }

        // Input array claim
        int[] claim = new int[n];
        for (int i = 0; i < n; i++) {
            claim[i] = scanner.nextInt();
        }

        // Input k
        int k = scanner.nextInt();

        // Process the data
        processTokens(tokens, claim, k);

        scanner.close();
    }

    private static void processTokens(int[] tokens, int[] claim, int k) {
        int n = tokens.length;
        int minWastage = Integer.MAX_VALUE;
        List<Integer> selectedDays = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            int wastage = calculateWastage(tokens, claim, i, i + k);
            if (wastage < minWastage) {
                minWastage = wastage;
                selectedDays.clear();
                for (int j = i; j < i + k; j++) {
                    if (claim[j] == 0) {
                        selectedDays.add(j + 1);
                    }
                }
            }
        }

        if (selectedDays.isEmpty()) {
            System.out.println("No suitable consecutive days found.");
        } else {
            System.out.println("Selected days: " + selectedDays);
        }
    }

    private static int calculateWastage(int[] tokens, int[] claim, int start, int end) {
        int wastage = 0;
        for (int i = start; i < end; i++) {
            if (claim[i] == 0) {
                wastage += tokens[i];
            }
        }
        return wastage;
    }
}