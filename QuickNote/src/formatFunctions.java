import java.awt.*;


public class formatFunctions {
     GUI gui;
     Font arial, verdana, sansSerif, timesNewRoman, lato;

     String selectedFont;

    public formatFunctions(GUI gui){

        this.gui = gui;
    }

    public void wordWrap(){
        if(gui.wordWrapOn == false){
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap: On");
        }
        else {
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap: Off");
        }
    }

    public void createFont(int fontSize){
        arial = new Font("Arial", Font.PLAIN,fontSize);
        verdana = new Font("Verdana", Font.PLAIN,fontSize);
        sansSerif = new Font("SansSerif", Font.PLAIN,fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
        lato = new Font("Lato",Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font){
        selectedFont = font;

        switch(selectedFont){
            case "Arial":
                gui.textArea.setFont(arial); break;
            case "Verdana":
                gui.textArea.setFont(verdana); break;
            case "SansSerif":
                gui.textArea.setFont(sansSerif); break;
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman); break;
            case "Lato":
                gui.textArea.setFont(lato); break;
        }

    }


}
