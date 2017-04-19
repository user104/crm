package my.crm.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2540p on 13.04.2017.
 */
@Entity
@Table(name = "authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "role", unique = true, nullable = false)
    private String role;
    
    @ManyToMany(mappedBy = "authority", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<User> userList = new ArrayList<>();

    public Authority() {
    }

    public Authority(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authority authority = (Authority) o;

        if (id != authority.id) return false;
        if (role != null ? !role.equals(authority.role) : authority.role != null) return false;
        return userList != null ? userList.equals(authority.userList) : authority.userList == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (userList != null ? userList.hashCode() : 0);
        return result;
    }
}
