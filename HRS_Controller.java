import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HRS_Controller implements ActionListener, DocumentListener {

    private HRS_GUI gui;
    private HotelSystem hotelSystem;

    // Class Initializations

    public HRS_Controller(HRS_GUI gui, HotelSystem hotelSystem) {
        this.gui = gui;
        this.hotelSystem = hotelSystem;

        gui.setActionListener(this);
        gui.setDocumentListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action performed: " + e.getActionCommand());


        // Create Hotel Menu
        if (e.getActionCommand().equals("CreateMenu"))
            gui.showCreateMenu();


        // Create Hotel
        if (e.getActionCommand().equals("Create")) {
            // Get the hotel name from the GUI
            // Validate the hotel name
            if (hotelSystem.validateHotelName(gui.getHotelName())) {
                hotelSystem.createHotel(gui.getHotelName());
                // After creating it should proceed to MainMenu
                gui.showMainMenu();
            } else {
                System.out.println("Invalid hotel name!");
                // Pop up error message
            }
        }

        // Choose Hotel Menu
//        if (e.getActionCommand().equals("ChooseHotel")) {
//            if (!hotelSystem.getHotelList().isEmpty())
//                gui.showChooseHotelMenu();
//            else
//                System.out.println("No hotels available! Create one First.");
//        }


    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}