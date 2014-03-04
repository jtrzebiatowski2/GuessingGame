package model;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author J-Tron
 */
public class GuessingService implements Serializable{
    private static final long serialVersionUID = 1;
    private int randomNumber;
    private String guessMessage;
    private int guessCount = 0;
    private int minNumGuesses = 100;
    private int maxNumGuesses = 0;
    private final String HIGH_GUESS = "Your Guess is too high";
    private final String LOW_GUESS = "Your Guess is too low";
    private final String CORRECT_GUESS = "You Guessed the right number";
    
    public GuessingService(){
        
    }

    public void generateRandomNumber(){
        Random rn = new Random();
        randomNumber = rn.nextInt(9) +1;
        getRandomNumber();
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }
    
    
    public String checkGuessedNumber(int guessedNumber){
        guessCount++;
        
        if(guessedNumber > randomNumber){
            guessMessage = HIGH_GUESS;
        }
        if(guessedNumber < randomNumber){
            guessMessage =  LOW_GUESS;
        }
        if(guessedNumber == randomNumber){
            guessMessage = CORRECT_GUESS;
            if(guessCount > maxNumGuesses){
                maxNumGuesses = guessCount;
            }if(guessCount < minNumGuesses){
                minNumGuesses = guessCount;
            }
            guessCount = 0;
        }
        
        return guessMessage;
    }

    public int getGuessCount() {
        return guessCount;
    }

    public String getGuessMessage() {
        return guessMessage;
    }

    public void setGuessMessage(String guessMessage) {
        this.guessMessage = guessMessage;
    }

    public void setMaxNumGuesses(int maxNumGuesses) {
        this.maxNumGuesses = maxNumGuesses;
    }

    public void setMinNumGuesses(int minNumGuesses) {
        this.minNumGuesses = minNumGuesses;
    }

    public void setGuessCount(int guessCount) {
        this.guessCount = guessCount;
    }

    public int getMinNumGuesses() {
        return minNumGuesses;
    }

    public int getMaxNumGuesses() {
        return maxNumGuesses;
    }
    
    
}
