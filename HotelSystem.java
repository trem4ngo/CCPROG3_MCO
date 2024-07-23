import java.util.ArrayList;

/**
 * This class handles the hotels and the details of said hotels.
 * It can construct a hotel, change its name, view information, manage the bookings of the rooms, etc.
 */
public class HotelSystem {

    private final ArrayList<Hotel> hotelList;

    public HotelSystem() {
        hotelList = new ArrayList<>();
    }

    public ArrayList<Hotel> getHotelList() {
        return hotelList;
    }

    public boolean validateHotelName (String hotelName) {
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelName().equalsIgnoreCase(hotelName)) {
                return false;
            }
        }
        return true;
    }

    // With GUI Java swing when button confirm is clicked
    public void createHotel (String hotelName) {
        Hotel newHotel = new Hotel(hotelName, hotelList.size() + 1);
        hotelList.add(newHotel);
        //newHotel.addInitialRoom(1);        // Adds 1 room when creating a hotel
    }

    // click option and confirmation
    public void destroyHotel (Hotel selectedHotel) {
        // Confirm action
        hotelList.remove(selectedHotel);
    }

    // Textbox and pop up finish and confirm menu

    public void changeHotelName (Hotel selectedHotel) {

        // validateHotelName(selectedHotel.getName());
        // sethotelname

        // Confirm action -- could be in controller
    }





}