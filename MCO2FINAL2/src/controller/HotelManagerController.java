package controller;

import gui.HotelManagerMenu;
import model.HotelSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagerController implements ActionListener {
    private HotelSystem hotelSystem;
    private HotelManagerMenu hotelManagerMenu;
    private MainController mainController;

    public HotelManagerController(HotelSystem hotelSystem, HotelManagerMenu hotelManagerMenu) {
        this.hotelSystem = hotelSystem;
        this.hotelManagerMenu = hotelManagerMenu;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setHotelName() {
        // Exception Handling
        if (hotelSystem.getSelectedHotel() == null) {
            System.out.println("\nYou have no Hotels! Create one.");
            return;
        }
        String hotelName = hotelSystem.getSelectedHotel().getHotelName();
        hotelManagerMenu.setHotelName(hotelName);
    }

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
                // Implement remove reservation logic
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
                mainController.showChooseHotelMenu();
                break;
        }
    }
}