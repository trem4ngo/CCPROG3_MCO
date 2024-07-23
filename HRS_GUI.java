import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;

public class HRS_GUI extends JFrame{
	private JButton buttonPrevious;
	private JButton buttonYes;
	private JButton buttonNo;
	private JButton buttonDone;

	private JButton buttonChoose;
	private JButton buttonCreate;

	private JButton buttonChangeName;
	private JButton buttonAddRoom;
	private JButton buttonRemoveRoom;
	private JButton buttonUpdatePrices;
	private JButton buttonRemoveReservation;
	private JButton buttonDemolishHotel;
	
	private JTextField textFieldHotelName;
	
	public HRS_GUI(){
		super("Hotel Reservation System");
		
		setLayout(new BorderLayout());
		setSize(350, 350);
		createHotelMenu();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void mainMenu(){
		// NORTH PANEL
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBackground(Color.decode("#112D4E")); // Background Color of the head
		
		JLabel labelHead = new JLabel("Hotel Reservation System");
		labelHead.setForeground(Color.decode("#F9F7F7"));
		labelHead.setFont(new Font("Verdana" , Font.BOLD, 20));
		panelNorth.add(labelHead);
		
		this.add(panelNorth, BorderLayout.NORTH);
		
		// CENTER PANEL
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());
		Insets insets = new Insets(10,10,10,10);
		panelCenter.setBackground(Color.decode("#F9F7F7")); // Background color of the body
		
		buttonCreate = new JButton("Create");
		buttonCreate.setBackground(Color.decode("#DBE2EF")); // Background color of buttons
		panelCenter.add(buttonCreate, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
		
		buttonChoose = new JButton("Choose");
		buttonChoose.setBackground(Color.decode("#DBE2EF"));
		panelCenter.add(buttonChoose, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
		
		this.add(panelCenter, BorderLayout.CENTER);
	}
	
	private void createHotelMenu(){
		// NORTH PANEL
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBackground(Color.decode("#112D4E"));
		
		JLabel labelHead = new JLabel("Create Menu");
		labelHead.setForeground(Color.decode("#F9F7F7"));
		labelHead.setFont(new Font("Verdana", Font.BOLD, 20));
		panelNorth.add(labelHead);
		
		this.add(panelNorth, BorderLayout.NORTH);
		
		// CENTER PANEL
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());
		Insets insets = new Insets(4,4,4,4);
		panelCenter.setBackground(Color.decode("#F9F7F7"));

		JLabel labelText = new JLabel("Enter Name:");
		labelText.setFont(new Font("Verdana", Font.BOLD, 10));
		panelCenter.add(labelText, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

		textFieldHotelName = new JTextField(15);
		panelCenter.add(textFieldHotelName, new GridBagConstraints(1, 1, 0, 0, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
		
		this.add(panelCenter, BorderLayout.CENTER);
	}
	
	private void roomMenu(){
		// NORTH PANEL
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBackground(Color.decode("#112D4E"));
		
		JLabel labelHead = new JLabel("Hotel Name"); // gotta do a function to display hotel name 
		labelHead.setForeground(Color.WHITE);
		labelHead.setFont(new Font("Verdana", Font.BOLD, 20));
		panelNorth.add(labelHead);
		
		this.add(panelNorth, BorderLayout.NORTH);
		
		// CENTER PANEL
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout());
		panelCenter.setBackground(Color.RED);
		
			// gotta add something to list the hotels rooms created
		
		textFieldHotelName = new JTextField(20);
		panelCenter.add(textFieldHotelName);
		
		this.add(panelCenter, BorderLayout.CENTER);
		
		// SOUTH PANEL
		JPanel panelSouth = new JPanel();
		panelSouth.setLayout(new FlowLayout());
		panelSouth.setBackground(Color.RED);
		
			// create a function that displays total revenue
		
		this.add(panelSouth, BorderLayout.SOUTH);
	}
	
	private void reservationMenu(){
		// NORTH PANEL
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBackground(Color.decode("#112D4E"));
		
		JLabel labelHead = new JLabel("Hotel Name"); // gotta do a function to display hotel name 
		labelHead.setForeground(Color.decode("#F9F7F7"));
		labelHead.setFont(new Font("Verdana", Font.BOLD, 20));
		panelNorth.add(labelHead);
		
		this.add(panelNorth, BorderLayout.NORTH);
		
		// CENTER PANEL
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout());
		panelCenter.setBackground(Color.RED);
		
		textFieldHotelName = new JTextField(20);
		panelCenter.add(textFieldHotelName);
		
		this.add(panelCenter, BorderLayout.CENTER);
		
		// SOUTH PANEL
		JPanel panelSouth = new JPanel();
		panelSouth.setLayout(new FlowLayout());
		panelSouth.setBackground(Color.RED);
		
			// create a function that displays total amount
		
		this.add(panelSouth, BorderLayout.SOUTH);
	}
	
	private void hotelManagerMenu(){
		// NORTH PANEL
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBackground(Color.decode("#112D4E"));
		
		JLabel labelHead = new JLabel("Hotel Name"); // gotta do a function to display hotel name
		labelHead.setForeground(Color.decode("#F9F7F7"));
		labelHead.setFont(new Font("Verdana", Font.BOLD, 20));
		panelNorth.add(labelHead);
		
		this.add(panelNorth, BorderLayout.NORTH);
		
		// CENTER PANEL
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		panelCenter.setBackground(Color.RED);
		
		buttonChangeName = new JButton("Change Name");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelCenter.add(buttonChangeName, gbc);
		
		buttonAddRoom = new JButton("Add Room");
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelCenter.add(buttonAddRoom, gbc);
		
		buttonRemoveRoom = new JButton("Remove Room");
		gbc.gridx = 1;
		gbc.gridy = 1;
		panelCenter.add(buttonRemoveRoom, gbc);
		
		buttonUpdatePrices = new JButton("Update Prices");
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelCenter.add(buttonUpdatePrices, gbc);
		
		buttonRemoveReservation = new JButton("Remove Reservation");
		gbc.gridx = 0;
		gbc.gridy = 3;
		panelCenter.add(buttonRemoveReservation, gbc);
		
		buttonDemolishHotel = new JButton("Demolish Hotel");
		gbc.gridx = 0;
		gbc.gridy = 4;
		panelCenter.add(buttonDemolishHotel, gbc);
		
		this.add(panelCenter, BorderLayout.CENTER);
		
		// SOUTH PANEL
		JPanel panelSouth = new JPanel();
		panelSouth.setLayout(new FlowLayout());
		panelSouth.setBackground(Color.RED);
		
		JLabel labelHotelName = new JLabel("Hotel Manager");
		labelHead.setForeground(Color.WHITE);
		labelHead.setFont(new Font("Verdana", Font.BOLD, 20));
		panelSouth.add(labelHotelName);
		
		this.add(panelSouth, BorderLayout.SOUTH);
	}

	private void changeNameMenu(){
		// NORTH PANEL
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBackground(Color.decode("#112D4E"));

		JLabel labelHead = new JLabel("Change Name Menu");
		labelHead.setForeground(Color.decode("#F9F7F7"));
		labelHead.setFont(new Font("Verdana", Font.BOLD, 20));
		panelNorth.add(labelHead);

		this.add(panelNorth, BorderLayout.NORTH);

		// CENTER PANEL
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout());
		panelCenter.setBackground(Color.decode("#F9F7F7"));

		this.add(panelCenter, BorderLayout.CENTER);
	}

	private void addRoomMenu(){
		// NORTH PANEL
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBackground(Color.decode("#112D4E"));

		JLabel labelHead = new JLabel("Add Room Menu");
		labelHead.setForeground(Color.decode("#F9F7F7"));
		labelHead.setFont(new Font("Verdana", Font.BOLD, 20));
		panelNorth.add(labelHead);

		this.add(panelNorth, BorderLayout.NORTH);

		// CENTER PANEL
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout());
		panelCenter.setBackground(Color.decode("#F9F7F7"));

		this.add(panelCenter, BorderLayout.CENTER);
	}

