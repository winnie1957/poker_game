package poker_game.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Card> cards = new ArrayList<>();

    public List<Card> getCards(){
        return cards;
    }

    public void reset(){
        cards.clear();
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void show(){
        System.out.print(cards.toString());
    }

    public int getScore() {
        return cards.stream()
            .map(Card::getPoint)
            .reduce(0, Integer::sum);
    }    

}
