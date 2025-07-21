package classes;
public class password_Info {
    private String website_App;
    private String username;
    private String password;

    public password_Info(){
        new password_Info("","","");
    }

    public password_Info(String website_App_Title, String username, String password){
        this.website_App = website_App_Title;
        this.username = username;
        this.password = password;
    }

    public String get_Website(){
        return this.website_App;
    }
    public String get_Username(){
        return this.username;
    }
    public String get_Password(){
        return this.password;
    }

    public void set_Website(String website_App){
        this.website_App = website_App;
    }
    public void set_Username(String username){
        this.username = username;
    }
    public void set_Password(String password){
        this.password = password;
    }
}
