package controller;

import gui.BookRoomMenu;
import model.HotelSystem;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * The controller for the Book Room feature.
 * This controller handles user interactions with the Book Room GUI.
 */
public class BookRoomController implements ActionListener, DocumentListener, ItemListener {

    private HotelSystem hotelSystem;
    private BookRoomMenu bookRoomMenu;
    private MainController mainController;

    /**
     * Creates a new BookRoomController instance.
     *
     * @param hotelSystem the hotel system model
     * @param bookRoomMenu the Book Room GUI
     */
    public BookRoomController(HotelSystem hotelSystem, BookRoomMenu bookRoomMenu) {
        this.hotelSystem = hotelSystem;
        this.bookRoomMenu = bookRoomMenu;
        this.bookRoomMenu.setActionListener(this);
        this.bookRoomMenu.setDocumentListener(this);
    }

    /**
     * Sets the MainController instance.
     *
     * @param mainController the main controller
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * Sets the room name in the Book Room GUI.
     */
    public void setRoomName() {
        if (hotelSystem.getSelectedHotel().getSelectedRoom() == null) {
            System.out.println("\nNo hotel or room selected!");
            return;
        }
        String roomName = hotelSystem.getSelectedHotel().getSelectedRoom().getRoomName();
        bookRoomMenu.setRoomName(roomName);
    }

    /**
     * Handles the action performed in the Book Room GUI
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nAction performed: " + e.getActionCommand());

        if (e.getActionCommand().equals("Back")) {
            bookRoomMenu.clearFields();
            mainController.showMainHotelMenu();
        }

        if (e.getActionCommand().equals("Done")) {
            try {
                boolean flag;
                String guestName = bookRoomMenu.getGuestName();
                String discountCode = bookRoomMenu.getDiscountCode();
                int checkInDate = bookRoomMenu.getCheckInDate();
                int checkOutDate = bookRoomMenu.getCheckOutDate();

                // Validate the input values
                if (guestName.isEmpty())
                    throw new IllegalArgumentException("Guest name cannot be empty!");

                flag = hotelSystem.getSelectedHotel().addReservation(guestName, checkInDate, checkOutDate, discountCode);

                if (flag) {
                    System.out.println("Reservation added successfully for " + guestName);
                    System.out.println("Check-in: " + checkInDate + ", Check-out: " + checkOutDate);
                    System.out.println("Discount code used: " + discountCode);
                    bookRoomMenu.showSuccess("Reservation added successfully.");
                } else
                    bookRoomMenu.showError("Room already reserved or dates conflict.");
                bookRoomMenu.clearFields();
                mainController.showMainHotelMenu();
            } catch (Exception ex) {
                bookRoomMenu.showError("Error. Input Valid Values.");
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }
}