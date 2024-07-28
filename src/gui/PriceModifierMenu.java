package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;

public class PriceModifierMenu extends JFrame {
    private JButton buttonDone;
    private JButton buttonBack;

    private JTextField textFieldModifier;
    private JTextField textFieldCheckInDate;
    private JTextField textFieldCheckOutDate;

    public PriceModifierMenu(){
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

    public void setActionListener(ActionListener listener){
        buttonDone.addActionListener(listener);
        buttonBack.addActionListener(listener);
    }

    public void setDocumentListener(DocumentListener listener){
        textFieldModifier.getDocument().addDocumentListener(listener);
        textFieldCheckInDate.getDocument().addDocumentListener(listener);
        textFieldCheckOutDate.getDocument().addDocumentListener(listener);
    }

    public String getModifier() {
        return textFieldModifier.getText();
    }

    public String getCheckInDate() {
        return textFieldCheckInDate.getText();
    }

    public String getCheckOutDate() {
        return textFieldCheckOutDate.getText();
    }

    public void clearFields() {
        textFieldModifier.setText("");
        textFieldCheckInDate.setText("");
        textFieldCheckOutDate.setText("");
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showSuccess(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
