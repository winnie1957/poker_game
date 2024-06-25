package poker_game.model;

/**
 * 撲克牌數字
 */
public enum Num {

    ONE("A", 11),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    ELEVEN("J", 10),
    TWELOV("Q", 10),
    THIREEN("K", 10);

    private String code;
    private int point;

    Num(String code, int point){
        this.code = code;
        this.point = point;
    }

    public String getCode() {
        return code;
    }

    public int getPoint() {
        return point;
    }

}
