package controller;

import model.HotelSystem;
import gui.RemoveReservationMenu;
import model.Room;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RemoveReservationController implements ActionListener, ItemListener {

    private HotelSystem hotelSystem;
    private RemoveReservationMenu removeReservationMenu;
    private MainController mainController;

    public RemoveReservationController(HotelSystem hotelSystem, RemoveReservationMenu removeReservationMenu) {
        this.hotelSystem = hotelSystem;
        this.removeReservationMenu = removeReservationMenu;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Back")) {
            mainController.showHotelManagerMenu();
        }

        if (e.getActionCommand().equals("Done")) {
            String selectedRoom = removeReservationMenu.getSelectedRoom();
            String selectedReservation = removeReservationMenu.getSelectedReservation();
            if (selectedRoom != null && !selectedRoom.isEmpty() && selectedReservation != null && !selectedReservation.isEmpty()) {
                int choice = JOptionPane.showConfirmDialog(removeReservationMenu, "Are you sure you want to remove the reservation?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.out.println("Selected room: " + selectedRoom);
                    System.out.println("Selected Guest reservation to remove: " + selectedReservation);
                    boolean removed = hotelSystem.getSelectedHotel().cancelReservation(selectedReservation);
                    if (removed) {
                        System.out.println("Reservation removed successfully.");
                        removeReservationMenu.showSuccess("Reservation removed successfully.");
                        mainController.showHotelManagerMenu();
                    } else {
                        System.out.println("Failed to remove reservation.");
                        removeReservationMenu.showError("Failed to remove reservation.");
                        mainController.showHotelManagerMenu();
                    }
                }
            } else {
                System.out.println("Please select both a room and a reservation to remove.");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedRoom = (String) e.getItem();
            if (selectedRoom != null) {
                Room room = hotelSystem.getSelectedHotel().findRoomByName(selectedRoom);
                hotelSystem.getSelectedHotel().setSelectedRoom(selectedRoom);
                if (room != null)
                {
                    String[] reservationNames = room.getReservationNames();
                    if (reservationNames.length == 0)
                    {
                        removeReservationMenu.showError("No reservations available.");
                        mainController.showHotelManagerMenu();
                        return;
                    }
                    removeReservationMenu.updateReservationList(reservationNames);
                }

            }
        }
    }


}