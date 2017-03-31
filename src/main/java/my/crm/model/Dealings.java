package my.crm.model;

import javax.persistence.*;

@Entity
@Table(name = "dealings")
public class Dealings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deal_id")
    private int id;

    @Column(name = "deal_name")
    private String deal_name;

    @Column(name = "comp_name")
    private String comp_name;

    @Column(name = "cont_name")
    private String cont_name;

    @Column(name = "deal_budget")
    private String deal_budget;

    @Column(name = "deal_status")
    private String deal_status;

    @Column(name = "deal_stage")
    private String deal_stage;

    public Dealings() {

    }

    public Dealings(String deal_name, String comp_name, String cont_name, String deal_budget, String deal_status, String deal_stage) {
        this.deal_name = deal_name;
        this.comp_name = comp_name;
        this.cont_name = cont_name;
        this.deal_budget = deal_budget;
        this.deal_status = deal_status;
        this.deal_stage = deal_stage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeal_name() {
        return deal_name;
    }

    public void setDeal_name(String deal_name) {
        this.deal_name = deal_name;
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

    public String getDeal_budget() {
        return deal_budget;
    }

    public void setDeal_budget(String deal_budget) {
        this.deal_budget = deal_budget;
    }

    public String getDeal_status() {
        return deal_status;
    }

    public void setDeal_status(String deal_status) {
        this.deal_status = deal_status;
    }

    public String getDeal_stage() {
        return deal_stage;
    }

    public void setDeal_stage(String deal_stage) {
        this.deal_stage = deal_stage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dealings dealings = (Dealings) o;

        if (id != dealings.id) return false;
        if (deal_name != null ? !deal_name.equals(dealings.deal_name) : dealings.deal_name != null) return false;
        if (comp_name != null ? !comp_name.equals(dealings.comp_name) : dealings.comp_name != null) return false;
        if (cont_name != null ? !cont_name.equals(dealings.cont_name) : dealings.cont_name != null) return false;
        if (deal_budget != null ? !deal_budget.equals(dealings.deal_budget) : dealings.deal_budget != null)
            return false;
        if (deal_status != null ? !deal_status.equals(dealings.deal_status) : dealings.deal_status != null)
            return false;
        return deal_stage != null ? deal_stage.equals(dealings.deal_stage) : dealings.deal_stage == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (deal_name != null ? deal_name.hashCode() : 0);
        result = 31 * result + (comp_name != null ? comp_name.hashCode() : 0);
        result = 31 * result + (cont_name != null ? cont_name.hashCode() : 0);
        result = 31 * result + (deal_budget != null ? deal_budget.hashCode() : 0);
        result = 31 * result + (deal_status != null ? deal_status.hashCode() : 0);
        result = 31 * result + (deal_stage != null ? deal_stage.hashCode() : 0);
        return result;
    }
}
