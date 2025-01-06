package main.data;
import java.util.*;
// TopKFrequentElements
public class Lc347  {
    public int[] topKFrequent(int[] nums, int k) {
        // 统计每个元素的频率
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // 创建一个小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        // 遍历频率表
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            // 将频率添加到堆中
            heap.add(entry);
            // 如果堆的大小超过k，则移除堆顶元素
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // 取出堆中的元素
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll().getKey();
        }
        return top;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        System.out.print("前 " + k + " 个高频元素是: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
