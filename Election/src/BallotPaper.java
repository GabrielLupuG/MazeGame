//Gabriel Lupu
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.Vector;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class BallotPaper extends JFrame {
	
	private JLabel[] partyLogoLabels = new JLabel[10];
	private JLabel[] candidateTitleLabels = new JLabel[10];
	private JLabel[] candidateImageLabels = new JLabel[10];
	
	private String[] preferenceStrings = {"----", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	
	private JComboBox<String> preferenceBoxes[];
	
	private Vector<Integer> preferences, correctPreferences;
	
	private JButton voteButton, cancelButton;
	
	private static VotingSystem parent;

	public BallotPaper(VotingSystem parent)  {

		super("Ballot Paper");
		
		this.parent = parent;
		
		setUpPartyLogoLabels();
		setUpCandidateTitleLabels();
		setUpCandidateImageLabels();
		setUpPreferenceBoxes();
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel displayPanel = new JPanel(new MigLayout());
		
		for (int i = 0; i < 10; i++) {
			
			displayPanel.add(candidateTitleLabels[i], "center");
			displayPanel.add(partyLogoLabels[i], "center");
			displayPanel.add(candidateImageLabels[i], "center");
			displayPanel.add(preferenceBoxes[i], "center, wrap");
			
		}
		
		c.add(displayPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		voteButton = new JButton("VOTE");
		buttonPanel.add(voteButton);
		cancelButton = new JButton("CANCEL");
		buttonPanel.add(cancelButton);
		
		voteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				preferences = new Vector<Integer>();
				
				for (int i = 0; i < 10; i++) {
					
					int selectedIndex = preferenceBoxes[i].getSelectedIndex();
					if (selectedIndex == 0) {
						preferences.add(new Integer(9999));
					}
					else {
						preferences.add(new Integer(selectedIndex));
					}
				}
						
			Collections.sort(preferences);
					
				boolean valid = BallotPaper.this.validate(preferences);
					
				if (valid) {
						
					correctPreferences = new Vector<Integer>();
					
					for (int i = 0; i < 10; i++) {
						
						int selectedIndex = preferenceBoxes[i].getSelectedIndex();
						if (selectedIndex == 0) {
							correctPreferences.add(new Integer(9999));
						}
						else {
							correctPreferences.add(new Integer(selectedIndex));
						}

					}
					
					JOptionPane.showMessageDialog(BallotPaper.this, "Vote cast");
					parent.castVote(correctPreferences);
					
					for (int i = 0; i < 10; i++) {
						
						preferenceBoxes[i].setSelectedIndex(0);
						
					}
					
					BallotPaper.this.dispose();
						
				}
					
			}
				
		});
		
		cancelButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(BallotPaper.this, "Vote cancelled");
				
				for (int i = 0; i < 10; i++) {
					
					preferenceBoxes[i].setSelectedIndex(0);
					
				}
					
			}
			
		});
		
		c.add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
			
	}

	private void setUpPreferenceBoxes() {
		
		preferenceBoxes = new JComboBox[10];
		
		for (int i = 0; i < 10; i++) {
		
			JComboBox<String> preferenceBox = new JComboBox<String>(preferenceStrings);
			preferenceBoxes[i] = preferenceBox;
				
		}
		
	}

	private void setUpCandidateImageLabels() {
		
		ImageIcon imgLabel;
		imgLabel = new ImageIcon("BoydBarrett.jpg");
		candidateImageLabels[0] = new JLabel(imgLabel);
		imgLabel = new ImageIcon("HealyRae.jpg");
		candidateImageLabels[1] = new JLabel(imgLabel);
		imgLabel = new ImageIcon("Howlin.jpg");
		candidateImageLabels[2] = new JLabel(imgLabel);
		imgLabel = new ImageIcon("Martin.jpg");
		candidateImageLabels[3] = new JLabel(imgLabel);
		imgLabel = new ImageIcon("McDonald.jpg");
		candidateImageLabels[4] = new JLabel(imgLabel);
		imgLabel = new ImageIcon("McGrath.jpg");
		candidateImageLabels[5] = new JLabel(imgLabel);
		imgLabel = new ImageIcon("Murphy.jpg");
		candidateImageLabels[6] = new JLabel(imgLabel);
		imgLabel = new ImageIcon("Ryan.jpg");
		candidateImageLabels[7] = new JLabel(imgLabel);
		imgLabel = new ImageIcon("Toibin.jpg");
		candidateImageLabels[8] = new JLabel(imgLabel);
		imgLabel = new ImageIcon("Varadkar.jpg");
		candidateImageLabels[9] = new JLabel(imgLabel);

	}

	
	private void setUpCandidateTitleLabels() {

		candidateTitleLabels[0] = new JLabel("BOYD-BARRETT - PEOPLE BEFORE PROFIT");
		candidateTitleLabels[1] = new JLabel("HEALY-RAE - NON-PARTY");
		candidateTitleLabels[2] = new JLabel("HOWLIN - THE LABOUR PARTY");
		candidateTitleLabels[3] = new JLabel("MARTIN - FIANNA FÁIL");
		candidateTitleLabels[4] = new JLabel("McDONALD - SINN FÉIN");
		candidateTitleLabels[5] = new JLabel("McGRATH - NON-PARTY");
		candidateTitleLabels[6] = new JLabel("MURPHY - SOCIAL DEMOCRATS");
		candidateTitleLabels[7] = new JLabel("RYAN - GREEN PARTY");
		candidateTitleLabels[8] = new JLabel("TÓIBÍN - AONTÚ");
		candidateTitleLabels[9] = new JLabel("VARADKAR - FINE GAEL");
		
	}

	private void setUpPartyLogoLabels() {

		ImageIcon imgLabel;
		imgLabel = new ImageIcon("SolPBP.jpg");
		partyLogoLabels[0] = new JLabel(imgLabel);
		partyLogoLabels[1] = new JLabel();
		imgLabel = new ImageIcon("Lab.jpg");
		partyLogoLabels[2] = new JLabel(imgLabel);
		imgLabel = new ImageIcon("FF.jpg");
		partyLogoLabels[3] = new JLabel(imgLabel);
		imgLabel = new ImageIcon("SF.jpg");
		partyLogoLabels[4] = new JLabel(imgLabel);
		partyLogoLabels[5] = new JLabel();
		imgLabel = new ImageIcon("SD.jpg");
		partyLogoLabels[6] = new JLabel(imgLabel);
		imgLabel = new ImageIcon("Green.jpg");
		partyLogoLabels[7] = new JLabel(imgLabel);
		imgLabel = new ImageIcon("Aontu.jpg");
		partyLogoLabels[8] = new JLabel(imgLabel);
		imgLabel = new ImageIcon("FG.jpg");
		partyLogoLabels[9] = new JLabel(imgLabel);
		
	}
	
	private boolean validate(Vector<Integer> preferences) {
		
		if (preferences.get(0) == 9999) {
			
			int result = JOptionPane.showOptionDialog(this, "No preferences selected. Do you wish to continue?", "Warning", JOptionPane.YES_NO_OPTION,
				    JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (result == JOptionPane.YES_OPTION) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (preferences.get(0) != 1) {
			JOptionPane.showMessageDialog(this, "No first preference selected");
			return false;
		}
		else {
			int current, next;
			current = preferences.get(0);
			next = preferences.get(1);
			for (int j = 0; j < 10 && next != 9999; j++) {
				current = preferences.get(j);
				if (j < 9) next = preferences.get(j + 1); else next = -1;
				if (current == next) {
					JOptionPane.showMessageDialog(this, "Preference " + current + " duplicated");
					return false;
				}
				else if (current + 1 != next && next != 9999) {
					JOptionPane.showMessageDialog(this, "Missing preference " + (current + 1));
					return false;		
				}
			}
		}
		return true;
	}

}
