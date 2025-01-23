public class editFunction {
    GUI gui;

    public editFunction(GUI gui){
        this.gui = gui;
    }
    public void undo(){
        gui.um.undo();
    }
    public void redo(){
        gui.um.redo();
    }
}
