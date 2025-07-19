package pages;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import constants.constants;
import constants.constants.CUSTOM_COLOR;
import constants.constants.CUSTOM_FONT_SETTINGS;
import constants.constants.CUSTOM_STRING;
import constants.constants.LOGIN_WINDOW;


public class new_User_Login_Page extends JPanel {
    // Labels to direct user to which field is for which input.
    private JLabel username_Label = new JLabel(CUSTOM_STRING.LOGIN_PAGE.USERNAME_LABEL_TEXT); 
    private JLabel password_Label = new JLabel(CUSTOM_STRING.LOGIN_PAGE.PASSWORD_LABEL_TEXT);

    // Input fields for username and password.
    private JTextField user_Name_Field = new JTextField();
    private JPasswordField password_Field = new JPasswordField();
        
    // Buttons for logging in as new user and returning to main login page.
    private JButton login_New_User_Button = new JButton(CUSTOM_STRING.LOGIN_PAGE.ADD_NEW_USER_BUTTON);
    private JButton cancel_Button = new JButton(CUSTOM_STRING.LOGIN_PAGE.CANCEL_BUTTON);

    // Set button dimensions.
    private int button_Width = LOGIN_WINDOW.LOGIN_PAGE_BUTTON_WIDTH;
    private int button_Height = LOGIN_WINDOW.LOGIN_PAGE_BUTTON_HEIGHT;
    private final int left_Bound_X = LOGIN_WINDOW.LEFT_BOUND_X; // Set the top and left bounds of the screen.
    private final int top_Bound_Y = LOGIN_WINDOW.TOP_BOUND_Y;
    private final int field_Width = LOGIN_WINDOW.LOGIN_INPUT_FIELD_WIDTH;
    private final int field_Height = LOGIN_WINDOW.LOGIN_INPUT_FIELD_HEIGHT;
    private final int window_Width = constants.LOGIN_WINDOW.WIDTH;
    private final int window_Height = constants.LOGIN_WINDOW.HEIGHT;

    private final Font font = CUSTOM_FONT_SETTINGS.NORMAL_FONT; 

    public new_User_Login_Page(ActionListener navigate_Page_Passwords, ActionListener navigate_Page_Cancel_New_User){

        
        // Set panel layout, color, and dimensions.
        this.setLayout(null);
        this.setBackground(CUSTOM_COLOR.WINDOW_BACKGROUND);
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
