package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class AddRoomMenu extends JFrame{
    private JButton buttonDone;
    private JButton buttonBack;
    private JTextField textFieldNoOfRooms;

    // Drop down for roomType
    private JComboBox<String> comboBoxRoomType;

    public AddRoomMenu(){
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

        JLabel labelHead = new JLabel("Add Room Menu");
        labelHead.setForeground(Color.decode("#F9F7F7"));
        labelHead.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(labelHead);

        this.add(panelNorth, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridBagLayout());
        Insets insets1 = new Insets(0,30,10,0);
        Insets insets2 = new Insets(0,0,10,30);
        panelCenter.setBackground(Color.decode("#F9F7F7"));

        // Combobox Panel
        JLabel labelRoomType = new JLabel("Choose Room Type:");
        labelRoomType.setFont(new Font("Verdana", Font.BOLD, 12));
        panelCenter.add(labelRoomType, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets1, 0, 0));

        comboBoxRoomType = new JComboBox<>();
        comboBoxRoomType.addItem("Standard");
        comboBoxRoomType.addItem("Deluxe");
        comboBoxRoomType.addItem("Executive");
        comboBoxRoomType.setSelectedIndex(0);
        panelCenter.add(comboBoxRoomType, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets2, 0, 0));


        JLabel labelText = new JLabel("Enter No. of Rooms:");
        labelText.setFont(new Font("Verdana", Font.BOLD, 12));
        panelCenter.add(labelText, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets1, 0, 0));

        textFieldNoOfRooms = new JTextField(5);
        panelCenter.add(textFieldNoOfRooms, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets2, 0, 0));

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

    public void setDocumentListener(DocumentListener listener){
        textFieldNoOfRooms.getDocument().addDocumentListener(listener);
    }

    public void setItemListener(ItemListener listener){
        comboBoxRoomType.addItemListener(listener);
    }

    public int getNumOfRooms() {
        // Exception handling
        try {
            return Integer.parseInt(textFieldNoOfRooms.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            return 0;
        }
    }

    public String getRoomType() {
        return (String) comboBoxRoomType.getSelectedItem();
    }

    public void clearField() {
        textFieldNoOfRooms.setText("");
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showSuccess(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
