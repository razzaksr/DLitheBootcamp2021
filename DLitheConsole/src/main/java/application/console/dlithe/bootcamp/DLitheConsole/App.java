package application.console.dlithe.bootcamp.DLitheConsole;

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
        assembly1.setAssemblyIssues(new String[] {"Traffic Issue","Drinage issue"});
        
        System.out.println("Assembly Details are: \n"+assembly1);
        //System.out.println("Assembly name: "+assembly1.getAssemblyName()+" assembly member: "+assembly1.getAssemblyMemberName()+" assembly popluation: "+assembly1.getAssemblyPopulation()+" assembly Contact: "+assembly1.getAssemblyContact());
        
        
        Assembly assembly2=new Assembly(98,312903,"Shivmoga","Jilani",new String[] {"Water","Electricity","Network"},98767876776L);
        System.out.println("Assembly Details are: ");
        System.out.println("assembly popluation: "+assembly2.getAssemblyPopulation()+" assembly Member: "+assembly2.getAssemblyMemberName());
    }
}
