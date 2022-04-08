package controller;

public class RuleSetFactory {

    public static boolean isInteger(String str)
	{
		try {
            int int_rep = Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
	}

    public static void fixedLength(String str) {
        
    }
    
}
