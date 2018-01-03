package first.java8Features;

import java.util.Arrays;

public class ParallelSortTest {
    private static final int BASE_ARRAY_SIZE = 10000;

    public static double[] generateArray(int size) {
        if (size <= 0 || size > Integer.MAX_VALUE) {
            return null;
        }
        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            result[i] = Math.random();
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10000; i *= 10) {
            int size = BASE_ARRAY_SIZE * i;
            
            double[] myArray1 = generateArray(size);
            double[] myArray2 = Arrays.copyOf(myArray1, myArray1.length);
            System.out.println("Array Size: " + size);

            long startTime = System.currentTimeMillis();
            Arrays.sort(myArray1);
            long endTime = System.currentTimeMillis();
            System.out.println("Time take in serial: " + (endTime - startTime)
                    + "ms.");

            startTime = System.currentTimeMillis();
            Arrays.parallelSort(myArray2);
            endTime = System.currentTimeMillis();
            System.out.println("Time take in parallel: "
                    + (endTime - startTime) + "ms.");
            System.out.println();
        }
    }
}
