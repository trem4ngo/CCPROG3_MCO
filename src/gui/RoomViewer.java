package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 * This class is for the GUI of the Room viewer. It has 1 combo box, 1 text area info, and 1 button.
 */

public class RoomViewer extends JFrame {
    private JComboBox<String> comboBoxRooms;
    private JTextArea textAreaInfo;
    private JButton buttonBack;

    /**
     * Creates and instantiates the window for the Room viewer.
     */
    public RoomViewer() {
        super("Room Viewer");
        setLayout(new BorderLayout());
        setSize(350, 350);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        initialize();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * Initializes the layout of the window, its color, buttons, labels, etc.
     */
    private void initialize() {
        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setBackground(Color.decode("#112D4E"));

        JLabel labelTitle = new JLabel("Room Viewer");
        labelTitle.setForeground(Color.WHITE);
        labelTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(labelTitle);

        add(panelNorth, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel panelCenter = new JPanel(new FlowLayout());
        panelCenter.setBackground(Color.decode("#F9F7F7"));

        JLabel labelRooms = new JLabel("Select Room:");
        panelCenter.add(labelRooms);

        comboBoxRooms = new JComboBox<>();
        panelCenter.add(comboBoxRooms);

        textAreaInfo = new JTextArea(10, 25);
        textAreaInfo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaInfo);
        panelCenter.add(scrollPane);

        add(panelCenter, BorderLayout.CENTER);

        // SOUTH PANEL
        JPanel panelSouth = new JPanel(new FlowLayout());
        panelSouth.setBackground(Color.decode("#F9F7F7"));
        buttonBack = new JButton("Back");
        buttonBack.setBackground(Color.decode("#DBE2EF"));
        panelSouth.add(buttonBack);
        add(panelSouth, BorderLayout.SOUTH);
    }

    /**
     * Updates the room list inside the combo box of rooms.
     *
     * @param roomNames the list of room names
     */
    public void updateRoomList(String[] roomNames) {
        comboBoxRooms.removeAllItems();
        for (String roomName : roomNames) {
            comboBoxRooms.addItem(roomName);
        }
    }

    /**
     * Gets the selected room.
     *
     * @return the combo box room
     */
    public String getSelectedRoom() {
        return (String) comboBoxRooms.getSelectedItem();
    }

    /**
     * Sets the room information.
     *
     * @param info the room information
     */
    public void setRoomInfo(String info) {
        textAreaInfo.setText(info);
    }

    /**
     * Listens for an action happening in the Room viewer.
     *
     * @param listener the listener for the event
     */
    public void setActionListener(ActionListener listener) {
        buttonBack.addActionListener(listener);
    }

    /**
     * Listens for an action happening in the combo box for rooms.
     *
     * @param listener the listener for the event
     */
    public void setItemListener(ItemListener listener) {
        comboBoxRooms.addItemListener(listener);
    }
}