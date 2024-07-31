package controller;

import gui.*;
import model.HotelSystem;

/**
 * The MainController class is responsible for managing the overall flow of the hotel booking system.
 * It coordinates the interactions between the GUI components, models, and controllers.
 * <p>
 * The MainController class initializes the hotel system, GUI components, and controllers.
 * It also sets up the necessary listeners and updates the necessary views based on user interactions.
 * <p>
 * The MainController class provides methods to show different GUI menus and set their visibility.
 * It also provides methods to update the hotel list for dropdown menus and other necessary updates.
 * <p>
 * The MainController class follows the MVC (Model-View-Controller) design pattern, separating the
 * application logic into models, views, and controllers.
 */
public class MainController {
    // Model
    private HotelSystem hotelSystem;

    // Gui / View
    private MainMenu mainMenu;
    private CreateHotelMenu createHotelMenu;
    private ChooseHotelMenu chooseHotelMenu;
    private HotelManagerMenu hotelManagerMenu;
    private ChangeNameMenu changeNameMenu;
    private AddRoomMenu addRoomMenu;
    private RemoveRoomMenu removeRoomMenu;
    private MainHotelMenu mainHotelMenu;
    private UpdatePricesMenu updatePricesMenu;
    private PriceModifierMenu priceModifierMenu;
    private ChooseRoomMenu chooseRoomMenu, chooseRoomMenu2;
    private BookRoomMenu bookRoomMenu;
    private RemoveReservationMenu removeReservationMenu;
    private HotelInfoMenu hotelInfoMenu;
    private AvailabilityChecker availabilityChecker;
    private RoomViewer roomViewer;
    private ReservationViewer reservationViewer;

    // Controllers
    private MainMenuController mainMenuController;
    private CreateHotelMenuController createHotelMenuController;
    private ChooseHotelMenuController chooseHotelMenuController;
    private HotelManagerController hotelManagerController;
    private ChangeHotelNameController changeHotelNameController;
    private AddRoomController addRoomController;
    private RemoveRoomController removeRoomController;
    private MainHotelMenuController mainHotelMenuController;
    private UpdatePricesController updatePricesController;
    private UpdateModifiersController updateModifiersController;
    private ChooseRoomController chooseRoomController;
    private ChooseRoom2Controller chooseRoom2Controller;
    private BookRoomController bookRoomController;
    private RemoveReservationController removeReservationController;
    private HotelInfoMenuController hotelInfoMenuController;
    private AvailabilityCheckerController availabilityCheckerController;
    private RoomViewerController roomViewerController;
    private ReservationViewerController reservationViewerController;

    public MainController() {
        initializeModel();
        initializeViews();
        initializeControllers();
    }

    private void initializeModel() {
        hotelSystem = new HotelSystem();
    }

    /*
     * Initialize GUI components and sets their visibility to off
     */
    private void initializeViews() {
        mainMenu = new MainMenu();
        createHotelMenu = new CreateHotelMenu();
        createHotelMenu.setVisible(false);
        chooseHotelMenu = new ChooseHotelMenu();
        chooseHotelMenu.setVisible(false);
        hotelManagerMenu = new HotelManagerMenu();
        hotelManagerMenu.setVisible(false);
        changeNameMenu = new ChangeNameMenu();
        changeNameMenu.setVisible(false);
        addRoomMenu = new AddRoomMenu();
        addRoomMenu.setVisible(false);
        removeRoomMenu = new RemoveRoomMenu();
        removeRoomMenu.setVisible(false);
        mainHotelMenu = new MainHotelMenu();
        mainHotelMenu.setVisible(false);
        updatePricesMenu = new UpdatePricesMenu();
        updatePricesMenu.setVisible(false);
        priceModifierMenu = new PriceModifierMenu();
        priceModifierMenu.setVisible(false);
        chooseRoomMenu = new ChooseRoomMenu();
        chooseRoomMenu.setVisible(false);
        bookRoomMenu = new BookRoomMenu();
        bookRoomMenu.setVisible(false);
        removeReservationMenu = new RemoveReservationMenu();
        removeReservationMenu.setVisible(false);
        hotelInfoMenu = new HotelInfoMenu();
        hotelInfoMenu.setVisible(false);
        availabilityChecker = new AvailabilityChecker();
        availabilityChecker.setVisible(false);
        roomViewer = new RoomViewer();
        roomViewer.setVisible(false);
        reservationViewer = new ReservationViewer();
        reservationViewer.setVisible(false);
        chooseRoomMenu2 = new ChooseRoomMenu();
        chooseRoomMenu2.setVisible(false);
    }

