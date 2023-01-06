import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        bubble_sort(arr, n);
        for(int i = 0 ; i < n ; i++)
            System.out.println(arr[i]);
    }
    public static void bubble_sort(int [] arr, int n){
        for(int i = 0 ; i < n-1 ; i++){
            for(int j = 0; j < n-1-i ; j++){
                if(arr[j] > arr[j+1]){
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }
}
