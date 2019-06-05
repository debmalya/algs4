package java8.examPreparation;

import java.util.ArrayList;
import java.util.List;

public class FunctionExamples {

    public static void main(String[] args) {

    }

    int[] powersOfTwo(int n) {
        char[] arr = Integer.toBinaryString(n).toCharArray();

        List<Integer> powList = new ArrayList<>(0);
        for (int i =0; i<arr.length;i++){
            if (arr[i]=='1'){
                powList.add((int)Math.pow(2,i));
            }

        }
        int[] a = new int[powList.size()];
        for (int i= 0; i< powList.size();i++){
            a[i] = powList.get(i);
        }
        return a;
    }
}
