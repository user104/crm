package my.crm.model;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Companies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comp_name")
    private String comp_name;

    @Column(name = "comp_address")
    private String comp_address;

    @Column(name = "comp_website")
    private String comp_website;

    @Column(name = "comp_phone_number")
    private String comp_phone_number;

    @Column(name = "comp_email")
    private String comp_email;

    @Column(name = "contact_type")
    private String contact_type;

    public Companies() {

    }

    public Companies(String comp_name, String comp_address, String comp_website, String comp_phone_number, String comp_email, String contact_type) {
        this.comp_name = comp_name;
        this.comp_address = comp_address;
        this.comp_website = comp_website;
        this.comp_phone_number = comp_phone_number;
        this.comp_email = comp_email;
        this.contact_type = contact_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getComp_address() {
        return comp_address;
    }

    public void setComp_address(String comp_address) {
        this.comp_address = comp_address;
    }

    public String getComp_website() {
        return comp_website;
    }

    public void setComp_website(String comp_website) {
        this.comp_website = comp_website;
    }

    public String getComp_phone_number() {
        return comp_phone_number;
    }

    public void setComp_phone_number(String comp_phone_number) {
        this.comp_phone_number = comp_phone_number;
    }

    public String getComp_email() {
        return comp_email;
    }

    public void setComp_email(String comp_email) {
        this.comp_email = comp_email;
    }

    public String getContact_type() {
        return contact_type;
    }

    public void setContact_type(String contact_type) {
        this.contact_type = contact_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Companies companies = (Companies) o;

        if (id != companies.id) return false;
        if (comp_name != null ? !comp_name.equals(companies.comp_name) : companies.comp_name != null) return false;
        if (comp_address != null ? !comp_address.equals(companies.comp_address) : companies.comp_address != null)
            return false;
        if (comp_website != null ? !comp_website.equals(companies.comp_website) : companies.comp_website != null)
            return false;
        if (comp_phone_number != null ? !comp_phone_number.equals(companies.comp_phone_number) : companies.comp_phone_number != null)
            return false;
        if (comp_email != null ? !comp_email.equals(companies.comp_email) : companies.comp_email != null) return false;
        return contact_type != null ? contact_type.equals(companies.contact_type) : companies.contact_type == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (comp_name != null ? comp_name.hashCode() : 0);
        result = 31 * result + (comp_address != null ? comp_address.hashCode() : 0);
        result = 31 * result + (comp_website != null ? comp_website.hashCode() : 0);
        result = 31 * result + (comp_phone_number != null ? comp_phone_number.hashCode() : 0);
        result = 31 * result + (comp_email != null ? comp_email.hashCode() : 0);
        result = 31 * result + (contact_type != null ? contact_type.hashCode() : 0);
        return result;
    }
}
