package controller;

import gui.PriceModifierMenu;
import model.HotelSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for handling the actions performed in the Price Modifier Menu.
 * It implements the ActionListener interface to listen for button clicks.
 */
public class UpdateModifiersController implements ActionListener {
    private HotelSystem hotelSystem;
    private PriceModifierMenu priceModifierMenu;
    private MainController mainController;

    /**
     * Constructor for UpdateModifiersController.
     *
     * @param hotelSystem The HotelSystem object to interact with.
     * @param priceModifierMenu The PriceModifierMenu object to display and interact with.
     */
    public UpdateModifiersController(HotelSystem hotelSystem, PriceModifierMenu priceModifierMenu) {
        this.hotelSystem = hotelSystem;
        this.priceModifierMenu = priceModifierMenu;
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
     * Handles the actions performed in the Price Modifier Menu.
     *
     * @param e The ActionEvent object containing information about the action performed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Done")) {
            double modifier;
            int checkInDate;
            int checkOutDate;

            try {
                modifier = Double.parseDouble(priceModifierMenu.getModifier());
                checkInDate = Integer.parseInt(priceModifierMenu.getCheckInDate());
                checkOutDate = Integer.parseInt(priceModifierMenu.getCheckOutDate());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input: Not a valid number");
                priceModifierMenu.showError("Invalid input.");
                return; // Exit the method if invalid
            }
            if (modifier < 0.50 || modifier > 1.50 || checkInDate < 1 || checkOutDate < 2 || checkOutDate > 31 || checkOutDate < checkInDate) {
                priceModifierMenu.showError("Invalid Modifier/Check-In/Check-Out input.");
                return;
            }

            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the price modifier to " + modifier + " for dates " + checkInDate + " to " + checkOutDate + "?", "Confirm Price Modifier Update", JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                boolean updated = hotelSystem.getSelectedHotel().setPriceModifiersForAllRooms(checkInDate, checkOutDate, modifier);
                priceModifierMenu.clearFields();
                // Check if reservation in hotel
                if (updated) {
                    priceModifierMenu.showSuccess("Price Modifier Updated Successfully. From " + checkInDate + " to " + checkOutDate + " with " + modifier + " modifier.");
                    mainController.showHotelManagerMenu();
                } else {
                    priceModifierMenu.showError("Unable to update price modifiers as there is a reservation.");
                    mainController.showHotelManagerMenu();
                }
            } else {
                priceModifierMenu.clearFields();
                priceModifierMenu.showError("Price Modifier Update Cancelled. Go Back or Input Value again.");
            }
        }

        if (e.getActionCommand().equals("Back")) {
            priceModifierMenu.clearFields();
            mainController.showHotelManagerMenu();
        }
    }
}
