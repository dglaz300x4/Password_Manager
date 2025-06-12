package widgets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import constants.constants;

public class saved_Password_Button extends JPanel{
    private String saved_Username;
    private String saved_Password;
    private Dimension fixed_Sizing = new Dimension(constants.password_Window.passwords_Main_Page.button_Width,constants.password_Window.passwords_Main_Page.button_Height);

    public saved_Password_Button(String username, String password){
        saved_Password = password;
        saved_Username = username;

        JButton password_Button = new JButton(saved_Username);
        JButton edit_Password = new JButton("...");
        setLayout(new FlowLayout());
        password_Button.addActionListener(
            (e) -> {
                System.out.println(saved_Password);
            }
        );
        
        edit_Password.addActionListener(
            (e) -> {
                System.out.println("Edit");
            }
        );
        super.add(password_Button);
        super.add(new JButton("2nd"));

        super.setMaximumSize(fixed_Sizing);
        super.setMinimumSize(fixed_Sizing);
        super.setPreferredSize(fixed_Sizing);

        super.setBackground(Color.CYAN);
        super.setBorder(BorderFactory.createLineBorder(Color.black));

    }
}
