package widgets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.password_Info;

public abstract class new_Password_Saver implements ActionListener { // Class creates an interface for an actionlistener to transfer data between pages.
        private password_Info saved_Info;

        public void set_Password_Info(password_Info saved_Info){
            this.saved_Info = saved_Info;
        }

        public String get_Website_Name(){
            return this.saved_Info.get_Website();
        }
        public String get_Username(){
            return this.saved_Info.get_Username();
        }
        public String get_Password(){
            return this.saved_Info.get_Password();
        }
        
        @Override
        public abstract void actionPerformed(ActionEvent e);


}
