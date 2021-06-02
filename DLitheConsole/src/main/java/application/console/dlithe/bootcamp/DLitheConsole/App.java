package application.console.dlithe.bootcamp.DLitheConsole;

import java.util.Scanner;

import application.console.dlithe.bootcamp.DLitheConsole.controller.Record;
import application.console.dlithe.bootcamp.DLitheConsole.model.Assembly;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner=new Scanner(System.in);
        Record record=new Record();
        Boolean more=false;
        do
        {
        	System.out.println("What you wish to do: ");
        	System.out.println("new\nviewall\nupdate\nread\ndelete");
            String process=scanner.next();// new, viewall
            switch(process)
            {
            case "new":
            	System.out.println("Tell us assembly number,population,name,membername,issues,contact");
            	Assembly assembly=new Assembly();
            	assembly.setAssembyNumber(scanner.nextInt());
            	assembly.setAssemblyPopulation(scanner.nextInt());
            	assembly.setAssemblyName(scanner.next());
            	assembly.setAssemblyMemberName(scanner.next());
            	System.out.println("Tell us how many issues in "+assembly.getAssemblyName());
            	Integer count=scanner.nextInt();//4
            	String[] tmp=new String[count];
            	System.out.println("Tell us "+count+" of issues one by one: ");
            	for(int index=0;index<count;index++)
            	{
            		tmp[index]=scanner.next();
            	}
            	assembly.setAssemblyIssues(tmp);
            	System.out.println("Tell us assembly contact: ");
            	assembly.setAssemblyContact(scanner.nextLong());
            	record.createNewRecord(assembly);
            	break;
            case "viewall":
            	System.out.println(record);
            }
            System.out.println("Do wish to continue(true/false): ");
            more=scanner.nextBoolean();
        }while(more);
        
        scanner.close();
    }
}
