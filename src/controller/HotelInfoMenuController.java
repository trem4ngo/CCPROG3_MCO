package controller;

import gui.ChooseHotelMenu;
import gui.HotelInfoMenu;
import model.HotelSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelInfoMenuController implements ActionListener {

    private HotelSystem hotelSystem;
    private HotelInfoMenu hotelInfoMenu;
    private MainController mainController;

    public HotelInfoMenuController(HotelSystem hotelSystem, HotelInfoMenu hotelInfoMenu) {
        this.hotelSystem = hotelSystem;
        this.hotelInfoMenu = hotelInfoMenu;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Back"))
            mainController.showMainHotelMenu();

        if (e.getActionCommand().equals("Check Availability"))
            mainController.showAvailabilityChecker();
//
//            if (e.getActionCommand().equals("View Rooms"))
//                //
//                if (e.getActionCommand().equals("View Reservations"))
//        //


    }
}
