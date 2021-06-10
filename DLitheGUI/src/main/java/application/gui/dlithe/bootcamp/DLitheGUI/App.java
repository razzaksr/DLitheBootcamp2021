package application.gui.dlithe.bootcamp.DLitheGUI;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	//Sample sample=new Sample();
    	Index index=new Index();
    	index.setVisible(true);
    }
}
