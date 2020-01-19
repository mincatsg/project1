public class test3 {

    //给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度
    public int removeElement(int[] nums, int val) {
        // int len = nums.length;
        // for(int i = 0; i < len; i++){
        //     if(nums[i] == val){
        //         nums[i] = nums[len - 1];
        //         len--;
        //         i--;
        //     }
        // }
        // return len;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[sum++] = nums[i];
            }
        }
        return sum;
    }
}
