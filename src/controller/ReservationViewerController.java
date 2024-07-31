package controller;

import model.Hotel;
import model.HotelSystem;
import gui.ReservationViewer;
import model.Room;
import model.Reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * This class is responsible for controlling the Reservation Viewer GUI.
 * It implements ActionListener and ItemListener interfaces to handle user interactions.
 */
public class ReservationViewerController implements ActionListener, ItemListener {
    private HotelSystem hotelSystem;
    private ReservationViewer reservationViewer;
    private MainController mainController;

    /**
     * Constructor for ReservationViewerController.
     *
     * @param hotelSystem The HotelSystem object to interact with.
     * @param reservationViewer The ReservationViewer object to display reservations.
     */
    public ReservationViewerController(HotelSystem hotelSystem, ReservationViewer reservationViewer) {
        this.hotelSystem = hotelSystem;
        this.reservationViewer = reservationViewer;
    }

    /**
     * Sets the MainController object for navigation.
     *
     * @param mainController The MainController object to handle navigation.
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * Handles action events from the GUI.
     *
     * @param e The ActionEvent object containing information about the event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            mainController.showChooseRoomMenu2();
        }
    }

    /**
     * Handles item state changes in the GUI.
     *
     * @param e The ItemEvent object containing information about the event.
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            int selectedIndex = reservationViewer.getSelectedIndex();
            Room selectedRoom = hotelSystem.getSelectedHotel().getSelectedRoom();

            if (hotelSystem.getSelectedHotel().hasReservation()) {
                String reservationInfo = hotelSystem.getSelectedHotel().getSelectedRoom().getReservationInfo(selectedIndex);
                // Set the reservation info in the Reservation Viewer
                reservationViewer.setReservationInfo(reservationInfo);
            } else {
                reservationViewer.showError("No reservations found for the selected room.");
                mainController.showHotelInfoMenu();
            }
        }
    }
}
