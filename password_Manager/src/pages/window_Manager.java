package pages;
/*
 * This class holds the pages and page navigation to be displayed.
 * - Jordan
 */

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.Box;
import constants.constants;
import constants.constants.*;
import widgets.saved_Password_Button;
import widgets.window_Render;

public class window_Manager{

// Variables
    private static int window_Height; // Set dimentions of the window.
    private static int window_Width;
    private static final int left_Bound_X = login_Window.left_Bound_X; // Set the top and left bounds of the screen.
    private static final int top_Bound_Y = login_Window.top_Bound_Y;
    private static final int field_Width = login_Window.login_Input_Field_Width;
    private static final int field_Height = login_Window.login_Input_Field_Height;
    private static final Font font = custom_Font_Settings.normal_Font;

    private static window_Page_Num current_Page; 

    private window_Render window = new window_Render(); // Window to be created.
    private CardLayout window_Layout;
    private JPanel display_Page;
    
// Functions
    public window_Manager(){
        window_Layout = new CardLayout();
        display_Page = new JPanel(window_Layout);
        window = new window_Render();
        window.setBackground(custom_Color.window_Title_bar); // Set the title bar to a gray.
        window.getContentPane().setBackground(custom_Color.window_Background); // Set the background color to a light gray.
        fill_Card_Layout_Pages();

        navigate_Page(window_Page_Num.login);

        window.setVisible(true); // Display the window. 

    }

    private static boolean is_Account(){ // Checks if account already exists.
        return false;
    }

    private static boolean is_Login_Data(){ // Checks if account exists and the login information is correct.
        return true;
    }

    private void navigate_Page(window_Page_Num page){ // Navigate to, and set, page given the page number.

        if (current_Page != page){
            current_Page = page;

            switch (page) { // Left as a switch to allow for future page additions.
                case window_Page_Num.login: // Login and create user pages have same size.
                case window_Page_Num.create_User:
                    window_Width = constants.login_Window.width;
                    window_Height = constants.login_Window.height;
                    break;
                
                case window_Page_Num.saved_Passwords: // Increase window size when 
                    window_Width = constants.password_Window.width;
                    window_Height = constants.password_Window.height;
                    break;
                
                default:
                    break;
            }

            window.setSize(window_Width, window_Height);
    
            window_Layout.show(display_Page, constants.page_Names.get_Name(page));

        }
    }

    private void fill_Card_Layout_Pages(){
        display_Page.add(main_Login_Page(),constants.page_Names.login_Page);
        display_Page.add(new_User_Login_Page(),constants.page_Names.create_User_Page);
        display_Page.add(saved_Passwords_Page(),constants.page_Names.passwords_Page);
        window.add(display_Page);
    }

    private ArrayList<saved_Password_Button> get_Passwords(){ // Gets the button list for the passwords.
        ArrayList<saved_Password_Button> temp = new ArrayList<saved_Password_Button>(); 
        for (int i = 0; i < 3; ++i){
            temp.add(new saved_Password_Button("Hello","Goodbye"+i));
        }        
        
        return temp;
    }

// Pages
    private JPanel main_Login_Page(){ // Returns the main login page to be added to the card layout.
        JPanel login_Page = new JPanel();
        
        // Labels to direct user to which field is for which input.
        JLabel username_Label = new JLabel(custom_String.login_Page.username_Label_Text); 
        JLabel password_Label = new JLabel(custom_String.login_Page.password_Label_Text);

        // Input fields for username and password.
        JTextField user_Name_Field = new JTextField();
        JPasswordField password_Field = new JPasswordField();
        
        // Buttons for logging in and adding a new user.
        JButton login_Button = new JButton(custom_String.login_Page.login_Page_Button);
        JButton create_User_Button = new JButton(custom_String.login_Page.create_New_User_Button);
        
        // Set button dimensions.
        int button_Width = constants.login_Window.login_Page_Button_Width;
        int button_Height = constants.login_Window.login_Page_Button_Height;

        // Set panel layout, color, and dimensions.
        login_Page.setLayout(null);
        login_Page.setBackground(custom_Color.window_Background);
        login_Page.setSize(window_Width, window_Height);

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
            (e)->{
                navigate_Page(window_Page_Num.saved_Passwords);
            }
        );
        create_User_Button.addActionListener(
            (e) -> {
                navigate_Page(window_Page_Num.create_User);
            }
        );

        // Add the labels, input fields, and the button for logging in.
        login_Page.add(password_Field);
        login_Page.add(password_Label);
        login_Page.add(username_Label);
        login_Page.add(user_Name_Field);
        login_Page.add(login_Button);
        login_Page.add(create_User_Button);

