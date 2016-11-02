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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Arrays;
        
public class Deck {
    public ArrayList<Card> deck = new ArrayList<Card>(); 
    private ArrayList<Card> available_cards; 
    private ArrayList<Card> unavailable_cards; 
    public ArrayList<String> ranks = new ArrayList<String>(Arrays.asList("Duce","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"));
    public ArrayList<String> suits = new ArrayList<String>(Arrays.asList("Hearts","Diamonds","Clubs","Spades"));
    public Deck(){
        factory();
    }
    
    public void factory(){
        for (String rank : ranks){
            for (String suit : suits){
                int rankScore = makeRankScore(rank);
                int suitScore = makeSuitScore(suit);
                Card card = new Card(rank, suit, rankScore, suitScore);
                deck.add(card);
            }
        }
        available_cards = new ArrayList<Card>(deck);
        unavailable_cards = new ArrayList<Card>();
    }
    
    public ArrayList getDeck(){
        return deck;
    }
    
    public ArrayList getAvailableCards(){
        return available_cards;
    }
    
    public void shuffle(){
        Collections.shuffle(available_cards);
    }
    
    public ArrayList draw(int quantity){
        ArrayList<Card> pile = new ArrayList<Card>();
        for (int i = 0; i<quantity;i++){
            pile.add(available_cards.get(0));
            unavailable_cards.add(available_cards.get(0));
            available_cards.remove(0);     
        }
        return pile;
    }
    public HashMap rankingSystem(){
        int iterator = 0;
        HashMap scoring = new HashMap();
        for (String rank:ranks){
            scoring.put(rank, iterator);
            iterator++;
        }
        return scoring;
    }

    public HashMap suitingSystem(){
        int iterator = 0;
        HashMap scoring = new HashMap();
        for (String suit:suits){
            scoring.put(suit, iterator);
            iterator++;
        }
        return scoring;
    }
    
    public int makeRankScore(String rank){
        HashMap scoring = new HashMap();
        scoring = rankingSystem();
        int score = (int)scoring.get(rank);
        return score;
    }
    
    public int makeSuitScore(String suit){
        HashMap scoring = new HashMap();
        scoring = suitingSystem();
        int score = (int)scoring.get(suit);
        return score;
    } 
    
    public String getRanking(int score){
        return ranks.get(score);
    }
}
