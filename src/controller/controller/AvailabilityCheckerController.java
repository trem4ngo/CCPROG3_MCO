package controller;

import model.HotelSystem;
import gui.AvailabilityChecker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * The controller for the Availability Checker feature.
 * This controller handles user interactions with the Availability Checker GUI.
 */
public class AvailabilityCheckerController implements ActionListener, ItemListener {

    private HotelSystem hotelSystem;
    private AvailabilityChecker availabilityChecker;
    private MainController mainController;

    /**
     * Creates a new AvailabilityCheckerController instance.
     *
     * @param hotelSystem the hotel system model
     * @param availabilityChecker the Availability Checker GUI
     */
    public AvailabilityCheckerController(HotelSystem hotelSystem, AvailabilityChecker availabilityChecker) {
        this.hotelSystem = hotelSystem;
        this.availabilityChecker = availabilityChecker;
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
        if (e.getActionCommand().equals("Back")) {
            mainController.showHotelInfoMenu();
        }
    }

    /**
     * Handles item state changes in the Availability Checker GUI.
     *
     * @param e the item event
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            int selectedDay = availabilityChecker.getSelectedDay();
            String availabilityInfo = hotelSystem.getDayAvailability(selectedDay);
            availabilityChecker.setAvailabilityInfo(availabilityInfo);
        }
    }
}