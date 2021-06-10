package application.gui.dlithe.bootcamp.DLitheGUI.modules;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.Driver;

import application.gui.dlithe.bootcamp.DLitheGUI.Assembly;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class FindAssembly extends JFrame {

	private JPanel contentPane;
	private JTextField pop;
	private JTextField issue;
	private JTextField name;
	private JComboBox combo;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { FindAssembly frame = new
	 * FindAssembly(); } catch (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public FindAssembly() {
		Vector<Integer> num=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dlithe","root","");
			String qry="select assembly_no from assembly";
			PreparedStatement pre=con.prepareStatement(qry);
			ResultSet set=pre.executeQuery();
			num=new Vector<Integer>();
			num.add(0);
			while(set.next())
			{
				num.add(set.getInt("assembly_no"));
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//setResizable(false);
		setTitle("Find Assemblies");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FindAssembly.class.getResource("/images/assembly.png")));
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1146, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Find Assemblies from Record");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Find By Number");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(158, 48, 207, 38);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Find By Population");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(158, 134, 207, 38);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Find By Issues");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1_1.setBounds(158, 220, 207, 38);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Find By Name");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1_1_1.setBounds(158, 308, 207, 38);
		panel.add(lblNewLabel_1_1_1_1);
		
		pop = new JTextField();
		pop.setColumns(10);
		pop.setBounds(638, 134, 256, 38);
		panel.add(pop);
		
		issue = new JTextField();
		issue.setColumns(10);
		issue.setBounds(638, 220, 256, 38);
		panel.add(issue);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(638, 308, 256, 38);
		panel.add(name);
		
		combo = new JComboBox(num);
		combo.setBounds(638, 48, 256, 38);
		panel.add(combo);
		
		JButton btnNewButton = new JButton("Find");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Assembly> tmp=null; 
				int no=(int)combo.getSelectedItem();
				String popu=pop.getText();
				//int population=Integer.parseInt(pop.getText());
				String is=issue.getText();
				String nm=name.getText();
				Assembly assembly=null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dlithe","root","");
					String qry="";
					PreparedStatement ps=null;
					if(no!=0&&popu.equals("")&&is.equals("")&&nm.equals(""))
					{
						tmp=new ArrayList<Assembly>();
						qry="select * from assembly where assembly_no = ?";
						ps=con.prepareStatement(qry);
						ps.setInt(1, no);
						ResultSet result = ps.executeQuery();
						if(result.next())
						{
							assembly=new Assembly();
							assembly.setAssembyNumber(result.getInt("assembly_no"));
							assembly.setAssemblyName(result.getString("assembly_name"));
							assembly.setAssemblyMemberName(result.getString("assembly_member_name"));
							assembly.setAssemblyPopulation(result.getInt("assembly_population"));
							assembly.setAssemblyContact(result.getLong("assembly_contact"));
							assembly.setAssemblyIssues(result.getString("assembly_issues"));
						}
						tmp.add(assembly);
						new ViewAssembly(tmp).setVisible(true);
						FindAssembly.this.dispose();
					}
					else if(no==0&&!popu.equals("")&&is.equals("")&&nm.equals(""))
					{
						int population=Integer.parseInt(pop.getText());
						tmp=new ArrayList<Assembly>();
						qry="select * from assembly where assembly_population >= ?";
						ps=con.prepareStatement(qry);
						ps.setInt(1, population);
						ResultSet result = ps.executeQuery();
						while(result.next())
						{
							assembly=new Assembly();
							assembly.setAssembyNumber(result.getInt("assembly_no"));
							assembly.setAssemblyName(result.getString("assembly_name"));
							assembly.setAssemblyMemberName(result.getString("assembly_member_name"));
							assembly.setAssemblyPopulation(result.getInt("assembly_population"));
							assembly.setAssemblyContact(result.getLong("assembly_contact"));
							assembly.setAssemblyIssues(result.getString("assembly_issues"));
							tmp.add(assembly);
						}
						new ViewAssembly(tmp).setVisible(true);
						FindAssembly.this.dispose();
					}
					else if(no==0&&popu.equals("")&&!is.equals("")&&nm.equals(""))
					{
						tmp=new ArrayList<Assembly>();
						qry="select * from assembly where assembly_issues like '%"+is+"%'";
						ps=con.prepareStatement(qry);
						ResultSet result = ps.executeQuery();
						while(result.next())
						{
							assembly=new Assembly();
							assembly.setAssembyNumber(result.getInt("assembly_no"));
							assembly.setAssemblyName(result.getString("assembly_name"));
							assembly.setAssemblyMemberName(result.getString("assembly_member_name"));
							assembly.setAssemblyPopulation(result.getInt("assembly_population"));
							assembly.setAssemblyContact(result.getLong("assembly_contact"));
							assembly.setAssemblyIssues(result.getString("assembly_issues"));
							tmp.add(assembly);
						}
						new ViewAssembly(tmp).setVisible(true);
						FindAssembly.this.dispose();
					}
					else if(no==0&&popu.equals("")&&is.equals("")&&!nm.equals(""))
					{
						tmp=new ArrayList<Assembly>();
						qry="select * from assembly where assembly_name = ?";
						ps=con.prepareStatement(qry);
						ps.setString(1, nm);
						ResultSet result = ps.executeQuery();
						while(result.next())
						{
							assembly=new Assembly();
							assembly.setAssembyNumber(result.getInt("assembly_no"));
							assembly.setAssemblyName(result.getString("assembly_name"));
							assembly.setAssemblyMemberName(result.getString("assembly_member_name"));
							assembly.setAssemblyPopulation(result.getInt("assembly_population"));
							assembly.setAssemblyContact(result.getLong("assembly_contact"));
							assembly.setAssemblyIssues(result.getString("assembly_issues"));
							tmp.add(assembly);
						}
						new ViewAssembly(tmp).setVisible(true);
						FindAssembly.this.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(FindAssembly.this, "Invalid Selection");
					}
					combo.setSelectedItem("0");
					pop.setText("");
					issue.setText("");
					name.setText("");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnNewButton.setBounds(386, 396, 93, 38);
		panel.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				combo.setSelectedItem("0");
				pop.setText("");
				issue.setText("");
				name.setText("");
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnClear.setBounds(609, 396, 93, 38);
		panel.add(btnClear);
		
		JLabel lblNewLabel_2 = new JLabel("OR");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_2.setBounds(496, 109, 48, 26);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("OR");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_2_1.setBounds(496, 187, 48, 26);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("OR");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_2_2.setBounds(496, 266, 48, 26);
		panel.add(lblNewLabel_2_2);
	}
}
