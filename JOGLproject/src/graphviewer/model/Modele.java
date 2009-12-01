package graphviewer.model;

/**
 *
 * @author vincent
 */
import edu.uci.ics.jung.graph.*;
import graphviewer.model.visualisation.GraphDeVisualisation;
import graphviewer.vue.VueNoeud;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;


public class Modele extends Observable{


    /**
     *  graph est le graphe nommé <graph de données> lors de la réunion du jeudi 15 oct
     */
    Graph<ModeleNoeud,ModeleArrete> graph = null;
    
    ModeleNoeud n1 = null ;
    ModeleNoeud n2 = null;


    /**
     *  graph est le graphe nommé <graph de visualisation> lors de la réunion du jeudi 15 oct
     * atention ce graphe est représentatble directement uniquement en utilisant la lib JUNG
     */
    GraphDeVisualisation graphVisualisation = null;




    ArrayList<ModeleNoeud> listeDeNoeud = new ArrayList<ModeleNoeud>();
    /**  Variable temporaire utilisée un peu partout.
     * une utilisation sans une intialisation a toutes
     * les chance de donner des résultats assez drôles.
     */
    private int i;

    
    public Modele() {
        super();

        graph = chargerGraph();

     
        // On a notre Graph venant d'un fichier ou autre. Ilnous faut cree le graph de visualisation.
          System.out.println(graph);


          // CONSTRUCTION DU GRAPH DE VISUALISATION
          graphVisualisation = new GraphDeVisualisation(graph);

          /** Affichage pour test:  On passe le graph de visualisation a l afficheur de jung !
           * Les algo de placement peuvent commencer a bosser !
           *System.out.println(graphVisualisation);
           *graph = (Graph)graphVisualisation.getGraph();
           */
          
    }

    /**
     * fournir le graph du model. On peut imaginer que par la suite on puissent selectionner une partie de graph
     * ou l'un des sous graphe du model
     * @return
     */
    public GraphDeVisualisation getGraph() {
        return graphVisualisation;
    }

    public void uneModif() {
      //  System.out.println("model: le controleur me demande de me modifier , mais c'est moi qui me modifie en fonction de mon humeur !");
        i = graph.getVertexCount();
        n2 = new ModeleNoeud(i, i, i, i + " nom ", i +" prenom ", new Date());
        VueNoeud nv = new VueNoeud(n2);
        graphVisualisation.graph.addVertex(nv);
            graphVisualisation.setData(nv);
            
        
        graph.addVertex(n2);
        listeDeNoeud.add(n2);
        graph.addEdge(new ModeleArrete(i),n2,listeDeNoeud.get(i-1));
       // n1 = n2;
        System.out.println("model: Bon j'ai fini je dis a la vue de se bouger un peu.");
        setData();
       // System.out.println(graph);
    }


    public void organize() {
        System.out.println("Be patient, it will come :) ");
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


    /**
     * Charger un graph a partir d'une certiaine source.
     * @return
     */
    private Graph<ModeleNoeud, ModeleArrete> chargerGraph() {
        Graph new_graph = new UndirectedSparseGraph();

        i = 0;
        n1 = new ModeleNoeud(i, i, i, i+" nom ", i+" prenom ", new Date());
        new_graph.addVertex(n1);
        listeDeNoeud.add(n1);
        for (i = 1; i < 4; i++) {
            n2 = new ModeleNoeud(i, i, i, i + " nom ", i +" prenom ", new Date());

            listeDeNoeud.add(n2);
            new_graph.addVertex(n2);
            new_graph.addEdge(new ModeleArrete(i), n1,n2);
            n1 = n2;

        }
          return new_graph;
    }
}
