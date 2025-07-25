package constants;

import java.awt.Color;
import java.awt.Font;

public final class constants {

    private constants(){
        // You shall not call!
    }

    public final class PAGE_NAMES {
        public static final String LOGIN_PAGE = WINDOW_PAGE_NUM.LOGIN.toString();
        public static final String CREATE_USER_PAGE = WINDOW_PAGE_NUM.CREATE_USER.toString();
        public static final String PASSWORDS_PAGE = WINDOW_PAGE_NUM.SAVED_PASSWORDS.toString();

        public static String get_Name(WINDOW_PAGE_NUM page){
            String page_Name = new String();
            switch (page) {
                case WINDOW_PAGE_NUM.LOGIN:
                    page_Name = LOGIN_PAGE;
                    break;
                case WINDOW_PAGE_NUM.CREATE_USER:
                    page_Name = CREATE_USER_PAGE;
                    break;
                case WINDOW_PAGE_NUM.SAVED_PASSWORDS:
                    page_Name = PASSWORDS_PAGE;
                    break;

            }
            return page_Name;
        }
    }

    public final class LOGIN_WINDOW { // Holds the constant login window dimensions.

        private LOGIN_WINDOW(){}

        public static final int HEIGHT = 200;
        public static final int WIDTH = 500;
        public static final int LEFT_BOUND_X = WIDTH/3;
        public static final int TOP_BOUND_Y = 20;
        public static final int LOGIN_INPUT_FIELD_WIDTH = 130;
        public static final int LOGIN_INPUT_FIELD_HEIGHT = 33;
        public static final int LOGIN_PAGE_BUTTON_WIDTH = WIDTH/3;
        public static final int LOGIN_PAGE_BUTTON_HEIGHT = HEIGHT/10;

    }

    public final class PASSWORD_WINDOW {
        
        private PASSWORD_WINDOW(){}

        public static final int HEIGHT = 700;
        public static final int WIDTH = 900;

        public final class OPTIONS_PANEL_DIMEN{
            
            private OPTIONS_PANEL_DIMEN(){}

            public static final int COLUMN_WIDTH = WIDTH/5;
            public static final int COLUMN_HEIGHT = HEIGHT;
        }

        public final class PASSWORDS_MAIN_PAGE{
            private PASSWORDS_MAIN_PAGE(){}

            public static final int PAGE_WIDTH = WIDTH-OPTIONS_PANEL_DIMEN.COLUMN_WIDTH;
            public static final int PAGE_HEIGHT = HEIGHT;

            public static final int BUTTON_HEIGHT = PAGE_HEIGHT/12;
            public static final int BUTTON_WIDTH = (PAGE_WIDTH*9)/10;
        }

    }
    
    public final class CUSTOM_FONT_SETTINGS { // Holds all the custom set font constants.
        private static final int NORMAL_FONT_SIZE = 18;
        private static final String NORMAL_FONT_NAME = "Arial";

        public static final Font NORMAL_FONT = new Font(NORMAL_FONT_NAME, Font.PLAIN, NORMAL_FONT_SIZE);
        
    }

    public final class CUSTOM_COLOR { // Holds the color constants for the window.
        public static final Color WINDOW_BACKGROUND = new Color(150,150,150);
        public static final Color WINDOW_TITLE_BAR = Color.DARK_GRAY;

        public static final Color PASSWORD_COLUMN = new Color(100, 150, 200);
        public static final Color PASSWORD_BACKGROUND = Color.GRAY;
        public static final Color PASSWORD_BOX_BORDER = Color.BLACK;
        public static final Color PASSWORD_BOX_BACKGROUND = new Color(100, 150, 200);
    }

    public final class CUSTOM_STRING { // Holds String constants.

        public final class MAIN_LOGIN_PAGE{
            public static final String USERNAME_LABEL_TEXT = "Username";
            public static final String PASSWORD_LABEL_TEXT = "Password";
            
            public final class LOGIN_PAGE{
                public static final String LOGIN_PAGE_BUTTON = "Login";
                public static final String CREATE_NEW_USER_BUTTON = "New User";
            }

            public final class NEW_USER_PAGE{
                public static final String CANCEL_BUTTON = "Cancel";
                public static final String ADD_NEW_USER_BUTTON = "Add User";
            }
        }
        
        public final class ADD_NEW_PASSWORD_WINDOW{

            public static final String WEBSITE = "Website/App";
            public static final String USERNAME = "Username";
            public static final String PASSWORD = "Password";
            public static final String ADD_NEW_PASSWORD_BUTTON = "Add New Password";
            public static final String CANCEL_BUTTON = "Cancel";
        }
        public final class PASSWORD_PAGE{
            public final class LEFT_PANEL{
                public static final String ADD_PASSWORD_BUTTON_TEXT = "Add New Password";
                public static final String LOGOUT_BUTTON_TEXT = "Logout";
            }

            public final class MAIN_PASSWORD_PAGE{
                public static final String PASSWORDS_TITLE = "Saved Passwords";
                public static final String NO_SAVED_PASSWORDS_TEXT = "There are currently no saved passwords";
            }
        }


        public static final String TITLE_BAR_TEXT = "Password Manager";
    }

    public enum WINDOW_PAGE_NUM {LOGIN, CREATE_USER, SAVED_PASSWORDS};
}
