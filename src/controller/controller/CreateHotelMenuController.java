package controller;

import model.HotelSystem;
import gui.CreateHotelMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for controlling the actions performed in the Create Hotel Menu.
 * It implements the ActionListener interface to handle button clicks.
 */
public class CreateHotelMenuController implements ActionListener {

    private HotelSystem hotelSystem;
    private CreateHotelMenu createHotelMenu;
    private MainController mainController;

    /**
     * Constructor for CreateHotelMenuController.
     *
     * @param hotelSystem The HotelSystem object to interact with.
     * @param createHotelMenu The CreateHotelMenu object to display and interact with.
     */
    public CreateHotelMenuController(HotelSystem hotelSystem, CreateHotelMenu createHotelMenu) {
        this.hotelSystem = hotelSystem;
        this.createHotelMenu = createHotelMenu;
    }

    /**
     * Sets the MainController object for navigation.
     *
     * @param mainController The MainController object to navigate to other menus.
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * Handles button click events in the Create Hotel Menu.
     *
     * @param e The ActionEvent object containing information about the button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Create")) {
            if (hotelSystem.validateHotelName(createHotelMenu.getHotelName())) {
                hotelSystem.createHotel(createHotelMenu.getHotelName());
                createHotelMenu.clearField();
                mainController.showMainMenu();
            } else {
                System.out.println("Invalid hotel name!");
            }
        } else if (e.getActionCommand().equals("Cancel")) {
            createHotelMenu.clearField();
            mainController.showMainMenu();
        }
    }
}