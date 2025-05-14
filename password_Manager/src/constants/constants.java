package constants;

import java.awt.Font;

public final class constants {

    private constants(){
        // You shall not call!
    }

    public final class login_Window { // Holds the login window dimensions.
        public static final int login_Window_Height = 200;
        public static final int login_Window_Width = 500;
        public static final int left_Bound_X = login_Window_Width/3;
        public static final int top_Bound_Y = 20;

    }
    

    public final class custom_Font_Settings extends Font{
        private static final int font_Size = 18;
        private static final String font_Name = "Arial";
        
        public custom_Font_Settings(){ // Sets the font to the constant value below.
            super(font_Name, Font.PLAIN, font_Size); // Call the "Font" constructor.
        }
    }

}
