package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 * This class is for the GUI of the Availability Checker. It has 1 combo box, 1 text area info, and 1 button.
 */
public class AvailabilityChecker extends JFrame {
    private JComboBox<Integer> comboBoxDays;
    private JTextArea textAreaInfo;
    private JButton buttonBack;

    /**
     * Creates and instantiates the window for the Availability Checker.
     */
    public AvailabilityChecker() {
        super("Availability Checker");
        setLayout(new BorderLayout());
        setSize(350, 350);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        initialize();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * Initializes the layout of the window, its color, buttons, labels, etc.
     */
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

    /**
     * Sets the availability info in the text area info.
     *
     * @param info the availability info
     */
    public void setAvailabilityInfo(String info) {
        textAreaInfo.setText(info);
    }

    /**
     * Listens for an action happening in the Main Menu.
     *
     * @param listener the listener for the event
     */
    public void setActionListener(ActionListener listener) {
        buttonBack.addActionListener(listener);
    }

    /**
     * Listens for an action happening in the Main Menu.
     *
     * @param listener the listener for the event
     */
    public void setItemListener(ItemListener listener) {
        comboBoxDays.addItemListener(listener);
    }
}