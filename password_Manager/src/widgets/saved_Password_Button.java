package widgets;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import constants.constants;
import constants.constants.custom_Color;

public class saved_Password_Button extends JPanel{
    private String saved_Username;
    private String saved_Password;
    private Dimension fixed_Sizing = new Dimension(constants.password_Window.passwords_Main_Page.button_Width,constants.password_Window.passwords_Main_Page.button_Height);

    public saved_Password_Button(String username, String password){
        saved_Password = password;
        saved_Username = username;

        JButton password_Button = new JButton(saved_Username);
        JButton edit_Password_Button = new JButton("...");
        
        //password_Button.setSize(500,300);
        password_Button.setPreferredSize(new Dimension(700,50));
        edit_Password_Button.setPreferredSize(new Dimension(20,20));

        super.setBackground(custom_Color.password_Box_Background);
        super.setBorder(BorderFactory.createLineBorder(custom_Color.password_Box_Border));

        setLayout(new FlowLayout());
        password_Button.addActionListener(
            (e) -> {
                System.out.println(saved_Password);
            }
        );
        
        edit_Password_Button.addActionListener(
            (e) -> {
                System.out.println("Edit");
            }
        );

        super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));


        super.add(password_Button);
        super.add(Box.createRigidArea(new Dimension(10,0)));
        super.add(edit_Password_Button);

        super.setMaximumSize(fixed_Sizing);
        super.setMinimumSize(fixed_Sizing);
        super.setPreferredSize(fixed_Sizing);


    }
}
