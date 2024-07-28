package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class ChooseRoomMenu extends JFrame {
    private JComboBox<String> comboBoxRooms;

    private JButton buttonDone;
    private JButton buttonBack;

    public ChooseRoomMenu(){
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

    public void setActionListener(ActionListener listener){
        buttonBack.addActionListener(listener);
        buttonDone.addActionListener(listener);
    }

    public void setItemListener (ItemListener listener) {
        comboBoxRooms.addItemListener(listener);
    }

    public void updateRoomList(String[] roomNames) {
        comboBoxRooms.removeAllItems();
        for (String roomName : roomNames)
            comboBoxRooms.addItem(roomName);
    }

    public String getSelectedRoom() {
        return (String) comboBoxRooms.getSelectedItem();
    }
}
