package pages;
/*
 * This class constructs the main login page for the user.
 * - Jordan
 */

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constants.constants.custom_Color;
import constants.constants.custom_Font_Settings;
import constants.constants.custom_String;
import constants.constants.login_Window;
import constants.constants.password_Window;
import constants.constants.window_Page_Num;
import widgets.window_Render;

public class window_Manager implements ActionListener{
// Variables
    private static int window_Height; // Set dimentions of the window.
    private static int window_Width;
    private static final int left_Bound_X = login_Window.left_Bound_X; // Set the top and left bounds of the screen.
    private static final int top_Bound_Y = login_Window.top_Bound_Y;
    private static final int field_Width = login_Window.login_Input_Field_Width;
    private static final int field_Height = login_Window.login_Input_Field_Height;
    private static final Font font = custom_Font_Settings.normal_Font;
    private static boolean displayable;
    private static window_Page_Num current_Page; 

    // Labels to direct user to which field is for which input.
    private JLabel username_Label = new JLabel(custom_String.login_Page.username_Label_Text); 
    private JLabel password_Label = new JLabel(custom_String.login_Page.password_Label_Text);

    private String user_Name_Input; // Strings to save  user input.
    private String password_Input;

    private window_Render window = new window_Render(); // Window to be created.
    private JButton login_Add_Usr_Button;// = new JButton(custom_String.login_Page.login_Page_Button); // Button to log user in.
    private JButton create_User_Cancel_Button = new JButton(custom_String.login_Page.create_New_User_Button);

    // Input fields for username and password.
    private JTextField user_Name_Field = new JTextField();
    private JPasswordField password_Field = new JPasswordField();

// Functions
    public window_Manager(boolean display, window_Render renderer){
        window = renderer;
        displayable = display;
        display_Login_Page();
    }

    private static boolean is_Account(){
        return false;
    }

    private static boolean is_Login_Data(){
        return true;
    }

    private void main_Login_Page(){
        current_Page = window_Page_Num.login; 

        window_Height = login_Window.height;
        window_Width = login_Window.width;

        // Set dimensions.
        window.setSize(window_Width,window_Height);
        
        // Set fonts.
        username_Label.setFont(font);
        password_Label.setFont(font);
        user_Name_Field.setFont(font);

        // Set bounds for username label and input field.
        username_Label.setBounds(left_Bound_X, top_Bound_Y, field_Width, field_Height);
        user_Name_Field.setBounds(left_Bound_X + username_Label.getWidth(), top_Bound_Y, field_Width, field_Height);

        // Set bounds for password label and input field.
        password_Label.setBounds(left_Bound_X, top_Bound_Y+username_Label.getHeight(), field_Width, field_Height);
        password_Field.setBounds(left_Bound_X + username_Label.getWidth(),  top_Bound_Y+username_Label.getHeight(), field_Width, field_Height);

        // Set bounds and action listener for the login and create user buttons.
        login_Add_Usr_Button.setBounds((left_Bound_X*2)/5, top_Bound_Y + (username_Label.getHeight()*2), window.getWidth()/3, window.getHeight()/10);
        create_User_Cancel_Button.setBounds((left_Bound_X*3)/5 + login_Add_Usr_Button.getWidth(), top_Bound_Y + (username_Label.getHeight()*2), window.getWidth()/3, window.getHeight()/10);
        login_Add_Usr_Button.addActionListener(this);
        create_User_Cancel_Button.addActionListener(this);

        // Add the labels, input fields, and the button for logging in.
        window.add(password_Field);
        window.add(password_Label);
        window.add(username_Label);
        window.add(user_Name_Field);
        window.add(login_Add_Usr_Button);
        window.add(create_User_Cancel_Button);

        window.setLayout(null); // Disables the default layout to be set custom.
        window.setBackground(custom_Color.window_Title_bar); // Set the title bar to a gray.
        window.getContentPane().setBackground(custom_Color.window_Background); // Set the background color to a light gray.
        window.setVisible(displayable); // Display the window. 
    }

    private void display_Login_Page(){ // Displays the login page. 
        current_Page = window_Page_Num.login;
        login_Add_Usr_Button = new JButton(custom_String.login_Page.login_Page_Button);
        create_User_Cancel_Button = new JButton(custom_String.login_Page.create_New_User_Button);
        main_Login_Page();
    }

    private void display_Create_User_Page(){ // Displays the add/create user page.
        current_Page = window_Page_Num.create_User;
        login_Add_Usr_Button = new JButton(custom_String.login_Page.add_Button);
        create_User_Cancel_Button = new JButton(custom_String.login_Page.cancel_Button);
        main_Login_Page();
    }

    private void display_Passwords_Page(){ // Displays the page will all of the user's saved passwords. // Also first experimentation with a JPanel.
        JPanel layout = new JPanel();
        JPanel left_Panel = new JPanel();
        JPanel password_Side = new JPanel();

        JButton add_Password_Button = new JButton(custom_String.password_Page.left_Panel.add_Password_Button_Text);
        JButton logout_Button = new JButton(custom_String.password_Page.left_Panel.logout_Button_Text);

        add_Password_Button.setSize(password_Window.width, left_Panel.getHeight()/10);

        left_Panel.setBounds(0,0, password_Window.left_Panel_Dimen.column_Width, password_Window.left_Panel_Dimen.column_Height); // Set dimensions and location for the column.
        left_Panel.setBackground(custom_Color.password_Column); // Set background color for column.

        password_Side.setBounds(password_Window.left_Panel_Dimen.column_Width, 0, password_Window.passwords_Main_Page.page_Width, password_Window.passwords_Main_Page.page_Height); // Set dimensions and location for the passwords page.
        password_Side.setBackground(custom_Color.password_Background); // Set background color for the column.
        
        layout.setBounds(0, 0, password_Window.width, password_Window.height); // Set location and size for the left panel 
        layout.setLayout(null);
        layout.setBackground(Color.LIGHT_GRAY);
        

        left_Panel.add(add_Password_Button);

        layout.add(left_Panel);
        layout.add(password_Side);

        current_Page = window_Page_Num.saved_Passwords;
        
        window_Height = password_Window.height;
        window_Width = password_Window.width;

        window.setSize(window_Width, window_Height); // Adjust size of window to the 
        window.add(layout);
        window.setLayout(null);
        window.setVisible(displayable);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == create_User_Cancel_Button){ // Checks if there was an ActionEvent from the  create user/cancel button.
            if (current_Page == window_Page_Num.login){ // Changes the page to the create/add new user page on click.
                window.clear_Window();
                display_Create_User_Page();
            }
            else if (current_Page == window_Page_Num.create_User){ // Changes the page to the login page on click.
                window.clear_Window();
                display_Login_Page();
            }
        }
        if (e.getSource() == login_Add_Usr_Button){
            if (current_Page == window_Page_Num.create_User){ // Create a new user and send them to a blank passwords screen.
                if (!is_Account()){ // Temporary until the login logic is created.
                    window.clear_Window();
                    display_Passwords_Page();
                }
                else{
                    // Dont log in.
                }
                
            }
            if (current_Page == window_Page_Num.login){ // Log user into program and send them to their passwords screen.
                if (is_Login_Data()){ // Temporary until login logic is
                    window.clear_Window();
                    display_Passwords_Page();
                }
                else{
                    // Dont log in.
                }
                
            }
        }
    }

}
