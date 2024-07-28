package controller;

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
        this.reservationViewer.setActionListener(this);
        this.reservationViewer.setItemListener(this);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            mainController.showHotelManagerMenu();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
//            if (e.getSource() == reservationViewer.getSelectedRoom()) {
//                String selectedRoom = (String) e.getItem();
//                if (selectedRoom != null) {
//                    Room room = hotelSystem.getSelectedHotel().findRoomByName(selectedRoom);
//                    hotelSystem.getSelectedHotel().setSelectedRoom(selectedRoom);
//                    if (room != null) {
//                        String[] reservationNames = room.getReservationNames();
//                        if (reservationNames.length == 0) {
//                            reservationViewer.showError("No reservations available for this room.");
//                            reservationViewer.updateGuestList(new String[0]);
//                            reservationViewer.setReservationInfo("");
//                        } else {
//                            reservationViewer.updateGuestList(reservationNames);
//                        }
//                    }
//                }
//            } else if (e.getSource() == reservationViewer.getSelectedGuest()) {
//                String selectedRoom = reservationViewer.getSelectedRoom();
//                String selectedGuest = (String) e.getItem();
//                if (selectedRoom != null && selectedGuest != null) {
//                    Room room = hotelSystem.getSelectedHotel().findRoomByName(selectedRoom);
//                    if (room != null) {
//                        Reservation reservation = findReservationByGuestName(room, selectedGuest);
//                        if (reservation != null) {
//                            String reservationInfo = getReservationInfo(reservation);
//                            reservationViewer.setReservationInfo(reservationInfo);
//                        }
//                    }
//                }
//            }
        }
    }
}