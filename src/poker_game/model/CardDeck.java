package poker_game.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 牌堆
 */
public class CardDeck extends Stack<Card> {

    /** 洗牌 */
    public void shuffle(int times){
        Collections.shuffle(this);
    }

    /** 秀出目前牌組(13張牌一行) */
    public void show(){
        Map<Integer, List<String>> result = new HashMap<>();
        int i = 0;
        for (Card card : this) {
            if(result.containsKey(i) && result.get(i).size()%13 == 0){
                i++;
            }
            result.computeIfAbsent(i, k -> new ArrayList<>())
                .add(card.toString());
        }
        result.values().forEach(System.out::println);
    }

    /** 重新產生一副牌組並洗牌一次 */
    public void initial(){
        List<Suit> suits = Arrays.asList(Suit.values()).stream()
            .sorted(Comparator.comparing(Suit::getSort))
            .toList();
        List<Num> nums = Arrays.asList(Num.values());

        List<Card> result = new ArrayList<>();
        suits.forEach(suit -> {
            nums.forEach(num -> {
                result.add(new Card(suit, num));
            });
        });
       
        this.clear();
        this.addAll(result);
        Collections.shuffle(this);
    }

}
