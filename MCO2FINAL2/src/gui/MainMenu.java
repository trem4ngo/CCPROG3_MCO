package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{
    private JButton buttonCreate;
    private JButton buttonHotels;

    public MainMenu(){
        super();
        setLayout(new BorderLayout());
        setSize(350, 350);
        initialize();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initialize(){
        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.decode("#112D4E")); // Background Color of the head

        JLabel labelHead = new JLabel("Hotel Reservation System");
        labelHead.setForeground(Color.decode("#F9F7F7"));
        labelHead.setFont(new Font("Verdana" , Font.BOLD, 20));
        panelNorth.add(labelHead);

        this.add(panelNorth, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridBagLayout());
        Insets insets = new Insets(0,5,10,5);
        panelCenter.setBackground(Color.decode("#F9F7F7")); // Background color of the body

        buttonCreate = new JButton("Create");
        buttonCreate.setActionCommand("Create");
        buttonCreate.setBackground(Color.decode("#DBE2EF")); // Background color of buttons
        panelCenter.add(buttonCreate, new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        buttonHotels = new JButton("Hotels");
        buttonHotels.setActionCommand("Hotels");
        buttonHotels.setBackground(Color.decode("#DBE2EF"));
        panelCenter.add(buttonHotels, new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        this.add(panelCenter, BorderLayout.CENTER);
    }

    public void setActionListener(ActionListener listener){
        buttonCreate.addActionListener(listener);
        buttonHotels.addActionListener(listener);
    }
}
