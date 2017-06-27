package my.crm.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comp_name", unique = true, nullable = false)
    private String companyName;

    @Column(name = "comp_address")
    private String companyAddress;

    @Column(name = "comp_website")
    private String companyWebsite;

    @Column(name = "comp_phone_number")
    private String companyPhoneNumber;

    @Column(name = "comp_email")
    private String companyEmail;

    @Column(name = "contact_type")
    private String contactType;

    @OneToMany(mappedBy = "companies", fetch = FetchType.LAZY)
    private List<ContactPerson> contactPersons = new ArrayList<>();


    public Company() {

    }

    public Company(String companyName, String companyAddress, String companyWebsite, String companyPhoneNumber, String companyEmail, String contactType) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyWebsite = companyWebsite;
        this.companyPhoneNumber = companyPhoneNumber;
        this.companyEmail = companyEmail;
        this.contactType = contactType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public List<ContactPerson> getContactPersons() {
        return contactPersons;
    }

    public void setContactPersons(List<ContactPerson> contactPersons) {
        this.contactPersons = contactPersons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company companies = (Company) o;

        if (id != companies.id) return false;
        if (companyName != null ? !companyName.equals(companies.companyName) : companies.companyName != null)
            return false;
        if (companyAddress != null ? !companyAddress.equals(companies.companyAddress) : companies.companyAddress != null)
            return false;
        if (companyWebsite != null ? !companyWebsite.equals(companies.companyWebsite) : companies.companyWebsite != null)
            return false;
        if (companyPhoneNumber != null ? !companyPhoneNumber.equals(companies.companyPhoneNumber) : companies.companyPhoneNumber != null)
            return false;
        if (companyEmail != null ? !companyEmail.equals(companies.companyEmail) : companies.companyEmail != null)
            return false;
        if (contactType != null ? !contactType.equals(companies.contactType) : companies.contactType != null)
            return false;
        return contactPersons != null ? contactPersons.equals(companies.contactPersons) : companies.contactPersons == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (companyAddress != null ? companyAddress.hashCode() : 0);
        result = 31 * result + (companyWebsite != null ? companyWebsite.hashCode() : 0);
        result = 31 * result + (companyPhoneNumber != null ? companyPhoneNumber.hashCode() : 0);
        result = 31 * result + (companyEmail != null ? companyEmail.hashCode() : 0);
        result = 31 * result + (contactType != null ? contactType.hashCode() : 0);
        result = 31 * result + (contactPersons != null ? contactPersons.hashCode() : 0);
        return result;
    }
}
