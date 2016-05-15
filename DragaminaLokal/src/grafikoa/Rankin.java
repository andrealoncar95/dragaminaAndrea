package grafikoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import logikoa.Jokalaria;
import logikoa.Ranking;

public class Rankin extends JFrame {

	private JPanel contentPane;
	private JTextArea txtArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rankin frame = new Rankin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Rankin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		txtArea=new JTextArea();
		contentPane.add(txtArea, BorderLayout.CENTER);
		Ranking.getRanking().rankingSortu();
		txtArea.setText(Ranking.getRanking().rankinaBueltatu());
		txtArea.setEditable(false);
	}

}
