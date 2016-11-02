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
import java.util.HashSet;
import java.util.HashMap;
import java.util.Collections;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<Card>();
    public Hand(ArrayList<Card> cards){
        this.cards = cards;
    }
    
    public void takeCards(ArrayList<Card> pile){
        for (Card card:pile){
           this.cards.add(card); 
        }
    }
    
    public void showHand(){
        for (Card card: this.cards){
            System.out.println(card.toString());
        }
        System.out.println("========================");
    }
    
    public void orderHand(){
        ArrayList<Card> new_hand = new ArrayList<Card>();
        mainloop:
        for (Card card:this.cards){
            int score = card.getRankScore();
            if (this.cards.indexOf(card) == 0){
                new_hand.add(card);
            } else {for (Card c:new_hand){
                if (card.getRankScore() < c.getRankScore()){
                    int index = new_hand.indexOf(c);
                    new_hand.add(index, card);
                    continue mainloop;
                }    
            }
                int index = new_hand.size();
                new_hand.add(index, card);  
                    }
        }
        this.cards = new_hand;
    }
    
    public ArrayList getRanks(){
        ArrayList<String> ranks = new ArrayList<String>();
        for (Card card: this.cards){
            ranks.add(card.getRank());
        } 
        return ranks;
    }
    
    public ArrayList getSuits(){
        ArrayList<String> suits = new ArrayList<String>();
        for (Card card: this.cards){
            suits.add(card.getSuit());
        } 
        return suits;        
    }

    public ArrayList getRankScores(){
        ArrayList<Integer> scores = new ArrayList<Integer>();
        for (Card card:this.cards){
            scores.add(card.getRankScore());
        }
        return scores;
    }
    public Card getHighCard(){
        orderHand();
        return this.cards.get(4);
        }

    public Integer ifFlushGetSuitScore(){
        Card highCard = getHighCard();
        int score = highCard.getSuitScore();
        return score;
    }
    
    public HashSet getPairs(int num_of_a_kind){
        ArrayList<String> ranks = new ArrayList<String>();
        HashSet<String> pairs = new HashSet<String>();
        ranks = getRanks();
        for (String rank: ranks){
            Integer occurrences = Collections.frequency(ranks, rank);
            if (occurrences == num_of_a_kind){
                pairs.add(rank);
            }
        }
        return pairs;
    }
    
    public Boolean hasOnePair(){
        HashSet<String> pairs = new HashSet<String>();
        pairs = getPairs(2);
        if (pairs.size() == 1){
            return true;
        } else return false;
    }
    
    public Boolean hasTwoPairs(){
        HashSet<String> pairs = new HashSet<String>();
        pairs = getPairs(2);
        if (pairs.size() == 2){
            return true;
        } else return false;
    }
    
    public Boolean hasThreeOfAKind(){
        HashSet<String> pairs = new HashSet<String>();
        pairs = getPairs(3);
        if (pairs.size() == 1){
            return true;
        } else return false;        
    }

    public Boolean hasFourOfAKind(){
        HashSet<String> pairs = new HashSet<String>();
        pairs = getPairs(4);
        if (pairs.size() == 1){
            return true;
        } else return false;        
    }
    
    public Boolean hasFullHouse(){
        if (hasOnePair() == true && hasThreeOfAKind() == true) {
            return true;
        } else return false;
    }
    
    public Boolean hasStraight(){
        ArrayList<Integer> scores = new ArrayList<Integer>();
        scores = getRankScores();
        int value = Collections.min(scores);
        for (int iterator = 0;iterator<5;iterator++){
            if (Collections.frequency(scores, value) == 0){
                return false;
            }
            value++;
        }
        return true;
    }
    
    public Boolean hasFlush(){
        ArrayList<String> suits = new ArrayList<String>();
        HashSet<String> unique_suits = new HashSet<String>();
        suits = getSuits();
        for (String suit:suits){
            unique_suits.add(suit);
        }
        if (unique_suits.size() == 1){
            return true;   
        } else return false;
    }
    
    public Boolean hasStraightFlush(){
        if (hasStraight() == true && hasFlush() == true){
            return true;
        } else return false;
    }
    
    public Boolean hasRoyalFlush(){
        Card highCard = getHighCard();
        String highRank = highCard.getRank();
        if (hasStraightFlush() == true && highRank == "Ace"){
            return true;
        } else return false;
    }
    
    public Integer getPokerHandRanking(){
        int score;
        if (hasRoyalFlush() == true){
            score = 9;
        } else if (hasStraightFlush() == true){
            score = 8;
        } else if (hasFourOfAKind() == true){
            score = 7;
        } else if (hasFullHouse() == true){
            score = 6;
        } else if (hasFlush() == true){
            score = 5;
        } else if (hasStraight() == true){
            score = 4;
        } else if (hasThreeOfAKind() == true){
            score = 3;
        } else if (hasTwoPairs() == true){
            score = 2;
        } else if (hasOnePair() == true){
            score = 1;
        } else{ 
            score = 0;
        }
        return score;
    }
}
