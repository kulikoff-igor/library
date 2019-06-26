package bytechs.testTask.library.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    private int roleId;
    private String role;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}