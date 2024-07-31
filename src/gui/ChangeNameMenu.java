package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

/**
 * This class is for the GUI of the Change Name Menu. It has 1 text field and 2 buttons.
 */
public class ChangeNameMenu extends JFrame{
    private JTextField textFieldNewName;
    private JButton buttonBack;
    private JButton buttonDone;

    /**
     * Creates and instantiates the window for the Change Name Menu.
     */
    public ChangeNameMenu(){
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

        JLabel labelHead = new JLabel("Change Name Menu");
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

        JLabel labelText = new JLabel("Enter Name: ");
        labelText.setFont(new Font("Verdana", Font.BOLD, 12));
        panelCenter.add(labelText, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets1, 0, 0));

        textFieldNewName = new JTextField(15);
        panelCenter.add(textFieldNewName, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets2, 0, 0));

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
     * Listens for an action happening in the Change Name Menu.
     *
     * @param listener the listener for the event
     */
    public void setActionListener(ActionListener listener){
        buttonBack.addActionListener(listener);
        buttonDone.addActionListener(listener);
    }

    /**
     * Gets the new name.
     *
     * @return text field new name
     */
    public String getNewName(){
        return textFieldNewName.getText();
    }

    /**
     * Clears the text field of new name.
     */
    public void clearField() {
        textFieldNewName.setText("");
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
