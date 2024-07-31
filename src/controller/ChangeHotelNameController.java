package controller;

import gui.ChangeNameMenu;
import model.HotelSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The controller for the Change Hotel Name feature.
 * This controller handles user interactions with the Change Hotel Name GUI.
 */
public class ChangeHotelNameController implements ActionListener {

    private HotelSystem hotelSystem;
    private ChangeNameMenu changeNameMenu;
    private MainController mainController;

    /**
     * Creates a new ChangeHotelNameController instance.
     *
     * @param hotelSystem the hotel system model
     * @param changeNameMenu the Change Hotel Name GUI
     */
    public ChangeHotelNameController(HotelSystem hotelSystem, ChangeNameMenu changeNameMenu) {
        this.hotelSystem = hotelSystem;
        this.changeNameMenu = changeNameMenu;
    }

    /**
     * Sets the MainController instance.
     *
     * @param mainController the main controller
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * Handles action events from the Availability Checker GUI.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Done")) {
            String newName = changeNameMenu.getNewName();
            if (!newName.isEmpty()) {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirmation Box", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    changeNameMenu.clearField();
                    hotelSystem.changeHotelName(newName);
                    changeNameMenu.showSuccess("Successfully changed hotel name.");
                    mainController.showHotelManagerMenu();
                } else {
                    changeNameMenu.clearField();
                    changeNameMenu.showError("Hotel update cancelled. Please enter a new name or Go Back.");
                }
            }
        }
        if (e.getActionCommand().equals("Back")) {
            changeNameMenu.clearField();
            mainController.showHotelManagerMenu();
        }
    }
}
