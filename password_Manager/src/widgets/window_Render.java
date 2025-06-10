package widgets;

import javax.swing.JFrame;

import constants.constants.custom_String;

public class window_Render extends JFrame{
// Private 
    private void set_Default_Window_Data(){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setTitle(custom_String.title_Bar_Text);
        super.setResizable(false); // Constant size by default.
        super.setLocation(300, 200);
    }

    // Public 
    public window_Render(){
        set_Default_Window_Data();
        
    }

    public void clear_Window(){ // Clears all of the contents from the window. Used for changing contents.
        super.getContentPane().removeAll();
        super.revalidate();
        super.repaint();
    }

}