        return login_Page;
    }

    private JPanel new_User_Login_Page(){ // Returns the new user login page to be added to the card layout
        JPanel new_User = new JPanel();

        // Labels to direct user to which field is for which input.
        JLabel username_Label = new JLabel(custom_String.login_Page.username_Label_Text); 
        JLabel password_Label = new JLabel(custom_String.login_Page.password_Label_Text);

        // Input fields for username and password.
        JTextField user_Name_Field = new JTextField();
        JPasswordField password_Field = new JPasswordField();
        
        // Buttons for logging in as new user and returning to main login page.
        JButton login_New_User_Button = new JButton(custom_String.login_Page.add_New_User_Button);
        JButton cancel_Button = new JButton(custom_String.login_Page.cancel_Button);

        // Set button dimensions.
        int button_Width = constants.login_Window.login_Page_Button_Width;
        int button_Height = constants.login_Window.login_Page_Button_Height;
        
        // Set panel layout, color, and dimensions.
        new_User.setLayout(null);
        new_User.setBackground(custom_Color.window_Background);
        new_User.setSize(window_Width, window_Height);

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
        login_New_User_Button.addActionListener(
            (e)->{
                navigate_Page(window_Page_Num.saved_Passwords);
            }
        );
        cancel_Button.addActionListener(
            (e) -> {
                navigate_Page(window_Page_Num.login);
            }
        );

        // Add the labels, input fields, and the button for logging in.
        new_User.add(password_Field);
        new_User.add(password_Label);
        new_User.add(username_Label);
        new_User.add(user_Name_Field);
        new_User.add(login_New_User_Button);
        new_User.add(cancel_Button);

        return new_User;
    }

    private JPanel saved_Passwords_Page(){ // Returns a the passwords page to be added to the card layout.
        JPanel saved_Passwords = new JPanel(new BorderLayout());
        JPanel options_Panel = new JPanel(); // Options panel to display the options for adding a new password.
        JPanel passwords_Panel = new JPanel(); // Passwords panel to display the list of passwords.

        BoxLayout password_Panel_Layout = new BoxLayout(passwords_Panel, BoxLayout.Y_AXIS);
        BoxLayout options_Panel_Layout = new BoxLayout(options_Panel, BoxLayout.Y_AXIS);

        JScrollPane scrolling_Passwords; // Scrolling panel to add the passwords panel to that would make the page scrollable.

        
        JButton add_New_Password = new JButton(custom_String.password_Page.left_Panel.add_Password_Button_Text); // Creates the button add a new password to the list.
        JButton log_Out = new JButton(custom_String.password_Page.left_Panel.logout_Button_Text); // Button to log out of user.

        ArrayList<saved_Password_Button> passwords_List = get_Passwords();    

        add_New_Password.addActionListener( // Display pop-up to add a new password.
            (e)->{
                
            }
        );

        // Buttons
        log_Out.addActionListener( // Logout and return to login page.
            (e)->{
                navigate_Page(window_Page_Num.login);
            }
        );



    // Options Panel 
        options_Panel.setSize(password_Window.left_Panel_Dimen.column_Width, password_Window.left_Panel_Dimen.column_Height); // Set dimensions for the column.
        options_Panel.setBackground(custom_Color.password_Column); // Set background color for column.
        options_Panel.setLayout(options_Panel_Layout);
        
        // Add buttons to options panel.
        options_Panel.add(add_New_Password);
        options_Panel.add(log_Out);

    // Passwords Panel
        passwords_Panel.setSize(password_Window.passwords_Main_Page.page_Width, password_Window.passwords_Main_Page.page_Height); // Set dimensions for the column.
        passwords_Panel.setBackground(custom_Color.password_Background); // Set background color for column.
        passwords_Panel.setLayout(password_Panel_Layout);
        
        // Add items to passwords panel.
        for (int i = 0; i < passwords_List.size(); ++i){
            passwords_Panel.add(passwords_List.get(i));
            passwords_Panel.add(Box.createRigidArea(new Dimension(0,10))); // THIS LINE IS A LIFE SAVER AT KEEPING DIMENSIONS!
        }
        passwords_List.clear();

    // Scrolling Panel
        scrolling_Passwords = new JScrollPane(passwords_Panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrolling_Passwords.setBounds(password_Window.left_Panel_Dimen.column_Width, 0, password_Window.passwords_Main_Page.page_Width+1, password_Window.passwords_Main_Page.page_Height-27);

        saved_Passwords.add(options_Panel, BorderLayout.WEST);
        saved_Passwords.add(scrolling_Passwords);
        
        return saved_Passwords;
    }

}
