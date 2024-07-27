package controller;

import gui.AddRoomMenu;
import model.HotelSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AddRoomController implements ActionListener, ItemListener {
    private HotelSystem hotelSystem;
    private AddRoomMenu addRoomMenu;
    private MainController mainController;

    public AddRoomController(HotelSystem hotelSystem, AddRoomMenu addRoomMenu) {
        this.hotelSystem = hotelSystem;
        this.addRoomMenu = addRoomMenu;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Done")) {
            try {
                int numOfRooms = addRoomMenu.getNumOfRooms();
                String roomType = addRoomMenu.getRoomType();

                if (numOfRooms <= 0 || numOfRooms > 50) {
                    System.out.println("Invalid input.");
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
                System.out.println("Invalid input: Not a number");
                addRoomMenu.showError("Invalid Input.");
            }
        }
        if (e.getActionCommand().equals("Back")) {
            addRoomMenu.clearField();
            mainController.showMainHotelMenu();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // Can put for testing in console
    }
}
