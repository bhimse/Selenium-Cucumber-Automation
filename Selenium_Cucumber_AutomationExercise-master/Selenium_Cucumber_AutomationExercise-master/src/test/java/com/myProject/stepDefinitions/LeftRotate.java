package com.myProject.stepDefinitions;

public class LeftRotate {
    public static void main(String[] args) {
        int[] arr ={1,4,3,6,8,5};
        int k = 3;
        for(int i=0;i<k;i++)
        {
            int first=arr[0];
            int j;
            for(j=0;j<arr.length-1;j++)
            {
                arr[j]= arr[j+1];
            }
            arr[j]=first;
        }
        System.out.println("array after left rotate");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
