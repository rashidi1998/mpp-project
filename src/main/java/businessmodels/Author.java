package businessmodels;

import models.AuthorModel;

import java.io.Serializable;

public class Author extends Person implements Serializable {
    private String bio;

    public Author(String firstName, String lastName, String phone, String bio, Address address) {
        super(firstName, lastName, phone, address);
        this.bio = bio;
    }

    public Author(AuthorModel author){
        // TODO: Validate DAO data
        this.setFirstName(author.firstName());
        this.setLastName(author.lastName());
        this.setPhone(author.phone());
        this.bio = author.bio();
        this.setAddress(new Address(author.street(), author.city(), author.state(), author.zip()));
    }
}
