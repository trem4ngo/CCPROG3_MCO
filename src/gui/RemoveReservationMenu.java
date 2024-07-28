package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class RemoveReservationMenu extends JFrame {
    private JComboBox<String> comboBoxRooms;
    private JComboBox<String> comboBoxReservations;

    private JButton buttonDone;
    private JButton buttonBack;

    public RemoveReservationMenu() {
        super();
        setLayout(new BorderLayout());
        setSize(350, 350);
        initialize();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initialize() {
        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.decode("#112D4E"));

        JLabel labelHead = new JLabel("Remove Reservation Menu");
        labelHead.setForeground(Color.decode("#F9F7F7"));
        labelHead.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(labelHead);

        this.add(panelNorth, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridBagLayout()); // Use GridBagLayout for better control over components
        panelCenter.setBackground(Color.decode("#F9F7F7"));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5); // Add some padding around the labels and comboboxes

        JLabel labelRoom = new JLabel("Select Room: ");
        labelRoom.setFont(new Font("Verdana", Font.PLAIN, 14));
        panelCenter.add(labelRoom, constraints);

        constraints.gridx = 1;
        comboBoxRooms = new JComboBox<>();
        comboBoxRooms.setFont(new Font("Verdana", Font.PLAIN, 14));
        panelCenter.add(comboBoxRooms, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel labelReservation = new JLabel("Select Reservation: ");
        labelReservation.setFont(new Font("Verdana", Font.PLAIN, 14));
        panelCenter.add(labelReservation, constraints);

        constraints.gridx = 1;
        comboBoxReservations = new JComboBox<>();
        comboBoxReservations.setFont(new Font("Verdana", Font.PLAIN, 14));
        panelCenter.add(comboBoxReservations, constraints);

        this.add(panelCenter, BorderLayout.CENTER);

        // SOUTH PANEL
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.decode("#F9F7F7"));

        buttonBack = new JButton("Back");
        buttonBack.setBackground(Color.decode("#DBE2EF"));
        panelSouth.add(buttonBack);

        buttonDone = new JButton("Done");
        buttonDone.setBackground(Color.decode("#DBE2EF"));
        panelSouth.add(buttonDone);

        this.add(panelSouth, BorderLayout.SOUTH);
    }

    public void setActionListener(ActionListener listener) {
        buttonBack.addActionListener(listener);
        buttonDone.addActionListener(listener);
    }

    public void setItemListener(ItemListener listener) {
        comboBoxRooms.addItemListener(listener);
    }

    public void updateRoomList(String[] roomNames) {
        comboBoxRooms.removeAllItems();
        for (String roomName : roomNames)
            comboBoxRooms.addItem(roomName);
    }

    public void updateReservationList(String[] reservationNames) {
        comboBoxReservations.removeAllItems();
        for (String reservationName : reservationNames)
            comboBoxReservations.addItem(reservationName);
    }

    public void showSuccess(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public String getSelectedRoom() {
        return (String) comboBoxRooms.getSelectedItem();
    }

    public String getSelectedReservation() {
        return (String) comboBoxReservations.getSelectedItem();
    }
}