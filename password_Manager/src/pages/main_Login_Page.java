package pages;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;

import constants.constants;
import constants.constants.custom_Color;
import constants.constants.custom_Font_Settings;
import constants.constants.custom_String;
import constants.constants.login_Window;
import constants.constants.window_Page_Num;


public class main_Login_Page extends JPanel {
    // Labels to direct user to which field is for which input.
    private JLabel username_Label = new JLabel(custom_String.login_Page.username_Label_Text); 
    private JLabel password_Label = new JLabel(custom_String.login_Page.password_Label_Text);

    // Input fields for username and password.
    private JTextField user_Name_Field = new JTextField();
    private JPasswordField password_Field = new JPasswordField();
        
    // Buttons for logging in and adding a new user.
    private JButton login_Button = new JButton(custom_String.login_Page.login_Page_Button);
    private JButton create_User_Button = new JButton(custom_String.login_Page.create_New_User_Button);
        
    // Set button dimensions.
    private int button_Width = constants.login_Window.login_Page_Button_Width;
    private int button_Height = constants.login_Window.login_Page_Button_Height;
    private static final int left_Bound_X = login_Window.left_Bound_X; // Set the top and left bounds of the screen.
    private static final int top_Bound_Y = login_Window.top_Bound_Y;
    private static final int field_Width = login_Window.login_Input_Field_Width;
    private static final int field_Height = login_Window.login_Input_Field_Height;

    private final Font font = custom_Font_Settings.normal_Font; 
    
    public static final int window_Width = constants.login_Window.width;
    public static final int window_Height = constants.login_Window.height;

    public main_Login_Page(ActionListener navigate_Page_Passwords, ActionListener navigate_Page_New_User){
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
        login_Button.setBounds((left_Bound_X*2)/5, top_Bound_Y + (username_Label.getHeight()*2), button_Width, button_Height);
        create_User_Button.setBounds((left_Bound_X*3)/5 + login_Button.getWidth(), top_Bound_Y + (username_Label.getHeight()*2), button_Width, button_Height);
        login_Button.addActionListener(
            navigate_Page_Passwords
        );
        create_User_Button.addActionListener(
            navigate_Page_New_User
        );

        // Add the labels, input fields, and the button for logging in.
        this.add(password_Field);
        this.add(password_Label);
        this.add(username_Label);
        this.add(user_Name_Field);
        this.add(login_Button);
        this.add(create_User_Button);


    }
    
}
