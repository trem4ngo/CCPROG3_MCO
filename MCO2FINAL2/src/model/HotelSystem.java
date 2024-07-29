package model;

import java.util.ArrayList;

/**
 * This class handles the hotels and the details of said hotels.
 * It can construct a hotel, change its name, view information, manage the bookings of the rooms, etc.
 */
public class HotelSystem {

    private final ArrayList<Hotel> hotelList;
    private Hotel selectedHotel;

    public HotelSystem() {
        hotelList = new ArrayList<>();
        selectedHotel = null;
    }

    public void selectHotel (String hotelName) {
        for (Hotel hotel : hotelList)
            if (hotel.getHotelName().equalsIgnoreCase(hotelName)) {
                selectedHotel = hotel;
                return;
            }
    }

    public Hotel getSelectedHotel () {
        return selectedHotel;
    }

    public ArrayList<Hotel> getHotelList() {
        return hotelList;
    }

    public String[] getHotelNames() {
        String[] names = new String[hotelList.size()];
        int i;
        for (i = 0; i < hotelList.size(); i++) {
            Hotel hotel = hotelList.get(i);
            names[i] = hotel.getHotelName();
        }
        return names;
    }

    public String getHighLevelInfo(String hotelName) {
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelName().equalsIgnoreCase(hotelName))
                return "Hotel Name: " + hotelName + "\nTotal number of Rooms: " + hotel.getNumberOfRooms() + "\nTotal revenue: " + hotel.calculateEstimatedEarnings();
        }
        return "Hotel information not available";
    }

    public String getDayAvailability(int date) {
        return "Total number of BOOKED rooms for Day#" + date + ": " + selectedHotel.checkSelectedDay(date) +
                "\n" + "Total number of AVAILABLE rooms for Day#" + date + ": " + (selectedHotel.getNumberOfRooms() -
                selectedHotel.checkSelectedDay(date));
    }


    public String getRoomInfo(String selectedRoom) {
        Room room = selectedHotel.findRoomByName(selectedRoom);
        return "Room Name: " + room.getRoomName() + "\n\nRoom Availability Calendar: \n" +
                room.displayIsReservedTable() + "\n1 - Reserved, 2 - CheckInDate, \n3 " +
                "- CheckOutDate, 4 - Overlap, 0 Not Reserved";
    }

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

    public void createHotel (String hotelName) {
        Hotel newHotel = new Hotel(hotelName, hotelList.size() + 1);
        hotelList.add(newHotel);
        newHotel.addRoom(1, "Standard");        // Adds 1 room when creating a hotel
        System.out.println("Created hotel with name: " + hotelName + "!");
    }

    public void demolishHotel () {
        hotelList.remove(selectedHotel);
    }

    public void changeHotelName(String newHotelName) {
        if (selectedHotel != null && validateHotelName(newHotelName)) {
            selectedHotel.setHotelName(newHotelName);
            System.out.println("Hotel name changed successfully!");
        } else
            System.out.println("Hotel name already exists or is invalid. Please choose a different name.");
    }






}