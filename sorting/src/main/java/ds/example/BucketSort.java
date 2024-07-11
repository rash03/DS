package ds.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    int[] arr;

    public BucketSort(int[] arr) {
        this.arr = arr;
    }

    void printArray() {
        System.out.println(Arrays.toString(arr));
    }

    public void printBucket(List<Integer>[] buckets) {
        for (List<Integer> bucket : buckets) {
            System.out.println(Arrays.toString(bucket.toArray()));
        }
    }

    public void sort() {
        int numOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        List<Integer>[] buckets = new ArrayList[numOfBuckets];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        for (int value : arr) {
            int bucketNum = (int) Math.ceil(((float) value * numOfBuckets) / (float) maxValue);
            buckets[bucketNum - 1].add(value);
        }

        System.out.println("printing Buckets before Sort");
        printBucket(buckets);
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);

        }
        System.out.println("printing Buckets after Sort");
        printBucket(buckets);

        int index = 0;
        for(List<Integer> bucket: buckets){
            for(int value: bucket){
                arr[index] = value;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,7,5,4,2,1,3,6,8};
        BucketSort bs = new BucketSort(arr);
        bs.printArray();
        bs.sort();
        bs.printArray();
    }
}
