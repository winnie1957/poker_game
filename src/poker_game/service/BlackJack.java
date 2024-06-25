package poker_game.service;

import static poker_game.service.Utils.keep;

import java.util.Scanner;

import poker_game.model.Card;
import poker_game.model.CardDeck;
import poker_game.model.Player;

/** 
 * 牌局
 * 
    向各玩家分別派發一張牌
    莊家發給自己一張牌
    向各玩家派第二張牌
    莊家再發給自己一張牌（不是所有賭場都會有這個步驟，大部份賭場都是在所有玩家結束要牌後才發第二張明牌給莊家）
    如果莊家明牌是A、荷官會詢問玩家是否購買保險
    玩家可進行加注、投降、分牌等動作
    莊家逐位詢問玩家是否加牌、直至閒家不加牌才詢問下一位玩家，輪流詢問玩家直至最後一位玩家加牌完成
    莊家如不足17點便需加牌直至超過或等於17點
    對未有爆牌的玩家，比點數大小，大者勝，可得賠金；如莊家爆牌、未有爆牌的玩家便可得賠金
 */
public class BlackJack {

    private CardDeck pokerCards = new CardDeck();
    private Player player = new Player();
    private Player makers = new Player();

    private final static int DEFAULT_SCORE = 21;

    public void start(Scanner scanner){
        int round = 1;
        do {
            oneRound(scanner, round, true);
            round++;
        } while (keep(scanner, "是否再玩一次"));
    }

    private void oneRound(Scanner scanner, int round, boolean isNewRound){
        if(isNewRound){
            System.out.println(String.format("---------- round %s : start ----------", round));
            reset();
        }

        do {
            deal();
            if(player.getScore() >= DEFAULT_SCORE){
                System.out.print("爆牌!!超過21點!!");
                showScoreAndThisRoundOver(round);
                return;
            }
        } while (keep(scanner, "是否加牌"));

        if(keep(scanner, "是否結算這局")){
            showScoreAndThisRoundOver(round);
        }else{
            if(keep(scanner, "是否繼續這局(若不繼續則直接開啟新牌局)")){
                oneRound(scanner, round, false);
            }else{
                showScoreAndThisRoundOver(round);
            }
        }
    }

    /** 計算成績並結束這局 */
    private void showScoreAndThisRoundOver(int round){
        System.out.println(String.format("這局玩家共得%s點!, 莊家%s點 ", player.getScore(), makers.getScore()));
        
        /** TODO: 判斷莊家分數 */
        int playerScore = DEFAULT_SCORE - player.getScore();
        int makerScore = DEFAULT_SCORE - makers.getScore();

        if(makerScore > 0 && playerScore > 0 && playerScore < makerScore){
            System.out.println("獲勝!!");
        }else{
            System.out.println("輸了....");
        }

        System.out.println(String.format("---------- round %s :  over ----------", round));
    }

    /** 重置牌堆 */
    private void reset(){
        player.reset();
        makers.reset();
        pokerCards.initial();
    }
    
    /** 發牌 */
    private void deal(){
        player.addCard(pokerCards.pop());
        System.out.print("玩家的牌：");
        player.show();
        System.out.println();
        
        if(makers.getCards().size() < 2){
            makers.addCard(pokerCards.pop());
        }

        System.out.print("莊家的牌：");
        switch (makers.getCards().size()) {
            case 1:
                System.out.println("[**]");
                break;
            case 2:
                Card makersSecCard = makers.getCards().get(1);
                System.out.println(String.format("[**, %s]", makersSecCard.toString()));
                break;
        
            default:
                break;
        }

    }

}
