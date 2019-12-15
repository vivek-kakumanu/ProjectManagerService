package com.taskmanagement.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name ="task_table")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_Id")
	private Long taskId;
		
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="parent_Id")
	private ParentTask parentTask;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="project_Id")
	private Project project;
	
	@Column(name = "task_Name")
	private String taskName;
	
	@Column(name = "priority")
	private int priority;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="YYYY-MM-dd")
	private Date startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	@Column(name="task_Status")
	private boolean endTaskStatus;
	
	
	@OneToOne(mappedBy = "task")
    private User user;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public ParentTask getParentTask() {
		return parentTask;
	}

	public void setParentTask(ParentTask parentId) {
		this.parentTask = parentId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isEndTaskStatus() {
		return endTaskStatus;
	}

	public void setEndTaskStatus(boolean endTaskStatus) {
		this.endTaskStatus = endTaskStatus;
	}

	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Task(ParentTask parentTask, Project project, String taskName, int priority, Date startDate,
			Date endDate, boolean endTaskStatus) {
		super();
		this.parentTask = parentTask;
		this.project = project;
		this.taskName = taskName;
		this.priority = priority;
		this.startDate = startDate;
		this.endDate = endDate;
		this.endTaskStatus = endTaskStatus;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
