public class SeqList {
    int[] data = new int[10];
    private  int size = 0;
    //打印
    public void display(){
        for(int i = 0; i < size; i++){
            if(i == 0){
                System.out.print("[");
            }
            if(i < size - 1){
                System.out.print(data[i]+ ",");
            }
            else{
                System.out.print(data[i] +"]");
            }
        }
        System.out.println();
    }
//添加元素
    public void add(int pos, int elem) {
              if(size == data.length){
                  realloc();
              }
              if (pos < 0 || pos > size) {
                  return;
              }
              if (pos == size) {
                  data[pos] = elem;
                  size++;
              } else {
                  for (int i = size - 1; i >= pos; i--) {
                      data[i + 1] = data[i];
                  }
                  data[pos] = elem;
                  size++;
              }
          }
          //增容
          public void realloc(){
        int[] arr = new int[data.length * 2];
        for(int i = 0; i < data.length; i++){
            arr[i] = data[i];
        }
        this.data = arr;
       }
       //查找某个元素位置
       public int search(int toFind) {
        for(int i = 0; i < size; i++){
            if(data[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        int p = search(toFind);
        if(p != -1) {
            return true;
        }
        return false;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos > 0 && pos < size){
            return data[pos];
        }
        return -1;
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        data[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int num = search(toRemove);
        if(num == -1){
            return;
        }
        for(;num < size - 1; num++){
            data[num] = data[num + 1];
        }
        System.out.println("删除成功");
    }
    //获取顺序表长度
    public int size() {
        return size;
    }
    //// 清空顺序表
    public void clear() {
        data = new int[10];
        System.out.println("清空完毕");
    }
    public static void main(String[] args) {
        //在另一个实验类中检验是否满足要求;
    }
}
