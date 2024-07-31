package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 * This class is for the GUI of the Remove Reservation Menu. It has 2 combo boxes and 2 buttons.
 */
public class RemoveReservationMenu extends JFrame {
    private JComboBox<String> comboBoxRooms;
    private JComboBox<String> comboBoxReservations;

    private JButton buttonDone;
    private JButton buttonBack;

    /**
     * Creates and instantiates the window for the Remove Reservation Menu.
     */
    public RemoveReservationMenu() {
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

    /**
     * Listens for an action happening in the Remove Reservation Menu.
     *
     * @param listener the listener for the event
     */
    public void setActionListener(ActionListener listener) {
        buttonBack.addActionListener(listener);
        buttonDone.addActionListener(listener);
    }

    /**
     * Listens for an action happening in the combo boxes.
     *
     * @param listener the listener for the event
     */
    public void setItemListener(ItemListener listener) {
        comboBoxRooms.addItemListener(listener);
    }

    public void updateRoomList(String[] roomNames) {
        comboBoxRooms.removeAllItems();
        for (String roomName : roomNames)
            comboBoxRooms.addItem(roomName);
    }

    /**
     * Updates the list of reservations in the combo box.
     *
     * @param reservationNames the list of reservation names
     */
    public void updateReservationList(String[] reservationNames) {
        comboBoxReservations.removeAllItems();
        for (String reservationName : reservationNames)
            comboBoxReservations.addItem(reservationName);
    }

    /**
     * A message dialog to show that an error occurred.
     *
     * @param message the error message
     */
    public void showSuccess(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * A message dialog to show that the action was a success.
     *
     * @param message the success message
     */
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Gets the selected room from the combobox.
     *
     * @return the selected room
     */
    public String getSelectedRoom() {
        return (String) comboBoxRooms.getSelectedItem();
    }

    /**
     * Gets the selected Reservation from the combobox.
     *
     * @return the selected Reservation
     */
    public String getSelectedReservation() {
        return (String) comboBoxReservations.getSelectedItem();
    }
}