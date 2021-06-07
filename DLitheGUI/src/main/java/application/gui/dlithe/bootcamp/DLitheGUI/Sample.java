package application.gui.dlithe.bootcamp.DLitheGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sample extends JFrame {

	private JPanel container;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Sample frame = new Sample();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public Sample() {
		setVisible(true);
		setTitle("DLithe GUI Sample");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ADMIN\\Downloads\\bullet.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1102, 560);
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(container);
		container.setLayout(null);
		
		JButton btnNewButton = new JButton("Delta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Sample.this, "Alpha is clicked");
			}
		});
		btnNewButton.setBounds(121, 423, 85, 21);
		container.add(btnNewButton);
		
		JButton bu2 = new JButton("Cosmo");
		bu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Sample.this, "Cosmo is clicked");
			}
		});
		bu2.setBounds(433, 95, 85, 21);
		container.add(bu2);
		
		JButton btnNewButton_2 = new JButton("Donut");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Sample.this, "Donut is clicked");
			}
		});
		btnNewButton_2.setBounds(914, 277, 85, 21);
		container.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eclairs");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Sample.this, "Alpha is clicked");
			}
		});
		btnNewButton_3.setBounds(716, 410, 85, 21);
		container.add(btnNewButton_3);
		
		JButton bu1 = new JButton("Alpha");
		bu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Alpha is Clicked");
				JOptionPane.showMessageDialog(Sample.this, "Alpha is clicked");
			}
		});
		bu1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\aud.jfif"));
		bu1.setForeground(Color.WHITE);
		bu1.setBackground(Color.BLUE);
		bu1.setBounds(57, 66, 85, 21);
		container.add(bu1);
	}
}
