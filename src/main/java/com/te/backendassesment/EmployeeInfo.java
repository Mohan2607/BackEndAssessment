package com.te.backendassesment;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeeInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int EmployeeId;
	@Column(name = "EmployeeName", length=50)
	private String EmployeeName;
	@Column(name = "EmployeeType", length=50)
	private String EmployeeType;
	@Column(name = "Email", length=100)
	private String Email;
	@Column(name = "Password", length=50)
	private String Password;
	@OneToMany
	List<EmployeeLeave>employeeLeave;

}
