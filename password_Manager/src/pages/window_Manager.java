package pages;
/*
 * This class holds the pages and page navigation to be displayed.
 * - Jordan
 */

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constants.constants;
import constants.constants.*;
import widgets.window_Render;

public class window_Manager{

// Variables
    private static int window_Height; // Set dimentions of the window.
    private static int window_Width;

    private static WINDOW_PAGE_NUM current_Page; 

    private window_Render window = new window_Render(); // Window to be created.
    private CardLayout window_Layout;
    private JPanel display_Page;
    
    

// Functions
    public window_Manager(){
        window_Layout = new CardLayout();
        display_Page = new JPanel(window_Layout);
        window = new window_Render();
        window.setBackground(CUSTOM_COLOR.WINDOW_TITLE_BAR); // Set the title bar to a gray.
        window.getContentPane().setBackground(CUSTOM_COLOR.WINDOW_BACKGROUND); // Set the background color to a light gray.
        fill_Card_Layout_Pages();

        navigate_Page(WINDOW_PAGE_NUM.LOGIN);

        window.setVisible(true); // Display the window. 

    }

    private void navigate_Page(WINDOW_PAGE_NUM page){ // Navigate to, and set, page given the page number.

        if (current_Page != page){
            current_Page = page;

            switch (page) { // Left as a switch to allow for future page additions.
                case WINDOW_PAGE_NUM.LOGIN: // Login and create user pages have same size.
                case WINDOW_PAGE_NUM.CREATE_USER:
                    window_Width = constants.LOGIN_WINDOW.WIDTH;
                    window_Height = constants.LOGIN_WINDOW.HEIGHT;
                    break;
                
                case WINDOW_PAGE_NUM.SAVED_PASSWORDS: // Increase window size when 
                    window_Width = constants.PASSWORD_WINDOW.WIDTH;
                    window_Height = constants.PASSWORD_WINDOW.HEIGHT;
                    break;
                
                default:
                    break;
            }

            window.setSize(window_Width, window_Height);
    
            window_Layout.show(display_Page, constants.PAGE_NAMES.get_Name(page));

        }
    }

    private void fill_Card_Layout_Pages(){
        display_Page.add(main_Login_Page(),constants.PAGE_NAMES.LOGIN_PAGE);
        display_Page.add(new_User_Login_Page(),constants.PAGE_NAMES.CREATE_USER_PAGE);
        display_Page.add(saved_Passwords_Page(),constants.PAGE_NAMES.PASSWORDS_PAGE);
        window.add(display_Page);
    }

    private ActionListener login_Page_Navigation_Listener(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e){
                navigate_Page(WINDOW_PAGE_NUM.LOGIN);
            }
        };
    }

    private ActionListener passwords_Page_Navigation_Listener(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e){
                navigate_Page(WINDOW_PAGE_NUM.SAVED_PASSWORDS);
            }
        };
    }

// Pages
    private JPanel main_Login_Page(){ // Returns the main login page to be added to the card layout.
        ActionListener nav_To_New_User;
        ActionListener nav_To_Passwords;

        nav_To_New_User = new ActionListener() {
            public void actionPerformed(ActionEvent e){
                navigate_Page(WINDOW_PAGE_NUM.CREATE_USER);
            }
        };
        nav_To_Passwords = passwords_Page_Navigation_Listener();
        
        return new login_Page(nav_To_Passwords,nav_To_New_User);
    }

    private JPanel new_User_Login_Page(){ // Returns the new user login page to be added to the card layout
        ActionListener create_New_User_Listener;
        ActionListener cancel_New_User_Listener;

        create_New_User_Listener = passwords_Page_Navigation_Listener();
        cancel_New_User_Listener = login_Page_Navigation_Listener();

        return new new_User_Login_Page(create_New_User_Listener, cancel_New_User_Listener);
    }

    private JPanel saved_Passwords_Page(){ // Returns a the passwords page to be added to the card layout.
        ActionListener nav_To_Login_Page = login_Page_Navigation_Listener();
        return new saved_Passwords_Page(nav_To_Login_Page);
    }





}
