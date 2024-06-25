package poker_game.model;

/** 撲克牌 */
public class Card implements Comparable<Card> {
    private Suit suit;
    private Num num;

    public Card(Suit suit, Num num){
        this.suit = suit;
        this.num = num;
    }

    public Suit getSuit(){
        return suit;
    }

    public Num getNum(){
        return num;
    }

    public int getPoint(){
        return num.getPoint();
    }

    @Override
    public String toString(){
        return num.getCode() + suit.toString();
    }

    @Override
    public int compareTo(Card o) {
        if(num != o.num){
            return num.getPoint() - o.num.getPoint();
        }
        return suit.compareTo(suit);
    }

}
