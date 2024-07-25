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
        if (hotelName.isEmpty())
            return false;
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelName().equalsIgnoreCase(hotelName)) {
                return false; // Pop up error if wrong
            }
        }
        return true;
    }

    // With GUI Java swing when button confirm is clicked
    // TEXTBOX NAME
    public void createHotel (String hotelName) {
        Hotel newHotel = new Hotel(hotelName, hotelList.size() + 1);
        hotelList.add(newHotel);
        newHotel.addInitialRoom();        // Adds 1 room when creating a hotel
        System.out.println("Created hotel with name: " + hotelName + "!");
    }

    // confirmation if this would run or not combo box destroy hotel
    public void destroyHotel (Hotel selectedHotel) {
        hotelList.remove(selectedHotel);
    }

    // Textbox and pop up finish and confirm menu
    public void changeHotelName (String hotelName, Hotel selectedHotel) {
        if (validateHotelName(selectedHotel.getHotelName()))
            selectedHotel.setHotelName(hotelName);
    }





}