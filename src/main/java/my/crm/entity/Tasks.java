package my.crm.entity;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "deadline")
    private String deadline;

    @Column(name = "task_status")
    private String taskStatus;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Dealings dealings;

    public Tasks(){

    }

    public Tasks(String taskName, String deadline, String taskStatus, Dealings dealings) {
        this.taskName = taskName;
        this.deadline = deadline;
        this.taskStatus = taskStatus;
        this.dealings = dealings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Dealings getDealings() {
        return dealings;
    }

    public void setDealings(Dealings dealings) {
        this.dealings = dealings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tasks tasks = (Tasks) o;

        if (id != tasks.id) return false;
        if (taskName != null ? !taskName.equals(tasks.taskName) : tasks.taskName != null) return false;
        if (deadline != null ? !deadline.equals(tasks.deadline) : tasks.deadline != null) return false;
        if (taskStatus != null ? !taskStatus.equals(tasks.taskStatus) : tasks.taskStatus != null) return false;
        return dealings != null ? dealings.equals(tasks.dealings) : tasks.dealings == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (taskStatus != null ? taskStatus.hashCode() : 0);
        result = 31 * result + (dealings != null ? dealings.hashCode() : 0);
        return result;
    }
}
