package controller;

import model.HotelSystem;
import gui.MainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The controller for the Main Menu
 */
public class MainMenuController implements ActionListener {

    private HotelSystem hotelSystem;
    private MainMenu mainMenu;
    private MainController mainController;

    /**
     * Creates a controller for the hotel system and main menu.
     *
     * @param hotelSystem the hotel system Model
     * @param mainMenu the main menu GUI
     */
    public MainMenuController(HotelSystem hotelSystem, MainMenu mainMenu) {
        this.hotelSystem = hotelSystem;
        this.mainMenu = mainMenu;
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

        if (e.getActionCommand().equals("Create")) {
            mainController.showCreateHotelMenu();
        }

        if (e.getActionCommand().equals("Hotels")) {
            if (!hotelSystem.getHotelList().isEmpty()) {
                mainController.showChooseHotelMenu();
            } else {
                System.out.println("No hotels available! Create one first.");
            }
        }
    }
}