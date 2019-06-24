package bytechs.testTask.library.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "UserDescription")
public class UserDescription {
    private int userDescriptionId;
    private String name;
    private String lastName;
    private String address;

    public UserDescription(int userDescriptionId, String name, String lastName, String address) {
        this.userDescriptionId = userDescriptionId;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
    }

    public UserDescription() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userDescriptionId", nullable = false)
    public int getUserDescriptionId() {
        return userDescriptionId;
    }

    public void setUserDescriptionId(int userDescriptionId) {
        this.userDescriptionId = userDescriptionId;
    }

    @Column(name = "name", nullable = false, length = 250)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "lastName", nullable = false, length = 250)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "address", nullable = false, length = 250)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
