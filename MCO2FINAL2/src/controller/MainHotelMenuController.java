package controller;

import gui.HotelManagerMenu;
import gui.MainHotelMenu;
import model.HotelSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainHotelMenuController implements ActionListener {
    private HotelSystem hotelSystem;
    private MainHotelMenu mainHotelMenu;
    private MainController mainController;

    public MainHotelMenuController(HotelSystem hotelSystem, MainHotelMenu mainHotelMenu) {
        this.hotelSystem = hotelSystem;
        this.mainHotelMenu = mainHotelMenu;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setHotelName() {
        // Exception Handling
        if (hotelSystem.getSelectedHotel() == null) {
            System.out.println("\nYou have no Hotels! Create one.");
            return;
        }
        String hotelName = hotelSystem.getSelectedHotel().getHotelName();
        mainHotelMenu.setHotelName(hotelName);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Back"))
            mainController.showChooseHotelMenu();

        if (e.getActionCommand().equals("Manage Hotel"))
            mainController.showHotelManagerMenu();

        if (e.getActionCommand().equals("Book Room"))
            mainController.showChooseRoomMenu();

        if (e.getActionCommand().equals("View Hotel"))
            mainController.showHotelInfoMenu();



    }
}
