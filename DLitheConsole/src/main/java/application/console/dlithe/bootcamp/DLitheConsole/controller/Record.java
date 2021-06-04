package application.console.dlithe.bootcamp.DLitheConsole.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import application.console.dlithe.bootcamp.DLitheConsole.model.Assembly;
import application.console.dlithe.bootcamp.DLitheConsole.model.AssemblyException;
import application.console.dlithe.bootcamp.DLitheConsole.remote.AssemblyWorks;

public class Record implements AssemblyWorks
{
	private ArrayList<Assembly> data=new ArrayList<Assembly>();
	private Scanner scanner=new Scanner(System.in);

	@Override
	public void createNewRecord(Assembly object) 
	{
		try
		{
			data.add(object);
			System.out.println(object.getAssemblyName()+" has added to the record");
		}
		catch(NullPointerException nullpoint)
		{
			System.out.println(nullpoint);
			System.out.println("Need to provide valid details in order to add to the records");
			data.remove(object);
			object=new Assembly();// initialize>> allocating
			System.out.println("Assembly number: ");
			object.setAssembyNumber(scanner.nextInt());
			System.out.println("Assembly population: ");
			object.setAssemblyPopulation(scanner.nextInt());
			System.out.println("Assembly name: ");
			object.setAssemblyName(scanner.next());
			System.out.println("Assembly member name: ");
			object.setAssemblyMemberName(scanner.next());
			System.out.println("Tell us how many issues in "+object.getAssemblyName());
        	Integer count=scanner.nextInt();//4
        	String[] tmp=new String[count];
        	System.out.println("Tell us "+count+" of issues one by one: ");
        	for(int index=0;index<count;index++)
        	{
        		tmp[index]=scanner.next();
        	}
        	object.setAssemblyIssues(tmp);
        	System.out.println("Assembly contact: ");
        	object.setAssemblyContact(scanner.nextLong());
			
			data.add(object);
			System.out.println(object.getAssemblyName()+" has added to the record");
		}
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
		System.out.println("Finding assembly matches "+number);
		Assembly temp=null;
		Boolean state=false;
		// TODO Auto-generated method stub
		try
		{
			Iterator<Assembly> it=data.iterator();
			while(it.hasNext())
			{
				temp=it.next();
				if(temp.getAssembyNumber()==number)
				{
					state=true;
					//return temp;
					break;
				}
			}
			if(state)
			{
				return temp;
			}
			else
			{
				throw new AssemblyException();
			}
		}
		catch(AssemblyException exp)
		{
			System.out.println(exp);
			System.out.println(number+" is not in the list enter it once again:");
			number=scanner.nextInt();
			Iterator<Assembly> it=data.iterator();
			while(it.hasNext())
			{
				temp=it.next();
				if(temp.getAssembyNumber()==number)
				{
					state=true;
					//return temp;
					break;
				}
			}
			if(state)
			{
				return temp;
			}
			else
			{
				return null;
			}
		}
	}
	@Override
	public Assembly readOne(String name) 
	{
		System.out.println("Finding assembly matches name "+name);
		// TODO Auto-generated method stub
		Assembly temp=null;
		Boolean state=false;
		try
		{
			// TODO Auto-generated method stub
			Iterator<Assembly> it=data.iterator();
			while(it.hasNext())
			{
				temp=it.next();
				if(temp.getAssemblyName().equalsIgnoreCase(name))
				{
					state=true;break;
				}
			}
			if(state)
				return temp;
			else
			{
				throw new AssemblyException();
			}
		}
		catch(AssemblyException exp)
		{
			System.out.println(exp);
			System.out.println(name+" is not matching with the record enter it once again:");
			name=scanner.next();
			return readOne(name);
		}
	}
	@Override
	public String readOne(Integer population, String Issue, int count) {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("Finding assemblies matches "+population+" population and issue: "+Issue);
			Assembly temp=null;
			Boolean dlithe=false;
			String hai="";
			// TODO Auto-generated method stub
			Iterator<Assembly> it=data.iterator();
			while(it.hasNext())
			{
				temp=it.next();
				if(Arrays.toString(temp.getAssemblyIssues()).contains(Issue)&&temp.getAssemblyPopulation()>=population)
				{
					//return temp;
					dlithe=true;
					hai+=temp+"\n";
				}
			}
			if(dlithe)
			{
				return hai;
			}
			else {
				throw new AssemblyException();
			}
		}
		catch(AssemblyException obj)
		{
			System.out.println(obj+"\nEnter the Population and issue once again: ");
			int pop=scanner.nextInt();
			String is=scanner.next();
			count++;
			if(count<3)
				return readOne(pop, is, count);
			else
				return "Maximum chances used so can't continue the process";
		}
	}

	@Override
	public String delete(Integer number) 
	{
		System.out.println("Trying to delete assembly by number: "+number);
		Boolean state=false;
		Assembly yet=null;
		try
		{
			for(Assembly tmp:data)
			{
				if(tmp.getAssembyNumber()==number)
				{
					state=true;
					yet=tmp;break;
				}
			}
			if(state) {
				String name=yet.getAssemblyName();
				data.remove(yet);
				return name+" has deleted from the record";
			}
			else {
				throw new AssemblyException();
			}
		}
		catch(AssemblyException ex)
		{
			System.out.println(ex+"\nEnter the correct number to delete: ");
			number=scanner.nextInt();
			for(Assembly tmp:data)
			{
				if(tmp.getAssembyNumber()==number)
				{
					state=true;
					yet=tmp;break;
				}
			}
			if(state) {
				String name=yet.getAssemblyName();
				data.remove(yet);
				return name+" has deleted from the record";
			}
			else {
				return "Chances are over and Couldn't complete the deletion";
			}
		}
	}

	@Override
	public void update(Integer number,int count) 
	{
		Boolean state=false;
		Assembly yet=null;
		try
		{
			System.out.println("Trying to update assembly "+number);
			for(Assembly ptr:data)
			{
				if(ptr.getAssembyNumber()==number)
				{
					state=true;yet=ptr;
					break;
				}
			}
			if(state)
			{
				System.out.println("Tell us what you wish to update in the "+yet.getAssemblyName());
				String aspect=scanner.next();// population
				switch(aspect)
				{
				case "population":
					System.out.println("Tell us new population value in the "+yet.getAssemblyName());
					Integer newone=scanner.nextInt();
					yet.setAssemblyPopulation(newone);
					System.out.println(yet.getAssemblyName()+" has updated the "+aspect);
					return;
				case "contact":
					System.out.println("Tell us new contact number for the "+yet.getAssemblyName());
					Long mobile=scanner.nextLong();
					yet.setAssemblyContact(mobile);
					System.out.println(yet.getAssemblyName()+" has updated the "+aspect);
					return;
				}
			}
			else {
				throw new AssemblyException();
			}
		}
		catch(AssemblyException obj)
		{
			System.out.println(obj+"\nNumber is not valid");
			int no=scanner.nextInt();
			count++;
			if(count<=3)
				update(no,count);
			else
				System.out.println("Chances are over and Couldn't complete the updation");
		}
	}
}