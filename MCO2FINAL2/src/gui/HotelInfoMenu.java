package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;

 class HotelInfoMenu extends JFrame{
    public HotelInfoMenu(){
        super();
        setLayout(new BorderLayout());
        setSize(350, 350);
        initialize();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initialize(){
        
    }

    public void setActionListener(ActionListener listener){

    }

    public void setDocumentListener(DocumentListener listener){

    }
}
