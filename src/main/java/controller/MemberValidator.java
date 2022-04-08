package controller;

import Validators.ValidatorFactory;
import validators.Validator;
import ui.AddNewMember;
import dao.LibraryMemberDAO;
import exceptions.InvalidFieldException;


public class MemberValidator {
    private MemberValidator(){}
    
    public static void validateInput(LibraryMemberDAO newMember) throws Exception{
        try {
            ValidatorFactory.checkNotEmptyOrNull(newMember);
        } catch(Exception e) {
            throw e;
        }
        
    }
}
