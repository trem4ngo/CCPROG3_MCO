package controller;

import gui.HotelManagerMenu;
import model.HotelSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for controlling the actions performed by the Hotel Manager in the Hotel Manager Menu.
 * It implements the ActionListener interface to handle button clicks.
 */
public class HotelManagerController implements ActionListener {
    private HotelSystem hotelSystem;
    private HotelManagerMenu hotelManagerMenu;
    private MainController mainController;

    /**
     * Constructor for HotelManagerController.
     *
     * @param hotelSystem The HotelSystem object representing the hotel management system.
     * @param hotelManagerMenu The HotelManagerMenu object representing the Hotel Manager Menu.
     */
    public HotelManagerController(HotelSystem hotelSystem, HotelManagerMenu hotelManagerMenu) {
        this.hotelSystem = hotelSystem;
        this.hotelManagerMenu = hotelManagerMenu;
    }

    /**
     * Sets the MainController object for this HotelManagerController.
     *
     * @param mainController The MainController object to be set.
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * Sets the hotel name in the Hotel Manager Menu based on the selected hotel in the HotelSystem.
     * If no hotel is selected, it prints an error message.
     */
    public void setHotelName() {
        // Exception Handling
        if (hotelSystem.getSelectedHotel() == null) {
            System.out.println("\nYou have no Hotels! Create one.");
            return;
        }
        String hotelName = hotelSystem.getSelectedHotel().getHotelName();
        hotelManagerMenu.setHotelName(hotelName);
    }

    /**
     * Handles the action performed by the user in the Hotel Manager Menu.
     *
     * @param e The ActionEvent object representing the action performed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        switch (e.getActionCommand()) {
            case "Change":
                mainController.showChangeHotelNameMenu();
                break;
            case "Add":
                mainController.showAddRoomMenu();
                break;
            case "Remove Room":
                mainController.showRemoveRoomMenu();
                break;
            case "Update":
                mainController.showUpdatePriceMenu();
                break;
            case "UpdateModifier":
                mainController.showPriceModifierMenu();
                break;
            case "Remove Reservation":
                mainController.showRemoveReservationMenu();
                break;
            case "Demolish Hotel":
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to demolish hotel?", "Confirm Removal", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    hotelSystem.demolishHotel();
                    hotelManagerMenu.showSuccess("Hotel Demolished successfully.");
                    mainController.showMainMenu();
                } else
                    hotelManagerMenu.showError("Hotel Demolish cancelled.");
                break;
            case "Back":
                mainController.showMainHotelMenu();
                break;
        }
    }
}