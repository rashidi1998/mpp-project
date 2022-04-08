package controller;

import Validators.ValidatorFactory;
import models.LibraryMemberModel;


public class MemberValidator {
    private MemberValidator(){}
    
    public static void validateInput(LibraryMemberModel newMember) throws Exception{
        try {
            ValidatorFactory.checkNotEmptyOrNull(newMember);
        } catch(Exception e) {
            throw e;
        }
        
    }
}
