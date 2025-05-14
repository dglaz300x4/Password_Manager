package pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JFrame;

import constants.constants.custom_Font_Settings;

public class welcome_Page implements ActionListener{
    final int window_Width = 100;
    final int window_Height = 100;
    final int text_Size = 18;
    final Font font = new custom_Font_Settings();

    String new_Username;
    String new_Password;

    JFrame window = new JFrame();
    
    
    public welcome_Page(){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(window_Width, window_Height);
        window.setTitle("Password Manager");


    }

    void set_Login_Data(){ // Function to set the login data.

    }

    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
