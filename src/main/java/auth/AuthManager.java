package auth;

import businessmodels.LibraryMember;
import businessmodels.Role;
import dataaccess.DataAccessorFacade;
import exceptions.UserNotFoundException;

public enum AuthManager {
    INSTANCE;

    private LibraryMember session = null;

    /**
     * Get authenticated User
     * @return LibraryMember instance
     */
    public LibraryMember getUser(){
        return session;
    }

    /**
     * Authenticate a user given LibraryMember ID
     * @param user UserDAO, containing userID and password
     * @throws UserNotFoundException If no user is found, UserNotFound exception is thrown
     */
    public void authenticateUser(UserModel user) throws UserNotFoundException{

        // TODO: Need to add input validation

        LibraryMember member = DataAccessorFacade.getInstance().getMember(user.username());
        if(member == null)
            throw new UserNotFoundException("Member ID: [" + user.username() + "] not found");

        if(!user.password().equals(member.getPassword()))
            throw new UserNotFoundException("Member Password is incorrect");

        this.session = member;
    }

    /**
     * Check if someone is authenticated
     * @return boolean
     */
    public boolean isAuth(){
        return session != null;
    }

    /**
     * CLear session
     */
    public void clearSession(){
        session = null;
    }

    /**
     * Check if authenticated user has specific role
     * @param role role to be compared
     * @return boolean
     */
    public boolean hasAccess(Role role){
        return getUser().getRole() == role;
    }

}
