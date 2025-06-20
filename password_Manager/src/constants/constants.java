package constants;

import java.awt.Color;
import java.awt.Font;

public final class constants {

    private constants(){
        // You shall not call!
    }

    public final class page_Names {
        public static final String login_Page = window_Page_Num.login.toString();
        public static final String create_User_Page = window_Page_Num.create_User.toString();
        public static final String passwords_Page = window_Page_Num.saved_Passwords.toString();

        public static String get_Name(window_Page_Num page){
            String page_Name = new String();
            switch (page) {
                case window_Page_Num.login:
                    page_Name = login_Page;
                    break;
                case window_Page_Num.create_User:
                    page_Name = create_User_Page;
                    break;
                case window_Page_Num.saved_Passwords:
                    page_Name = passwords_Page;
                    break;

            }
            return page_Name;
        }
    }

    public final class login_Window { // Holds the constant login window dimensions.

        private login_Window(){}

        public static final int height = 200;
        public static final int width = 500;
        public static final int left_Bound_X = width/3;
        public static final int top_Bound_Y = 20;
        public static final int login_Input_Field_Width = 130;
        public static final int login_Input_Field_Height = 33;
        public static final int login_Page_Button_Width = width/3;
        public static final int login_Page_Button_Height = height/10;

    }

    public final class password_Window {
        
        private password_Window(){}

        public static final int height = 700;
        public static final int width = 900;

        public final class left_Panel_Dimen{
            
            private left_Panel_Dimen(){}

            public static final int column_Width = width/5;
            public static final int column_Height = height;
        }

        public final class passwords_Main_Page{
            private passwords_Main_Page(){}

            public static final int page_Width = width-left_Panel_Dimen.column_Width;
            public static final int page_Height = height;

            public static final int button_Height = page_Height/12;
            public static final int button_Width = page_Width/3;
        }

    }
    
    public final class custom_Font_Settings { // Holds all the custom set font constants.
        private static final int normal_Font_Size = 18;
        private static final String normal_Font_Name = "Arial";

        public static final Font normal_Font = new Font(normal_Font_Name, Font.PLAIN, normal_Font_Size);
        
    }

    public final class custom_Color { // Holds the color constants for the window.
        public static final Color window_Background = new Color(150,150,150);
        public static final Color window_Title_bar = Color.DARK_GRAY;

        public static final Color password_Column = new Color(250, 170, 10);
        public static final Color password_Background = Color.GRAY;
        public static final Color password_Box_Border = Color.BLACK;
        public static final Color password_Box_Background = new Color(200, 200, 200);
    }

    public final class custom_String { // Holds String constants.

        public final class login_Page{
            public static final String username_Label_Text = "Username";
            public static final String password_Label_Text = "Password";
            
            public static final String login_Page_Button = "Login";
            public static final String create_New_User_Button = "New User";
            public static final String cancel_Button = "Cancel";
            public static final String add_New_User_Button = "Add User";
        }

        public final class password_Page{
            public final class left_Panel{
                public static final String add_Password_Button_Text = "Add New Password";
                public static final String logout_Button_Text = "Logout";
            }

            public final class main_Password_Page{
                public static final String passwords_Title = "Saved Passwords";
                public static final String no_Saved_Passwords_Text = "There are currently no saved passwords";
            }
        }


        public static final String title_Bar_Text = "Password Manager";
    }

    public enum window_Page_Num {login, create_User, saved_Passwords};
}
