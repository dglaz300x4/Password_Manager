import pages.window_Manager;
import widgets.window_Render;


public class App {
    static window_Manager open;

    public static void main(String[] args) throws Exception {
        window_Render window = new window_Render();
        window.setLocation(300,200);

        open = new window_Manager(true, window);
    }
}
