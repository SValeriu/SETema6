package main;
import controllers.Tema6Controller;
import model.Tema6Model;
import views.Tema6View;;

public class Tema6Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tema6Model model = new Tema6Model();
		Tema6View view = new Tema6View();
        Tema6Controller controller = new Tema6Controller();

        // Attach the view to the model
        model.addModelListener(view);

        // Tell the view about the model and the controller
        view.addModel(model);
        view.addController(controller);

        // Tell the controller about the model and the view
        controller.addModel(model);
        controller.addView(view);
        
        // Display the view
        view.setVisible(true);
	}

}
