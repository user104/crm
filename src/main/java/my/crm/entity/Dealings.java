package my.crm.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dealings")
public class Dealings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "deal_name", nullable = false)
    private String dealName;

    @Column(name = "deal_budget")
    private String dealBudget;

    @Column(name = "deal_status")
    private String dealStatus;

    @Column(name = "deal_stage")
    private String dealStage;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private ContactPerson contactPerson;

    @OneToMany(mappedBy = "dealings", fetch = FetchType.LAZY)
    private List<Tasks> tasks = new ArrayList<>();

    public Dealings() {

    }

    public Dealings(String dealName, String dealBudget, String dealStatus, String dealStage, ContactPerson contactPerson, List<Tasks> tasks) {
        this.dealName = dealName;
        this.dealBudget = dealBudget;
        this.dealStatus = dealStatus;
        this.dealStage = dealStage;
        this.contactPerson = contactPerson;
        this.tasks = tasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public String getDealBudget() {
        return dealBudget;
    }

    public void setDealBudget(String dealBudget) {
        this.dealBudget = dealBudget;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getDealStage() {
        return dealStage;
    }

    public void setDealStage(String dealStage) {
        this.dealStage = dealStage;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dealings dealings = (Dealings) o;

        if (id != dealings.id) return false;
        if (dealName != null ? !dealName.equals(dealings.dealName) : dealings.dealName != null) return false;
        if (dealBudget != null ? !dealBudget.equals(dealings.dealBudget) : dealings.dealBudget != null) return false;
        if (dealStatus != null ? !dealStatus.equals(dealings.dealStatus) : dealings.dealStatus != null) return false;
        if (dealStage != null ? !dealStage.equals(dealings.dealStage) : dealings.dealStage != null) return false;
        if (contactPerson != null ? !contactPerson.equals(dealings.contactPerson) : dealings.contactPerson != null)
            return false;
        return tasks != null ? tasks.equals(dealings.tasks) : dealings.tasks == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dealName != null ? dealName.hashCode() : 0);
        result = 31 * result + (dealBudget != null ? dealBudget.hashCode() : 0);
        result = 31 * result + (dealStatus != null ? dealStatus.hashCode() : 0);
        result = 31 * result + (dealStage != null ? dealStage.hashCode() : 0);
        result = 31 * result + (contactPerson != null ? contactPerson.hashCode() : 0);
        result = 31 * result + (tasks != null ? tasks.hashCode() : 0);
        return result;
    }
}
