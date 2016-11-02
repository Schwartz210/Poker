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

public class Poker {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Player> players = new ArrayList<Player>();
    public static void main(String[] args) {
        playerFactory();
        round();
        }

    public static void playerFactory(){
        String playerNames[] = {"Abby","Benny","Charlie","David","Eddy"};
        for (String name:playerNames){
            Player p = new Player(name);
            players.add(p);
        }
    }
    
    public static void round(){
        startRound();
        showHand();
        scoreRound();
        showRoundResults();           
    }
    
    public static void scoreRound(){
        int bestScore = 0;
        String bestPlayer = "";
        for (Player player: players){
            if (player.getHandScore() > bestScore){
                bestScore = player.getHandScore();
                bestPlayer = player.getName();
            }
        }
        for (Player player: players){
            if (bestPlayer.equals(player.getName())){
                player.setPlayerScore(bestScore);
            }
        }
        System.out.println(bestPlayer);
    }
    
    public static void showRoundResults(){
        for (Player player: players){
            System.out.print(player.getName());
            System.out.print(" - ");
            System.out.println(player.getHandScore());        
        }
    }
    
    public static void startRound(){
        Deck deck = new Deck();
        deck.shuffle();
        for (Player player:players){
            Hand hand = new Hand(deck.draw(5));
            player.setHand(hand);
        }
    }
    
    public static void showHand(){
        for (Player player:players){
            player.show();
        }
    }
}

