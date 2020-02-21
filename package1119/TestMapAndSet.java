package package1119;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

public class TestMapAndSet {

    // [1, 1, 2, 2, 3]
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int x : nums) {
            result ^= x;
        }
        return result;
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        // 1. 先创建一个 HashMap , key 是旧的节点, value 是旧的节点对应的新的节点
        HashMap<Node, Node> hashMap = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            // 2. 把旧链表的节点依次以键值对的形式插入进来
            hashMap.put(cur, new Node(cur.val, null, null));
        }
        // 3. 再次遍历旧的链表, 根据刚才得到的 hashMap
        // 就能够方便的把 next 和 random 都指到正确的位置上
        for (Node cur = head; cur != null; cur = cur.next) {
            hashMap.get(cur).next = hashMap.get(cur.next);
            hashMap.get(cur).random = hashMap.get(cur.random);
        }
        return hashMap.get(head);
    }

    public int numJewelsInStones(String J, String S) {
        // 1. 创建一个 Set 来保存所有的宝石
        Set<Character> set = new HashSet<>();
        // 2. 遍历 J , 把所有的宝石加入到 Set 中.
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        // 3. 遍历 S, 取出每个字符, 看看是不是宝石
        //    如果是宝石, 就 count += 1
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public List<String> topKFrequent(String[] words, int k) {
        // 1. 统计每个单词出现的次数, Map 来搞定
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            int count = map.getOrDefault(w, 0);
            map.put(w, count + 1);
        }
        // 2. 把这些单词放在一个 ArrayList 中, 并进行排序
        //    自定制比较规则
        List<String> result = new ArrayList<>(map.keySet());
        // 在 sort 方法的第二个参数中指定一个比较器对象
        // 来描述自定制比较规则(按出现次数来排序)
        Collections.sort(result, new MyComp(map));
        // subList 能够返回一个 List 中的一个子区间
        // [0, k) 前闭后开区间
        return result.subList(0, k);
    }

    class MyComp implements Comparator<String> {
        private Map<String, Integer> map = null;

        public MyComp(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                // 就按字符串自身的大小来决定先后顺序
                return o1.compareTo(o2);
            }
            // 降序排序写成 count2 - count1
            // 升序排序写成 count1 - count2
            return count2 - count1;
        }
    }
}
