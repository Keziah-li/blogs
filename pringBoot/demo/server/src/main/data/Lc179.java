package main.data;
import java.util.*;

class Lc179 {
    public String largestNumber(int[] nums) {
        // 将整数数组转换为字符串数组
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 自定义排序规则
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // 如果排序后的第一个元素是 "0"，则整个数组都是 "0"
        if (strs[0].equals("0")) {
            return "0";
        }

        // 拼接排序后的字符串数组
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }
}
