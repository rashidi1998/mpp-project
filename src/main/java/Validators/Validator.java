package validators;

import exceptions.InvalidFieldException;

public interface Validator<T> {
    boolean validate(T t);
}
