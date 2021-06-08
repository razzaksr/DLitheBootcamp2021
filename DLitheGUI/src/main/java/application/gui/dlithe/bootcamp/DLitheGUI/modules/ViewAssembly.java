package application.gui.dlithe.bootcamp.DLitheGUI.modules;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import application.gui.dlithe.bootcamp.DLitheGUI.Assembly;

import java.awt.Color;

public class ViewAssembly extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static DefaultTableModel model;
	private ArrayList<Assembly> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAssembly frame = new ViewAssembly();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewAssembly() {
		setVisible(true);
		list=new ArrayList<Assembly>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dlithe","root","");
			String qry="select * from assembly";
			PreparedStatement ps=con.prepareStatement(qry);
			ResultSet result=ps.executeQuery();
			Assembly assembly=null;
			while(result.next())
			{
				assembly=new Assembly();
				assembly.setAssembyNumber(result.getInt("assembly_no"));
				assembly.setAssemblyName(result.getString("assembly_name"));
				assembly.setAssemblyMemberName(result.getString("assembly_member_name"));
				assembly.setAssemblyPopulation(result.getInt("assembly_population"));
				assembly.setAssemblyContact(result.getLong("assembly_contact"));
				assembly.setAssemblyIssues(result.getString("assembly_issues"));
				list.add(assembly);
			}
			
			Collections.sort(list);
			
			model=new DefaultTableModel();
			
			model.addColumn("Assembly Number");model.addColumn("Assembly Name");
			model.addColumn("Assembly Member Name");model.addColumn("Assembly Population");
			model.addColumn("Assembly Contact Number");model.addColumn("Assembly Issues");
			
			for(Assembly tmp:list)
			{
				model.addRow(new Object[] {
						tmp.getAssembyNumber(),tmp.getAssemblyName(),tmp.getAssemblyMemberName(),
						tmp.getAssemblyPopulation(),tmp.getAssemblyContact(),tmp.getAssemblyIssues()
				});
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewAssembly.class.getResource("/images/assembly.png")));
		setTitle("View Assembly");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(model);
		table.setBackground(Color.CYAN);
		scrollPane.setViewportView(table);
	}

}
