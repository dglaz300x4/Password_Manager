package pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JFrame;

import constants.constants.custom_Font_Settings;
import constants.constants.login_Window;

public class welcome_Page implements ActionListener{
    final int window_Width = login_Window.login_Window_Width;
    final int window_Height = login_Window.login_Window_Height;
    final Font font = custom_Font_Settings.normal_Font;

    String new_Username;
    String new_Password;

    JFrame window = new JFrame();
    
    
    public welcome_Page(boolean display){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(window_Width, window_Height);
        window.setTitle("Password Manager");

        window.setVisible(display);
    }

    void set_Login_Data(){ // Function to set the login data.

    }

    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