    /*
     * Instantiate controllers and set up necessary listeners and updates
     */
    private void initializeControllers() {
        // Instantiate the Controllers
        mainMenuController = new MainMenuController(hotelSystem, mainMenu);
        createHotelMenuController = new CreateHotelMenuController(hotelSystem, createHotelMenu);
        chooseHotelMenuController = new ChooseHotelMenuController(hotelSystem, chooseHotelMenu);
        hotelManagerController = new HotelManagerController(hotelSystem, hotelManagerMenu);
        changeHotelNameController = new ChangeHotelNameController(hotelSystem, changeNameMenu);
        addRoomController = new AddRoomController(hotelSystem, addRoomMenu);
        removeRoomController = new RemoveRoomController(hotelSystem, removeRoomMenu);
        mainHotelMenuController = new MainHotelMenuController(hotelSystem, mainHotelMenu);
        updatePricesController = new UpdatePricesController(hotelSystem, updatePricesMenu);
        updateModifiersController = new UpdateModifiersController(hotelSystem, priceModifierMenu);
        chooseRoomController = new ChooseRoomController(hotelSystem, chooseRoomMenu);
        bookRoomController = new BookRoomController(hotelSystem, bookRoomMenu);
        removeReservationController = new RemoveReservationController(hotelSystem, removeReservationMenu);
        hotelInfoMenuController = new HotelInfoMenuController(hotelSystem, hotelInfoMenu);
        availabilityCheckerController = new AvailabilityCheckerController(hotelSystem, availabilityChecker);
        roomViewerController = new RoomViewerController(hotelSystem, roomViewer);
        reservationViewerController = new ReservationViewerController(hotelSystem, reservationViewer);
        chooseRoom2Controller = new ChooseRoom2Controller(hotelSystem, chooseRoomMenu2);

        // Setting the Main Controller
        mainMenuController.setMainController(this);
        createHotelMenuController.setMainController(this);
        chooseHotelMenuController.setMainController(this);
        hotelManagerController.setMainController(this);
        changeHotelNameController.setMainController(this);
        addRoomController.setMainController(this);
        removeRoomController.setMainController(this);
        mainHotelMenuController.setMainController(this);
        updatePricesController.setMainController(this);
        updateModifiersController.setMainController(this);
        chooseRoomController.setMainController(this);
        bookRoomController.setMainController(this);
        removeReservationController.setMainController(this);
        hotelInfoMenuController.setMainController(this);
        availabilityCheckerController.setMainController(this);
        roomViewerController.setMainController(this);
        reservationViewerController.setMainController(this);
        chooseRoom2Controller.setMainController(this);

        // Setting Necessary Listeners
        mainMenu.setActionListener(mainMenuController);
        createHotelMenu.setActionListener(createHotelMenuController);
        chooseHotelMenu.setActionListener(chooseHotelMenuController);
        chooseHotelMenu.setItemListener(chooseHotelMenuController);
        hotelManagerMenu.setActionListener(hotelManagerController);
        changeNameMenu.setActionListener(changeHotelNameController);
        addRoomMenu.setActionListener(addRoomController);
        addRoomMenu.setItemListener(addRoomController);
        removeRoomMenu.setActionListener(removeRoomController);
        mainHotelMenu.setActionListener(mainHotelMenuController);
        updatePricesMenu.setActionListener(updatePricesController);
        priceModifierMenu.setActionListener(updateModifiersController);
        chooseRoomMenu.setActionListener(chooseRoomController);
        chooseRoomMenu.setItemListener(chooseRoomController);
        bookRoomMenu.setActionListener(bookRoomController);
        bookRoomMenu.setItemListener(bookRoomController);
        removeReservationMenu.setActionListener(removeReservationController);
        removeReservationMenu.setItemListener(removeReservationController);
        hotelInfoMenu.setActionListener(hotelInfoMenuController);
        availabilityChecker.setActionListener(availabilityCheckerController);
        availabilityChecker.setItemListener(availabilityCheckerController);
        roomViewer.setActionListener(roomViewerController);
        reservationViewer.setActionListener(reservationViewerController);
        reservationViewer.setItemListener(reservationViewerController);
        chooseRoomMenu2.setActionListener(chooseRoom2Controller);
        chooseRoomMenu2.setItemListener(chooseRoom2Controller);
    }

    /*
     * Set visibility of all GUI components to false
     */
    public void setVisibilityOff() {
        mainMenu.setVisible(false);
        createHotelMenu.setVisible(false);
        chooseHotelMenu.setVisible(false);
        hotelManagerMenu.setVisible(false);
        changeNameMenu.setVisible(false);
        addRoomMenu.setVisible(false);
        removeRoomMenu.setVisible(false);
        mainHotelMenu.setVisible(false);
        updatePricesMenu.setVisible(false);
        priceModifierMenu.setVisible(false);
        chooseRoomMenu.setVisible(false);
        bookRoomMenu.setVisible(false);
        removeReservationMenu.setVisible(false);
        hotelInfoMenu.setVisible(false);
        availabilityChecker.setVisible(false);
        roomViewer.setVisible(false);
        reservationViewer.setVisible(false);
        chooseRoomMenu2.setVisible(false);
    }

