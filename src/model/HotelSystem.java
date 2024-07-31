package model;

import java.util.ArrayList;

/**
 * This class handles the hotels and the details of said hotels.
 * It can construct a hotel, change its name, view information, manage the bookings of the rooms, etc.
 */
public class HotelSystem {

    private final ArrayList<Hotel> hotelList;
    private Hotel selectedHotel;

    /**
     * Constructs the hotel system and initializes a list of hotel and sets selected hotel to null.
     */
    public HotelSystem() {
        hotelList = new ArrayList<>();
        selectedHotel = null;
    }

    /**
     * Selects a hotel from the list.
     *
     * @param hotelName the hotel's name to be selected
     */
    public void selectHotel (String hotelName) {
        for (Hotel hotel : hotelList)
            if (hotel.getHotelName().equalsIgnoreCase(hotelName)) {
                selectedHotel = hotel;
                return;
            }
    }

    /**
     * Gets the selected hotel.
     *
     * @return the selected hotel
     */
    public Hotel getSelectedHotel () {
        return selectedHotel;
    }

    /**
     * Gets the hotel list.
     *
     * @return the hotel list
     */
    public ArrayList<Hotel> getHotelList() {
        return hotelList;
    }

    /**
     * Gets the hotel names.
     *
     * @return the hotel names
     */
    public String[] getHotelNames() {
        String[] names = new String[hotelList.size()];
        int i;
        for (i = 0; i < hotelList.size(); i++) {
            Hotel hotel = hotelList.get(i);
            names[i] = hotel.getHotelName();
        }
        return names;
    }

    /**
     * Gets the hotel name, total number of rooms, and total revenue of a hotel.
     *
     * @param hotelName the hotel's name to be checked
     * @return a string of hotel information
     */
    public String getHighLevelInfo(String hotelName) {
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelName().equalsIgnoreCase(hotelName))
                return "Hotel Name: " + hotelName + "\nTotal number of Rooms: " + hotel.getNumberOfRooms() + "\nTotal revenue: " + hotel.calculateEstimatedEarnings();
        }
        return "Hotel information not available";
    }

    /**
     * Gets the availability for a day.
     *
     * @param date the date to be checked
     * @return a string of total number of booked rooms and total number of available rooms for a specific date
     */
    public String getDayAvailability(int date) {
        return "Total number of BOOKED rooms for Day#" + date + ": " + selectedHotel.checkSelectedDay(date) +
                "\n" + "Total number of AVAILABLE rooms for Day#" + date + ": " + (selectedHotel.getNumberOfRooms() -
                selectedHotel.checkSelectedDay(date));
    }

    /**
     *  Gets the information for a room.
     *
     * @param selectedRoom the room selected
     * @return a string of room name and room availability calendar
     */
    public String getRoomInfo(String selectedRoom) {
        Room room = selectedHotel.findRoomByName(selectedRoom);
        return "Room Name: " + room.getRoomName() + "\n\nRoom Availability Calendar: \n" +
                room.displayIsReservedTable() + "\n1 - Reserved, 2 - CheckInDate, \n3 " +
                "- CheckOutDate, 4 - Overlap, 0 Not Reserved";
    }

    /**
     * Checks the hotel name.
     *
     * @param hotelName the hotel's name
     * @return false if the hotel name exists
     */
    public boolean validateHotelName (String hotelName) {
        if (hotelName.isEmpty())
            return false;
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelName().equalsIgnoreCase(hotelName)) {
                return false; // Pop up error if wrong
            }
        }
        return true;
    }

    /**
     *  Creates a hotel.
     *
     * @param hotelName the name of the hotel to be created
     */
    public void createHotel (String hotelName) {
        Hotel newHotel = new Hotel(hotelName, hotelList.size() + 1);
        hotelList.add(newHotel);
        newHotel.addRoom(1, "Standard");        // Adds 1 room when creating a hotel
        System.out.println("Created hotel with name: " + hotelName + "!");
    }

    /**
     * Demolishes the selected hotel.
     */
    public void demolishHotel () {
        hotelList.remove(selectedHotel);
    }

    /**
     * Changes the hotel name. Also checks if the new name is already exists.
     *
     * @param newHotelName the new hotel name
     */
    public void changeHotelName(String newHotelName) {
        if (selectedHotel != null && validateHotelName(newHotelName)) {
            selectedHotel.setHotelName(newHotelName);
            System.out.println("Hotel name changed successfully!");
        } else
            System.out.println("Hotel name already exists or is invalid. Please choose a different name.");
    }
}