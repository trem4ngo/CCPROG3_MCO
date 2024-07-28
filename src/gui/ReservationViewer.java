package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class ReservationViewer extends JFrame {
    private JComboBox<String> comboBoxRooms;
    private JComboBox<String> comboBoxGuests;
    private JTextArea textAreaInfo;
    private JButton buttonBack;

    public ReservationViewer() {
        super("Reservation Viewer");
        setLayout(new BorderLayout());
        setSize(350, 350);
        initialize();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initialize() {
        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setBackground(Color.decode("#112D4E"));

        JLabel labelTitle = new JLabel("Reservation Viewer");
        labelTitle.setForeground(Color.WHITE);
        labelTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(labelTitle);

        add(panelNorth, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel panelCenter = new JPanel(new GridBagLayout());
        panelCenter.setBackground(Color.decode("#F9F7F7"));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelRooms = new JLabel("Select Room:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panelCenter.add(labelRooms, constraints);

        comboBoxRooms = new JComboBox<>();
        constraints.gridx = 1;
        constraints.gridy = 0;
        panelCenter.add(comboBoxRooms, constraints);

        JLabel labelGuests = new JLabel("Select Guest:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panelCenter.add(labelGuests, constraints);

        comboBoxGuests = new JComboBox<>();
        constraints.gridx = 1;
        constraints.gridy = 1;
        panelCenter.add(comboBoxGuests, constraints);

        textAreaInfo = new JTextArea(10, 25);
        textAreaInfo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaInfo);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        panelCenter.add(scrollPane, constraints);

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

    public void updateGuestList(String[] guestNames) {
        comboBoxGuests.removeAllItems();
        for (String guestName : guestNames) {
            comboBoxGuests.addItem(guestName);
        }
    }

    public String getSelectedRoom() {
        return (String) comboBoxRooms.getSelectedItem();
    }

    public String getSelectedGuest() {
        return (String) comboBoxGuests.getSelectedItem();
    }

    public void setReservationInfo(String info) {
        textAreaInfo.setText(info);
    }

    public void setActionListener(ActionListener listener) {
        buttonBack.addActionListener(listener);
    }

    public void setItemListener(ItemListener listener) {
        comboBoxRooms.addItemListener(listener);
        comboBoxGuests.addItemListener(listener);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}