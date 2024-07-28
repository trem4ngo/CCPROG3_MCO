package controller;

import model.HotelSystem;
import gui.CreateHotelMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateHotelMenuController implements ActionListener {

    private HotelSystem hotelSystem;
    private CreateHotelMenu createHotelMenu;
    private MainController mainController;

    public CreateHotelMenuController(HotelSystem hotelSystem, CreateHotelMenu createHotelMenu) {
        this.hotelSystem = hotelSystem;
        this.createHotelMenu = createHotelMenu;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Create")) {
            if (hotelSystem.validateHotelName(createHotelMenu.getHotelName())) {
                hotelSystem.createHotel(createHotelMenu.getHotelName());
                createHotelMenu.clearField();
                mainController.showMainMenu();
            } else {
                System.out.println("Invalid hotel name!");
            }
        } else if (e.getActionCommand().equals("Cancel")) {
            createHotelMenu.clearField();
            mainController.showMainMenu();
        }
    }
}