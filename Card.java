/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poker;

/**
 *
 * @author aschwartz
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Card {
    private String rank;
    private String suit;
    private int rankScore;
    private int suitScore;
    public Card(String rank, String suit, Integer rankScore, Integer suitScore){
        this.rank  = rank;
        this.suit = suit;
        this.rankScore = rankScore;
        this.suitScore = suitScore;
    }
   
    public String toString(){
        return this.rank + " of " + this.suit;
    }
    
    public String getRank(){
        return this.rank;
    }
    
    public String getSuit(){
        return this.suit;
    }
    
    public Integer getRankScore(){
        return this.rankScore;
    }
    
    public Integer getSuitScore(){
        return this.suitScore;
    }
    

    
    
}
