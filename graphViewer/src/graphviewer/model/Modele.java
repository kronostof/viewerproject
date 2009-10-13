package graphviewer.model;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vincent
 */
import edu.uci.ics.jung.graph.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;


public class Modele extends Observable{


    Graph<ModeleNoeud,ModeleArrete> graph = null;
    ModeleNoeud n1 = null ,n2 = null;
    ArrayList<ModeleNoeud> listeDeNoeud = new ArrayList<ModeleNoeud>();
    /**  Variable temporaire utilisée un peu partout.
     * une utilisation sans une intialisation a toutes
     * les chance de donner des résultats assez drôles.
     */
    private int i;
    
    /**
     * Génération a partir de code en 'dur' pour l'instant, le model se contente de proposer un graph existant
     * pour l'instant. Quand la gestion d'importation de graph sera plus avancée, il faudra remplacer ceci par
     * qlq chose de plus consequent.
     */
    public Modele() {
        super();
        graph = new UndirectedSparseGraph();
        //factory=UndirectedSparseGraph.getFactory();

        int i = 0;
        n1 = new ModeleNoeud(i, i, i, i+" nom ", i+" prenom ", new Date());
        graph.addVertex(n1);
        listeDeNoeud.add(n1);
        for (i = 1; i < 5; i++) {
            n2 = new ModeleNoeud(i, i, i, i + " nom ", i +" prenom ", new Date());
            
            listeDeNoeud.add(n2);
            graph.addVertex(n2);
            graph.addEdge(new ModeleArrete(i), n1,n2);
            n1 = n2;
            
        }
        //    n2 = new NoeudModel(i+1, i+1, i+1, i+1+" nom ", i+1+" prenom ", new Date());
          //  graph.addEdge(new arreteModel(i+1), n1,n2);

          System.out.println(graph);
    }

    /**
     * fournir le graph du model. On peut imaginer que par la suite on puissent selectionner une partie de graph
     * ou l'un des sous graphe du model
     * @return
     */
    public Graph getGraph() {
        return graph;
    }

    public void uneModif() {
        System.out.println("model: le controleur me demande de me modifier , mais c'est moi qui me modifie en fonction de mon humeur !");
        i = graph.getVertexCount();
        n2 = new ModeleNoeud(i, i, i, i + " nom ", i +" prenom ", new Date());
        graph.addVertex(n2);
        listeDeNoeud.add(n2);
        graph.addEdge(new ModeleArrete(i),n2,listeDeNoeud.get(i-1));
        n1 = n2;
        System.out.println("model: Bon j'ai fini je dis a la vue de se bouger un peu.");
        setData();
        System.out.println(graph);
    }




    /**
     * utilisation du pattern observateur
     * la modification du model doit passer par l'appelle de cette methode pour etre relever par la methode traitant
     * l'observation.
     * @param lbData
     */

    void setData(){
        setChanged(); // Positionne son indicateur de changement
        notifyObservers(); // (1) notification
    }




}
