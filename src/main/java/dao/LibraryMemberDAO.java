package dao;

import business.Role;

public record LibraryMemberDAO(
    String firstName, String lastName, String phone, 
    String memberId, String password, Role role, String street,
    String city, String state, String zip
) {}