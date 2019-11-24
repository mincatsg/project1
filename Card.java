package MyComparable;

class Card1 implements Comparable<Card1>{
    public int rank; //数值
    public String suit; //花色

    public Card1(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }


    // < 0: 表示 this 指向的对象小于 o 指向的对象
    // == 0: 表示 this 指向的对象等于 o 指向的对象
    // > 0: 表示 this 指向的对象等于 o 指向的对象
    @Override
    public int compareTo(Card1 o){
      if(o == null){
          return 1;
      }
      return rank - o.rank;
    }
}
public class Card{
    public int rank; //数值
    public String suit; //花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

     @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || !(o instanceof Card)){
            return false;
        }
        Card c = (Card)o;
        return rank == c.rank && suit.equals(c.suit);
     }

    public static void main(String[] args) {
        Card p = new Card(1, "♠");
        Card q = new Card(1, "♠");
        Card o = p;

        System.out.println(p.equals(o));    // true
        System.out.println(p.equals(q));    // true


        Card1 p1 = new Card1(1, "♠");
        Card1 q1 = new Card1(2, "♠");
        Card1 o1 = new Card1(1, "♠");

        p1.compareTo(o1);     // == 0，表示牌相等
        p1.compareTo(q1);     // < 0，表示 p 比较小
        q1.compareTo(p1);     // > 0，表示 q 比较大
    }
}
