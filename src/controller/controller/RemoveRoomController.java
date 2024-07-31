package controller;

import gui.RemoveRoomMenu;
import model.HotelSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for handling the actions performed in the Remove Room Menu.
 * It implements the ActionListener interface to listen for button clicks.
 */
public class RemoveRoomController implements ActionListener {
    private HotelSystem hotelSystem;
    private RemoveRoomMenu removeRoomMenu;
    private MainController mainController;

    /**
     * Constructor for RemoveRoomController.
     *
     * @param hotelSystem The HotelSystem object to interact with.
     * @param removeRoomMenu The RemoveRoomMenu object to display and interact with.
     */
    public RemoveRoomController(HotelSystem hotelSystem, RemoveRoomMenu removeRoomMenu) {
        this.hotelSystem = hotelSystem;
        this.removeRoomMenu = removeRoomMenu;
    }

    /**
     * Sets the MainController object for navigation.
     *
     * @param mainController The MainController object to navigate to.
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * Handles the actions performed in the Remove Room Menu.
     *
     * @param e The ActionEvent object containing information about the action performed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Done")) {
            try {
                int numOfRooms = Integer.parseInt(removeRoomMenu.getNumOfRooms());
                int totalRooms = hotelSystem.getSelectedHotel().getNumberOfRooms();

                if (numOfRooms <= 0 || numOfRooms >= totalRooms) {
                    System.out.println("Invalid input");
                    removeRoomMenu.showError("Invalid number of rooms.");
                    return;
                }
                // Confirmation
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove " + numOfRooms + " rooms?", "Confirm Removal", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    hotelSystem.getSelectedHotel().removeRoom(numOfRooms);
                    removeRoomMenu.showSuccess(numOfRooms + " Rooms removed successfully!");
                    removeRoomMenu.clearFields();
                    mainController.showHotelManagerMenu();
                } else {
                    // Cancelled
                    removeRoomMenu.clearFields();
                    removeRoomMenu.showError("Room update cancelled by user.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input: Not a number");
                removeRoomMenu.showError("Invalid input.");
            }
        }
        if (e.getActionCommand().equals("Back")) {
            removeRoomMenu.clearFields();
            mainController.showHotelManagerMenu();
        }
    }
}
