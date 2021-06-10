package application.gui.dlithe.bootcamp.DLitheGUI.modules;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ViewAssembly frame = new
	 * ViewAssembly(); } catch (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public ViewAssembly(ArrayList<Assembly> hai)
	{
		//System.out.println(hai);
		setVisible(true);
		list=hai;
		
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
			model.addColumn("Edit");model.addColumn("Delete");
			
			for(Assembly tmp:list)
			{
				model.addRow(new Object[] {
						tmp.getAssembyNumber(),tmp.getAssemblyName(),tmp.getAssemblyMemberName(),
						tmp.getAssemblyPopulation(),tmp.getAssemblyContact(),tmp.getAssemblyIssues(),
						"Edit","Delete"
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
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				int col=table.getSelectedColumn();
				int num=(int)model.getValueAt(row, 0);
				String field=(String)model.getValueAt(row, col);
				//JOptionPane.showMessageDialog(ViewAssembly.this, "Selected assembly is "+num+" for "+field);
				if(field.equals("Delete"))
				{
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dlithe","root","");
						String qry="delete from assembly where assembly_no = ?";
						PreparedStatement pre=con.prepareStatement(qry);
						pre.setInt(1, num);
						int ack=pre.executeUpdate();
						if(ack!=0)
						{
							model.removeRow(row);
							JOptionPane.showMessageDialog(ViewAssembly.this, num+" Assembly has deleted");
						}
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(field.equals("Edit"))
				{
					Assembly received=list.get(row);
					//JOptionPane.showMessageDialog(ViewAssembly.this, received);
					EditAssembly edit=new EditAssembly(received);
					ViewAssembly.this.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(ViewAssembly.this, "Invalid Option");
				}
			}
		});
	}

}
