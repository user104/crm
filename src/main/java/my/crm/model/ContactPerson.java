package my.crm.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contact_person")
public class ContactPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cont_name")
    private String conactName;

    @Column(name = "cont_position")
    private String conactPosition;

    @Column(name = "cont_phone_number")
    private String conactPhoneNumber;

    @Column(name = "cont_email")
    private String conactEmail;

    @Column(name = "contact_type")
    private String conactType;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Companies companies;

    @OneToMany(mappedBy = "contactPerson", fetch = FetchType.EAGER)
    private List<Dealings> dealings = new ArrayList<>();

    public ContactPerson(){

    }

    public ContactPerson(String conactName, String conactPosition, String conactPhoneNumber, String conactEmail, String conactType, Companies companies, List<Dealings> dealings) {
        this.conactName = conactName;
        this.conactPosition = conactPosition;
        this.conactPhoneNumber = conactPhoneNumber;
        this.conactEmail = conactEmail;
        this.conactType = conactType;
        this.companies = companies;
        this.dealings = dealings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConactName() {
        return conactName;
    }

    public void setConactName(String conactName) {
        this.conactName = conactName;
    }

    public String getConactPosition() {
        return conactPosition;
    }

    public void setConactPosition(String conactPosition) {
        this.conactPosition = conactPosition;
    }

    public String getConactPhoneNumber() {
        return conactPhoneNumber;
    }

    public void setConactPhoneNumber(String conactPhoneNumber) {
        this.conactPhoneNumber = conactPhoneNumber;
    }

    public String getConactEmail() {
        return conactEmail;
    }

    public void setConactEmail(String conactEmail) {
        this.conactEmail = conactEmail;
    }

    public String getConactType() {
        return conactType;
    }

    public void setConactType(String conactType) {
        this.conactType = conactType;
    }

    public Companies getCompanies() {
        return companies;
    }

    public void setCompanies(Companies companies) {
        this.companies = companies;
    }

    public List<Dealings> getDealings() {
        return dealings;
    }

    public void setDealings(List<Dealings> dealings) {
        this.dealings = dealings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactPerson that = (ContactPerson) o;

        if (id != that.id) return false;
        if (conactName != null ? !conactName.equals(that.conactName) : that.conactName != null) return false;
        if (conactPosition != null ? !conactPosition.equals(that.conactPosition) : that.conactPosition != null)
            return false;
        if (conactPhoneNumber != null ? !conactPhoneNumber.equals(that.conactPhoneNumber) : that.conactPhoneNumber != null)
            return false;
        if (conactEmail != null ? !conactEmail.equals(that.conactEmail) : that.conactEmail != null) return false;
        if (conactType != null ? !conactType.equals(that.conactType) : that.conactType != null) return false;
        if (companies != null ? !companies.equals(that.companies) : that.companies != null) return false;
        return dealings != null ? dealings.equals(that.dealings) : that.dealings == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (conactName != null ? conactName.hashCode() : 0);
        result = 31 * result + (conactPosition != null ? conactPosition.hashCode() : 0);
        result = 31 * result + (conactPhoneNumber != null ? conactPhoneNumber.hashCode() : 0);
        result = 31 * result + (conactEmail != null ? conactEmail.hashCode() : 0);
        result = 31 * result + (conactType != null ? conactType.hashCode() : 0);
        result = 31 * result + (companies != null ? companies.hashCode() : 0);
        result = 31 * result + (dealings != null ? dealings.hashCode() : 0);
        return result;
    }
}
