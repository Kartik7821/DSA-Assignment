import java.util.Scanner;

public class TreeProduct {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int H = scanner.nextInt();
            if (H == 0)
                break;

            int[] values = new int[(int) Math.pow(2, H) - 1];
            for (int i = 0; i < values.length; i++) {
                values[i] = scanner.nextInt();
            }

            int result = calculateP1(H, values);
            System.out.println(result);
        }
    }

    static int calculateP1(int H, int[] values) {
        int[] internalValues = new int[(int) Math.pow(2, H)];

        for (int i = (int) Math.pow(2, H) - 1; i > 0; i--) {
            int leftChild = 2 * i;
            int rightChild = 2 * i + 1;

            if (leftChild >= values.length) {
                internalValues[i] = values[i - 1];
            } else {
                internalValues[i] = Math.max(values[i - 1] * internalValues[leftChild],
                        values[i - 1] * internalValues[rightChild]);
            }
            internalValues[i] %= MOD;
        }

        return internalValues[1];
    }
}
