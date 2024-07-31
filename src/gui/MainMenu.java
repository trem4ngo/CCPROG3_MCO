package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

/**
 * This class is for the GUI of the Main Menu.
 */
public class MainMenu extends JFrame{
    private JButton buttonCreate;
    private JButton buttonHotels;

    /**
     * Creates and instantiates the window for the Main Menu
     */
    public MainMenu(){
        super();
        setLayout(new BorderLayout());
        setSize(350, 350);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        initialize();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Initializes the layout of the window, its color, buttons, labels, etc.
     */
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

    /**
     * Listens for an action happening in the Main Menu.
     *
     * @param listener the listener for the event
     */
    public void setActionListener(ActionListener listener){
        buttonCreate.addActionListener(listener);
        buttonHotels.addActionListener(listener);
    }
}
