package com.codurance;

public class Game {

  public static final int GAME = 22;
  private int scoreArray[] = new int[GAME];
  private int currentPosition;
  public void roll(int...rolls) {
    for (int roll : rolls){
      roll(roll);
    }
  }

  private void roll(int roll) {
    scoreArray[currentPosition++] = roll;
  }

  public int score(){
    int score = 0;
    currentPosition = 0;
    for (int frame = 0; frame < 10; frame++){
      if (isStrike(currentPosition)){
        score += 10 + scoreArray[currentPosition + 1] + scoreArray[currentPosition + 2];
        currentPosition += 1;
      } else if (isSpare(currentPosition)){
        score += 10 + scoreArray[currentPosition + 2];
        currentPosition += 2;
      }else {
        score += scoreArray[currentPosition] + scoreArray[currentPosition + 1];
        currentPosition += 2;
      }
    }
    return score;
  }

  private boolean isStrike(int currentPosition) {
    return scoreArray[currentPosition] == 10;
  }

  private boolean isSpare(int currentPosition) {
    return scoreArray[currentPosition] + scoreArray[currentPosition + 1] == 10;
  }
}
