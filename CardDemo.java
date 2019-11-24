package NewArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card{
     public String suit; // 花色
     public String rank; // 牌面值

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
     public String toString() {
         return "[" + suit + "," + rank + "]" + "" ;
     }
 }
public class CardDemo {
     public static final String []color = {"♠", "♥", "♣", "♦"};

     public static List<Card>  buyDeck(){
         List<Card>  Cards = new ArrayList<>(52);
         for(int i = 0; i < 4; i++){
             Cards.add(new Card(color[i], " A"));
             for(int j = 2; j <= 10; j++) {
                 Cards.add(new Card(color[i], j + ""));
             }
             Cards.add(new Card(color[i], "J"));
             Cards.add(new Card(color[i], "Q"));
             Cards.add(new Card(color[i], "K"));
         }
         return Cards;
     }
     public static void swap(int i, int j, List<Card> Cards){  //交换顺序表的2个对象
         Card tem = Cards.get(i);
         Cards.set(i, Cards.get(j));
         Cards.set(j, tem);
     }

     public static List<Card> shuffle(List<Card> Cards){
         Random random = new Random();
         for(int size = 0; size < Cards.size(); size++){
             int i = random.nextInt(Cards.size() - 1);
             swap(i, size, Cards);
         }
         return Cards;
     }
     public static List<List<Card>> licensing(List<Card> CC){
         List<List<Card>> Cardsll = new ArrayList<>();
           Cardsll.add(new ArrayList<>());
           Cardsll.add(new ArrayList<>());
           Cardsll.add(new ArrayList<>());
           for(int i = 0; i < 5; i++){
               for(int j = 0; j < 3; j++){
                   Cardsll.get(j).add(CC.remove(0));   //这个Cards的顺序表里存的是顺序表用get(0)取到其中顺序表并保存之间洗好牌的顺序表删除的那张牌。
               }
           }
           return Cardsll;
     }
    public static void main(String[] args) {
        List<Card> test = buyDeck();
        System.out.println("刚买回的牌");
        System.out.println(test);
        shuffle(test);
        System.out.println("洗过的牌:");
        System.out.println(test);
        List<List<Card>> hands = licensing(test);
        System.out.println("剩余的牌:");
        System.out.println(test);
        System.out.println("A 手中的牌:");
        System.out.println(hands.get(0));
        System.out.println("B 手中的牌:");
        System.out.println(hands.get(1));
        System.out.println("C 手中的牌:");
        System.out.println(hands.get(2));
    }
}
