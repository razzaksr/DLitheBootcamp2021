package application.gui.dlithe.bootcamp.DLitheGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Index extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Index frame = new Index(); } catch
	 * (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public Index() {
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
			String qry1="create database if not exists dlithe";
			String qry2="create table if not exists dlithe.assembly(assembly_no int(4) primary key, assembly_name varchar(100) not null, assembly_member_name varchar(100) not null, assembly_population int(8) not null, assembly_contact bigint(13) not null, assembly_issues text)";
			PreparedStatement ps=con.prepareStatement(qry1);
			if(ps.executeUpdate()!=0)
			{
				JOptionPane.showMessageDialog(Index.this, "Data base created now");
			}
			ps=con.prepareStatement(qry2);
			if(ps.executeUpdate()!=0)
			{
				JOptionPane.showMessageDialog(Index.this, "Assembly table created now");
			}
		} /*
			 * catch (ClassNotFoundException e2) { // TODO Auto-generated catch block
			 * e2.printStackTrace(); }
			 */catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(Index.class.getResource("/images/assembly.png")));
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 824, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		try {
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(contentPane);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login into infohouse");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(167, 10, 487, 103);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(124, 133, 204, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1_1.setBounds(124, 261, 204, 44);
		contentPane.add(lblNewLabel_1_1);
		
		user = new JTextField();
		user.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		user.setForeground(new Color(0, 0, 128));
		user.setBounds(458, 133, 179, 44);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setEchoChar('*');
		pass.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		pass.setForeground(new Color(0, 0, 128));
		pass.setBounds(458, 261, 179, 44);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String us=user.getText();
				String ps=pass.getText();
				if(us.equals("dlithe")&&ps.equals("bootcamp2021"))
				{
					Home home=new Home();
					Index.this.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(Index.this, "Invalid Credentials");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBounds(254, 386, 126, 44);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index.this.dispose();
			}
		});
		btnCancel.setForeground(new Color(0, 0, 128));
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnCancel.setBounds(434, 386, 126, 44);
		contentPane.add(btnCancel);
	}
}
