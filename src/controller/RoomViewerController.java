package controller;

import model.HotelSystem;
import gui.RoomViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * This class is responsible for controlling the RoomViewer GUI and handling user interactions.
 * It implements ActionListener and ItemListener interfaces to listen for button clicks and item selections.
 */
public class RoomViewerController implements ActionListener, ItemListener {
    private HotelSystem hotelSystem;
    private RoomViewer roomViewer;
    private MainController mainController;

    /**
     * Constructor for RoomViewerController.
     *
     * @param hotelSystem The HotelSystem object to interact with.
     * @param roomViewer  The RoomViewer object to control.
     */
    public RoomViewerController(HotelSystem hotelSystem, RoomViewer roomViewer) {
        this.hotelSystem = hotelSystem;
        this.roomViewer = roomViewer;
        this.roomViewer.setActionListener(this);
        this.roomViewer.setItemListener(this);
    }

    /**
     * Sets the MainController object for navigation purposes.
     *
     * @param mainController The MainController object to set.
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * Handles button click events.
     *
     * @param e The ActionEvent object containing information about the event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            mainController.showMainHotelMenu();
        }
    }

    /**
     * Handles item selection events.
     *
     * @param e The ItemEvent object containing information about the event.
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedRoom = roomViewer.getSelectedRoom();
            String roomInfo = hotelSystem.getRoomInfo(selectedRoom);
            roomViewer.setRoomInfo(roomInfo);
        }
    }
}