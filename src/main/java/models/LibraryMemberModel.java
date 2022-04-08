package models;

import businessmodels.Role;

public record LibraryMemberModel(
    String firstName, String lastName, String phone, 
    String memberId, String password, Role role, String street,
    String city, String state, String zip
) {}