package views;

import interfaces.IController;
import interfaces.IModelListener;
import interfaces.IView;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import model.Tema6Model;
import javax.swing.JLabel;

import utils.UpdateAction;

import java.awt.Font;

public class Tema6View extends JFrame implements IModelListener, IView {

	private static final long serialVersionUID = -5758555454500685115L;

	// View components
	private JPanel contentPane = new JPanel();
	private JLabel lblTemperature = new JLabel("Temperature:");
	private JButton btnUpdate = new JButton("Update");
	private JLabel lblPrecipitation = new JLabel("Precipitation:");
	private JLabel lblTempValue = new JLabel("0");
	private JLabel lblPrecValue = new JLabel("0");

	private Tema6Model mModel;

	/**
	 * Constructor.
	 */
	public Tema6View() {

		// Initialise components
		if (btnUpdate.getAction() == null) {
			btnUpdate.setAction(new UpdateAction());
		}
		btnUpdate.getAction().putValue(IController.ACTION_UPDATE, 0);
		btnUpdate.setActionCommand(IController.ACTION_UPDATE);
		btnUpdate.setText("Update");

		lblTemperature.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTemperature.setBounds(128, 72, 94, 14);

		lblPrecipitation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecipitation.setBounds(128, 115, 94, 14);

		lblTempValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTempValue.setBounds(286, 74, 46, 14);

		lblPrecValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecValue.setBounds(286, 117, 46, 14);

		// layout the components
		contentPane.add(btnUpdate);
		contentPane.add(lblTemperature);
		contentPane.add(lblPrecipitation);
		contentPane.add(lblTempValue);
		contentPane.add(lblPrecValue);

		// Finalize layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnUpdate.setBounds(173, 195, 89, 23);
	}

	/**
	 * Sets the view's reference to the model - Only get operations allowed
	 * 
	 * @param model The application model
	 *            
	 */
	public void addModel(Tema6Model model) {
		mModel = model;
		lblTempValue.setText(model.getTemperature() + "\u00b0" + "C");
		lblPrecValue.setText(model.getPrecipitation() + "%");
	}

	/**
	 * Sets the view's event listener - the controller - so that the changes
	 * made by the user in the view, can be reflected in the model
	 * 
	 * @param controller
	 *            The controller (event listener)
	 */
	public void addController(IController controller) {
		btnUpdate.setActionCommand(IController.ACTION_UPDATE);
		btnUpdate.addActionListener(controller);
	}

	@Override
	public void onMessage(boolean isError, String message) {
		// TODO Auto-generated method stub
		if (isError) {
			JOptionPane.showMessageDialog(this, message, "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, message, "Calc MVC",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		lblTempValue.setText(mModel.getTemperature() + "\u00b0" + "C");
		lblPrecValue.setText(mModel.getPrecipitation() + "%");
	}
}
