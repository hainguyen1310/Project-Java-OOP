package Model;

public class Task {
    private int id;
    private String taskTypeId;
    private String requireName;
    private String date;
    private String planFrom;
    private String planTo;
    private String assign;
    private String reviewer;

    public Task() {
    }

    public Task(int id, String taskTypeId, String requireName, String date, String planFrom, String planTo, String assign, String reviewer) {
        this.id = id;
        this.taskTypeId = taskTypeId;
        this.requireName = requireName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getRequireName() {
        return requireName;
    }

    public void setRequireName(String requireName) {
        this.requireName = requireName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(String planFrom) {
        this.planFrom = planFrom;
    }

    public String getPlanTo() {
        return planTo;
    }

    public void setPlanTo(String planTo) {
        this.planTo = planTo;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
}
