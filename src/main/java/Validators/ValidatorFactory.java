package Validators;

import exceptions.InvalidFieldException;
import java.lang.reflect.RecordComponent;

public class ValidatorFactory {
    public static BookValidator getBookValidator(){
        return new BookValidator();
    }
    
    public static void checkNotEmptyOrNull(Object obj) throws Exception {
        RecordComponent[] rc = obj.getClass().getRecordComponents();
        for(RecordComponent f : rc){   
            try {
                Object val = f.getAccessor().invoke(obj); 
                if(val == null || (val instanceof String && ((String)val).isEmpty())) throw new InvalidFieldException("All fields are required");
                System.out.println(val);
                
            } catch(IllegalAccessException e) {
                throw new Exception("An error occured, please try again");
            } catch(Exception e) {
                throw e;
            }
        }
    }
    
}
