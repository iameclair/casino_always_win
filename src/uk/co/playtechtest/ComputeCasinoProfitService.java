package uk.co.playtechtest;

import java.util.List;

/**
 * Created by ${Eclair} on 1/26/2019.
 *
 * This is the interface exposed by the Casino to computer the Casino profits
 */
public interface ComputeCasinoProfitService {
     /**
      * This methods returns a list of the five most profitable players
      *
      * @param playerSessions
      * @return the list of ids of most profitable players
      */
     List<Integer> getHighRollers(final List<PlayerSession> playerSessions);
}
