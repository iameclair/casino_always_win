package uk.co.playtechtest;

/**
 * Created by ${Eclair} on 1/26/2019.
 */
public class PlayerSession{
    private int playerId;
    /**
     *
     * Instead of a string game name, I have Created an Enum called Game
     * Which encapsulate the gameName and the ante required for each game for better OO design
     * */
    private Game game;
    private int numberOfGamesPlayed;
    private int amountWageredInPounds;
    private int amountWonInpounds;

    public PlayerSession(final int playerId,
                         final Game gameName,
                         final int numberOfGamesPlayed,
                         final int amountWageredInPounds,
                         final int amountWonInpounds)
    {
        this.playerId = playerId;
        this.game = gameName;
        this.numberOfGamesPlayed = numberOfGamesPlayed;
        this.amountWageredInPounds = amountWageredInPounds;
        this.amountWonInpounds = amountWonInpounds;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(final int playerId) {
        this.playerId = playerId;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(final Game game) {
        this.game = game;
    }

    public int getNumberOfGamesPlayed() {
        return numberOfGamesPlayed;
    }

    public void setNumberOfGamesPlayed(final int numberOfGamesPlayed) {
        this.numberOfGamesPlayed = numberOfGamesPlayed;
    }

    public int getAmountWageredInPounds() {
        return amountWageredInPounds;
    }

    public void setAmountWageredInPounds(final int amountWageredInPounds) {
        this.amountWageredInPounds = amountWageredInPounds;
    }

    public int getAmountWonInpounds() {
        return amountWonInpounds;
    }

    public void setAmountWonInpounds(final int amountWonInpounds) {
        this.amountWonInpounds = amountWonInpounds;
    }
}
