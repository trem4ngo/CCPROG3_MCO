import java.util.ArrayList;

class HotelSystem {
//test
    private ArrayList<Hotel> hotelList;

    /*
     * Initialize arraylist for hotels
     */
    public HotelSystem() {
        hotelList = new ArrayList<>();
    }

    public ArrayList<Hotel> getHotelList() {
        return hotelList;
    }

    /*
     * When it is constructed it should have a minimum of one room, the checking of other same names
     * @hotel
     */
    public boolean constructHotel(String hotelName) {
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelName().equals(hotelName)) {
                System.out.println("Hotel with name '" + hotelName + "' already exists!");
                return false;
            }
        }

        Hotel newHotel = new Hotel(hotelName, hotelList.size() + 1);
        hotelList.add(newHotel);
        return true;

    }

    public boolean demolishHotel(String hotelName) {
        // Valid inputs assumed
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelName().equals(hotelName)) {
                hotelList.remove(hotel);
                System.out.println("Hotel with name '" + hotelName + "' has been constructed!");
                return true;
            }
        }
        System.out.println("Hotel with name '" + hotelName + "' has been demolished!");
        return false;
    }

    // ASSUME INPUTS ARE VALID FOR STRING NAMES IN DRIVER/MAIN
    public boolean changeHotelName(String currentName, String newName) {  // The user is asked in main what hotel to change already print the list there
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelName().equals(newName)) {
                System.out.println("Hotel with name '" + newName + "' already exists!");
                return false;
            }
        }

        for (Hotel hotel : hotelList) {         // Iterate through the list to get to the index of the current hotel we want to change
            if (hotel.getHotelName().equals(currentName)) {
                hotel.setHotelName(newName);
                System.out.println("Hotel with name '" + currentName + "' has been changed to '" + newName + "'!");
                return true;
            }
        }

        System.out.println("Hotel with name '" + currentName + "' has not been found!");
        return false;
    }

    public void viewHotel(String hotelName) {

    }

    public void manageHotel(String hotelName) {

    }

    /*
    alot of parameters here checkin... stuff
     */
    public void simulateBooking(Hotel hotel) {

    }


}
