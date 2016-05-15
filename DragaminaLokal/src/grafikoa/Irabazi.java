package grafikoa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Irabazi extends JDialog implements ActionListener {

	
	private int zail; 
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */

	public Irabazi(int zailtasuna) {
		zail=zailtasuna;
		setBounds(100, 100, 300, 100);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lbel= new JLabel("Zorionak, irabazi duzu!");
		contentPanel.add(lbel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Berriz jokatu");
				okButton.setActionCommand("jokatu");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Ranking-a ikusi");
				cancelButton.setActionCommand("rankin");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand()=="jokatu"){
			Tableroa tableroa = new Tableroa(zail);
			tableroa.start_actionPerformed();	
		}
		else if(e.getActionCommand()=="rankin"){
			Rankin r = new Rankin();
			r.setVisible(true);
		}
		this.dispose();
		
	}

}
