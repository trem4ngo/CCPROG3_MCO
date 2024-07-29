package controller;

import model.HotelSystem;
import gui.RoomViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RoomViewerController implements ActionListener, ItemListener {
    private HotelSystem hotelSystem;
    private RoomViewer roomViewer;
    private MainController mainController;

    public RoomViewerController(HotelSystem hotelSystem, RoomViewer roomViewer) {
        this.hotelSystem = hotelSystem;
        this.roomViewer = roomViewer;
        this.roomViewer.setActionListener(this);
        this.roomViewer.setItemListener(this);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            mainController.showMainHotelMenu();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedRoom = roomViewer.getSelectedRoom();
            String roomInfo = hotelSystem.getRoomInfo(selectedRoom);
            roomViewer.setRoomInfo(roomInfo);
        }
    }
}