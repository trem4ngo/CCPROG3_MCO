package controller;

import gui.UpdatePricesMenu;
import model.HotelSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePricesController implements ActionListener {
    private HotelSystem hotelSystem;
    private UpdatePricesMenu updatePricesMenu;
    private MainController mainController;

    public UpdatePricesController(HotelSystem hotelSystem, UpdatePricesMenu updatePricesMenu) {
        this.hotelSystem = hotelSystem;
        this.updatePricesMenu = updatePricesMenu;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Done")) {
            try {
                double newPrice = Double.parseDouble(updatePricesMenu.getNewPrice());
                if (newPrice < 100) {
                    System.out.println("Invalid input: Price must be at least 100");
                    updatePricesMenu.showError("Invalid input: Price must be at least 100");
                    return;
                }
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the price to " + newPrice + "?", "Confirm Price Update", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    boolean updated = hotelSystem.getSelectedHotel().updateRoomPrice(newPrice); // Check if updated
                    updatePricesMenu.clearField();
                    if (updated) {
                        updatePricesMenu.showSuccess("Prices updated successfully.");
                        mainController.showHotelManagerMenu();
                    } else
                        updatePricesMenu.showError("Unable to update prices as there is a reservation.");
                } else {
                    updatePricesMenu.clearField();
                    updatePricesMenu.showError("Price update cancelled by user");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input: Not a valid number");
                updatePricesMenu.showError("Please enter a valid number for the price.");
            }
        }
        if (e.getActionCommand().equals("Back")) {
            updatePricesMenu.clearField();
            mainController.showHotelManagerMenu();
        }
    }
}