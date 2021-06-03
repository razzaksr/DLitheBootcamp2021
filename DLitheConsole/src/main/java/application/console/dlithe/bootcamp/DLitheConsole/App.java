package application.console.dlithe.bootcamp.DLitheConsole;

import java.util.Scanner;

import application.console.dlithe.bootcamp.DLitheConsole.controller.Record;
import application.console.dlithe.bootcamp.DLitheConsole.model.Assembly;

/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner=new Scanner(System.in);
        Record record=new Record();
        Boolean more=false;
        Assembly assembly1=new Assembly();
        assembly1.setAssemblyName("Mudbadri");
        assembly1.setAssemblyContact(987656787655L);
        assembly1.setAssemblyPopulation(200000);
        assembly1.setAssembyNumber(87);
        assembly1.setAssemblyMemberName("Rohan");
        assembly1.setAssemblyIssues(new String[] {"Traffic","Drinage"});
        Assembly assembly2=new Assembly(98,312903,"Shivmoga","Jilani",new String[] {"Water","Electricity","Network"},98767876776L);
        Assembly assembly3=new Assembly(12,287945,"Madiwala","Ganavi",new String[] {"Hospitality","Transportation"},1234323454L);
        Assembly assembly4=new Assembly(34,312903,"Bangalore East","Oliver",new String[] {"Agriculture","Traffic","Pollution"},87656787634L);
        record.createNewRecord(assembly1);record.createNewRecord(assembly2);record.createNewRecord(assembly3);
        record.createNewRecord(assembly4);
        
        //System.out.println(record);
        
        
        
        System.out.println("Tell us user name: ");
        String user=scanner.next();
        System.out.println("Tell us password: ");
        String pass=scanner.next();
        if(user.equals("dlithe")&&pass.equals("bootcamp2021"))
        {
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
                	System.out.println(record);break;
                case "read":
                	System.out.println("Getting assembly details based on Assembly number / name: ");
                	String based=scanner.next();
                	if(based.equalsIgnoreCase("number"))
                	{
                		System.out.println("User required to enter assembly number: ");
                		int no=scanner.nextInt();
                		System.out.println(record.readOne(no));
                	}
                	else if(based.equalsIgnoreCase("name"))
                	{
                		System.out.println("User required to enter assembly name: ");
                		String nm=scanner.next();
                		System.out.println(record.readOne(nm));
                	}
                	else if(based.equalsIgnoreCase("population&issue"))
                	{
                		System.out.println("TEll us popluation: ");
                		int pop=scanner.nextInt();
                		System.out.println("Tell us issue: ");
                		String is=scanner.next();
                		System.out.println(record.readOne(pop,is));
                	}
                	break;
                }
                System.out.println("Do wish to continue(true/false): ");
                more=scanner.nextBoolean();
            }while(more);
        }
        else {
        	System.out.println("Invalid credentials");
        }
        
        scanner.close();
    }
}
