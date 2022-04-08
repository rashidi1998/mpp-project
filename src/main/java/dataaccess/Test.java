package dataaccess;

public class Test {
    public static void main(String[] args) {
        var data = DataAccessorFacade.getInstance().getCheckoutRecord("admin1");
        System.out.println(data);
    }
}
