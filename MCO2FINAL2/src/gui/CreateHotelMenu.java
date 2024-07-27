package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;

public class CreateHotelMenu extends JFrame{
    private JTextField textFieldHotelName;
    private JButton buttonCreate;
    private JButton buttonCancel;

    public CreateHotelMenu(){
        super();
        setLayout(new BorderLayout());
        setSize(350, 350);
        initialize();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initialize(){
        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.decode("#112D4E"));

        JLabel labelHead = new JLabel("Create Menu");
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

        JLabel labelText = new JLabel("Enter Name:");
        labelText.setFont(new Font("Verdana", Font.BOLD, 12));
        panelCenter.add(labelText, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets1, 0, 0));

        textFieldHotelName = new JTextField(15);
        panelCenter.add(textFieldHotelName, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets2, 0, 0));

        this.add(panelCenter, BorderLayout.CENTER);

        // SOUTH PANEL
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.decode("#F9F7F7"));

        buttonCancel = new JButton("Cancel");
        buttonCancel.setBackground(Color.decode("#DBE2EF"));
        panelSouth.add(buttonCancel);

        buttonCreate = new JButton("Create");
        buttonCreate.setBackground(Color.decode("#DBE2EF"));
        panelSouth.add(buttonCreate);

        this.add(panelSouth, BorderLayout.SOUTH);
    }

    public void setActionListener(ActionListener listener){
        buttonCreate.addActionListener(listener);
        buttonCancel.addActionListener(listener);
    }

    public void setDocumentListener(DocumentListener listener){
        textFieldHotelName.getDocument().addDocumentListener(listener);
    }

    public String getHotelName() {
        return textFieldHotelName.getText();
    }

    public void clearField() {
        textFieldHotelName.setText("");
    }
}
