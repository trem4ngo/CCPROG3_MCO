package controller;

import gui.AddRoomMenu;
import gui.ChooseRoomMenu;
import model.HotelSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChooseRoomController implements ActionListener, ItemListener {
    private HotelSystem hotelSystem;
    private ChooseRoomMenu chooseRoomMenu;
    private MainController mainController;

    public ChooseRoomController(HotelSystem hotelSystem, ChooseRoomMenu chooseRoomMenu) {
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
            // Reserve Menu
            mainController.showBookRoomMenu();
        }

        if (e.getActionCommand().equals("Back"))
            mainController.showMainHotelMenu();

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // Can put for testing in console
    }
}
