package controller;

import gui.ChooseRoomMenu;
import model.HotelSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChooseRoom2Controller implements ActionListener, ItemListener {
    private HotelSystem hotelSystem;
    private ChooseRoomMenu chooseRoomMenu;
    private MainController mainController;

    public ChooseRoom2Controller(HotelSystem hotelSystem, ChooseRoomMenu chooseRoomMenu) {
        this.hotelSystem = hotelSystem;
        this.chooseRoomMenu = chooseRoomMenu;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

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

    @Override
    public void itemStateChanged(ItemEvent e) {
        // Can put for testing in console
    }
}
