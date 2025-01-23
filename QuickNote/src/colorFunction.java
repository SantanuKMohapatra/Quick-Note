import java.awt.*;

public class colorFunction {
    GUI gui;

    public colorFunction(GUI gui){
        this.gui = gui;
    }
    public void changeColor(String color){
        switch (color){
            case "White":
                gui.window.getContentPane().setBackground(new Color(248, 248, 255));
                gui.textArea.setBackground(new Color(248, 248, 255));
                gui.textArea.setForeground(Color.BLACK);
                break;
            case "Black":
                gui.window.getContentPane().setBackground(new Color(27, 18, 18));
                gui.textArea.setBackground(new Color(27, 18, 18));
                gui.textArea.setForeground(Color.WHITE);
                break;
            case "Silver":
                gui.window.getContentPane().setBackground(Color.LIGHT_GRAY);
                gui.textArea.setBackground(Color.LIGHT_GRAY);
                gui.textArea.setForeground(Color.BLACK);
                break;
            case "Light Blue":
                gui.window.getContentPane().setBackground(new Color(28,186,186));
                gui.textArea.setBackground(new Color(28,186,186));
                gui.textArea.setForeground(Color.WHITE);
                break;
        }

    }
}
