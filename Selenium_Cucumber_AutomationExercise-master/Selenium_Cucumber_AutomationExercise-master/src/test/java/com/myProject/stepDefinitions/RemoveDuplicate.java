package com.myProject.stepDefinitions;

import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,4,6,3,2,3,4,1,6,8,4};
        int temp[] = new int[arr.length];
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int j=0;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]!=arr[i+1])
                temp[j++]=arr[i];
        }
        temp[j++]=arr[arr.length-1];
        System.out.println(j);
        for(int k=0;k<j;k++)
            arr[k]=temp[k];
        for(int i=0;i<j;i++)
            System.out.print(arr[i]+" ");
    }
}
