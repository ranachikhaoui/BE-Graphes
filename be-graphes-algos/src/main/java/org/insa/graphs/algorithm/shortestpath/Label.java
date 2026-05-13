package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.*;


public class Label implements Comparable<Label>{

    private Node sommetCourant;
    private boolean marque;
    private double coutRealise;
    private Arc pere;

    //Constructeur de la classe
    public Label (Node sommetCourant,boolean marque, double coutRealise, Arc pere ){
        this.sommetCourant = sommetCourant;
        this.marque = marque;
        this.coutRealise = coutRealise;
        this.pere = pere;
    }



    public double getCost(){
        return this.coutRealise;
    }

    public Node getSommetCourant(){
        return this.sommetCourant;
    }


    public boolean getMarque(){
        return this.marque;
    }


    public Arc getPere(){
        return this.pere;
    }

    public void setCost (double cout){
        this.coutRealise = cout;
    }

    public void setMarque (boolean mark){
        this.marque= mark;
    }

    public void setPere (Arc arc){
        this.pere = arc;
    }

    //Qd on implémente une interface , comme elle est abstraite, on doit définir toutes les méthodes qu'elle contient
    public int compareTo(Label autre){
        if (this.coutRealise > autre.coutRealise){
            return 1;
        } else if (this.coutRealise > autre.coutRealise) {
            return -1;
        }else {
            return 0;
        }


    }

}