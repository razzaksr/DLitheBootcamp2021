package application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "candidates")
public class Students// students 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;
	private String studentName;
	private String studentOrg;
	@ManyToOne
	private Event event;
	private Long studentContact;
	private String studentEmail;
	@Nullable
	private Boolean studentCeriticate;
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Students(Integer studentId, String studentName, String studentOrg, Event event, Long studentContact,
			String studentEmail, Boolean studentCeriticate) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentOrg = studentOrg;
		this.event = event;
		this.studentContact = studentContact;
		this.studentEmail = studentEmail;
		this.studentCeriticate = studentCeriticate;
	}
	@Override
	public String toString() {
		return "Students [studentId=" + studentId + ", studentName=" + studentName + ", studentOrg=" + studentOrg
				+ ", event=" + event + ", studentContact=" + studentContact + ", studentEmail=" + studentEmail
				+ ", studentCeriticate=" + studentCeriticate + "]";
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentOrg() {
		return studentOrg;
	}
	public void setStudentOrg(String studentOrg) {
		this.studentOrg = studentOrg;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Long getStudentContact() {
		return studentContact;
	}
	public void setStudentContact(Long studentContact) {
		this.studentContact = studentContact;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public Boolean getStudentCeriticate() {
		return studentCeriticate;
	}
	public void setStudentCeriticate(Boolean studentCeriticate) {
		this.studentCeriticate = studentCeriticate;
	}
}
