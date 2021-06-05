package application.console.dlithe.bootcamp.DLitheConsole.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import application.console.dlithe.bootcamp.DLitheConsole.model.Assembly;
import application.console.dlithe.bootcamp.DLitheConsole.model.AssemblyException;
import application.console.dlithe.bootcamp.DLitheConsole.remote.AssemblyWorks;

public class Record implements AssemblyWorks
{
	private ArrayList<Assembly> data;
	private Scanner scanner=new Scanner(System.in);
	private File file;
	public Record()
	{
		data=new ArrayList<Assembly>();
		file=new File("C:\\Users\\ADMIN\\git\\DLitheBoot2021\\DLitheConsole\\assembly.doc");
	}
	@Override
	public void createNewRecord(Assembly object) 
	{
		FileOutputStream fos;
		ObjectOutputStream oos;
		try
		{
			data.add(object);
			fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
			System.out.println(object.getAssemblyName()+" has added to the record");
			oos.writeObject(data);
			fos.close();
			oos.close();
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
			try {
				fos=new FileOutputStream(file);
				oos=new ObjectOutputStream(fos);
				data.add(object);
				System.out.println(object.getAssemblyName()+" has added to the record");
				oos.writeObject(data);
				fos.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString()
	{
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		String hai="";
		try {
			fis = new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			ArrayList<Assembly> hi=(ArrayList<Assembly>) ois.readObject();
			fis.close();
			ois.close();
			Collections.sort(hi);
			for(Assembly tmp:hi)
			{
				hai+=tmp;
			}
			return hai;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public Assembly readOne(Integer number) {
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		//String hai="";
		Boolean state=false;
		Assembly yet=null;
		try {
			fis = new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			ArrayList<Assembly> hi=(ArrayList<Assembly>) ois.readObject();
			fis.close();
			ois.close();
			for(Assembly tmp:hi)
			{
				//hai+=tmp;
				//System.out.println(tmp);
				if(tmp.getAssembyNumber().equals(number))
				{
					state=true;
					yet=tmp;break;
				}
			}
			if(state)
				return yet;
			else
				throw new AssemblyException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AssemblyException e) 
		{
			// TODO Auto-generated catch block
			try
			{
				e.printStackTrace();
				System.out.println("Enter the valid number: ");
				number=scanner.nextInt();
				fis = new FileInputStream(file);
				ois=new ObjectInputStream(fis);
				ArrayList<Assembly> hi=(ArrayList<Assembly>) ois.readObject();
				fis.close();
				ois.close();
				for(Assembly tmp:hi)
				{
					//hai+=tmp;
					if(tmp.getAssembyNumber().equals(number))
					{
						state=true;
						yet=tmp;break;
					}
				}
				if(state)
					return yet;
				else
					return null;
			}
			catch (IOException i) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException ie) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return null;
	}
	@Override
	public Assembly readOne(String name) 
	{
		System.out.println("Finding assembly matches name "+name);
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		//String hai="";
		Boolean state=false;
		Assembly yet=null;
		try {
			fis = new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			ArrayList<Assembly> hi=(ArrayList<Assembly>) ois.readObject();
			fis.close();
			ois.close();
			for(Assembly tmp:hi)
			{
				//hai+=tmp;
				//System.out.println(tmp);
				if(tmp.getAssemblyName().equals(name))
				{
					state=true;
					yet=tmp;break;
				}
			}
			if(state)
				return yet;
			else
				throw new AssemblyException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(AssemblyException exp)
		{
			System.out.println(exp);
			System.out.println(name+" is not matching with the record enter it once again:");
			name=scanner.next();
			return readOne(name);
		}
		return null;
	}
	@Override
	public String readOne(Integer population, String Issue, int count) {
		// TODO Auto-generated method stub
		System.out.println("Finding assembly matches with population: "+population+" and issue: "+Issue);
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		//String hai="";
		Boolean state=false;
		Assembly yet=null;
		try {
			fis = new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			ArrayList<Assembly> hi=(ArrayList<Assembly>) ois.readObject();
			fis.close();
			ois.close();
			for(Assembly tmp:hi)
			{
				//hai+=tmp;
				//System.out.println(tmp);
				if((int)tmp.getAssemblyPopulation()>population&&Arrays.toString(tmp.getAssemblyIssues()).contains(Issue))
				{
					state=true;
					yet=tmp;break;
				}
			}
			if(state)
				return yet.toString();
			else
				throw new AssemblyException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(AssemblyException obj)
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
		return "Maximum chances used so can't continue the process";
	}

	@Override
	public String delete(Integer number) 
	{
		System.out.println("Trying to delete assembly by number: "+number);
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		//String hai="";
		Boolean state=false;
		Assembly yet=null;
		try {
			fis = new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			ArrayList<Assembly> hi=(ArrayList<Assembly>) ois.readObject();
			fis.close();
			ois.close();
			for(Assembly tmp:hi)
			{
				//hai+=tmp;
				//System.out.println(tmp);
				if(tmp.getAssembyNumber().equals(number))
				{
					state=true;
					yet=tmp;break;
				}
			}
			if(state)
			{
				String name=yet.getAssemblyName();
				hi.remove(yet);
				FileOutputStream fos;
				ObjectOutputStream oos;
				try
				{
					fos=new FileOutputStream(file);
					oos=new ObjectOutputStream(fos);
					oos.writeObject(hi);
					fos.close();
					oos.close();
					return name+" has deleted from the record";
				}
				catch(IOException ir)
				{
					ir.printStackTrace();
				}
				
			}
			else
				throw new AssemblyException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(AssemblyException ex)
		{
			System.out.println(ex+"\nEnter the correct number to delete: ");
			number=scanner.nextInt();
			try {
				fis = new FileInputStream(file);
				ois=new ObjectInputStream(fis);
				ArrayList<Assembly> hi=(ArrayList<Assembly>) ois.readObject();
				fis.close();
				ois.close();
				for(Assembly tmp:hi)
				{
					//hai+=tmp;
					//System.out.println(tmp);
					if(tmp.getAssembyNumber().equals(number))
					{
						state=true;
						yet=tmp;break;
					}
				}
				if(state)
				{
					String name=yet.getAssemblyName();
					hi.remove(yet);
					FileOutputStream fos;
					ObjectOutputStream oos;
					try
					{
						fos=new FileOutputStream(file);
						oos=new ObjectOutputStream(fos);
						oos.writeObject(hi);
						fos.close();
						oos.close();
						return name+" has deleted from the record";
					}
					catch(IOException ir)
					{
						ir.printStackTrace();
					}
					
				}
				else {
					return "Chances are over and Couldn't complete the deletion";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Chances are over and Couldn't complete the deletion";
	}

	@Override
	public void update(Integer number,int count) 
	{
		Boolean state=false;
		Assembly yet=null;
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try
		{
			System.out.println("Trying to update assembly "+number);
			fis = new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			ArrayList<Assembly> hi=(ArrayList<Assembly>) ois.readObject();
			fis.close();
			ois.close();
			for(Assembly tmp:hi)
			{
				//hai+=tmp;
				//System.out.println(tmp);
				if(tmp.getAssembyNumber().equals(number))
				{
					state=true;
					yet=tmp;break;
				}
			}
			if(state)
			{
				int index=hi.indexOf(yet);
				System.out.println("Tell us what you wish to update in the "+yet.getAssemblyName());
				String aspect=scanner.next();// population
				switch(aspect)
				{
				case "population":
					System.out.println("Tell us new population value in the "+yet.getAssemblyName());
					Integer newone=scanner.nextInt();
					yet.setAssemblyPopulation(newone);
					//System.out.println(yet.getAssemblyName()+" has updated the "+aspect);
					break;
				case "contact":
					System.out.println("Tell us new contact number for the "+yet.getAssemblyName());
					Long mobile=scanner.nextLong();
					yet.setAssemblyContact(mobile);
					//System.out.println(yet.getAssemblyName()+" has updated the "+aspect);
					break;
				}
				hi.set(index, yet);
				
				FileOutputStream fos;
				ObjectOutputStream oos;
				try
				{
					fos=new FileOutputStream(file);
					oos=new ObjectOutputStream(fos);
					oos.writeObject(hi);
					fos.close();
					oos.close();
					System.out.println(yet.getAssemblyName()+" has updated the "+aspect);
				}
				catch(IOException ir)
				{
					ir.printStackTrace();
				}
				
			}
			else {
				throw new AssemblyException();
			}
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
		catch(ClassNotFoundException cne) {cne.printStackTrace();}
		catch(AssemblyException obj)
		{
			System.out.println(obj+"\nNumber is not valid");
			int no=scanner.nextInt();
			count++;
			if(count<3)
				update(no,count);
			else
				System.out.println("Chances are over and Couldn't complete the updation");
		}
	}
}