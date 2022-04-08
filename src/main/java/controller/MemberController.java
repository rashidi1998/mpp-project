package controller;

import java.util.*;


import businessmodels.Address;
import businessmodels.LibraryMember;
import dataaccess.DataAccessorFacade;
import uimodels.AddNewMember;
import exceptions.AlreadyExistsException;
import models.LibraryMemberModel;


public class MemberController {
    private static MemberController instance = new MemberController();
    
    private MemberController() {};

    public static MemberController getInstance() {
        return instance;
    }

    public void addMember(LibraryMemberModel newMember, AddNewMember component) throws Exception{
        MemberValidator.validateInput(newMember);

        Address address = new Address(
            newMember.street(), newMember.city(), newMember.state(), newMember.zip()
        );
        
        DataAccessorFacade db = DataAccessorFacade.getInstance();
    
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
        return DataAccessorFacade.getInstance().getLibraryMemberList();
    }
}
