package controller;

public class Validator {

    public static boolean isInteger(String str) {
	try {
            int int_rep = Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean notNull(Object obj) {
        return obj != null;
    }
    
    
	
}
