package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class ChooseHotelMenu extends JFrame {
    private JComboBox<String> comboBoxHotels;

    private JButton buttonDone;
    private JButton buttonBack;

    private JTextArea textArea;

    public ChooseHotelMenu(){
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


        JLabel labelHead = new JLabel("Hotel Menu");
        labelHead.setForeground(Color.decode("#F9F7F7"));
        labelHead.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(labelHead);

        this.add(panelNorth, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new FlowLayout());
        panelCenter.setBackground(Color.decode("#F9F7F7"));

        // Input high level information when hovering hotel
        JLabel labelHighLevelInfo = new JLabel("HIGH LEVEL INFO:");
        labelHighLevelInfo.setFont(new Font("Verdana", Font.BOLD, 15));
        panelCenter.add(labelHighLevelInfo);

        // Text Area
        textArea = new JTextArea(5, 20);
        textArea.setFont(new Font("Verdana", Font.PLAIN, 15));
        textArea.setEditable(false);
        panelCenter.add(textArea);

        // Hotel List -- Dropdown for selecting hotel
        JLabel labelHotelList = new JLabel("Hotel List:");
        labelHotelList.setForeground(Color.decode("#112D4E"));
        labelHotelList.setFont(new Font("Verdana", Font.PLAIN, 10));
        panelCenter.add(labelHotelList);


        // Dropdown for HotelList -- Gets Hotel List and converted to Hotel List to be used
        comboBoxHotels = new JComboBox<>();
        panelCenter.add(comboBoxHotels);

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

    public void updateHotelList(String[] hotelNames) {
        comboBoxHotels.removeAllItems();
        for (String hotelName : hotelNames)
            comboBoxHotels.addItem(hotelName);
    }

    public String getSelectedHotel() {
        return (String) comboBoxHotels.getSelectedItem();
    }

    public void setActionListener(ActionListener listener) {
        for (ActionListener al : buttonBack.getActionListeners())
            buttonBack.removeActionListener(al);
        for (ActionListener al : buttonDone.getActionListeners())
            buttonDone.removeActionListener(al);

        buttonBack.addActionListener(listener);
        buttonDone.addActionListener(listener);
    }

    public void setItemListener(ItemListener listener) {
        comboBoxHotels.addItemListener(listener);
    }

    public void setHighLevelInfo(String info) {
        textArea.setText(info);
    }
}
