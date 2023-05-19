package co.mz.gposoft.katlhula.domain;

public class User {

    private long id;

    private String username;

    private Role roles;

    public boolean integratedAuthentication(){
        return false;
    }

    /*
     * then a set of business and other (CRUD) methods
     * */

}
