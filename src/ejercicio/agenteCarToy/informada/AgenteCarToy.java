package ejercicio.agenteCarToy.informada;

import ejercicio.agenteCarToy.busqueda.actions.IrNoreste;
import ejercicio.agenteCarToy.busqueda.actions.IrNoroeste;
import ejercicio.agenteCarToy.busqueda.actions.IrNorte;
import ejercicio.agenteCarToy.busqueda.actions.IrSur;
import ejercicio.agenteCarToy.busqueda.actions.IrOeste;
import ejercicio.agenteCarToy.busqueda.actions.IrEste;
import ejercicio.agenteCarToy.busqueda.actions.IrSureste;
import ejercicio.agenteCarToy.busqueda.actions.IrSuroeste;
import ejercicio.agenteCarToy.busqueda.*;



import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.search.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;

public class AgenteCarToy extends SearchBasedAgent {

    public AgenteCarToy() {

        // The Agent Goal
        ObjetivoAgenteCarToy agGoal = new ObjetivoAgenteCarToy();

        // The Agent State
        EstadoAgenteCarToy agState = new EstadoAgenteCarToy();
        this.setAgentState(agState);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        operators.addElement(new IrNorte());	
        operators.addElement(new IrSur());	
        operators.addElement(new IrOeste());	
        operators.addElement(new IrEste());
        operators.addElement(new IrNoreste());	
        operators.addElement(new IrSureste());	
        operators.addElement(new IrNoroeste());	
        operators.addElement(new IrSuroeste());	

        // Create the Problem which the agent will resolve
        Problem problem = new Problem(agGoal, agState, operators);
        this.setProblem(problem);
    }

    /**
     * This method is executed by the simulator to ask the agent for an action.
     */
    @Override
    public Action selectAction() {

        // Create the search strategy
        IStepCostFunction cost = new CostFunction();
        IEstimatedCostFunction heuristic = new Heuristic();
        AStarSearch strategy = new AStarSearch(cost, heuristic);          

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.EFAIA_TREE);

        // Set the Search searchSolver.
        this.setSolver(searchSolver);

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(AgenteCarToy.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;

    }

    /**
     * This method is executed by the simulator to give the agent a perception.
     * Then it updates its state.
     * @param p
     */
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
}
