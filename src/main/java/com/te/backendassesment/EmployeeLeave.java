package com.te.backendassesment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmployeeLeave {
	@Id
	int Employee_ID;
	@Column(name = "LeaveDate", length=50)
	String LeaveDate;
	@Column(name = "LeaveStatus", length=50)
	String LeaveStatus;

}
