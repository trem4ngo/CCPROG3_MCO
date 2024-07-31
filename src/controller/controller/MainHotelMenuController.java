package controller;

import gui.HotelManagerMenu;
import gui.MainHotelMenu;
import model.HotelSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class is responsible for controlling the main hotel menu. It implements the ActionListener interface to handle menu item clicks.
 */
public class MainHotelMenuController implements ActionListener {
    private HotelSystem hotelSystem;
    private MainHotelMenu mainHotelMenu;
    private MainController mainController;

    /**
     * Constructor for MainHotelMenuController.
     *
     * @param hotelSystem The HotelSystem object to interact with.
     * @param mainHotelMenu The MainHotelMenu object to update.
     */
    public MainHotelMenuController(HotelSystem hotelSystem, MainHotelMenu mainHotelMenu) {
        this.hotelSystem = hotelSystem;
        this.mainHotelMenu = mainHotelMenu;
    }

    /**
     * Sets the main controller for this controller.
     *
     * @param mainController The MainController object to set.
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * Sets the hotel name in the main hotel menu.
     * If no hotel is selected, it prints a message to the console.
     */
    public void setHotelName() {
        // Exception Handling
        if (hotelSystem.getSelectedHotel() == null) {
            System.out.println("\nYou have no Hotels! Create one.");
            return;
        }
        String hotelName = hotelSystem.getSelectedHotel().getHotelName();
        mainHotelMenu.setHotelName(hotelName);
    }

    /**
     * Handles action events from the menu items.
     *
     * @param e The ActionEvent object containing information about the event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Back"))
            mainController.showChooseHotelMenu();

        if (e.getActionCommand().equals("Manage Hotel"))
            mainController.showHotelManagerMenu();

        if (e.getActionCommand().equals("Book Room"))
            mainController.showChooseRoomMenu();

        if (e.getActionCommand().equals("View Hotel"))
            mainController.showHotelInfoMenu();
    }
}