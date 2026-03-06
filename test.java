public class test {

    public static void testRange(int min, int max, boolean evens) {
        System.out.println("Testing [" + min + "," + max + "] " + (evens ? "evens" : "odds") + "...");
        for (int i = min; i < max; i += 2) {
            int testValue = evens ? i : i - 1;
            int result = isEven.isEven(testValue);
            boolean isEvenResult = (result == 1);

            if (isEvenResult != evens) {
                throw new RuntimeException("Test failed. Got: isEven(" + testValue + ") = " +
                                         result + ". Expected: isEven(" + testValue + ") = " +
                                         (evens ? "1" : "0") + ".");
            }
        }
        System.out.println("Test passed.");
    }

    public static void main(String[] args) {
        testRange(0, 10000, true);
        testRange(0, 10000, false);

        // Additional edge case tests
        System.out.println("Testing edge cases...");

        // Test large numbers (recursive case)
        int result10000 = isEven.isEven(10000);
        if (result10000 != 1) {
            throw new RuntimeException("Test failed for 10000. Expected even.");
        }

        int result10001 = isEven.isEven(10001);
        if (result10001 != 0) {
            throw new RuntimeException("Test failed for 10001. Expected odd.");
        }

        int result50000 = isEven.isEven(50000);
        if (result50000 != 1) {
            throw new RuntimeException("Test failed for 50000. Expected even.");
        }

        int result99999 = isEven.isEven(99999);
        if (result99999 != 0) {
            throw new RuntimeException("Test failed for 99999. Expected odd.");
        }

        System.out.println("All edge case tests passed.");
        System.out.println("\nAll tests passed successfully!");
    }
}