	private void removeRoomMenu(){
		// NORTH PANEL
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBackground(Color.decode("#112D4E"));

		JLabel labelHead = new JLabel("Remove Room Menu");
		labelHead.setForeground(Color.decode("#F9F7F7"));
		labelHead.setFont(new Font("Verdana", Font.BOLD, 20));
		panelNorth.add(labelHead);

		this.add(panelNorth, BorderLayout.NORTH);

		// CENTER PANEL
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout());
		panelCenter.setBackground(Color.decode("#F9F7F7"));

		this.add(panelCenter, BorderLayout.CENTER);
	}

	private void updatePricesMenu(){
		// NORTH PANEL
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBackground(Color.decode("#112D4E"));

		JLabel labelHead = new JLabel("Update Prices Menu");
		labelHead.setForeground(Color.decode("#F9F7F7"));
		labelHead.setFont(new Font("Verdana", Font.BOLD, 20));
		panelNorth.add(labelHead);

		this.add(panelNorth, BorderLayout.NORTH);

		// CENTER PANEL
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout());
		panelCenter.setBackground(Color.decode("#F9F7F7"));

		this.add(panelCenter, BorderLayout.CENTER);
	}

	private void removeReservationMenu(){
		// NORTH PANEL
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBackground(Color.decode("#112D4E"));

		JLabel labelHead = new JLabel("Remove Reservation Menu");
		labelHead.setForeground(Color.decode("#F9F7F7"));
		labelHead.setFont(new Font("Verdana", Font.BOLD, 20));
		panelNorth.add(labelHead);

		this.add(panelNorth, BorderLayout.NORTH);

		// CENTER PANEL
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout());
		panelCenter.setBackground(Color.decode("#F9F7F7"));

		this.add(panelCenter, BorderLayout.CENTER);
	}

	private void confirmationMenu(){
		// CENTER PANEL
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());
		Insets insets = new Insets(10,10,10,10);
		panelCenter.setBackground(Color.decode("#F9F7F7"));

		JLabel labelText = new JLabel("Are you sure?");
		labelText.setFont(new Font("Verdana", Font.BOLD, 20));
		panelCenter.add(labelText);

		buttonYes = new JButton("Create");
		buttonYes.setBackground(Color.decode("#DBE2EF"));
		panelCenter.add(buttonYes, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

		buttonYes = new JButton("Choose");
		buttonYes.setBackground(Color.decode("#DBE2EF"));
		panelCenter.add(buttonYes, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

		this.add(panelCenter, BorderLayout.CENTER);
	}
	
	public void setActionListener(ActionListener listener){
		
	}
	
	public void setDocumentListener(DocumentListener listener){
		
	}
	
	// functions regarding gui
}