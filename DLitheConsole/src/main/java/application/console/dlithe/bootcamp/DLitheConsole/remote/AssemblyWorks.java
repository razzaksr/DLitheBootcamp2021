package application.console.dlithe.bootcamp.DLitheConsole.remote;

import application.console.dlithe.bootcamp.DLitheConsole.model.Assembly;

public interface AssemblyWorks 
{
	public void createNewRecord(Assembly object);
	public String toString();
	public Assembly readOne(Integer number);
	public String delete(Integer number);
	public void update(Integer number);
}
