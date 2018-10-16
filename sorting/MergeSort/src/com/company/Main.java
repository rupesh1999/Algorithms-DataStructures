package com.company;

public class Main {

    void merge(int arr[] , int l , int m , int r){
        int r1 = m-l+1;
        int r2 = r-m;

        int[] L = new int[r1];
        int[] R = new int[r2];

        for(int i = 0 ; i < r1 ; i++)
            L[i] = arr[l + i];
        for (int j=0; j<r2; ++j)
            R[j] = arr[m + 1+ j];

        int i=0 , j=0 , k=l;
        while(i<r1 && j<r2){
            if(L[i] < R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < r1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < r2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int[] arr , int l , int r){
        if(l<r){
            int mid = (l+r)/2;

            sort(arr , l , mid);
            sort(arr , mid+1 , r);

            merge(arr , l , mid , r);
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
	    // write your code here
        Main ob = new Main();
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
