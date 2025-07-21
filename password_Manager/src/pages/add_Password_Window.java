package pages;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.password_Info;
import constants.constants;
import constants.constants.CUSTOM_COLOR;
import constants.constants.CUSTOM_FONT_SETTINGS;
import constants.constants.CUSTOM_STRING;
import constants.constants.LOGIN_WINDOW;
import widgets.add_Password_Listener;
import widgets.window_Render;

public class add_Password_Window {
    private window_Render new_Window;

    private JPanel new_Password_Panel;

    private JButton add_Password_Button;
    private JButton cancel_Password_Button;

    private final JLabel website_Title = new JLabel(CUSTOM_STRING.ADD_NEW_PASSWORD_WINDOW.WEBSITE);
    private final JLabel username_Title = new JLabel(CUSTOM_STRING.ADD_NEW_PASSWORD_WINDOW.USERNAME);
    private final JLabel password_Title = new JLabel(CUSTOM_STRING.ADD_NEW_PASSWORD_WINDOW.PASSWORD);

    private final JTextField website_Field = new JTextField(); 
    private final JTextField username_Field = new JTextField(); 
    private final JTextField password_Field = new JTextField(); 

    private final Font font = CUSTOM_FONT_SETTINGS.NORMAL_FONT; 
    
    public add_Password_Window(add_Password_Listener window_Listener){
        Rectangle title_Bounds = new Rectangle(40,LOGIN_WINDOW.TOP_BOUND_Y,LOGIN_WINDOW.LOGIN_INPUT_FIELD_WIDTH,LOGIN_WINDOW.LOGIN_INPUT_FIELD_HEIGHT);
        Rectangle button_Bounds = new Rectangle(title_Bounds.width+40,LOGIN_WINDOW.TOP_BOUND_Y,LOGIN_WINDOW.LOGIN_INPUT_FIELD_WIDTH,LOGIN_WINDOW.LOGIN_INPUT_FIELD_HEIGHT);
        int spacer = 10;
        new_Window = new window_Render(400,300);
        new_Password_Panel = new JPanel(null);
        add_Password_Button = new JButton(constants.CUSTOM_STRING.ADD_NEW_PASSWORD_WINDOW.ADD_NEW_PASSWORD_BUTTON);
        cancel_Password_Button = new JButton(constants.CUSTOM_STRING.ADD_NEW_PASSWORD_WINDOW.CANCEL_BUTTON);
        
        
        website_Title.setFont(font);
        username_Title.setFont(font);
        password_Title.setFont(font);

        website_Title.setBounds(title_Bounds);
        title_Bounds.translate(0, title_Bounds.height+spacer);
        username_Title.setBounds(title_Bounds);
        title_Bounds.translate(0, title_Bounds.height+spacer);
        password_Title.setBounds(title_Bounds);

        title_Bounds.translate(0, title_Bounds.height+spacer);
        add_Password_Button.setBounds(title_Bounds);
        
        website_Field.setBounds(button_Bounds);
        button_Bounds.translate(0, button_Bounds.height+spacer);
        username_Field.setBounds(button_Bounds);
        button_Bounds.translate(0, button_Bounds.height+spacer);
        password_Field.setBounds(button_Bounds);

        button_Bounds.translate(40, button_Bounds.height+spacer);
        cancel_Password_Button.setBounds(button_Bounds);



        new_Window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close window on exit.
        new_Window.setAlwaysOnTop(true); // Always places the window on top of any other existing window.

        new_Password_Panel.setBackground(CUSTOM_COLOR.WINDOW_BACKGROUND); // Set the background color.


        new_Password_Panel.add(website_Title);
        new_Password_Panel.add(username_Title);
        new_Password_Panel.add(password_Title);

        new_Password_Panel.add(website_Field);
        new_Password_Panel.add(username_Field);
        new_Password_Panel.add(password_Field);

        new_Password_Panel.add(add_Password_Button);
        new_Password_Panel.add(cancel_Password_Button);

        add_Password_Button.addActionListener( // Button saves values from the entered fields and closes the popup window.
            (a) -> {
                window_Listener.set_Password_Info(new password_Info());
                window_Listener.actionPerformed(a);
                new_Window.dispose(); // Close the window after adding new password.
            }
        );

        cancel_Password_Button.addActionListener( // Closes the window without saving.
            (a) -> {
                new_Window.dispose(); // Close the window on cancel.
            }
        );

        new_Window.setVisible(true);
        new_Window.add(new_Password_Panel); // Adds the UI for the window.
    }

}
        