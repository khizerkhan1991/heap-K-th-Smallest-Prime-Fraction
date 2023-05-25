import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        kthSmallestPrimeFraction(new int[]{1,7}, 1);
    }


    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {

        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Map<Double, List<Integer>> map = new HashMap<>();

        while (firstIndex < arr.length -1){

            if(priorityQueue.size() >= k *2)
                break;

            int firstNumber = arr[firstIndex];
            int secondNumber = arr[lastIndex];

            double factor = (double) arr[firstIndex]/ arr[lastIndex];
            map.put(factor,new ArrayList<>(){{add(firstNumber); add(secondNumber);}});
            priorityQueue.add(factor);

            if(lastIndex - firstIndex <= 1){
                firstIndex ++;
                lastIndex = arr.length -1;
            }
            else {
                lastIndex--;
            }
        }


        while (priorityQueue.size() > k)
            priorityQueue.poll();

        List<Integer> list = map.get(priorityQueue.poll());

        return new int[]{list.get(0), list.get(1)};
    }
}