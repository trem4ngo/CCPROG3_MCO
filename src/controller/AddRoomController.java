package controller;

import gui.AddRoomMenu;
import model.HotelSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*
 * The controller for the AddRoomMenu
 */
public class AddRoomController implements ActionListener, ItemListener {
    private HotelSystem hotelSystem;
    private AddRoomMenu addRoomMenu;
    private MainController mainController;

    /**
     * Creates a controller for the hotel system and main menu.
     *
     * @param hotelSystem the hotel system Model
     * @param addRoomMenu the add room menu GUI
     */
    public AddRoomController(HotelSystem hotelSystem, AddRoomMenu addRoomMenu) {
        this.hotelSystem = hotelSystem;
        this.addRoomMenu = addRoomMenu;
    }

    /**
     * Sets the Main Controller.
     *
     * @param mainController the main controller
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * Handles the action performed in the Main Menu GUI.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Done")) {
            try {
                int numOfRooms = addRoomMenu.getNumOfRooms();
                String roomType = addRoomMenu.getRoomType();

                if (numOfRooms <= 0 || numOfRooms > 50) {
                    System.out.println("Invalid input.");
                    addRoomMenu.clearField();
                    addRoomMenu.showError("Please Input a number between 0 and 50.");
                    return;
                }
                // Confirmation
                int result = JOptionPane.showConfirmDialog(addRoomMenu, "Are you sure you want to add " + numOfRooms + " rooms to the hotel?", "Add Rooms", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    hotelSystem.getSelectedHotel().addRoom(numOfRooms, roomType);
                    addRoomMenu.showSuccess("Successfully added " + numOfRooms + " " + roomType + " rooms to the hotel.");
                    addRoomMenu.clearField();
                    mainController.showMainHotelMenu();
                } else {
                    addRoomMenu.clearField();
                    addRoomMenu.showError("Room update cancelled by user.");
                }
            } catch (NumberFormatException ex) {
                addRoomMenu.clearField();
                System.out.println("Invalid input: Not a number");
                addRoomMenu.showError("Invalid Input.");
            }
        }
        if (e.getActionCommand().equals("Back")) {
            addRoomMenu.clearField();
            mainController.showMainHotelMenu();
        }
    }

    /**
     * Handles the item state changed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        // Can put for testing in console
    }
}
