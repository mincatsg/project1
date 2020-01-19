public class test7 {
    //给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
        public void rotate(int[] nums, int k) {
            //     int i = 0; //进行nums.length次
            //     int key = 0;
            //     int value = nums[0];
            //     k = k % nums.length;  //实际移动次数
            //    while(i < nums.length){
            //           int tem = 0;
            //           key = (key + k) % nums.length; //这个值该放的位置
            //           tem = nums[key]; //记住原本值.
            //           nums[key] = value;
            //           value = tem;
            //           i++;
            //    }
            int[] tem = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                tem[(i + k) % nums.length] = nums[i];
            }
            for(int i = 0; i < nums.length; i++){
                nums[i] = tem[i];
            }
        }

}
