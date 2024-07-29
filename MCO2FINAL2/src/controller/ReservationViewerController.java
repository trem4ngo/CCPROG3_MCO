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

public class ReservationViewerController implements ActionListener, ItemListener {
    private HotelSystem hotelSystem;
    private ReservationViewer reservationViewer;
    private MainController mainController;

    public ReservationViewerController(HotelSystem hotelSystem, ReservationViewer reservationViewer) {
        this.hotelSystem = hotelSystem;
        this.reservationViewer = reservationViewer;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            mainController.showChooseRoomMenu2();
        }
    }

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
