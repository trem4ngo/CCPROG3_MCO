public class HRS_Driver {
    public static void main(String[] args){
        HRS_GUI gui = new HRS_GUI();
        HotelSystem hotelSystem = new HotelSystem();
        HRS_Controller controller = new HRS_Controller(gui,hotelSystem);
    }
}
