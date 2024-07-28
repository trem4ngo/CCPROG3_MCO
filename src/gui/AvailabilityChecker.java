package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class AvailabilityChecker extends JFrame {
    private JComboBox<Integer> comboBoxDays;
    private JTextArea textAreaInfo;
    private JButton buttonBack;

    public AvailabilityChecker() {
        super("Availability Checker");
        setLayout(new BorderLayout());
        setSize(350, 350);
        initialize();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initialize() {
        JPanel panelNorth = new JPanel();
        panelNorth.setBackground(Color.decode("#112D4E"));
        JLabel labelTitle = new JLabel("Availability Checker");
        labelTitle.setForeground(Color.WHITE);
        labelTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(labelTitle);
        add(panelNorth, BorderLayout.NORTH);

        JPanel panelCenter = new JPanel(new FlowLayout());
        panelCenter.setBackground(Color.decode("#F9F7F7"));

        JLabel labelDays = new JLabel("Select Day:");
        panelCenter.add(labelDays);

        comboBoxDays = new JComboBox<>();
        for (int i = 1; i <= 31; i++)
            comboBoxDays.addItem(i);
        comboBoxDays.setSelectedIndex(0);
        panelCenter.add(comboBoxDays);

        textAreaInfo = new JTextArea(10, 25);
        textAreaInfo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaInfo);
        panelCenter.add(scrollPane);

        add(panelCenter, BorderLayout.CENTER);

        JPanel panelSouth = new JPanel(new FlowLayout());
        panelSouth.setBackground(Color.decode("#F9F7F7"));
        buttonBack = new JButton("Back");
        buttonBack.setBackground(Color.decode("#DBE2EF"));
        panelSouth.add(buttonBack);
        add(panelSouth, BorderLayout.SOUTH);
    }

    public int getSelectedDay() {
        return (Integer)comboBoxDays.getSelectedItem();
    }

    public void setAvailabilityInfo(String info) {
        textAreaInfo.setText(info);
    }

    public void setActionListener(ActionListener listener) {
        buttonBack.addActionListener(listener);
    }

    public void setItemListener(ItemListener listener) {
        comboBoxDays.addItemListener(listener);
    }
}