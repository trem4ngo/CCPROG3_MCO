package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

/**
 * This class is for the GUI of the Hotel Manager menu. It has 8 buttons and a label.
 */
public class HotelManagerMenu extends JFrame{
    private JButton buttonChangeName;
    private JButton buttonUpdatePrices;
    private JButton buttonAddRoom;
    private JButton buttonRemoveRoom;
    private JButton buttonRemoveReservation;
    private JButton buttonDemolishHotel;
    private JButton buttonUpdatePriceModifier;
    private JButton buttonBack;

    private JLabel hotelLabel;

    /**
     * Creates and instantiates the window for the Hotel Manager Menu
     */
    public HotelManagerMenu(){
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

        hotelLabel = new JLabel("Hotel Name");
        hotelLabel.setForeground(Color.decode("#F9F7F7"));
        hotelLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(hotelLabel);

        this.add(panelNorth, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridBagLayout());
        Insets insets1 = new Insets(0,30,5,30);
        Insets insets2 = new Insets(0,30,5,5);
        Insets insets3 = new Insets(0,5,5,30);
        panelCenter.setBackground(Color.decode("#F9F7F7"));

        buttonChangeName = new JButton("Change Name");
        buttonChangeName.setActionCommand("Change");
        buttonChangeName.setBackground(Color.decode("#DBE2EF"));
        panelCenter.add(buttonChangeName, new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets1, 0, 0));

        buttonAddRoom = new JButton("Add Room");
        buttonAddRoom.setActionCommand("Add");
        buttonAddRoom.setBackground(Color.decode("#DBE2EF"));
        panelCenter.add(buttonAddRoom, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets2, 0, 0));

        buttonRemoveRoom = new JButton("Remove Room");
        buttonRemoveRoom.setActionCommand("Remove Room");
        buttonRemoveRoom.setBackground(Color.decode("#DBE2EF"));
        panelCenter.add(buttonRemoveRoom, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets3, 0, 0));

        buttonUpdatePrices = new JButton("Update Prices");
        buttonUpdatePrices.setActionCommand("Update");
        buttonUpdatePrices.setBackground(Color.decode("#DBE2EF"));
        panelCenter.add(buttonUpdatePrices, new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets1, 0, 0));

        buttonUpdatePriceModifier = new JButton("Update Price Modifier");
        buttonUpdatePriceModifier.setActionCommand("UpdateModifier");
        buttonUpdatePriceModifier.setBackground(Color.decode("#DBE2EF"));
        panelCenter.add(buttonUpdatePriceModifier, new GridBagConstraints(0, 3, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets1, 0, 0));

        buttonRemoveReservation = new JButton("Remove Reservation");
        buttonRemoveReservation.setActionCommand("Remove Reservation");
        buttonRemoveReservation.setBackground(Color.decode("#DBE2EF"));
        panelCenter.add(buttonRemoveReservation, new GridBagConstraints(0, 4, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets1, 0, 0));

        buttonDemolishHotel = new JButton("Demolish");
        buttonDemolishHotel.setActionCommand("Demolish Hotel");
        buttonDemolishHotel.setBackground(Color.decode("#DBE2EF"));
        panelCenter.add(buttonDemolishHotel, new GridBagConstraints(0, 5, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets1, 0, 0));

        buttonBack = new JButton("Back");
        buttonBack.setActionCommand("Back");
        buttonBack.setBackground(Color.decode("#DBE2EF"));
        panelCenter.add(buttonBack, new GridBagConstraints(0, 6, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets1, 0, 0));

        this.add(panelCenter, BorderLayout.CENTER);

        // SOUTH PANEL
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.decode("#112D4E"));

        JLabel labelHotelName = new JLabel("Hotel Manager");
        labelHotelName.setForeground(Color.decode("#F9F7F7"));
        labelHotelName.setFont(new Font("Verdana", Font.BOLD, 10));
        panelSouth.add(labelHotelName);

        this.add(panelSouth, BorderLayout.SOUTH);
    }

    /**
     * Listens for an action happening in the Main Menu.
     *
     * @param listener the listener for the event
     */
    public void setActionListener(ActionListener listener){
        buttonChangeName.addActionListener(listener);
        buttonAddRoom.addActionListener(listener);
        buttonRemoveRoom.addActionListener(listener);
        buttonUpdatePrices.addActionListener(listener);
        buttonUpdatePriceModifier.addActionListener(listener);
        buttonRemoveReservation.addActionListener(listener);
        buttonDemolishHotel.addActionListener(listener);
        buttonBack.addActionListener(listener);
    }

    /**
     * Sets the hotel name in the label.
     *
     * @param hotelName the hotel's name
     */
    public void setHotelName(String hotelName) {
        hotelLabel.setText("Selected Hotel: " + hotelName);
    }

    /**
     * A message dialog to show that an error occurred.
     *
     * @param message the error message
     */
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * A message dialog to show that the action was a success.
     *
     * @param message the success message
     */
    public void showSuccess(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
