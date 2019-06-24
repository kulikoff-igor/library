package bytechs.testTask.library.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    private int id;
    private String role;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}