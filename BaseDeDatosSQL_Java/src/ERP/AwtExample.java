package ERP;

import java.awt.*;
import java.awt.event.*;

public class AwtExample extends Frame {
  public AwtExample() {
    Button button = new Button("Button");
    Label label = new Label("Muestralo");
    
    Choice choice = new Choice();
    choice.addItem("Pedro");
    choice.addItem("Luis");
    choice.addItem("Mario");

    List list = new List();
    TextField textField = new TextField();
    
    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox checkbox = new Checkbox("Alto", cbg,true);
    Checkbox checkbox2 = new Checkbox("Medio", cbg,false);
    Checkbox checkbox3 = new Checkbox("Bajo", cbg,false);
    /*
     * Text Area - Scrollbar - Canvas - Menu - MenuBar - PopUpMenu
     * 
     * Panel - Frame - Dialog - ScrollPane
     */

    button.setBounds(50, 50, 50, 50);
    add(label);
    add(button);
    add(choice);
    add(checkbox);
    add(checkbox2);
    add(checkbox3);
    add(textField);
    add(list);
    setSize(1200, 740);
    setTitle("This is my First AWT example");
    setLayout(new FlowLayout());
    setVisible(true);
    
    addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
            dispose();
        }
    });
  }

  public static void main(String args[]){
    new AwtExample();
  }
}
