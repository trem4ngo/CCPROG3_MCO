package controller;

import gui.*;
import model.HotelSystem;

public class MainController {
    // Gui / View
    private HotelSystem hotelSystem;
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
    private ChooseRoomMenu chooseRoomMenu;
    private BookRoomMenu bookRoomMenu;

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
    private BookRoomController bookRoomController;

    public MainController() {
        initializeModel();
        initializeViews();
        initializeControllers();
    }

    private void initializeModel() {
        hotelSystem = new HotelSystem();
    }

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
    }


    private void initializeControllers() {
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
    }

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
    }

    public void showMainMenu() {
        setVisibilityOff();
        mainMenu.setVisible(true);
    }

    public void showCreateHotelMenu() {
        setVisibilityOff();
        createHotelMenu.setVisible(true);
    }

    public void showChooseHotelMenu() {
        setVisibilityOff();
        chooseHotelMenu.setVisible(true);
        // Updates Hotel List for Dropdown
        chooseHotelMenu.updateHotelList(hotelSystem.getHotelNames());
    }

    public void showHotelManagerMenu() {
        setVisibilityOff();
        hotelManagerMenu.setVisible(true);

        hotelManagerController.setHotelName();
    }

    public void showChangeHotelNameMenu() {
        setVisibilityOff();
        changeNameMenu.setVisible(true);
    }

    public void showAddRoomMenu() {
        setVisibilityOff();
        addRoomMenu.setVisible(true);
    }

    public void showRemoveRoomMenu() {
        setVisibilityOff();
        removeRoomMenu.setVisible(true);
    }

    public void showMainHotelMenu() {
        setVisibilityOff();
        mainHotelMenu.setVisible(true);

        mainHotelMenuController.setHotelName();
    }

    public void showUpdatePriceMenu() {
        setVisibilityOff();
        updatePricesMenu.setVisible(true);
    }

    public void showPriceModifierMenu() {
        setVisibilityOff();
        priceModifierMenu.setVisible(true);
    }

    public void showChooseRoomMenu() {
        setVisibilityOff();
        chooseRoomMenu.setVisible(true);
        chooseRoomMenu.updateRoomList(hotelSystem.getSelectedHotel().getRoomNames());
    }

    public void showBookRoomMenu() {
        setVisibilityOff();
        bookRoomMenu.setVisible(true);
        bookRoomController.setRoomName();
    }
}