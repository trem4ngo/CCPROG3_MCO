package controller;

import gui.ChooseRoomMenu;
import model.HotelSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*
 * Controller for the Choose Room Menu.
 * Allows user to select a room and navigate to the next screen.
 */
/**
 * This class is responsible for controlling the second Choose Room Menu in the Hotel Reservation System.
 * It implements ActionListener and ItemListener interfaces to handle user interactions.
 */
public class ChooseRoom2Controller implements ActionListener, ItemListener {
    private HotelSystem hotelSystem;
    private ChooseRoomMenu chooseRoomMenu;
    private MainController mainController;

    /**
     * Constructor for ChooseRoom2Controller.
     *
     * @param hotelSystem The HotelSystem object representing the entire hotel reservation system.
     * @param chooseRoomMenu The ChooseRoomMenu object representing the GUI for choosing a room.
     */
    public ChooseRoom2Controller(HotelSystem hotelSystem, ChooseRoomMenu chooseRoomMenu) {
        this.hotelSystem = hotelSystem;
        this.chooseRoomMenu = chooseRoomMenu;
    }

    /**
     * Setter method for the MainController object.
     *
     * @param mainController The MainController object responsible for controlling the overall flow of the application.
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * This method is called when an action event occurs in the GUI.
     *
     * @param e The ActionEvent object containing information about the event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Done")) {
            String selectedRoom = chooseRoomMenu.getSelectedRoom();
            System.out.println("Selected room: " + selectedRoom);
            hotelSystem.getSelectedHotel().setSelectedRoom(selectedRoom);
            // Reservation Viewer
            mainController.showReservationViewer();
        }

        if (e.getActionCommand().equals("Back"))
            mainController.showHotelInfoMenu();
    }

    /**
     * This method is called when an item event occurs in the GUI.
     *
     * @param e The ItemEvent object containing information about the event.
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        // Can put for testing in console
    }
}

