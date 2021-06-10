package application.gui.dlithe.bootcamp.DLitheGUI.modules;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;

public class NewAssembly extends JFrame {

	private JPanel contentPane;
	private JTextField aNumber;
	private JTextField aName;
	private JTextField aMemberName;
	private JTextField aPop;
	private JTextField aContact;
	private JTextArea aIssues;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { NewAssembly frame = new NewAssembly();
	 * } catch (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public NewAssembly() {
		//setVisible(true);
		setResizable(false);
		setTitle("New Assembly");
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewAssembly.class.getResource("/images/assembly.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1201, 622);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adding New Assembly");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(459, 25, 328, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Assembly Number");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(226, 111, 235, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Assembly Name");
		lblNewLabel_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(226, 160, 235, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Assembly Member Name");
		lblNewLabel_1_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_2.setBounds(226, 209, 235, 39);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Assembly Population");
		lblNewLabel_1_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_3.setBounds(226, 258, 235, 39);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Assembly Contact Number");
		lblNewLabel_1_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_4.setBounds(226, 307, 235, 39);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Assembly Issues");
		lblNewLabel_1_5.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_5.setBounds(226, 356, 235, 39);
		contentPane.add(lblNewLabel_1_5);
		
		aNumber = new JTextField();
		aNumber.setForeground(Color.DARK_GRAY);
		aNumber.setBackground(Color.CYAN);
		aNumber.setBounds(650, 111, 240, 27);
		contentPane.add(aNumber);
		aNumber.setColumns(10);
		
		aName = new JTextField();
		aName.setForeground(Color.DARK_GRAY);
		aName.setBackground(Color.CYAN);
		aName.setColumns(10);
		aName.setBounds(650, 160, 240, 27);
		contentPane.add(aName);
		
		aMemberName = new JTextField();
		aMemberName.setForeground(Color.DARK_GRAY);
		aMemberName.setBackground(Color.CYAN);
		aMemberName.setColumns(10);
		aMemberName.setBounds(650, 209, 240, 27);
		contentPane.add(aMemberName);
		
		aPop = new JTextField();
		aPop.setForeground(Color.DARK_GRAY);
		aPop.setBackground(Color.CYAN);
		aPop.setColumns(10);
		aPop.setBounds(650, 258, 240, 27);
		contentPane.add(aPop);
		
		aContact = new JTextField();
		aContact.setForeground(Color.DARK_GRAY);
		aContact.setBackground(Color.CYAN);
		aContact.setColumns(10);
		aContact.setBounds(650, 307, 240, 27);
		contentPane.add(aContact);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(650, 356, 240, 81);
		contentPane.add(scrollPane);
		
		aIssues= new JTextArea();
		aIssues.setForeground(Color.DARK_GRAY);
		aIssues.setBackground(Color.CYAN);
		scrollPane.setViewportView(aIssues);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=Integer.parseInt(aNumber.getText());
				String name=aName.getText();
				String member=aMemberName.getText();
				int pop=Integer.parseInt(aPop.getText());
				long mobile=Long.parseLong(aContact.getText());
				String issues=aIssues.getText();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dlithe","root","");
					
					String qry="insert into assembly(assembly_no,assembly_name,assembly_member_name,assembly_population,assembly_contact,assembly_issues) values(?,?,?,?,?,?)";
					PreparedStatement statement=con.prepareStatement(qry);
					statement.setInt(1, num);statement.setString(3, member);
					statement.setString(2, name);statement.setInt(4, pop);
					statement.setLong(5, mobile);statement.setString(6, issues);
					
					try
					{
						int state=statement.executeUpdate();
						if(state!=0)
						{
							JOptionPane.showMessageDialog(NewAssembly.this, "New Assembly added to our record");
							aNumber.setText("");aName.setText("");aMemberName.setText("");aPop.setText("");
							aIssues.setText("");aContact.setText("");
						}
						else
						{
							JOptionPane.showMessageDialog(NewAssembly.this, "New Assembly failed to our record");
						}
					}
					catch(Exception et)
					{
						JOptionPane.showMessageDialog(NewAssembly.this, et);
					}
					con.close();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(366, 501, 109, 39);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aNumber.setText("");aName.setText("");aMemberName.setText("");aPop.setText("");
				aIssues.setText("");aContact.setText("");
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnClear.setForeground(Color.DARK_GRAY);
		btnClear.setBackground(Color.CYAN);
		btnClear.setBounds(650, 501, 109, 39);
		contentPane.add(btnClear);
	}
}
