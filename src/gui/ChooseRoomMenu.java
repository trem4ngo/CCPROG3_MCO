package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 * This class is for the GUI of the Choose Room menu. It has 1 combo box and 2 buttons.
 */
public class ChooseRoomMenu extends JFrame {
    private JComboBox<String> comboBoxRooms;

    private JButton buttonDone;
    private JButton buttonBack;

    /**
     * Creates and instantiates the window for the Choose Room menu.
     */
    public ChooseRoomMenu(){
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
        panelNorth.setBackground(Color.decode("#112D4E"));

        JLabel labelHead = new JLabel("Choose Room Menu");
        labelHead.setForeground(Color.decode("#F9F7F7"));
        labelHead.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(labelHead);

        this.add(panelNorth, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridBagLayout());
        panelCenter.setBackground(Color.decode("#F9F7F7"));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;

        // Room List -- Dropdown for selecting Room
        JLabel labelRoomList = new JLabel("Room List: ");
        labelRoomList.setForeground(Color.decode("#112D4E"));
        labelRoomList.setFont(new Font("Verdana", Font.BOLD, 16));
        panelCenter.add(labelRoomList, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;

        comboBoxRooms = new JComboBox<>();
        panelCenter.add(comboBoxRooms, constraints);

        this.add(panelCenter, BorderLayout.CENTER);

        // SOUTH PANEL
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.decode("#F9F7F7"));

        buttonBack = new JButton("Back");
        buttonBack.setActionCommand("Back");
        buttonBack.setBackground(Color.decode("#DBE2EF"));
        panelSouth.add(buttonBack);

        buttonDone = new JButton("Done");
        buttonDone.setActionCommand("Done");
        buttonDone.setBackground(Color.decode("#DBE2EF"));
        panelSouth.add(buttonDone);

        this.add(panelSouth, BorderLayout.SOUTH);
    }

    /**
     * Listens for an action happening in the Choose Room menu.
     *
     * @param listener the listener for the event
     */
    public void setActionListener(ActionListener listener){
        buttonBack.addActionListener(listener);
        buttonDone.addActionListener(listener);
    }

    /**
     * Listens for an action happening in the combo box of rooms.
     *
     * @param listener the listener for the event
     */
    public void setItemListener (ItemListener listener) {
        comboBoxRooms.addItemListener(listener);
    }

    /**
     * Updates the room list in the combo box.
     *
     * @param roomNames the list of room names
     */
    public void updateRoomList(String[] roomNames) {
        comboBoxRooms.removeAllItems();
        for (String roomName : roomNames)
            comboBoxRooms.addItem(roomName);
    }

    /**
     * Gets selected room.
     *
     * @return combo box rooms
     */
    public String getSelectedRoom() {
        return (String) comboBoxRooms.getSelectedItem();
    }
}
