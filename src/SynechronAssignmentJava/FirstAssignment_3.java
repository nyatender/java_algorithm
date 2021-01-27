package SynechronAssignmentJava;

import java.util.LinkedHashSet;
import java.util.Set;

public class FirstAssignment_3 {

    Set<Integer> cache;
    int capacity;
    int pageFault;

    public FirstAssignment_3(int capacity)
    {
        this.cache = new LinkedHashSet<Integer>(capacity);
        this.capacity = capacity;
        this.pageFault = 0;
    }

    public boolean get(int key)
    {
        if (!cache.contains(key))
            return false;
        cache.remove(key);
        cache.add(key);
        return true;
    }

    public void refer(int key)
    {
        if (get(key) == false) {
            put(key);
            pageFault++;
        }
    }

    public void put(int key)
    {
        if (cache.contains(key))
            cache.remove(key);

        else if (cache.size() == capacity) {
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }

        cache.add(key);
    }

    public int getPageFault() {
        return pageFault;
    }
    public static void main(String[] args)
    {
        int[] arrList = new int[] { 5, 0, 1, 3, 2, 4, 1, 0, 5};
        int page_count = 4;

        FirstAssignment_3 LRU = new FirstAssignment_3(page_count);
        for(int i = 0; i < arrList.length; i++)
            LRU.refer(arrList[i]);
        System.out.println(LRU.getPageFault());
    }
}