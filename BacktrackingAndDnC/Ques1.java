// count inversions - hackerrank

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ques1 {
    // public static void main(String[] args) {
    //     //  ********** brute force approach - O(n^2) ********** 
    //     int[] arr = {8, 4, 2, 1};
        
    //     int count = 0;
    //     for(int i = 0; i < arr.length; i++) {
    //         for(int j = i+1; j < arr.length; j++) {
    //             if(arr[i] > arr[j]) {
    //                 count++;
    //                 System.out.println("("+arr[i]+","+arr[j]+")");
    //             }
    //         }
    //     }

    //     System.out.println("count inversions: " + count);
    // }

    public static void Merge(List<Integer> arr, int start, int mid, int end, int[] count) {
        List<Integer> leftarr = new ArrayList<>();
        List<Integer> rightarr = new ArrayList<>();
        for(int i = start; i <= mid; i++) leftarr.add(arr.get(i));
        for(int i = mid+1; i <= end; i++) rightarr.add(arr.get(i));

        List<Integer> newarr = new ArrayList<>();

        int i = 0, j = 0;
        while(i < leftarr.size() && j < rightarr.size()) {
            if(leftarr.get(i) <= rightarr.get(j)) {
                newarr.add(leftarr.get(i));
                i++;
            }
            else {
                count[0]+=(leftarr.size()-i);
                newarr.add(rightarr.get(j));
                j++;
            }
        }

        while(i < leftarr.size()) {
            newarr.add(leftarr.get(i));
            i++;
        }

        while(j < rightarr.size()) {
            newarr.add(rightarr.get(j));
            j++;
        }

        for(i = start, j = 0; i <= end; i++, j++) {
            arr.set(i, newarr.get(j));
        }
    }

    public static void mergeSort(List<Integer> arr, int start, int end, int[] count) {
        if(start >= end) return ;

        int mid = (start+end) >> 1;

        mergeSort(arr, start, mid, count);
        mergeSort(arr, mid+1, end, count);
        Merge(arr, start, mid, end, count);
    }

    public static void main(String[] args) {
        // merge sort approach with added count inversion - O(n*logn)

        List<Integer> arr = new ArrayList<>(Arrays.asList(2, 1, 3, 1, 2));
        int[] count = new int[1];
        mergeSort(arr, 0, arr.size()-1, count);

        System.out.println("count inversions: " + count[0]);
    }
}