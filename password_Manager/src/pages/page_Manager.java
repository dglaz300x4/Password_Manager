package pages;

import java.awt.event.ActionListener;
import constants.constants.window_Page_Num;


public class page_Manager {
    private window_Page_Num current_Page;
    private ActionListener displayed_Page;

    private ActionListener login_Page(){
        return null;
    }

    private ActionListener create_User_Page(){
        return null;
    }

    private ActionListener saved_Passwords_Page(){
        return null;
    }
    
    public page_Manager(){
        current_Page = window_Page_Num.login;
        get_Page(window_Page_Num.login);
    }

    public window_Page_Num get_Current_Page(){
        return current_Page;
    }

    public ActionListener get_Page(window_Page_Num page){
        if (current_Page != page){
            current_Page = page;
            switch (page) {
                case window_Page_Num.login:
                    displayed_Page = login_Page();
                    break;

                case window_Page_Num.create_User:
                    displayed_Page = create_User_Page();
                    break;

                case window_Page_Num.saved_Passwords:
                    displayed_Page = saved_Passwords_Page();
                    break;
            
                default:
                    break;
            }
        }


        return displayed_Page;
    }
}

