package pages;
/*
 * This class constructs the main login page for the user.
 * - Jordan
 */

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import constants.constants.*;
import widgets.window_Render;

public class window_Manager implements ActionListener{

    //? Should I create a new class to hold the functions to create a new frame. (Class with jframe and listener, each function to set up new page) (Maybe pass in the page number to create/adjust the window)
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

        //display_Saved_Passwords_Page();
    }

    private static boolean is_Account(){ // Checks if account already exists.
        return false;
    }

    private static boolean is_Login_Data(){ // Checks if account exists and the login information is correct.
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

    private ArrayList<JButton> get_Passwords(){ // Gets the button list for the passwords.
        ArrayList<JButton> temp = new ArrayList<JButton>(); 
        JButton temp_Button;
        for (int i = 0; i < 35; ++i){
            temp_Button = new JButton("Button: " + (i+1));
            temp_Button.setSize(400, 200);
            temp.add(temp_Button);
        }        
        
        return temp;
    }

    private void display_Saved_Passwords_Page(){
        JPanel options_Panel = new JPanel();
        JPanel passwords_Panel = new JPanel();

        JScrollPane scrolling_Passwords;

        
        JButton add_New_Password = new JButton(custom_String.password_Page.left_Panel.add_Password_Button_Text);
        JButton log_Out = new JButton(custom_String.password_Page.left_Panel.logout_Button_Text);

        ArrayList<JButton> passwords_List = get_Passwords();

        window_Height = password_Window.height;
        window_Width = password_Window.width;
        window.setSize(window_Width, window_Height); // Adjust size of window to the 


        // Options Panel 
        options_Panel.setBounds(0,0, password_Window.left_Panel_Dimen.column_Width, password_Window.left_Panel_Dimen.column_Height); // Set dimensions and location for the column.
        options_Panel.setBackground(custom_Color.password_Column); // Set background color for column.
        options_Panel.setLayout(new BoxLayout(options_Panel, BoxLayout.Y_AXIS));

        options_Panel.add(add_New_Password);
        options_Panel.add(log_Out);

        // Passwords Panel
        passwords_Panel.setSize(password_Window.passwords_Main_Page.page_Width, password_Window.passwords_Main_Page.page_Height);
        passwords_Panel.setBackground(custom_Color.password_Background);
        passwords_Panel.setLayout(new BoxLayout(passwords_Panel, BoxLayout.Y_AXIS));

        for (int i = 0; i < passwords_List.size(); ++i){
            passwords_Panel.add(passwords_List.get(i));
        }

        

        // Scrolling Panel
        /*
        
        scrolling_Passwords.setLayout(null);
        scrolling_Passwords.getVerticalScrollBar().setValue(0);

        scrolling_Passwords.add(passwords_Panel); */

        scrolling_Passwords = new JScrollPane(passwords_Panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrolling_Passwords.setBounds(password_Window.left_Panel_Dimen.column_Width, 0, password_Window.passwords_Main_Page.page_Width, password_Window.passwords_Main_Page.page_Height-28);

        window.getContentPane().add(options_Panel, BorderLayout.WEST);
        window.getContentPane().add(scrolling_Passwords);
        
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
                    display_Saved_Passwords_Page();
                }
                else{
                    // Dont log in.
                }
                
            }
            if (current_Page == window_Page_Num.login){ // Log user into program and send them to their passwords screen.
                if (is_Login_Data()){ // Temporary until login logic is
                    window.clear_Window();
                    display_Saved_Passwords_Page();
                }
                else{
                    // Dont log in.
                }
                
            }
        }
    }

}
