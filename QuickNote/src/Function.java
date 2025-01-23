import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function {

    GUI gui;
    String fileName;
    String fileAddress;

    public Function(GUI gui){
        this.gui = gui;
    }
    public void newFile(){
        gui.textArea.setText("");
        gui.window.setTitle("Untitled");
        fileName = null;
        fileAddress = null;
    }
    public void open(){
        FileDialog dialog = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        dialog.setVisible(true);
        if(dialog.getFile() != null){
            fileName = dialog.getFile();
            fileAddress = dialog.getDirectory();
            gui.window.setTitle(fileName);
        }
        System.out.println("File address and File name:" + fileAddress + fileName);

        try{
            //Used to address and read a file
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText("");
            String line = null;
            while((line = br.readLine())!=null){
                gui.textArea.append(line + "\n");
            }
            br.close();
        }
        catch (Exception e){
            System.out.println("File Not Found!");
        }
    }

    public void save(){
        if(fileName==null){
            saveAs();
        }
        else{
            try{
                FileWriter writer = new FileWriter(fileAddress+fileName);
                writer.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                writer.close();

            }
            catch (Exception e){
                System.out.println("File Not Found!");
            }
        }
    }
    public void saveAs(){
        FileDialog dialog = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        dialog.setVisible(true);

        if(dialog.getFile()!=null){
            fileName = dialog.getFile();
            fileAddress = dialog.getDirectory();
            gui.window.setTitle(fileName);
        }

        try{
            FileWriter writer = new FileWriter(fileAddress+fileName);
            writer.write(gui.textArea.getText());
            writer.close();
        }
        catch (Exception e){
            System.out.println("Cannot write the file!");
        }
    }

    public void exit(){
        System.exit(0);
    }


}
