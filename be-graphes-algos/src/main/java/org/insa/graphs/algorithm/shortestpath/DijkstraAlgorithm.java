package org.insa.graphs.algorithm.shortestpath;

import java.util.List;

import org.insa.graphs.algorithm.utils.BinaryHeap;
import org.insa.graphs.model.*;


public class DijkstraAlgorithm extends ShortestPathAlgorithm {
    

    //Déclarations
    private Label TabLabels[];

    private BinaryHeap<Label> Tas;

    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected ShortestPathSolution doRun() {


        List<Arc> arcsSolution;  //Contiendra les arcs qui construiront le PCC  
        ///////////////////////////Pour creer le Path Solution , on doit utiliser ce constructeur:  public Path(Graph graph, List<Arc> arcs)


        TabLabels = new Label [data.getGraph().size()];


        // retrieve data from the input problem (getInputData() is inherited from the
        // parent class ShortestPathAlgorithm)
        final ShortestPathData data = getInputData();

        // variable that will contain the solution of the shortest path problem
        ShortestPathSolution solution = null;

        // TODO: implement the Dijkstra algorithm

        Label labelCourant;
        // =============== Initialisation des Labels pour les N nodes  ===========
    
        for (Node node : data.getGraph().getNodes()){
            labelCourant = new Label(node,false, Double.POSITIVE_INFINITY, null);
            TabLabels[node.getId()] = labelCourant;            
        }
        Node SommetOrigine = data.getOrigin();
        Label labelOrigine = TabLabels[SommetOrigine.getId()];
        labelOrigine.setCost(0);

        this.Tas = new BinaryHeap<>();
        Tas.insert(labelOrigine);



        // =============== Itérations  ===========
        while (!(Tas.isEmpty())){
            Label labelMin = Tas.deleteMin(); 
            labelMin.setMarque(true);

            for(Arc arc : labelMin.getSommetCourant().getSuccessors() ) {
                boolean maj = false;
                Node NodeSuiv = arc.getDestination();
                Label labelSuiv = TabLabels[NodeSuiv.getId()];
                if (labelSuiv.getMarque() == false) {
                    if (labelMin.getCost() + arc.getLength() < labelSuiv.getCost()){
                        labelSuiv.setCost(labelMin.getCost() + arc.getLength());
                        maj =true;
                    } 
                    if (maj==true){
                        Tas.insert(labelSuiv);
                        TabLabels[labelSuiv.getSommetCourant().getId()].setPere(arc);
                    }
                }
            }
        }


        // when the algorithm terminates, return the solution that has been found
        return solution;
    }

}
