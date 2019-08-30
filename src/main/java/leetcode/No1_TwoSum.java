package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AddTwoNumbers
 * @Description: 数组，哈希表
 * @auther: caiwei
 * @date: 2019/4/16 17:21
 */
public class No1_TwoSum {
    public static void main(String[] args) {
        method1();
        method2();
    }
    //二重遍历
    static void method1(){
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        for(int i = 0; i < arr.length; i++){
            for (int j = i+1; j < arr.length; j++) {
                if((arr[i] + arr[j]) == 7){
                    int[]a = new int[]{1, 2};
                    System.out.println("i: "+i+" j:"+ j);
                }
            }
        }
    }
    //map
    static void method2() {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }
        for (int j = 0; j < arr.length; j++) {
            int complement = 7 - arr[j];
            if (map.containsKey(complement) && map.get(complement) != j) {
                System.out.println(map.get(complement) +"  "+ j);
            }
        }

    }
}
