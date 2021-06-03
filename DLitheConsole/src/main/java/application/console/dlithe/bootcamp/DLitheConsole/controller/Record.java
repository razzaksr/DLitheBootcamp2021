package application.console.dlithe.bootcamp.DLitheConsole.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import application.console.dlithe.bootcamp.DLitheConsole.model.Assembly;
import application.console.dlithe.bootcamp.DLitheConsole.remote.AssemblyWorks;

public class Record implements AssemblyWorks
{
	private ArrayList<Assembly> data=new ArrayList<Assembly>();
	private Scanner scanner=new Scanner(System.in);

	@Override
	public void createNewRecord(Assembly object) 
	{
		data.add(object);
		System.out.println(object.getAssemblyName()+" has added to the record");
	}

	@Override
	public String toString()
	{
		Collections.sort(data);
		//System.out.println(data);
		String hai="";
		System.out.println("Listing all the assembly records");
		for(Assembly ptr:data)
		{
			hai+=ptr+"\n";
		}
		return hai;
	}

	@Override
	public Assembly readOne(Integer number) {
		Assembly temp=null;
		// TODO Auto-generated method stub
		Iterator<Assembly> it=data.iterator();
		while(it.hasNext())
		{
			temp=it.next();
			if(temp.getAssembyNumber()==number)
			{
				return temp;
			}
		}
		return null;
	}
	@Override
	public Assembly readOne(String name) 
	{
		// TODO Auto-generated method stub
		Assembly temp=null;
		// TODO Auto-generated method stub
		Iterator<Assembly> it=data.iterator();
		while(it.hasNext())
		{
			temp=it.next();
			if(temp.getAssemblyName().equalsIgnoreCase(name))
			{
				return temp;
			}
		}
		return null;
	}
	@Override
	public String readOne(Integer population, String Issue) {
		// TODO Auto-generated method stub
		System.out.println("Finding assemblies matches "+population+" popluation and issue: "+Issue);
		Assembly temp=null;
		String hai="";
		// TODO Auto-generated method stub
		Iterator<Assembly> it=data.iterator();
		while(it.hasNext())
		{
			temp=it.next();
			if(Arrays.toString(temp.getAssemblyIssues()).contains(Issue)&&temp.getAssemblyPopulation()>=population)
			{
				//return temp;
				hai+=temp+"\n";
			}
		}
		return hai;
	}

	@Override
	public String delete(Integer number) 
	{
		Assembly yet=null;
		for(Assembly tmp:data)
		{
			if(tmp.getAssembyNumber()==number)
			{
				yet=tmp;break;
			}
		}
		String name=yet.getAssemblyName();
		data.remove(yet);
		return name;
	}

	@Override
	public void update(Integer number) 
	{
		for(Assembly ptr:data)
		{
			if(ptr.getAssembyNumber()==number)
			{
				System.out.println("Tell us what you wish to update in the "+ptr.getAssemblyName());
				String aspect=scanner.nextLine();// population
				switch(aspect)
				{
				case "population":
					System.out.println("Tell us new population value in the "+ptr.getAssemblyName());
					Integer newone=scanner.nextInt();
					ptr.setAssemblyPopulation(newone);
					System.out.println(ptr.getAssemblyName()+" has updated the "+aspect);
					return;
				case "contact":
					System.out.println("Tell us new contact number for the "+ptr.getAssemblyName());
					Long mobile=scanner.nextLong();
					ptr.setAssemblyContact(mobile);
					System.out.println(ptr.getAssemblyName()+" has updated the "+aspect);
					return;
				}
			}
		}
	}
}
