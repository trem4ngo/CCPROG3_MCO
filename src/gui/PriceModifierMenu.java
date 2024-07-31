package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

/**
 * This class is for the GUI of the Price Modifier Menu. This has 2 buttons and 3 text fields.
 */

public class PriceModifierMenu extends JFrame {
    private JButton buttonDone;
    private JButton buttonBack;

    private JTextField textFieldModifier;
    private JTextField textFieldCheckInDate;
    private JTextField textFieldCheckOutDate;

    /**
     * Creates and instantiates the window for the Price Modifier Menu.
     */
    public PriceModifierMenu(){
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

        JLabel labelHead = new JLabel("Update Price Modifier");
        labelHead.setForeground(Color.decode("#F9F7F7"));
        labelHead.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(labelHead);

        this.add(panelNorth, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridBagLayout());
        Insets insets = new Insets(5, 5, 5, 5);
        panelCenter.setBackground(Color.decode("#F9F7F7"));

        JLabel labelModifier = new JLabel("Price Modifier (0.50 - 1.50):");
        panelCenter.add(labelModifier, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, insets, 0, 0));

        textFieldModifier = new JTextField(10);
        panelCenter.add(textFieldModifier, new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        JLabel labelCheckIn = new JLabel("Check-in Date (1-30):");
        panelCenter.add(labelCheckIn, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, insets, 0, 0));

        textFieldCheckInDate = new JTextField(10);
        panelCenter.add(textFieldCheckInDate, new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        JLabel labelCheckOut = new JLabel("Check-out Date (2-31):");
        panelCenter.add(labelCheckOut, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, insets, 0, 0));

        textFieldCheckOutDate = new JTextField(10);
        panelCenter.add(textFieldCheckOutDate, new GridBagConstraints(1, 2, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));

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
     * Listens for an action happening in the Price Modifier menu.
     *
     * @param listener the listener for the event
     */
    public void setActionListener(ActionListener listener){
        buttonDone.addActionListener(listener);
        buttonBack.addActionListener(listener);
    }

    /**
     * Takes the text in text field modifier.
     *
     * @return text field modifier
     */
    public String getModifier() {
        return textFieldModifier.getText();
    }

    /**
     * Takes the text in text field check in date.
     *
     * @return text field check in date
     */
    public String getCheckInDate() {
        return textFieldCheckInDate.getText();
    }

    /**
     * Takes the text in text field check-out date.
     *
     * @return text field check-out date
     */
    public String getCheckOutDate() {
        return textFieldCheckOutDate.getText();
    }

    /**
     * Clears the text fields.
     */
    public void clearFields() {
        textFieldModifier.setText("");
        textFieldCheckInDate.setText("");
        textFieldCheckOutDate.setText("");
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
