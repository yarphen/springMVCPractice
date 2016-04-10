package com.sheremet.spring.MVCPractice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="students")
@NamedQueries({
	@NamedQuery(name = Student.getAllStudents, query = "SELECT student FROM Student student"),
	@NamedQuery(name =Student.getStudentByPib, query = "SELECT student FROM Student student WHERE student.pib = :pib"),
	@NamedQuery(name =Student.getStudentsByCourse, query = "SELECT student FROM Student student WHERE student.course = :course")
})
public class Student implements Serializable{
	public static final String getAllStudents = "Student.getAllStudents";
	public static final String getStudentByPib = "Student.getStudentByPib";
	public static final String getStudentsByCourse = "Student.getStudentsByCourse";
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int studentId;

	private String pib;
	private int course;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getPib() {
		return pib;
	}
	public void setPib(String pib) {
		this.pib = pib;
	}
	public int getCourse() {
		return course;
	}
	public void setCourse(int course) {
		this.course = course;
	}
	@Override
	public int hashCode() {
		final int prime = 347;
		int result = 1;
		result = prime * result + course;
		result = prime * result + ((pib == null) ? 0 : pib.hashCode());
		result = prime * result + studentId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (course != other.course)
			return false;
		if (pib == null) {
			if (other.pib != null)
				return false;
		} else if (!pib.equals(other.pib))
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}
}
