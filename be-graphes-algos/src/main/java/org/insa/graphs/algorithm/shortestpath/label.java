import org.insa.graphs.model.*;


public class label{

    private Node sommetCourant;
    private boolean marque;
    private int coutRealise;
    private Arc pere;


    //Constructeur de la classe
    public label (Node sommetCourant,boolean marque, int coutRealise, Arc pere ){
        this.sommetCourant = sommetCourant;
        this.marque = marque;
        this.coutRealise = coutRealise;
        this.pere = pere;
    }



    public int getCost(){
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





}