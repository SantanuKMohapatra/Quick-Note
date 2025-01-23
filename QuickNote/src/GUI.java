import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI implements ActionListener {

    // creates a window or a frame where we can add components like labels
    JFrame window;

    // Multi-line area that displays plain text
    // Text Area
    JTextArea textArea;

    // Creates a scroll-bar to scroll the text
    JScrollPane scrollPane;

    boolean wordWrapOn = false;

    // Create a top menu-bar
    // Top Menu Bar
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;

    // File Menu
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    //Edit Menu
    JMenuItem iUndo, iRedo;

    Function file = new Function(this);
    formatFunctions format = new formatFunctions(this);

    // Format menu
    JMenuItem iWrap, iFontArial, iFontVerdana, iFontSansSerif, iFontTimesNewRoman, iFontLato;
    JMenuItem iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    JMenu menuFont, menuFontSize;
    // Color Menu
    JMenuItem iColor1, iColor2, iColor3, iColor4;
    Function function = new Function(this);
    editFunction edit = new editFunction(this);

    formatFunctions functions = new formatFunctions(this);
    colorFunction color = new colorFunction(this);

    KeyHandler handler = new KeyHandler(this);

    UndoManager um = new UndoManager();

    public static void main(String[] args) {

        new GUI();
    }
    public GUI(){

        // calls the createWindow function
        createWindow();

        // calls the textArea function
        createTextArea();

        createMenuBar();

        createFileMenu();

        createEditMenu();

        createFormatMenu();

        createColorMenu();

        format.selectedFont = "Arial";
        format.createFont(16);
        format.wordWrap();
        color.changeColor("White");

        // the window is always visible
        window.setVisible(true);

    }

    public void createWindow(){

         // sets title of the application
         window = new JFrame("Quick Note");

         // sets the size or the frame of the window
         window.setSize(800,600);

         // closes the window
         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void createTextArea(){

        textArea = new JTextArea();
        textArea.setFont(functions.arial);

        textArea.addKeyListener(handler);

        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        um.addEdit(e.getEdit());
                    }
                }
        );
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                               JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar(){

        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);

    }

    public void createFileMenu(){
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New"); // A string value can be set to trigger the ActionListener on this item
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("SaveAs");
        menuFile.add(iSaveAs);
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }
    public void createEditMenu(){
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
    }

    public void createFormatMenu(){
        iWrap = new JMenuItem("Word wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);
        
        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontVerdana = new JMenuItem("Verdana");
        iFontVerdana.addActionListener(this);
        iFontVerdana.setActionCommand("Verdana");
        JMenuItem add = menuFont.add(iFontVerdana);

        iFontSansSerif = new JMenuItem("Sans Serif");
        iFontSansSerif.addActionListener(this);
        iFontSansSerif.setActionCommand("SansSerif");
        menuFont.add(iFontSansSerif);

        iFontTimesNewRoman = new JMenuItem("Times New Roman");
        iFontTimesNewRoman.addActionListener(this);
        iFontTimesNewRoman.setActionCommand("Times New Roman");
        menuFont.add(iFontTimesNewRoman);

        iFontLato = new JMenuItem("Lato");
        iFontLato.addActionListener(this);
        iFontLato.setActionCommand("Lato");
        menuFont.add(iFontLato);
                

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("size28");
        menuFontSize.add(iFontSize28);

    }

    public void createColorMenu(){
        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Light Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Light Blue");
        menuColor.add(iColor3);

        iColor4 = new JMenuItem("Silver");
        iColor4.addActionListener(this);
        iColor4.setActionCommand("Silver");
        menuColor.add(iColor4);
    }

    @Override
    public  void actionPerformed(ActionEvent e){

        String command = e.getActionCommand();

        switch (command){
            case "New": function.newFile(); break;
            case "Open": function.open(); break;
            case "Save": function.save(); break;
            case "SaveAs": function.saveAs(); break;
            case "Exit": function.exit(); break;
            case "Undo": edit.undo(); break;
            case "Redo": edit.redo(); break;
            case "Word Wrap": format.wordWrap(); break;
            case "Arial": format.setFont(command); break;
            case "Verdana": format.setFont(command); break;
            case "SansSerif": format.setFont(command); break;
            case "Times New Roman": format.setFont(command); break;
            case "Lato": format.setFont(command); break;
            case "size8": format.createFont(8); break;
            case "size12": format.createFont(12); break;
            case "size16": format.createFont(16); break;
            case "size20": format.createFont(20); break;
            case "size24": format.createFont(24); break;
            case "size28": format.createFont(28); break;
            case "White": color.changeColor(command); break;
            case "Black": color.changeColor(command); break;
            case "Light Blue": color.changeColor(command); break;
            case "Silver": color.changeColor(command); break;


        }

    }


}