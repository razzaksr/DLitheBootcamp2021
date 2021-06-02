package application.console.dlithe.bootcamp.DLitheConsole;

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
        Assembly assembly1=new Assembly();
        // Classname object=new Constructor()
        assembly1.setAssemblyName("Bangalore West");
        assembly1.setAssemblyContact(76543456785L);
        assembly1.setAssemblyPopulation(200000);
        assembly1.setAssembyNumber(87);
        assembly1.setAssemblyMemberName("Rohan");
        assembly1.setAssemblyIssues(new String[] {"Traffic","Drinage"});
        Assembly assembly2=new Assembly(98,312903,"Shivmoga","Jilani",new String[] {"Water","Electricity","Network"},98767876776L);
        Assembly assembly3=new Assembly(12,287945,"Madiwala","Ganavi",new String[] {"Hospitality","Transportation"},1234323454L);
        Assembly assembly4=new Assembly(34,312903,"Bangalore East","Oliver",new String[] {"Agriculture","Traffic","Pollution"},87656787634L);
        
        Record record=new Record();
        record.createNewRecord(assembly1);
        record.createNewRecord(assembly2);
        record.createNewRecord(assembly3);
        record.createNewRecord(assembly4);
        
        
        //System.out.println(record);
        
		/*
		 * Assembly hai=record.readOne(100); System.out.println("REceived "+hai);
		 */
        
		/*
		 * String assem=record.delete(98);
		 * System.out.println("Deleted assemebly from record is: "+assem);
		 */
        record.update(12);
    }
}
