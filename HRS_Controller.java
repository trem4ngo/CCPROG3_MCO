import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HRS_Controller implements ActionListener, DocumentListener {

    private HRS_GUI gui;
    private HotelSystem hotelSystem;

    // Class Initializations

    public HRS_Controller(HRS_GUI gui, HotelSystem hotelSystem) {
        this.gui = gui;
        this.hotelSystem = hotelSystem;

        updateView();

        gui.setActionListener(this);
        gui.setDocumentListener(this);
    }

    public void updateView()
    {
        // Update the view with the current state of the model
        // This could involve updating the GUI components with the current data

        System.out.println("Hello");

    }


    @Override
    public void actionPerformed(ActionEvent e) {

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
}