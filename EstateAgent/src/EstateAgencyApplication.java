// C15712195 Gabriel Lupu DT354/4
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

import java.text.NumberFormat;
import java.util.*;

public class EstateAgencyApplication extends JFrame {

	int structureType = -1;
	

	JMenuBar menuBar;
	JMenu listMenu, closeMenu;
	JMenuItem firstItem, nextItem, prevItem, lastItem, closeApp;
	JButton firstItemButton, nextItemButton, prevItemButton, lastItemButton;
	JLabel houseImageLabel, idLabel, streetLabel, cityLabel, bedroomsLabel, bathroomsLabel, priceLabel, contactNoLabel;
	JTextField idTextField, streetTextField, cityTextField, bedroomsTextField, bathroomsTextField, priceTextField, contactNoTextField;
	String[][] records = { {"113 The Maltings", "Dublin 8", "2", "1", "155500.00", "House1.jpg", "(087) 9011135"},
			{"78 Newington Lodge", "Dublin 14", "3", "2", "310000.00", "House2.jpg", "(087) 9010580"},
			{"62 Bohernabreena Road", "Dublin 24", "3", "1", "220000.00", "House3.jpg", "(087) 6023159"},
			{"18 Castledevitt Park", "Dublin 15", "3", "3", "325000.00", "House4.jpg", "(087) 9010580"},
			{"40 Dunsawny Road", "Swords", "3", "19", "245000.00", "House5.jpg", "(087) 9011135"}
	};


	HouseIterator iterator;

	public EstateAgencyApplication() {
		super("Estate Agent Application");
		loadItems();
		initComponents();	
	}

	private void loadItems() {
		String[] options = new String[] {"Array", "Array List", "Linked List"};
		structureType = JOptionPane.showOptionDialog(null, "Choose a data storage structure", "Start Up",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);
		
	
		
		iterator = HouseIteratorFactory.getIterator(structureType, records);		
		
	}

	public void initComponents() {
		setLayout(new BorderLayout());
		JPanel displayPanel = new JPanel(new MigLayout());

		// Ensures that image is centred in label
		houseImageLabel = new JLabel(new ImageIcon(), SwingConstants.CENTER);
		displayPanel.add(houseImageLabel, "push, grow, span 2, wrap");

		idLabel = new JLabel("House ID: ");
		idTextField = new JTextField(3);
		idTextField.setEditable(false);

		displayPanel.add(idLabel, "growx, pushx");
		displayPanel.add(idTextField, "growx, pushx, wrap");

		streetLabel = new JLabel("Address Line 1: ");
		streetTextField = new JTextField(15);
		streetTextField.setEditable(false);

		displayPanel.add(streetLabel, "growx, pushx");
		displayPanel.add(streetTextField, "growx, pushx, wrap");

		cityLabel = new JLabel("Address Line 2: ");
		cityTextField = new JTextField(15);
		cityTextField.setEditable(false);

		displayPanel.add(cityLabel, "growx, pushx");
		displayPanel.add(cityTextField, "growx, pushx, wrap");

		bedroomsLabel = new JLabel("Number of bedrooms: ");
		bedroomsTextField = new JTextField(3);
		bedroomsTextField.setEditable(false);

		displayPanel.add(bedroomsLabel, "growx, pushx");
		displayPanel.add(bedroomsTextField, "growx, pushx, wrap");

		bathroomsLabel = new JLabel("Number of bathrooms: ");
		bathroomsTextField = new JTextField(3);
		bathroomsTextField.setEditable(false);

		displayPanel.add(bathroomsLabel, "growx, pushx");
		displayPanel.add(bathroomsTextField, "growx, pushx, wrap");

		priceLabel = new JLabel("Price: ");
		priceTextField = new JTextField(10);
		priceTextField.setEditable(false);

		displayPanel.add(priceLabel, "growx, pushx");
		displayPanel.add(priceTextField, "growx, pushx, wrap");

		contactNoLabel = new JLabel("Contact number: ");
		contactNoTextField = new JTextField(15);
		contactNoTextField.setEditable(false);

		displayPanel.add(contactNoLabel, "growx, pushx");
		displayPanel.add(contactNoTextField, "growx, pushx, wrap");
		add(displayPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 4));

		firstItemButton = new JButton(new ImageIcon("first.png"));
		nextItemButton = new JButton(new ImageIcon("next.png"));
		prevItemButton = new JButton(new ImageIcon("prev.png"));
		lastItemButton = new JButton(new ImageIcon("last.png"));

		buttonPanel.add(firstItemButton);
		buttonPanel.add(prevItemButton);
		buttonPanel.add(nextItemButton);
		buttonPanel.add(lastItemButton);

		JPanel bottomPanel = new JPanel();
		bottomPanel.add(buttonPanel);

		add(bottomPanel, BorderLayout.SOUTH);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		listMenu = new JMenu("Display");
		firstItem = new JMenuItem("First");
		prevItem = new JMenuItem("Previous");
		nextItem = new JMenuItem("Next");
		lastItem = new JMenuItem("Last");

		listMenu.add(firstItem);
		listMenu.add(prevItem);
		listMenu.add(nextItem);
		listMenu.add(lastItem);

		menuBar.add(listMenu);

		closeMenu = new JMenu("Exit");
		closeApp = new JMenuItem("Close");

		closeMenu.add(closeApp);

		menuBar.add(closeMenu);

	
		
		displayDetails(iterator.first());

		
		ActionListener first = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayDetails(iterator.first());
			}
		};

		ActionListener next = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (iterator.atEnd())
					JOptionPane.showMessageDialog(EstateAgencyApplication.this, "No further records");
				displayDetails(iterator.next());
			}
		};

		ActionListener prev = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (iterator.atBeginning())
					JOptionPane.showMessageDialog(EstateAgencyApplication.this, "No previous records");
				displayDetails(iterator.prev());					
			}
		};

		ActionListener last = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayDetails(iterator.last());
			}
		};

		firstItemButton.addActionListener(first);
		firstItem.addActionListener(first);

		nextItemButton.addActionListener(next);
		nextItem.addActionListener(next);

		prevItemButton.addActionListener(prev);
		prevItem.addActionListener(prev);

		lastItemButton.addActionListener(last);
		lastItem.addActionListener(last);

		closeApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});	
	}

	public void displayDetails(House currentHouse) {
		houseImageLabel.setIcon(new ImageIcon(currentHouse.getImageLocation()));
		idTextField.setText(currentHouse.getId() + "");
		streetTextField.setText(currentHouse.getStreet());
		cityTextField.setText(currentHouse.getCity());
		bedroomsTextField.setText(currentHouse.getBedrooms() + "");
		bathroomsTextField.setText(currentHouse.getBathrooms() + "");
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		priceTextField.setText(nf.format(currentHouse.getPrice()));
		contactNoTextField.setText(currentHouse.getContactNo());
	}


	public static void main(String[] args) {
		EstateAgencyApplication ea = new EstateAgencyApplication();
		ea.pack();
		ea.setSize(400, 550);
		ea.setVisible(true);
	}

}
