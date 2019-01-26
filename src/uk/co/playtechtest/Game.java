package uk.co.playtechtest;

/**
 * Created by ${Eclair} on 1/26/2019.
 * This Enum represent a DataStructure for the Games offered by the Casino
 */
public enum Game {
    POKER("Poker", 2),
    ROULETTE("Roulette",1),
    BLACKJACK("Blackjack",0);
    /** the name of the Game*/
    private final String gameName;
    /** the ante required for the game"*/
    private final int ante;

    Game(final String gameName, final int ante){
        this.ante = ante;
        this.gameName = gameName;
    }
    //provide a get method to access ante amount for each game
    public int getAnte(){
        return this.ante;
    }
    public String getGameName(){
        return this.gameName;
    }
}
