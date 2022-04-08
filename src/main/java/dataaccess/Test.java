package dataaccess;

import business.Address;
import business.LibraryMember;
import business.Role;

public class Test {
    public static void main(String[] args) {
        var data = DataAccessFacade.getInstance().getCheckoutRecord("admin1");
        System.out.println(data);
    }
}
