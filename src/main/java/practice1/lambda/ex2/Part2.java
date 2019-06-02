package practice1.lambda.ex2;

import java.util.*;

public class Part2 {
    private static int k = 3;

    public static void main(String[] args) {
        System.out.println("With ArrayList it's claimed: " + doWithArrayList(1499) + " , with LinkedList it's claimed: " + doWithLinkedList(1499));
    }

    private static long doWithArrayList(int n) {
        ArrayList<Integer> listOfNumber = new ArrayList<>();
        populateArray(listOfNumber, n);
        long startTime = System.nanoTime();
        doIt(listOfNumber);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long doWithLinkedList(int n) {
        LinkedList lst = new LinkedList();
        populateArray(lst, n);
        long startTime = System.nanoTime();
        doIt(lst);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static void doIt(AbstractList<Integer> list) {
        int countN = 0;
        int countK = 0;
        while (list.size() > 0) {
            countN++;
            countK++;
            if (countN > list.size() - 1) {
                countN = 0;
            }
            if (countK == k) {
                list.remove(countN);
                countK = 0;
            }
        }
    }

    private static void populateArray(AbstractList<Integer> list, int n) {
        while (n > 0) {
            list.add(new Random().nextInt(1500));
            n--;
        }
    }
}
