import java.util.Arrays;

public class Patterns {
    public static void main(String[] args) {
        int[] arr={3,2,4,1,5};
        quickSort(arr,0,4);
        System.out.println(Arrays.toString(arr));
    }
    static void pattern(int n){
        for (int row = 1; row <2*n; row++) {
            int noOfCols=row<=n?row:(2*n-row);
            for (int col = 1; col <=noOfCols; col++) {
                System.out.print("* ");
            }
            System.out.println();

        }
    }
    static void pattern2(int n){
        for (int row = 1; row <2*n; row++) {
            int noOfCols=row<=n?row:(2*n-row);
            int noOfSpaces=n-noOfCols;
            for (int space = 0; space <noOfSpaces ; space++) {
                System.out.print(" ");

            }
            for (int col = 1; col <=noOfCols; col++) {
                System.out.print("* ");
            }
            System.out.println();

        }
    }
    static  void pattern3(int n)
    {
        for(int row=1;row<n;row++)
        {
            for(int spaces=1;spaces<=n-row;spaces++)
                System.out.print(" ");
            for (int col=row;col>=1;col--)
                System.out.print(col+"");
            for (int col=2;col<=row;col++)
                System.out.print(col+"");
            System.out.println();
        }
    }
    static void recursionPattern(int r,int c)
    {
        if(r==0) return;
        if (r>c) {
            recursionPattern(r,c+1);
            System.out.print("* ");
        }
        else {
            recursionPattern(r-1,0);
            if (r==1) return;

            System.out.println();
        }

    }
    static int[] recursionBubbleSort(int[] arr, int lastIndex , int currentIndex)
    {
        if(lastIndex==0) return arr;
        if(lastIndex>currentIndex)
        {
            if (arr[currentIndex] > arr[currentIndex + 1]) {
                int temp = arr[currentIndex];
                arr[currentIndex] = arr[currentIndex + 1];
                arr[currentIndex + 1] = temp;
            }
            return recursionBubbleSort(arr,lastIndex,currentIndex+1);
        }
        else {
            return recursionBubbleSort(arr,lastIndex-1,0);
        }
    }
    static void recursionSelectionSort(int[] arr, int lastIndex , int currentIndex,int maxIndex)
    {
        if(lastIndex==0) return;
        if(lastIndex>=currentIndex)
        {
            if (arr[currentIndex] > arr[maxIndex]) {
                maxIndex=currentIndex;
            }
             recursionSelectionSort(arr,lastIndex,currentIndex+1,maxIndex);
        }
        else {

            int temp = arr[lastIndex];
            arr[lastIndex] = arr[maxIndex];
            arr[maxIndex] = temp;
             recursionSelectionSort(arr,lastIndex-1,0,0);
        }
    }
    static int[] mergeSort(int[] arr)
    {
        if(arr.length==1) return arr;
        int mid=arr.length/2;
        int[] left=mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right=mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix=new int[first.length+second.length];
        int i=0,j=0,k=0;
        while(i< first.length&&j< second.length)
        {
            if(first[i]<second[j]) mix[k++]=first[i++];
            else mix[k++]=second[j++];
        }
        while (i< first.length) mix[k++]=first[i++];
        while (j< second.length) mix[k++]=second[j++];
        return mix;
    }
    static void mergeSortInPlace(int[] arr,int s,int e)
    {
        if(e-s==0) return ;
        int mid=(s+e)/2;
        mergeSortInPlace(arr,s,mid);
        mergeSortInPlace(arr,mid+1,e);
        mergeInPlace(arr,s,mid,e);
    }
    static void mergeInPlace(int[] arr, int s,int m ,int e) {
        int[] mix=new int[e-s+1];
        int i=s,j=m+1,k=0;
        while(i<=m&&j<=e)
        {
            if(arr[i]<arr[j]) mix[k++]=arr[i++];
            else mix[k++]=arr[j++];
        }
        while (i<=m) mix[k++]=arr[i++];
        while (j<=e) mix[k++]=arr[j++];
        for (int l = 0; l < mix.length; l++) {
            arr[s+l]=mix[l];
        }
    }
    static void quickSort(int[] arr,int low, int high)
    {
        if(low>=high) return;

        int s=low;
        int e=high;
        int mid=s+(e-s)/2;
        int pivot= arr[mid];
        while (s<=e)
        {
            while(arr[s]<pivot) s++;
            while(arr[e]>pivot) e--;
            if(s<=e){
                int temp=arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;e--;
            }
        }
        quickSort(arr,low,e);
        quickSort(arr,s,high);
    }

}
