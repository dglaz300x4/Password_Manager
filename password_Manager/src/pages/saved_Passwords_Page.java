package pages;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import classes.password_Info;
import constants.constants.CUSTOM_COLOR;
import constants.constants.CUSTOM_STRING;
import constants.constants.PASSWORD_WINDOW;
import widgets.add_Password_Listener;
import widgets.saved_Password_Button;



public class saved_Passwords_Page extends JPanel {
    private JPanel options_Panel = new JPanel(); // Options panel to display the options for adding a new password.
    private JPanel passwords_Panel = new JPanel(); // Passwords panel to display the list of passwords.
    
    private ArrayList<saved_Password_Button> passwords_List;
    
    private JScrollPane scrolling_Passwords; // Scrolling panel to add the passwords panel to that would make the page scrollable.
    
    private final BoxLayout password_Panel_Layout = new BoxLayout(passwords_Panel, BoxLayout.Y_AXIS);
    private final BoxLayout options_Panel_Layout = new BoxLayout(options_Panel, BoxLayout.Y_AXIS);

    private final JButton add_New_Password = new JButton(CUSTOM_STRING.PASSWORD_PAGE.LEFT_PANEL.ADD_PASSWORD_BUTTON_TEXT); // Creates the button add a new password to the list.
    private final JButton log_Out = new JButton(CUSTOM_STRING.PASSWORD_PAGE.LEFT_PANEL.LOGOUT_BUTTON_TEXT); // Button to log out of user.
    
    private final Dimension option_Panel_Size = new Dimension(PASSWORD_WINDOW.OPTIONS_PANEL_DIMEN.COLUMN_WIDTH, PASSWORD_WINDOW.OPTIONS_PANEL_DIMEN.COLUMN_HEIGHT);
    private final Dimension option_Panel_Button_Size = new Dimension(PASSWORD_WINDOW.OPTIONS_PANEL_DIMEN.COLUMN_WIDTH,20);


    public saved_Passwords_Page(ActionListener navigate_To_Login_Listener){
        this.setLayout(new BorderLayout());

        passwords_List = get_Passwords();

        // Buttons
        add_New_Password.addActionListener( // Display pop-up to add a new password.
            (e)->{
                // Temporary code to add a new password for the user.
                add_New_Password_Window(); // Creates the new window to add the password.
            }
        );

        log_Out.addActionListener(navigate_To_Login_Listener); // Logout and return to login page.

    // Options Panel 
        options_Panel.setMinimumSize(option_Panel_Size);
        options_Panel.setMaximumSize(option_Panel_Size);
        options_Panel.setBackground(CUSTOM_COLOR.PASSWORD_COLUMN); // Set background color for column.
        options_Panel.setLayout(options_Panel_Layout);

        options_Panel_Layout.maximumLayoutSize(options_Panel);

        add_New_Password.setMaximumSize(option_Panel_Button_Size);
        add_New_Password.setMinimumSize(option_Panel_Button_Size);
        log_Out.setMaximumSize(option_Panel_Button_Size);
        log_Out.setMinimumSize(option_Panel_Button_Size);

        // Add buttons to options panel.
        options_Panel.add(add_New_Password);
        options_Panel.add(log_Out);

    // Passwords Panel
        passwords_Panel.setSize(PASSWORD_WINDOW.PASSWORDS_MAIN_PAGE.PAGE_WIDTH, PASSWORD_WINDOW.PASSWORDS_MAIN_PAGE.PAGE_HEIGHT); // Set dimensions for the column.
        passwords_Panel.setBackground(CUSTOM_COLOR.PASSWORD_BACKGROUND); // Set background color for column.
        passwords_Panel.setLayout(password_Panel_Layout);
        
        // Add items to passwords panel.
        for (int i = 0; i < passwords_List.size(); ++i){
            passwords_Panel.add(passwords_List.get(i));
            passwords_Panel.add(Box.createRigidArea(new Dimension(0,10))); // THIS LINE IS A LIFE SAVER AT KEEPING DIMENSIONS!
        }


    // Scrolling Panel
        scrolling_Passwords = new JScrollPane(passwords_Panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrolling_Passwords.setBounds(PASSWORD_WINDOW.OPTIONS_PANEL_DIMEN.COLUMN_WIDTH, 0, PASSWORD_WINDOW.PASSWORDS_MAIN_PAGE.PAGE_WIDTH+1, PASSWORD_WINDOW.PASSWORDS_MAIN_PAGE.PAGE_HEIGHT-27);

        this.add(options_Panel, BorderLayout.WEST);
        this.add(scrolling_Passwords);
        
    }

    private ArrayList<saved_Password_Button> get_Passwords(){ // Gets the button list for the passwords.
        ArrayList<saved_Password_Button> temp = new ArrayList<saved_Password_Button>(); 

        //* Update this to reflect data pulled from DB later

        for (int i = 0; i < 3; ++i){
            temp.add(new saved_Password_Button(new password_Info("Website"+i,"Username"+i,"Password"+i)));
        }        
        
        return temp;
    }
    
    private void add_New_Password_Window(){
        add_Password_Listener password_listener;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwords_List.add(new saved_Password_Button(new password_Info("Website", "Username", "Password")));
                passwords_Panel.add(passwords_List.getLast());
                passwords_Panel.add(Box.createRigidArea(new Dimension(0,10))); // THIS LINE IS A LIFE SAVER AT KEEPING DIMENSIONS!
                passwords_Panel.updateUI();
            }
        };
        
        password_listener  = new add_Password_Listener(listener);

        add_Password_Window window = new add_Password_Window(password_listener);
    }

}
