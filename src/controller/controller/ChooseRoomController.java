package controller;

import gui.ChooseRoomMenu;
import model.HotelSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * This class is responsible for controlling the Choose Room Menu in the Hotel Reservation System.
 * It implements ActionListener and ItemListener interfaces to handle user interactions.
 */
public class ChooseRoomController implements ActionListener, ItemListener {
    private HotelSystem hotelSystem;
    private ChooseRoomMenu chooseRoomMenu;
    private MainController mainController;

    /**
     * Constructor for ChooseRoomController.
     *
     * @param hotelSystem The HotelSystem object representing the entire hotel reservation system.
     * @param chooseRoomMenu The ChooseRoomMenu object representing the GUI for choosing a room.
     */
    public ChooseRoomController(HotelSystem hotelSystem, ChooseRoomMenu chooseRoomMenu) {
        this.hotelSystem = hotelSystem;
        this.chooseRoomMenu = chooseRoomMenu;
    }

    /**
     * Setter method for the MainController object.
     *
     * @param mainController The MainController object responsible for controlling the main menu.
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * This method handles action events triggered by user interactions in the Choose Room Menu.
     *
     * @param e The ActionEvent object representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Done")) {
            String selectedRoom = chooseRoomMenu.getSelectedRoom();
            System.out.println("Selected room: " + selectedRoom);
            hotelSystem.getSelectedHotel().setSelectedRoom(selectedRoom);
            // Reserve Menu
            mainController.showBookRoomMenu();
        }

        if (e.getActionCommand().equals("Back"))
            mainController.showMainHotelMenu();
    }

    /**
     * This method handles item state changes triggered by user interactions in the Choose Room Menu.
     *
     * @param e The ItemEvent object representing the user's interaction.
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        // Can put for testing in console
    }
}
