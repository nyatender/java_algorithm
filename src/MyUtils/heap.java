package MyUtils;

public class heap {
    public static void main(String[] args) {
        int[] array = new int[]{2,10,6,18,11,1,3,56,4};
        Heap obj = new Heap(array);
        obj.buildHeap();
        obj.sortHeap();
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
       // obj.display();
    }
    static class Heap {
        private int[] arr;
        private int length;
        Heap(int[] array) {
            arr = array;
            length = arr.length;
        }
        void buildHeap() {
            for(int i = arr.length/2; i >= 0; i--) {
                reHeap(i, length);
            }
        }
        void sortHeap() {
            for(int i = length-1; i >= 0; i--) {
                swap(i, 0);
                reHeap(0, i);
            }
        }
        void reHeap(int parent, int n) {
            int left = 2*parent + 1;
            int right = 2*parent + 2;
            int largest = parent;
            if(left < n && arr[left] > arr[largest])
                largest = left;
            if(right < n && arr[right] > arr[largest])
                largest = right;

            if(largest != parent) {
                swap(largest, parent);
                reHeap(largest, n);
            }
        }
        void swap(int i, int j) {
            int val = arr[i];
            arr[i] = arr[j];
            arr[j] = val;
        }
        void display() {
            for(int i = 0; i < length; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}
