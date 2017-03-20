package my.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_person")
public class ContactPerson {

    @Id
    @Column(name = "cont_name")
    private String cont_name;

    @Column(name = "comp_name")
    private String comp_name;

    @Column(name = "cont_position")
    private String cont_position;

    @Column(name = "cont_phone_number")
    private String cont_phone_number;

    @Column(name = "cont_email")
    private String cont_email;

    @Column(name = "contact_type")
    private String contact_type;

    public ContactPerson(){

    }

    public ContactPerson(String cont_name, String comp_name, String cont_position, String cont_phone_number, String cont_email, String contact_type) {
        this.cont_name = cont_name;
        this.comp_name = comp_name;
        this.cont_position = cont_position;
        this.cont_phone_number = cont_phone_number;
        this.cont_email = cont_email;
        this.contact_type = contact_type;
    }

    public String getCont_name() {
        return cont_name;
    }

    public void setCont_name(String cont_name) {
        this.cont_name = cont_name;
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getCont_position() {
        return cont_position;
    }

    public void setCont_position(String cont_position) {
        this.cont_position = cont_position;
    }

    public String getCont_phone_number() {
        return cont_phone_number;
    }

    public void setCont_phone_number(String cont_phone_number) {
        this.cont_phone_number = cont_phone_number;
    }

    public String getCont_email() {
        return cont_email;
    }

    public void setCont_email(String cont_email) {
        this.cont_email = cont_email;
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

        ContactPerson person = (ContactPerson) o;

        if (cont_name != null ? !cont_name.equals(person.cont_name) : person.cont_name != null) return false;
        if (comp_name != null ? !comp_name.equals(person.comp_name) : person.comp_name != null) return false;
        if (cont_position != null ? !cont_position.equals(person.cont_position) : person.cont_position != null)
            return false;
        if (cont_phone_number != null ? !cont_phone_number.equals(person.cont_phone_number) : person.cont_phone_number != null)
            return false;
        if (cont_email != null ? !cont_email.equals(person.cont_email) : person.cont_email != null) return false;
        return contact_type != null ? contact_type.equals(person.contact_type) : person.contact_type == null;

    }

    @Override
    public int hashCode() {
        int result = cont_name != null ? cont_name.hashCode() : 0;
        result = 31 * result + (comp_name != null ? comp_name.hashCode() : 0);
        result = 31 * result + (cont_position != null ? cont_position.hashCode() : 0);
        result = 31 * result + (cont_phone_number != null ? cont_phone_number.hashCode() : 0);
        result = 31 * result + (cont_email != null ? cont_email.hashCode() : 0);
        result = 31 * result + (contact_type != null ? contact_type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactPerson{" +
                "cont_name='" + cont_name + '\'' +
                ", comp_name='" + comp_name + '\'' +
                ", cont_position='" + cont_position + '\'' +
                ", cont_phone_number='" + cont_phone_number + '\'' +
                ", cont_email='" + cont_email + '\'' +
                ", contact_type='" + contact_type + '\'' +
                '}';
    }
}
