import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;



public class window {
    JFrame display;
    int dimen = 400;

    private class pages{
        final static String PAGE1 = "PAGE1";
        final static String PAGE2 = "PAGE2";
    }

    private String current_Page;

    CardLayout set_Layout = new CardLayout();

    JPanel parent_Page = new JPanel(set_Layout);


    JButton first_Button = new JButton("Go to page 2");
    JButton second_Button = new JButton("Go to page 1");

    JPanel get_First_Page(){
        JPanel panel = new JPanel();
        JButton extra_Button = new JButton("Say Hello");

        panel.setBackground(Color.red);
        panel.add(first_Button);
        panel.add(extra_Button);

        extra_Button.addActionListener(
            (e) -> {
                System.out.println("Hello");
            }
        );

        return panel;
    }

    JPanel get_Second_Page(){
        JPanel panel = new JPanel();
        JButton extra_Button = new JButton("Say Goodbye");

        panel.setBackground(Color.BLUE);
        panel.add(second_Button);
        panel.add(extra_Button);

        extra_Button.addActionListener(
            (e) -> {
                System.out.println("Goodbye");
            }
        );


        return panel;
    }

    private void navigate_Page(String page){ // Naviagte page
        current_Page = page;
        set_Layout.show(parent_Page, page);

        switch (page) {
            case pages.PAGE1:
                display.setSize(dimen, dimen);
                break;
            case pages.PAGE2:
                display.setSize(300, 300);
                break;
        
            default:
                break;
        }
    }

    public window(){
        display = new JFrame();

        parent_Page.add(get_First_Page(), pages.PAGE1); // Adds the page Page1 to the parent page with card layout.
        parent_Page.add(get_Second_Page(), pages.PAGE2); // Adds page Page2 to page with card layout.
        
        first_Button.addActionListener( 
            (e)->{
                navigate_Page(pages.PAGE2);
            }
        );
        second_Button.addActionListener( 
            (e)->{
                navigate_Page(pages.PAGE1);
            }
        );
                
        navigate_Page(pages.PAGE1); // Sets the first page by default.
        display.add(parent_Page);
        display.setDefaultCloseOperation(display.EXIT_ON_CLOSE);
        display.setVisible(true);
    }
}
