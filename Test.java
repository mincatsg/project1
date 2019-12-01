import java.util.Comparator;

class Card implements Comparable<Card> {
    public String suit; // 花色
    public int rank;    // 点数

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object obj) {
        // 按值来比较
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Card)) {
            return false;
        }
        // 真正比较值
        Card otherCard = (Card)obj;
        return this.rank == otherCard.rank &&
                this.suit.equals(otherCard.suit);
    }

    @Override
    public int compareTo(Card o) {
        // 比较 this 和 o 这两个对象的大小关系
        // 返回值如果 this < o , 返回 <0 的整数
        // 如果 this > o , 返回 >0 的整数
        // 如果 this 和 o 相等, 返回 0
        // 我们可以认为 null 是最小
        if (o == null) {
            return 1;
        }
        return this.rank - o.rank;
    }
}

class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        // 如果 o1 < o2 , 返回 <0 的整数
        // 如果 o1 > o2 , 返回 >0 的整数
        // 如果 o1 和 o2 相等, 返回 0
        // 直接调用 compareTo 的情况
        // return o1.compareTo(o2);
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            // o2 一定不是 null
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.rank - o2.rank;
    }
}

public class Test {
    public static void main(String[] args) {
        Card card1 = new Card("♠", 10);
        Card card2 = new Card("♠", 10);
        System.out.println(card1 == card2);
        // equals 默认行为也是比较身份
        System.out.println(card1.equals(card2));
    }
}