    /*
     * Show the Main Menu GUI component
     */
    public void showMainMenu() {
        setVisibilityOff();
        mainMenu.setVisible(true);
    }

    /*
     * Show the Create Hotel Menu GUI component
     */
    public void showCreateHotelMenu() {
        setVisibilityOff();
        createHotelMenu.setVisible(true);
    }

    /*
     * Show the Choose Hotel Menu GUI component and update the hotel list for dropdown
     */
    public void showChooseHotelMenu() {
        setVisibilityOff();
        chooseHotelMenu.setVisible(true);
        // Updates Hotel List for Dropdown
        chooseHotelMenu.updateHotelList(hotelSystem.getHotelNames());
    }

    /*
     * Show the Hotel Manager Menu GUI component and set the hotel name
     */
    public void showHotelManagerMenu() {
        setVisibilityOff();
        hotelManagerMenu.setVisible(true);
        hotelManagerController.setHotelName();
    }

    /*
     * Show the Change Hotel Name Menu GUI component
     */
    public void showChangeHotelNameMenu() {
        setVisibilityOff();
        changeNameMenu.setVisible(true);
    }

    /*
     * Show the Add Room Menu GUI component
     */
    public void showAddRoomMenu() {
        setVisibilityOff();
        addRoomMenu.setVisible(true);
    }

    /*
     * Show the Remove Room Menu GUI component
     */
    public void showRemoveRoomMenu() {
        setVisibilityOff();
        removeRoomMenu.setVisible(true);
    }

    /*
     * Show the Main Hotel Menu GUI component and set the hotel name
     */
    public void showMainHotelMenu() {
        setVisibilityOff();
        mainHotelMenu.setVisible(true);

        mainHotelMenuController.setHotelName();
    }

    /*
     * Show the Update Prices Menu GUI component
     */
    public void showUpdatePriceMenu() {
        setVisibilityOff();
        updatePricesMenu.setVisible(true);
    }

    /*
     * Show the Price Modifier Menu GUI component
     */
    public void showPriceModifierMenu() {
        setVisibilityOff();
        priceModifierMenu.setVisible(true);
    }

    /*
     * Show the Choose Room Menu GUI component and update the room list for dropdown
     */
    public void showChooseRoomMenu() {
        setVisibilityOff();
        chooseRoomMenu.setVisible(true);
        chooseRoomMenu.updateRoomList(hotelSystem.getSelectedHotel().getRoomNames());
    }

    /*
     * Show the Choose Room Menu 2 GUI component and update the room list for dropdown
     */
    public void showChooseRoomMenu2() {
        setVisibilityOff();
        chooseRoomMenu2.setVisible(true);
        chooseRoomMenu2.updateRoomList(hotelSystem.getSelectedHotel().getRoomNames());
    }

    /*
     * Show the Book Room Menu GUI component and set the room name
     */
    public void showBookRoomMenu() {
        setVisibilityOff();
        bookRoomMenu.setVisible(true);
        bookRoomController.setRoomName();
    }

    /*
     * Show the Remove Reservation Menu GUI component and update the room list for dropdown
     */
    public void showRemoveReservationMenu() {
        setVisibilityOff();
        removeReservationMenu.setVisible(true);
        removeReservationMenu.updateRoomList(hotelSystem.getSelectedHotel().getRoomNames());
    }

    /*
     * Show the Hotel Info Menu GUI component
     */
    public void showHotelInfoMenu() {
        setVisibilityOff();
        hotelInfoMenu.setVisible(true);
    }

    /*
     * Show the Availability Checker GUI component
     */
    public void showAvailabilityChecker() {
        setVisibilityOff();
        availabilityChecker.setVisible(true);
    }

    /*
     * Show the Room Viewer GUI component and update the room list for dropdown
     */
    public void showRoomViewer() {
        setVisibilityOff();
        roomViewer.setVisible(true);
        roomViewer.updateRoomList(hotelSystem.getSelectedHotel().getRoomNames());
    }

    /*
     * Show the Reservation Viewer GUI component and update the guest list for dropdown
     */
    public void showReservationViewer() {
        setVisibilityOff();
        reservationViewer.setVisible(true);
        reservationViewer.updateGuestList(hotelSystem.getSelectedHotel().getSelectedRoom().getReservationNames());
    }
}