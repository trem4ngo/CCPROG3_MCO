package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;

public class MainHotelMenu extends JFrame{
    private JButton buttonHotelViewer;
    private JButton buttonHotelManager;
    private JButton buttonBookARoom;
    private JButton buttonBack;

    private JLabel hotelLabel;

    public MainHotelMenu() {
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

        hotelLabel = new JLabel("Hotel Name");
        hotelLabel.setForeground(Color.decode("#F9F7F7"));
        hotelLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(hotelLabel);

        this.add(panelNorth, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridBagLayout());
        Insets insets = new Insets(0,30,5,30);
        panelCenter.setBackground(Color.decode("#F9F7F7"));

        buttonHotelViewer = new JButton("Hotel Viewer");
        buttonHotelViewer.setActionCommand("View Hotel");
        buttonHotelViewer.setBackground(Color.decode("#DBE2EF"));
        buttonHotelViewer.setPreferredSize(new Dimension(150, 50));
        panelCenter.add(buttonHotelViewer, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        buttonHotelManager = new JButton("Hotel Manager");
        buttonHotelManager.setActionCommand("Manage Hotel");
        buttonHotelManager.setBackground(Color.decode("#DBE2EF"));
        buttonHotelManager.setPreferredSize(new Dimension(150, 50));
        panelCenter.add(buttonHotelManager, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        buttonBookARoom = new JButton("Book A Room");
        buttonBookARoom.setActionCommand("Book Room");
        buttonBookARoom.setBackground(Color.decode("#DBE2EF"));
        buttonBookARoom.setPreferredSize(new Dimension(150, 50));
        panelCenter.add(buttonBookARoom, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        buttonBack = new JButton("Back");
        buttonBack.setActionCommand("Back");
        buttonBack.setBackground(Color.decode("#DBE2EF"));
        buttonBack.setPreferredSize(new Dimension(150, 50));
        panelCenter.add(buttonBack, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        this.add(panelCenter, BorderLayout.CENTER);
    }

    public void setActionListener(ActionListener listener){
        buttonHotelViewer.addActionListener(listener);
        buttonHotelManager.addActionListener(listener);
        buttonBookARoom.addActionListener(listener);
        buttonBack.addActionListener(listener);
    }

    public void setHotelName(String hotelName) {
        hotelLabel.setText("Selected Hotel: " + hotelName);
    }

}
