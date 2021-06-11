package com.codurance;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

  Game game;

  @Before
  public void setUp() throws Exception {
    game = new Game();
  }

  @Test
  public void can_score_gutter_game() {
    game.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
    assertThat(game.score()).isEqualTo(0);
  }

  @Test
  public void can_score_game_of_ones() {
    game.roll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);
    assertThat(game.score()).isEqualTo(20);
  }

  @Test
  public void can_score_spare_followed_by_three() {
    game.roll(5,5, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
    assertThat(game.score()).isEqualTo(16);
  }

  @Test
  public void can_score_strike_followed_by_three_then_three() {
    game.roll(10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
    assertThat(game.score()).isEqualTo(22);
  }

  @Test
  public void can_score_perfect_game() {
    game.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
    assertThat(game.score()).isEqualTo(300);
  }
}
