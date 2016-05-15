package grafikoa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.TableroController;
import logikoa.Jokoa;

public class Tableroa extends JFrame{

	private JPanel panela = new JPanel();
	private JButton start = new JButton();
	private JLabel minak;
	private int minaKop=0;
	private  JButton taula[][];
	private int zailtasuna;
	private JLabel lblTime = new JLabel();

	public Tableroa(int zailtasuna){
		this.zailtasuna=zailtasuna;
		try    {
			this.getContentPane().setLayout(new BorderLayout());
			this.setTitle("Dragamina");

			if (zailtasuna==1){
				this.setSize(new Dimension(325, 350));
				panela.setBounds(new Rectangle(0, 40, 280, 270));
			}
			else if (zailtasuna==2){
				this.setSize(new Dimension(516, 392));
				panela.setBounds(new Rectangle(0, 40, 500, 320));
			}
			else if (zailtasuna==3){
				this.setSize(new Dimension(1030, 597));
				panela.setBounds(new Rectangle(0, 40, 1060, 540));
			}
			TableroController.getTableroController().tableroaHasieratu(zailtasuna);


			panela.setBackground(new Color(0, 200, 200));
			panela.setLayout(new GridLayout(TableroController.getTableroController().getZutabeak(), TableroController.getTableroController().getLerroak()));
			start.setBounds(new Rectangle(0, 0, 125, 40));
			start.setFont(new Font("Calibri", 0, 12));
			start.setHorizontalTextPosition(SwingConstants.CENTER);
			start.setAlignmentY((float)0.0);
			start.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					start_actionPerformed();
				}
			});
			JPanel menuPanela=new JPanel(new FlowLayout());
			menuPanela.add(start);
			minak=new JLabel(minaKop+"/"+Integer.toString(TableroController.getTableroController().getBonbak()));
			menuPanela.add(minak);
			this.getContentPane().add(menuPanela, BorderLayout.NORTH);
			this.getContentPane().add(panela, BorderLayout.CENTER);
			
	        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        menuPanela.add(lblTime);

			taula= new JButton[TableroController.getTableroController().getZutabeak()][TableroController.getTableroController().getLerroak()];
			taulaKargatu();
			this.setVisible(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void start_actionPerformed()  {
		TableroController.getTableroController().tableroaHasieratu(zailtasuna);
		minaKop=0;
		minak.setText(minaKop+"/"+Integer.toString(TableroController.getTableroController().getBonbak()));
		for (int i=0;i<taula.length;i++){
			for (int z=0;z<taula[0].length;z++){
				taula[i][z].setEnabled(true);
				taula[i][z].setText(" ");
			}
		}
		this.setTitle("Dragamina");
		start.setText("HASI");
	}

	public void taulaKargatu(){
		for (int i=0;i<taula.length;i++){
			for (int z=0;z<taula[0].length;z++){
				taula[i][z]= new JButton();
				panela.add(taula[i][z]);
				taula[i][z].setBounds(i*25,z*25,25,25);
				taula[i][z].setMargin(new Insets(0, 0, 0, 0));
				taula[i][z].setFont(new Font("Tahoma", 0,10));
				
				taula[i][z].addActionListener(
						new ActionListener(){
							public void actionPerformed(ActionEvent ar) {
								for (int i=0;i<taula.length;i++){
									for (int z=0;z<taula[0].length;z++){
										if (ar.getSource()==taula[i][z]){
											if(!Jokoa.getNireJokoa().markatuta(i, z)){
												Jokoa.getNireJokoa().ireki(i, z);
											}

										} 
									}        
								}
								for (int i=0;i<taula.length;i++){
									for (int z=0;z<taula[0].length;z++){
										if (Jokoa.getNireJokoa().sakatuta(i, z)){
											taula[i][z].setText(Jokoa.getNireJokoa().getText(i, z));
											taula[i][z].setEnabled(false);
										}
									}
								}	
								if(Jokoa.getNireJokoa().irabazi()){
									Irabazi irabazi= new Irabazi(zailtasuna);
									irabazi.setVisible(true);
									dispose();
								}
							}
						}
						);  
				taula[i][z].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						if (e.getButton()==MouseEvent.BUTTON3){
							for (int i=0;i<taula.length;i++){
								for (int z=0;z<taula[0].length;z++){
									if (e.getSource()==taula[i][z]){
										if(Jokoa.getNireJokoa().markatuta(i, z)&&!Jokoa.getNireJokoa().sakatuta(i, z)){
											minaKop--;
											minak.setText((minaKop+"/"+Integer.toString(TableroController.getTableroController().getBonbak())));
											taula[i][z].setText(Jokoa.getNireJokoa().getMarka(i, z));
											Jokoa.getNireJokoa().markatu(i, z);
										}
										else if (!Jokoa.getNireJokoa().markatuta(i, z)&&!Jokoa.getNireJokoa().sakatuta(i, z)){
											if(minaKop<TableroController.getTableroController().getBonbak()){
												minaKop++;
												minak.setText((minaKop+"/"+Integer.toString(TableroController.getTableroController().getBonbak())));
												taula[i][z].setText(Jokoa.getNireJokoa().getMarka(i, z));
												Jokoa.getNireJokoa().markatu(i, z);
											}
										}
									} 
								}        
							}
						}

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}
				});

			}
		}
	}


}
