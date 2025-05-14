package pages;
/*
 * This class constructs the main login page for the user.
 * - Jordan
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constants.constants.login_Window;

public class login_Page implements ActionListener {
    final int window_Height = login_Window.login_Window_Height; // Set default dimentions of the window.
    final int window_Width = login_Window.login_Window_Width;
    final int left_Bound_X = window_Width/3; // Set the top and left bounds of the screen.
    final int top_Bound_Y = 20;
    final int text_Size = 18;
    final int field_Width = 130;
    final int field_Height = 33;
    final Font font = new Font("Arial", Font.PLAIN,text_Size);

    String user_Name_Input; // Strings to be saved for user input.
    String password_Input;

    JFrame window = new JFrame(); // Window to be created.
    JButton login_Button = new JButton("Login"); // Button to log user in.
    
    // Labels to direct user to which field is for which input.
    JLabel username_Label = new JLabel("Username: "); 
    JLabel password_Label = new JLabel("Password: ");
    
    // Input fields for username and password.
    JTextField user_Name_Field = new JTextField();
    JPasswordField password_Field = new JPasswordField();

    public login_Page(boolean disiplay){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(window_Width, window_Height);
        window.setTitle("Password Manager");


        // Set fonts
        username_Label.setFont(font);
        password_Label.setFont(font);
        user_Name_Field.setFont(font);

        // Set bounds for username label and input field.
        username_Label.setBounds(left_Bound_X, top_Bound_Y, field_Width, field_Height);
        user_Name_Field.setBounds(left_Bound_X + username_Label.getWidth(), top_Bound_Y, field_Width, field_Height);


        // Set bounds for password label and input field.
        password_Label.setBounds(left_Bound_X, top_Bound_Y+username_Label.getHeight(), field_Width, field_Height);
        password_Field.setBounds(left_Bound_X + username_Label.getWidth(),  top_Bound_Y+username_Label.getHeight(), field_Width, field_Height);

        // Set bounds and action listener for the login button.
        login_Button.setBounds(left_Bound_X,top_Bound_Y + (username_Label.getHeight()*2), window.getWidth()/3, window.getHeight()/10);
        login_Button.addActionListener(this);

        // Add the labels, input fields, and the button for logging in.
        window.add(password_Field);
        window.add(password_Label);
        window.add(username_Label);
        window.add(user_Name_Field);
        window.add(login_Button);

        window.setLayout(null); // Disables the default layout to be set custom.
        window.setBackground(Color.DARK_GRAY); // Set the title bar to a gray.
        window.getContentPane().setBackground(Color.getHSBColor(200,200,100)); // Set the background color to a light gray.
        window.setResizable(false); // Keeps the window a constant size.
        window.setVisible(disiplay); // Display the window. 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login_Button){
            user_Name_Input = user_Name_Field.getText();
            password_Input = password_Field.getPassword().toString();
            System.out.println("Password "+ password_Input);
            System.out.println("User " + user_Name_Input);
        }
        

    }


}
