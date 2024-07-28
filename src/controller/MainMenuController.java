package controller;

import model.HotelSystem;
import gui.MainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController implements ActionListener {

    private HotelSystem hotelSystem;
    private MainMenu mainMenu;
    private MainController mainController;

    public MainMenuController(HotelSystem hotelSystem, MainMenu mainMenu) {
        this.hotelSystem = hotelSystem;
        this.mainMenu = mainMenu;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Create")) {
            mainController.showCreateHotelMenu();
        }

        if (e.getActionCommand().equals("Hotels")) {
            if (!hotelSystem.getHotelList().isEmpty()) {
                mainController.showChooseHotelMenu();
            } else {
                System.out.println("No hotels available! Create one first.");
            }
        }
    }
}