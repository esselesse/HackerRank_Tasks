import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        int len = arr.length;
        quickSort(arr, 0, len-1);
        int counter=0;
        int i=0;
        int j=1;


        while (j<len && i<len){
            if(arr[j]-arr[i]==k) {
                counter++;
                j++;
            }
            else if(arr[j]-arr[i]<k)
                j++;
            else i++;
        }


        return counter;
    }

    public static void quickSort(int[] mass, int a, int b){
        if(a>=b) return;

        int index = partition(mass, a, b);
        quickSort(mass, a, index);
        quickSort(mass,index+1, b);
    }

    public static int partition(int [] mass, int a, int b){
        int tempIndex = a+(b-a+1)/2;
        long mid = mass[tempIndex];
        int i = a, j = b;
        while (i<=j){
            while(mass[i]<mid) {
                i++;
            }
            while(mass[j]>mid) {
                j--;
            }
            if(i<=j) {
                swap(mass, i++, j--);
            }
        }
        return j;
    }

    private static void swap(int[] mass, int j, int i) {
        int temp = mass[j];
        mass[j]=mass[i];
        mass[i]=temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);
        System.out.println(result);
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
