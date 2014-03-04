package managed.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.GuessingService;

/**
 *
 * @author J-Tron
 */
@Named("guessBean")
@SessionScoped
public class GuessBean implements Serializable{
    private static final long serialVersionUID = 1;
    private String guessMessage;
    private int guess;
    private boolean playAgain = false;
    private boolean gameStatus=false;
    private int maxGuesses;
    private int minGuesses;
    private String gameStatusMessage;
    
    
    @Inject
    private GuessingService guessService;
    
    public GuessBean(){
        
    }
    @PostConstruct
    public void init(){
        guessService.generateRandomNumber();
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }
    
    public void generateRandomNumber(){
       guessService.generateRandomNumber();
    }
    
    public int getRandomNumber(){
        return guessService.getRandomNumber();
    }

    public String checkGuess(){
        gameStatus = false;
        guessService.checkGuessedNumber(guess);
        guessMessage = guessService.getGuessMessage();
        maxGuesses = guessService.getMaxNumGuesses();
        minGuesses = guessService.getMinNumGuesses();
        getMaxGuesses();
        getMinGuesses();
        if(guessMessage.equals("You Guessed the right number")){
            playAgain = true;
        }
        if(guessMessage.equals("Your Guess is too high") || guessMessage.equals("Your Guess is too low")){
            playAgain=false;
        }
        return null;
    }
    
    public void setGuessMessage(String guessMessage) {
        this.guessMessage = guessMessage;
    }

    public String getGuessMessage() {
        return guessMessage;
    }

    public void setPlayAgain(boolean playAgain) {
        this.playAgain = playAgain;
    }

    public boolean isPlayAgain() {
        return playAgain;
    }
    

    public void setMaxGuesses(int maxGuesses) {
        this.maxGuesses = maxGuesses;
    }

    public void setMinGuesses(int minGuesses) {
        this.minGuesses = minGuesses;
    }

    public int getMaxGuesses() {
        return maxGuesses;
    }

    public int getMinGuesses() {
        return minGuesses;
    }

    public void setGameStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    public boolean isGameStatus() {
        return gameStatus;
    }
    
    public String newGame(){
        playAgain = false;
        guessService.generateRandomNumber();
        guessService.setGuessCount(0);
        gameStatusMessage = "A new number has been generated";
        guessMessage = "";
        gameStatus = true;
        guess = 5;
        
        return null;
    }

    public String getGameStatusMessage() {
        return gameStatusMessage;
    }

    public void setGameStatusMessage(String gameStatusMessage) {
        this.gameStatusMessage = gameStatusMessage;
    }
    
    
 
}
