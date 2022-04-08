package business;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable {
    private String firstName;
    private String lastName;
    private String phone;
    private Address address;
    private String memberId;
    private Role role;
    private String password;

    public LibraryMember(String firstName, String lastName, String phone, 
            String memberId, String password, Role role, Address address) {
        super(firstName, lastName, phone, address);
        this.memberId = memberId;
        this.role = role;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getMemberId() {
        return memberId;
    }

    public Role getRole() {
        return role;
    }

    // public void setMemberId(String memberId) {
    //     this.memberId = memberId;
    // }
    
}
