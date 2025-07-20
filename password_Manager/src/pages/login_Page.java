package pages;

import java.awt.event.ActionListener;

import constants.constants.CUSTOM_STRING;

public class login_Page extends main_Login_Page { // Class extends the main_Login_Page class to create the actual login page with updated button text.

    public login_Page(ActionListener navigate_Page_Passwords, ActionListener navigate_Page_New_User) {
        super(navigate_Page_Passwords, navigate_Page_New_User);
    }

    @Override
    protected void set_Left_Button_Text() { // Updates the left (login) button.
        left_Button_Text = CUSTOM_STRING.MAIN_LOGIN_PAGE.LOGIN_PAGE.LOGIN_PAGE_BUTTON;
    }
    
    @Override
    protected void set_Right_Button_Text() { // Updates the right (new user) button.
        right_Button_Text = CUSTOM_STRING.MAIN_LOGIN_PAGE.LOGIN_PAGE.CREATE_NEW_USER_BUTTON;
    }
    
}
    
    

