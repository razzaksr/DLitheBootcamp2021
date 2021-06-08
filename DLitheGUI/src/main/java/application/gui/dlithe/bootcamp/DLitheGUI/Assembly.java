package application.gui.dlithe.bootcamp.DLitheGUI;

import java.io.Serializable;
import java.util.Arrays;
// business class/ Model class/ Entity
public class Assembly implements Comparable<Assembly>, Serializable
{
	private Integer assembyNumber, assemblyPopulation;
	private String assemblyName, assemblyMemberName;
	private String assemblyIssues;
	private Long assemblyContact;
	@Override
	public int compareTo(Assembly o) 
	{
		return this.assembyNumber.compareTo(o.assembyNumber);
	}
	public Assembly() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Assembly(Integer assembyNumber, Integer assemblyPopulation, String assemblyName, String assemblyMemberName,
			String assemblyIssues, Long assemblyContact) {
		super();
		this.assembyNumber = assembyNumber;
		this.assemblyPopulation = assemblyPopulation;
		this.assemblyName = assemblyName;
		this.assemblyMemberName = assemblyMemberName;
		this.assemblyIssues = assemblyIssues;
		this.assemblyContact = assemblyContact;
	}

	@Override
	public String toString() {
		return "Assembly [assembyNumber=" + assembyNumber + ", assemblyPopulation=" + assemblyPopulation
				+ ", assemblyName=" + assemblyName + ", assemblyMemberName=" + assemblyMemberName + ", assemblyIssues="
				+ assemblyIssues + ", assemblyContact=" + assemblyContact + "]\n";
	}
	
	public Integer getAssembyNumber() {
		return assembyNumber;
	}
	public void setAssembyNumber(Integer assembyNumber) {
		this.assembyNumber = assembyNumber;
	}
	public Integer getAssemblyPopulation() {
		return assemblyPopulation;
	}
	public void setAssemblyPopulation(Integer assemblyPopulation) {
		this.assemblyPopulation = assemblyPopulation;
	}
	public String getAssemblyName() {
		return assemblyName;
	}
	public void setAssemblyName(String assemblyName) {
		this.assemblyName = assemblyName;
	}
	public String getAssemblyMemberName() {
		return assemblyMemberName;
	}
	public void setAssemblyMemberName(String assemblyMemberName) {
		this.assemblyMemberName = assemblyMemberName;
	}
	public String getAssemblyIssues() {
		return assemblyIssues;
	}
	public void setAssemblyIssues(String assemblyIssues) {
		this.assemblyIssues = assemblyIssues;
	}
	public Long getAssemblyContact() {
		return assemblyContact;
	}
	public void setAssemblyContact(Long assemblyContact) {
		this.assemblyContact = assemblyContact;
	}
}
