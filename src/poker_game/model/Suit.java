package poker_game.model;

/** 
 * 撲克牌花色
 */
public enum Suit {
    
    // 梅花
    TREFLES('\u2663', 4),
    // 方塊
    CARREAUX('\u2666', 3),
    // 紅心
    COEURS('\u2665', 2),
    // 黑桃
    PIQUES('\u2660', 1);

    // private Character code;
    private char code;
    private int sort;

    Suit(char code, int sort) {
        this.code = code;
        this.sort = sort;
    }

    public char getCode() {
        return code;
    }

    public int getSort() {
        return sort;
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }

}
