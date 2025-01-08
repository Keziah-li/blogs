import java.util.*;
public class Lc56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
              return new int[0][];
        }

        // 为什么可以直接new int【】
        // 在Java中，int是一个基本数据类型，而不是一个对象类型。
        // 你不能直接使用new关键字来创建一个int变量，但是你可以使用new关键字来创建一个int数组。

        // 例如：
        //  int[] array = new int[10]; // 创建一个包含10个整数的数组
        // 在这个例子中，new int[10]创建了一个包含10个整数的数组。数组是对象，因此可以使用new关键字来创建。

        // 如果你想创建一个Integer对象（Integer是int的包装类），你可以这样做：
        // Integer integerObject = new Integer(5); // 创建一个包含值5的Int
        // 总结：

        // int是基本数据类型，不能直接使用new关键字。
        // int[]是一个数组，可以使用new关键字来创建。
        // Integer是int的包装类，可以使用new关键字来创建。

        // 按照区间的起始位置进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
              // 如果 merged 为空，或者当前区间的起始位置大于 merged 列表中最后一个区间的结束位置
              if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                   merged.add(interval);
              } else {
                   // 否则，合并区间
                   merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
              }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
