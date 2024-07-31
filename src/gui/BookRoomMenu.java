package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class BookRoomMenu extends JFrame {
    private JButton buttonDone;
    private JButton buttonBack;

    private JComboBox<Integer> comboBoxCheckInDate;
    private JComboBox<Integer> comboBoxCheckOutDate;

    private JTextField textFieldGuestName;
    private JTextField textFieldDiscountCode;

    private JLabel labelRoomName;

    public BookRoomMenu(){
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

        labelRoomName = new JLabel("Book Room");
        labelRoomName.setForeground(Color.decode("#F9F7F7"));
        labelRoomName.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(labelRoomName);

        this.add(panelNorth, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridBagLayout());
        Insets insets1 = new Insets(0,30,30,0);
        Insets insets2 = new Insets(0,0,30,30);
        panelCenter.setBackground(Color.decode("#F9F7F7"));

        JLabel labelText1 = new JLabel("Enter Name:");
        labelText1.setFont(new Font("Verdana", Font.BOLD, 12));
        panelCenter.add(labelText1, new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets1, 0, 0));

        textFieldGuestName = new JTextField(15);
        panelCenter.add(textFieldGuestName, new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets2, 0, 0));

        JLabel labelText2 = new JLabel("Enter Discount Code:");
        labelText2.setFont(new Font("Verdana", Font.BOLD, 12));
        panelCenter.add(labelText2, new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets1, 0, 0));

        textFieldDiscountCode = new JTextField(15);
        panelCenter.add(textFieldDiscountCode, new GridBagConstraints(1, 2, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets2, 0, 0));

        JLabel labelText3 = new JLabel("Select Check-In Date:");
        labelText3.setFont(new Font("Verdana", Font.BOLD, 12));
        panelCenter.add(labelText3, new GridBagConstraints(0, 3, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets1, 0, 0));

        comboBoxCheckInDate = new JComboBox<>();
        for (int i = 1; i <= 30; i++)
            comboBoxCheckInDate.addItem(i);
        comboBoxCheckInDate.setSelectedIndex(0);

        panelCenter.add(comboBoxCheckInDate, new GridBagConstraints(1, 3, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets2, 0, 0));

        JLabel labelText4 = new JLabel("Select Check-Out Date:");
        labelText4.setFont(new Font("Verdana", Font.BOLD, 12));
        panelCenter.add(labelText4, new GridBagConstraints(0, 4, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets1, 0, 0));

        comboBoxCheckOutDate = new JComboBox<>();
        for (int i = 2; i <= 31; i++)
            comboBoxCheckOutDate.addItem(i);
        comboBoxCheckOutDate.setSelectedIndex(0);

        panelCenter.add(comboBoxCheckOutDate, new GridBagConstraints(1, 4, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets2, 0, 0));

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
        for (ActionListener al : buttonBack.getActionListeners())
            buttonBack.removeActionListener(al);
        for (ActionListener al : buttonDone.getActionListeners())
            buttonDone.removeActionListener(al);

        buttonBack.addActionListener(listener);
        buttonDone.addActionListener(listener);

    }

    public void setDocumentListener(DocumentListener listener){
        textFieldGuestName.getDocument().addDocumentListener(listener);
        textFieldDiscountCode.getDocument().addDocumentListener(listener);

    }

    public void setItemListener(ItemListener listener){
        comboBoxCheckInDate.addItemListener(listener);
        comboBoxCheckOutDate.addItemListener(listener);
    }

    public String getGuestName(){
        return textFieldGuestName.getText();
    }

    public String getDiscountCode(){
        return textFieldDiscountCode.getText();
    }

    public int getCheckInDate(){
        return (Integer)comboBoxCheckInDate.getSelectedItem();
    }

    public int getCheckOutDate(){
        return (Integer)comboBoxCheckOutDate.getSelectedItem();
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showSuccess(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setRoomName(String roomName) {
        labelRoomName.setText("Booking For Room: " + roomName);
    }

    public void clearFields() {
        textFieldGuestName.setText("");
        textFieldDiscountCode.setText("");
        comboBoxCheckInDate.setSelectedIndex(0);
        comboBoxCheckOutDate.setSelectedIndex(0);
    }

}
