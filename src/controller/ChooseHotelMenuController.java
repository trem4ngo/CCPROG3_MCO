package controller;

import model.HotelSystem;
import gui.ChooseHotelMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*
 * Controller for the ChooseHotelMenu GUI.
 * Handles action events and updates the hotel system model.
 */
public class ChooseHotelMenuController implements ActionListener, ItemListener {

    private HotelSystem hotelSystem;
    private ChooseHotelMenu chooseHotelMenu;
    private MainController mainController;

    /**
     * Creates a new controller for ChooseHotelMenu
     *
     * @param hotelSystem the hotel system model
     * @param chooseHotelMenu the GUI for the ChooseHotelMenu
     */
    public ChooseHotelMenuController(HotelSystem hotelSystem, ChooseHotelMenu chooseHotelMenu) {
        this.hotelSystem = hotelSystem;
        this.chooseHotelMenu = chooseHotelMenu;
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

        if (e.getActionCommand().equals("Back"))
            mainController.showMainMenu();

        if (e.getActionCommand().equals("Done")) {
            String selectedHotel = chooseHotelMenu.getSelectedHotel();
            System.out.println("Selected hotel: " + selectedHotel);
            hotelSystem.selectHotel(selectedHotel);
            mainController.showMainHotelMenu();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedHotel = (String) e.getItem();
            if (selectedHotel != null) {
                String highLevelInfo = hotelSystem.getHighLevelInfo(selectedHotel);
                chooseHotelMenu.setHighLevelInfo(highLevelInfo);
            }
        }
    }
}