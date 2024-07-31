package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

public class HotelInfoMenu extends JFrame {
    private JButton buttonAvailabilityChecker;
    private JButton buttonRoomViewer;
    private JButton buttonReservationViewer;
    private JButton buttonBack;

    public HotelInfoMenu() {
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

    private void initialize() {
        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.decode("#112D4E"));

        JLabel menuLabel = new JLabel("Low-Level Info Menu");
        menuLabel.setForeground(Color.decode("#F9F7F7"));
        menuLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(menuLabel);

        this.add(panelNorth, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridBagLayout());
        Insets insets = new Insets(0, 30, 5, 30);
        panelCenter.setBackground(Color.decode("#F9F7F7"));

        buttonAvailabilityChecker = new JButton("Availability Checker");
        buttonAvailabilityChecker.setActionCommand("Check Availability");
        buttonAvailabilityChecker.setBackground(Color.decode("#DBE2EF"));
        buttonAvailabilityChecker.setPreferredSize(new Dimension(200, 50));
        panelCenter.add(buttonAvailabilityChecker, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        buttonRoomViewer = new JButton("Room Viewer");
        buttonRoomViewer.setActionCommand("View Rooms");
        buttonRoomViewer.setBackground(Color.decode("#DBE2EF"));
        buttonRoomViewer.setPreferredSize(new Dimension(200, 50));
        panelCenter.add(buttonRoomViewer, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        buttonReservationViewer = new JButton("Reservation Viewer");
        buttonReservationViewer.setActionCommand("View Reservations");
        buttonReservationViewer.setBackground(Color.decode("#DBE2EF"));
        buttonReservationViewer.setPreferredSize(new Dimension(200, 50));
        panelCenter.add(buttonReservationViewer, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        this.add(panelCenter, BorderLayout.CENTER);

        // SOUTH PANEL
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSouth.setBackground(Color.decode("#F9F7F7"));

        buttonBack = new JButton("Back");
        buttonBack.setActionCommand("Back");
        buttonBack.setBackground(Color.decode("#DBE2EF"));
        buttonBack.setPreferredSize(new Dimension(100, 30));
        panelSouth.add(buttonBack);

        this.add(panelSouth, BorderLayout.SOUTH);
    }

    public void setActionListener(ActionListener listener) {
        buttonAvailabilityChecker.addActionListener(listener);
        buttonRoomViewer.addActionListener(listener);
        buttonReservationViewer.addActionListener(listener);
        buttonBack.addActionListener(listener);
    }
}