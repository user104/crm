package my.crm.model;

import javax.persistence.*;

@Entity
@Table(name = "dealings")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "task_name")
    private String task_name;

    @Column(name = "comp_name")
    private String comp_name;

    @Column(name = "cont_name")
    private String cont_name;

    @Column(name = "deadline")
    private String deadline;

    @Column(name = "task_status")
    private String task_status;

    @Column(name = "deal_id")
    private int deal_id;

    public Tasks(){

    }

    public Tasks(String task_name, String comp_name, String cont_name, String deadline, String task_status, int deal_id) {
        this.task_name = task_name;
        this.comp_name = comp_name;
        this.cont_name = cont_name;
        this.deadline = deadline;
        this.task_status = task_status;
        this.deal_id = deal_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getCont_name() {
        return cont_name;
    }

    public void setCont_name(String cont_name) {
        this.cont_name = cont_name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }

    public int getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tasks tasks = (Tasks) o;

        if (id != tasks.id) return false;
        if (deal_id != tasks.deal_id) return false;
        if (task_name != null ? !task_name.equals(tasks.task_name) : tasks.task_name != null) return false;
        if (comp_name != null ? !comp_name.equals(tasks.comp_name) : tasks.comp_name != null) return false;
        if (cont_name != null ? !cont_name.equals(tasks.cont_name) : tasks.cont_name != null) return false;
        if (deadline != null ? !deadline.equals(tasks.deadline) : tasks.deadline != null) return false;
        return task_status != null ? task_status.equals(tasks.task_status) : tasks.task_status == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (task_name != null ? task_name.hashCode() : 0);
        result = 31 * result + (comp_name != null ? comp_name.hashCode() : 0);
        result = 31 * result + (cont_name != null ? cont_name.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (task_status != null ? task_status.hashCode() : 0);
        result = 31 * result + deal_id;
        return result;
    }
}
