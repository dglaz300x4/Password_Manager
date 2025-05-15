package pages;
/*
 * This class constructs the main login page for the user.
 * - Jordan
 */

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constants.constants.custom_Color;
import constants.constants.custom_Font_Settings;
import constants.constants.custom_String;
import constants.constants.login_Window;

import widgets.window_Render;

public class window_Manager implements ActionListener{
// Variables
    private static final int window_Height = login_Window.login_Window_Height; // Set default dimentions of the window.
    private static final int window_Width = login_Window.login_Window_Width;
    private static final int left_Bound_X = window_Width/3; // Set the top and left bounds of the screen.
    private static final int top_Bound_Y = login_Window.top_Bound_Y;
    private static final int field_Width = login_Window.login_Input_Field_Width;
    private static final int field_Height = login_Window.login_Input_Field_Height;
    private static final Font font = custom_Font_Settings.normal_Font;
    private boolean displayable;

    private String user_Name_Input; // Strings to save  user input.
    private String password_Input;

    private window_Render window = new window_Render(); // Window to be created.
    private JButton login_Button = new JButton(custom_String.login_Page_Button); // Button to log user in.
    private JButton create_User_Button = new JButton(custom_String.create_New_User_Button);
    private JButton add_New_User_Button = new JButton("Add User");
    private JButton cancel_Button = new JButton("Cancel");

    // Input fields for username and password.
    private JTextField user_Name_Field = new JTextField();
    private JPasswordField password_Field = new JPasswordField();

// Functions
    public window_Manager(boolean display, window_Render renderer){
        window = renderer;
        displayable = display;
        display_Login_Page();
    }


    public void display_Login_Page(){ // Displays the login page. 
        // Labels to direct user to which field is for which input.
        JLabel username_Label = new JLabel(custom_String.username_Label_Text); 
        JLabel password_Label = new JLabel(custom_String.password_Label_Text);

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
        login_Button.setBounds((left_Bound_X*2)/5, top_Bound_Y + (username_Label.getHeight()*2), window.getWidth()/3, window.getHeight()/10);
        create_User_Button.setBounds((left_Bound_X*3)/5 + login_Button.getWidth(), top_Bound_Y + (username_Label.getHeight()*2), window.getWidth()/3, window.getHeight()/10);
        login_Button.addActionListener(this);
        create_User_Button.addActionListener(this);

        // Add the labels, input fields, and the button for logging in.
        window.add(password_Field);
        window.add(password_Label);
        window.add(username_Label);
        window.add(user_Name_Field);
        window.add(login_Button);
        window.add(create_User_Button);

        window.setLayout(null); // Disables the default layout to be set custom.
        window.setBackground(custom_Color.window_Title_bar); // Set the title bar to a gray.
        window.getContentPane().setBackground(custom_Color.window_Background); // Set the background color to a light gray.
        window.setVisible(displayable); // Display the window. 
    }

    public void display_Create_User_Page(){
        // Labels to direct user to which field is for which input.
        JLabel username_Label = new JLabel(custom_String.username_Label_Text); 
        JLabel password_Label = new JLabel(custom_String.password_Label_Text);

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
        add_New_User_Button.setBounds((left_Bound_X*2)/5, top_Bound_Y + (username_Label.getHeight()*2), window.getWidth()/3, window.getHeight()/10);
        cancel_Button.setBounds((left_Bound_X*3)/5 + login_Button.getWidth(), top_Bound_Y + (username_Label.getHeight()*2), window.getWidth()/3, window.getHeight()/10);
        add_New_User_Button.addActionListener(this);
        cancel_Button.addActionListener(this);

        // Add the labels, input fields, and the button for logging in.
        window.add(password_Field);
        window.add(password_Label);
        window.add(username_Label);
        window.add(user_Name_Field);
        window.add(add_New_User_Button);
        window.add(cancel_Button);

        window.setLayout(null); // Disables the default layout to be set custom.
        window.setBackground(custom_Color.window_Title_bar); // Set the title bar to a gray.
        window.getContentPane().setBackground(custom_Color.window_Background); // Set the background color to a light gray.
        window.setVisible(displayable); // Display the window. 

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == create_User_Button){
            window.clear_Window();
            display_Create_User_Page();
        }
        if (e.getSource() == cancel_Button){
            window.clear_Window();
            display_Login_Page();
        }
    }

}
