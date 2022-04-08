package controller;

import java.util.*;


import business.Address;
import business.LibraryMember;
import business.Role;
import dataaccess.DataAccessFacade;
import ui.AddNewMember;
import exceptions.AlreadyExistsException;
import dao.LibraryMemberDAO;


public class MemberController {
    private static MemberController instance = new MemberController();
    
    private MemberController() {};

    public static MemberController getInstance() {
        return instance;
    }

    public void addMember(LibraryMemberDAO newMember, AddNewMember component) throws Exception{
        MemberValidator.validateInput(newMember);

        Address address = new Address(
            newMember.street(), newMember.city(), newMember.state(), newMember.zip()
        );
        
        DataAccessFacade db = DataAccessFacade.getInstance();
    
        if(db.memberExists(newMember.memberId()))  {
            throw new AlreadyExistsException("Member with the [MemberID: " + newMember.memberId() + "] already exists.");
        } else {
            LibraryMember member = new LibraryMember(
                newMember.firstName(), newMember.lastName(), newMember.phone(), 
                newMember.memberId(), newMember.password(), newMember.role(), 
                address);

            db.saveNewMember(member);
        }

    }


    public List<LibraryMember> getLibraryMemberList() {
        return DataAccessFacade.getInstance().getLibraryMemberList();
    }
}
