package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class RoomViewer extends JFrame {
    private JComboBox<String> comboBoxRooms;
    private JTextArea textAreaInfo;
    private JButton buttonBack;

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

    public void updateRoomList(String[] roomNames) {
        comboBoxRooms.removeAllItems();
        for (String roomName : roomNames) {
            comboBoxRooms.addItem(roomName);
        }
    }

    public String getSelectedRoom() {
        return (String) comboBoxRooms.getSelectedItem();
    }

    public void setRoomInfo(String info) {
        textAreaInfo.setText(info);
    }

    public void setActionListener(ActionListener listener) {
        buttonBack.addActionListener(listener);
    }

    public void setItemListener(ItemListener listener) {
        comboBoxRooms.addItemListener(listener);
    }
}