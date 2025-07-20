package pages;

import java.awt.event.ActionListener;

import constants.constants.CUSTOM_STRING;


public class new_User_Login_Page extends main_Login_Page { // Class extends the main_Login_Page class to create the new user page with updated button text.


    public new_User_Login_Page(ActionListener navigate_Page_Passwords, ActionListener navigate_Page_Cancel_New_User){
        super(navigate_Page_Passwords, navigate_Page_Cancel_New_User);
    }

    @Override
    protected void set_Left_Button_Text() { // Updates the left (add user) button.
        left_Button_Text = CUSTOM_STRING.MAIN_LOGIN_PAGE.NEW_USER_PAGE.ADD_NEW_USER_BUTTON;
    }
    
    @Override
    protected void set_Right_Button_Text() { // Updates the right (cancel) button.
        right_Button_Text = CUSTOM_STRING.MAIN_LOGIN_PAGE.NEW_USER_PAGE.CANCEL_BUTTON;
    }
    

}
