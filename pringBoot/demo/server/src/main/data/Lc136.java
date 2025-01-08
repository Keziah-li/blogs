import java.util.*;
public class Lc136 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1); // 统计每个数出现的次数
        }
        //   Set<Map.Entry<K, V>> entrySet() 返回映射关系的Set集合
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey(); // 找到出现一次的数
            }
        }
        return -1; // 如果没有找到，返回-1
    }
}

