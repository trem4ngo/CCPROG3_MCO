package controller;

import gui.ChooseHotelMenu;
import gui.HotelInfoMenu;
import model.HotelSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for controlling the actions performed in the HotelInfoMenu.
 * It implements the ActionListener interface to handle button clicks.
 */
public class HotelInfoMenuController implements ActionListener {

    private HotelSystem hotelSystem;
    private HotelInfoMenu hotelInfoMenu;
    private MainController mainController;

    /**
     * Constructor for HotelInfoMenuController.
     *
     * @param hotelSystem The HotelSystem object to interact with.
     * @param hotelInfoMenu The HotelInfoMenu object to control.
     */
    public HotelInfoMenuController(HotelSystem hotelSystem, HotelInfoMenu hotelInfoMenu) {
        this.hotelSystem = hotelSystem;
        this.hotelInfoMenu = hotelInfoMenu;
    }

    /**
     * Sets the MainController for this controller.
     *
     * @param mainController The MainController object to set.
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * Handles the action performed in the HotelInfoMenu.
     *
     * @param e The ActionEvent object representing the action performed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Back"))
            mainController.showMainHotelMenu();

        if (e.getActionCommand().equals("Check Availability"))
            mainController.showAvailabilityChecker();

        if (e.getActionCommand().equals("View Rooms"))
            mainController.showRoomViewer();

        if (e.getActionCommand().equals("View Reservations"))
            mainController.showChooseRoomMenu2();
    }
}
