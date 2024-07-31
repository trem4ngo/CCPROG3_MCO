package controller;

import gui.RemoveRoomMenu;
import model.HotelSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveRoomController implements ActionListener {
    private HotelSystem hotelSystem;
    private RemoveRoomMenu removeRoomMenu;
    private MainController mainController;

    public RemoveRoomController(HotelSystem hotelSystem, RemoveRoomMenu removeRoomMenu) {
        this.hotelSystem = hotelSystem;
        this.removeRoomMenu = removeRoomMenu;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

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
