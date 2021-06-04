public class BubbleSort {
    public static void main(String[] args) {
        LinkedList<Integer> unsorted = new LinkedList<>();

        unsorted.push(4);
        unsorted.push(2);
        unsorted.push(9);
        unsorted.push(1);
        unsorted.push(7);

        for (int i = 0; i < unsorted.getSize(); i++) {
            System.out.println(unsorted.get(i));
        }

        System.out.println("");

        LinkedList<Integer> sorted = bubbleSort(unsorted);
        for (int i = 0; i < sorted.getSize(); i++) {
            System.out.println(sorted.get(i));
        }
    }

    public static LinkedList<Integer> bubbleSort(LinkedList<Integer> sort){
        LinkedList<Integer> sorted = sort;

        for (int i = 0; i < sorted.getSize(); i++) {
            for (int n = 0; n < sorted.getSize() - 1; n++) {
                int current = sorted.get(n);
                int next = sorted.get(n + 1);

                if (current > next) {
                    sorted.set(n + 1, current);
                    sorted.set(n, next);
                }
            }
        }
        return sorted;
    }


}
