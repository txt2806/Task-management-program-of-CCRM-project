/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author thanh
 */
public class TaskResponseDTO {

    private int id;
    private String requirementName;
    private String taskTypeName;
    private String date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;

    //constructor khong tham so
    public TaskResponseDTO() {
    }

    //constructor co tham so
    public TaskResponseDTO(int id, String requirementName, String taskTypeName,
            String date, double planFrom, double planTo,
            String assignee, String reviewer) {
        this.id = id;
        this.requirementName = requirementName;
        this.taskTypeName = taskTypeName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    //getter & setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    //in ra thong tin
    @Override
    public String toString() {
        return String.format("%-5d %-20s %-10s %-12s %-7.1f %-7.1f %-12s %-12s",
                id, requirementName, taskTypeName, date, planFrom, planTo, assignee, reviewer);
    }
}
