package application.console.dlithe.bootcamp.DLitheConsole.remote;

import application.console.dlithe.bootcamp.DLitheConsole.model.Assembly;

public interface AssemblyWorks 
{
	public void createNewRecord(Assembly object);
	public String toString();
	public Assembly readOne(Integer number);
	public Assembly readOne(String name);
	public String readOne(Integer population, String Issue);
	public String delete(Integer number);
	public void update(Integer number);
}
