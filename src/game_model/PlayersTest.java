package game_model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Test
    void currentIsLast() {
        Players players = new Players(false, false, false, false);
        assertTrue(players.currentIsFirst());
        for (int i = 0; i < 3; i++) {
            players.nextPlayer();
        }
        assertTrue(players.currentIsLast());
    }
}