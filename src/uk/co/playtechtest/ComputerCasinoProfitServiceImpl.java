package uk.co.playtechtest;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Created by ${Eclair} on 1/26/2019.
 */
public class ComputerCasinoProfitServiceImpl implements ComputeCasinoProfitService {

    /**
     * implementation of getHighRollers
     *
     * @param playerSessions
     *         the list of playerSessions
     * @return  the list of the 5 most profitable players
     */
    @Override
    public List<Integer> getHighRollers(List<PlayerSession> playerSessions) {
        final Integer[] mostProfitablePlayers = new Integer[5];
        final Map<Integer, Integer> playerIdToCasinoWinMap = new HashMap<>();
        for (final PlayerSession playerSession : playerSessions) {
            int casinoWin = calculateCasinoWin(playerSession.getGame().getAnte(), playerSession.getAmountWageredInPounds(),
                    playerSession.getAmountWonInpounds());
            if (playerIdToCasinoWinMap.containsKey(playerSession.getPlayerId())) {
                casinoWin += playerIdToCasinoWinMap.get(playerSession.getPlayerId());
            }
            playerIdToCasinoWinMap.put(playerSession.getPlayerId(), casinoWin);
        }
        addMostProfitablePlayersToArray(mostProfitablePlayers, playerIdToCasinoWinMap);
        return Arrays.stream(mostProfitablePlayers).collect(Collectors.toList());
    }

    /**
     * This method adds the most profitable player to the array
     * @param mostProfitablePlayers the array of most profitable players
     * @param playerIdToCasinoWinMap the map of playerId and their associated casino wins
     */
    private void addMostProfitablePlayersToArray(Integer[] mostProfitablePlayers, Map<Integer, Integer> playerIdToCasinoWinMap) {
        for (int i = 0; i < mostProfitablePlayers.length; i++) {
            mostProfitablePlayers[i] = findMostProfitable(playerIdToCasinoWinMap);
        }
    }

    /**
     * This method finds the most profitable player and returns the player id
     *
     * @param playerIdToCasinoWinMap the map of playerId and their associated casino wins
     * @return the id of the most profitable player
     */
    private Integer findMostProfitable(final Map<Integer, Integer> playerIdToCasinoWinMap) {
        int biggestCasinoWin = 0;
        int highestProfitable = 0;
        for (Entry<Integer, Integer> higestRoller : playerIdToCasinoWinMap.entrySet()) {
            if (biggestCasinoWin < higestRoller.getValue()) {
                biggestCasinoWin = higestRoller.getValue();
                highestProfitable = higestRoller.getKey();
            }
        }
        playerIdToCasinoWinMap.remove(highestProfitable);
        return highestProfitable;
    }

    /**
     * This method compute the casino win
     *
     * @param ante the ante
     * @param amountWagered the amount wagered in the game
     * @param amountWon the amount the player has won
     * @return the casino profit
     */
    private int calculateCasinoWin(final int ante, final int amountWagered, final int amountWon) {
        return (ante + amountWagered) - amountWon;
    }

    /**
     * Test the program
     * @param args cmd arguments
     */
    public static void main(String[] args) {
        List<PlayerSession> playerSessions = new ArrayList<>();

        PlayerSession a = new PlayerSession(1, Game.BLACKJACK, 8, 100, 30);
        playerSessions.add(a);

        PlayerSession b = new PlayerSession(2, Game.POKER, 4, 45, 0);
        playerSessions.add(b);

        PlayerSession c = new PlayerSession(3, Game.POKER, 5, 85, 10);
        playerSessions.add(c);

        PlayerSession d = new PlayerSession(4, Game.ROULETTE, 3, 150, 3);
        playerSessions.add(d);

        PlayerSession e = new PlayerSession(5, Game.BLACKJACK, 6, 200, 80);
        playerSessions.add(e);

        PlayerSession f = new PlayerSession(6, Game.ROULETTE, 4, 85, 15);
        playerSessions.add(f);

        a = new PlayerSession(1, Game.POKER, 3, 320, 75);
        playerSessions.add(a);

        f = new PlayerSession(6, Game.BLACKJACK, 2, 50, 0);
        playerSessions.add(f);

        c = new PlayerSession(3, Game.BLACKJACK, 5, 55, 1);
        playerSessions.add(c);

        a = new PlayerSession(1, Game.ROULETTE, 9, 30, 45);
        playerSessions.add(a);

        System.out.println(new ComputerCasinoProfitServiceImpl().getHighRollers(playerSessions));
    }
}
