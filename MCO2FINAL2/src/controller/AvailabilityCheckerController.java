package controller;

import model.HotelSystem;
import gui.AvailabilityChecker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AvailabilityCheckerController implements ActionListener, ItemListener {
    private HotelSystem hotelSystem;
    private AvailabilityChecker availabilityChecker;
    private MainController mainController;

    public AvailabilityCheckerController(HotelSystem hotelSystem, AvailabilityChecker availabilityChecker) {
        this.hotelSystem = hotelSystem;
        this.availabilityChecker = availabilityChecker;
        this.availabilityChecker.setActionListener(this);
        this.availabilityChecker.setItemListener(this);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            mainController.showHotelInfoMenu();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            int selectedDay = availabilityChecker.getSelectedDay();
            String availabilityInfo = hotelSystem.getDayAvailability(selectedDay);
            availabilityChecker.setAvailabilityInfo(availabilityInfo);
        }
    }
}