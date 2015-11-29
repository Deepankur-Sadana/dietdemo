package models;


public class DietPlanEntity {
    private String type;
    private String time;
    int id;
    Boolean ischecked;

    public DietPlanEntity(int id,String type, String time,  Boolean ischecked) {
        this.type = type;
        this.time = time;
        this.id = id;
        this.ischecked = ischecked;
    }

    public Boolean getIschecked() {
        return ischecked;
    }

    public void setIschecked(Boolean ischecked) {
        this.ischecked = ischecked;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}