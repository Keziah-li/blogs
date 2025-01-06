public class Lc384 {
    int[] nums; // 保存当前数组
    int[] original; // 保存原始数组

    // 构造函数，初始化对象
    public Solution(int[] nums) {
        this.nums = nums; // 保存传入的数组
        this.original = new int[nums.length]; // 创建一个与 nums 长度相同的数组
        System.arraycopy(nums, 0, original, 0, nums.length); // 将 nums 的内容复制到 original
    }
    
    // 重置方法，将数组重置为原始配置
    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, nums.length); // 将 original 的内容复制回 nums
        return nums; // 返回重置后的数组
    }
    
    // 打乱方法，返回数组的随机排列
    public int[] shuffle() {
        Random random = new Random(); // 创建随机数生成器
        for (int i = 0; i < nums.length; ++i) { // 遍历数组
            int j = i + random.nextInt(nums.length - i); // 生成从 i 到数组末尾之间的随机索引
            int temp = nums[i]; // 交换当前元素和随机索引位置的元素
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums; // 返回打乱后的数组
    }
}
