package pages;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import constants.constants;
import constants.constants.custom_Color;
import constants.constants.custom_Font_Settings;
import constants.constants.custom_String;
import constants.constants.login_Window;

public class new_User_Login_Page extends JPanel {
    // Labels to direct user to which field is for which input.
    private JLabel username_Label = new JLabel(custom_String.login_Page.username_Label_Text); 
    private JLabel password_Label = new JLabel(custom_String.login_Page.password_Label_Text);

    // Input fields for username and password.
    private JTextField user_Name_Field = new JTextField();
    private JPasswordField password_Field = new JPasswordField();
        
    // Buttons for logging in as new user and returning to main login page.
    private JButton login_New_User_Button = new JButton(custom_String.login_Page.add_New_User_Button);
    private JButton cancel_Button = new JButton(custom_String.login_Page.cancel_Button);

    // Set button dimensions.
    private int button_Width = login_Window.login_Page_Button_Width;
    private int button_Height = login_Window.login_Page_Button_Height;
    private final int left_Bound_X = login_Window.left_Bound_X; // Set the top and left bounds of the screen.
    private final int top_Bound_Y = login_Window.top_Bound_Y;
    private final int field_Width = login_Window.login_Input_Field_Width;
    private final int field_Height = login_Window.login_Input_Field_Height;
    private final int window_Width = constants.login_Window.width;
    private final int window_Height = constants.login_Window.height;

    private final Font font = custom_Font_Settings.normal_Font; 

    public new_User_Login_Page(ActionListener navigate_Page_Passwords, ActionListener navigate_Page_Cancel_New_User){

        
        // Set panel layout, color, and dimensions.
        this.setLayout(null);
        this.setBackground(custom_Color.window_Background);
        this.setSize(window_Width, window_Height);

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
        login_New_User_Button.setBounds((left_Bound_X*2)/5, top_Bound_Y + (username_Label.getHeight()*2), button_Width, button_Height);
        cancel_Button.setBounds((left_Bound_X*3)/5 + login_New_User_Button.getWidth(), top_Bound_Y + (username_Label.getHeight()*2),  button_Width, button_Height);
        login_New_User_Button.addActionListener(navigate_Page_Passwords);
        cancel_Button.addActionListener(navigate_Page_Cancel_New_User);

        // Add the labels, input fields, and the button for logging in.
        this.add(password_Field);
        this.add(password_Label);
        this.add(username_Label);
        this.add(user_Name_Field);
        this.add(login_New_User_Button);
        this.add(cancel_Button);


    }
}
