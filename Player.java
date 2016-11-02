/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poker;

import java.util.ArrayList;

/**
 *
 * @author aschwartz
 */
public class Player {
    private String name;
    private int score;
    private Hand hand;
    public Player(String playerName){
        name = playerName;
        score = 0;
    }
    
    public String getName(){
        return name;
    }
    
    public void setHand(Hand startinghand){
        hand = startinghand;
    }
    
    public void setCards(ArrayList<Card> cards){
        hand.takeCards(cards);
    }
    
    public void setPlayerScore(int points){
        score += points;
    }
    
    public int getPlayerScore(){
        return score;
    }
    
    public int getHandScore(){
        return hand.getPokerHandRanking();
    }
    
    public void show(){
        System.out.println(name);
        hand.showHand();
    }
}
