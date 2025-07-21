package widgets;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import classes.password_Info;

public class add_Password_Listener{
    private password_Info information;
    private ActionListener listener;

    public add_Password_Listener(ActionListener listener){
        this.listener = listener;
    }

    public void set_Password_Info(password_Info information){
        this.information = information;
    }

    public password_Info get_Password_Info(){
        return this.information;
    }

    public void actionPerformed(ActionEvent e){
        listener.actionPerformed(e);
    }
}
