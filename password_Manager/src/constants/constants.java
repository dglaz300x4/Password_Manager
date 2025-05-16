package constants;

import java.awt.Color;
import java.awt.Font;

public final class constants {

    private constants(){
        // You shall not call!
    }

    public final class login_Window { // Holds the constant login window dimensions.
        public static final int login_Window_Height = 200;
        public static final int login_Window_Width = 500;
        public static final int left_Bound_X = login_Window_Width/3;
        public static final int top_Bound_Y = 20;
        public static final int login_Input_Field_Width = 130;
        public static final int login_Input_Field_Height = 33;

    }
    
    public final class custom_Font_Settings { // Holds all the custom set font constants.
        private static final int normal_Font_Size = 18;
        private static final String normal_Font_Name = "Arial";

        public static final Font normal_Font = new Font(normal_Font_Name, Font.PLAIN, normal_Font_Size);
        
    }

    public final class custom_Color { // Holds the color constants for the window.
        public static final Color window_Background = Color.getHSBColor(200,200,100);
        public static final Color window_Title_bar = Color.DARK_GRAY;
    }

    public final class custom_String { // Holds String constants.
        public static final String username_Label_Text = "Username";
        public static final String password_Label_Text = "Password";
        
        public static final String login_Page_Button = "Login";
        public static final String create_New_User_Button = "New User";
        public static final String cancel_Button = "Cancel";
        public static final String add_Button = "Add User";


        public static final String title_Bar_Text = "Password Manager";
    }

    public enum window_Page_Num {login, create_User, saved_Passwords};
}
