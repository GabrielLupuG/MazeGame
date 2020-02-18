import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class VotingSystem extends JFrame{
	
	private JButton btnStartVoting, btnCastVote, btnCloseVoting, btnCountVotes;
	
	private ArrayList<Vector<Integer>> votesCast = new ArrayList<Vector<Integer>>();
	
	public VotingSystem() {
		
		super("Voting System");
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel();
		btnStartVoting = new JButton("START");
		btnStartVoting.setEnabled(true);
		buttonPanel.add(btnStartVoting);
		btnCastVote = new JButton("VOTE");
		btnCastVote.setEnabled(false);
		buttonPanel.add(btnCastVote);
		btnCloseVoting = new JButton("CLOSE");
		btnCloseVoting.setEnabled(false);
		buttonPanel.add(btnCloseVoting);
		btnCountVotes = new JButton("COUNT");
		btnCountVotes.setEnabled(false);
		buttonPanel.add(btnCountVotes);
		
		btnStartVoting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCloseVoting.setEnabled(true);
				btnCastVote.setEnabled(true);
				btnStartVoting.setEnabled(false);
			}
		});
		
		btnCastVote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BallotPaper(VotingSystem.this);
			}
		});
		
		btnCloseVoting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCastVote.setEnabled(false);
				btnCountVotes.setEnabled(true);
				btnCloseVoting.setEnabled(false);
			}
		});
		
		btnCountVotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] voteTotals = new int[10];
				for(Vector<Integer> vote : votesCast) {
					for (int pos = 0; pos < vote.size(); pos++) {
						if (vote.get(pos) == 1) 
							voteTotals[pos]++;
					}
				}
				
				String[] candidateTitles = new String[10];

				
				candidateTitles[0] = "BOYD-BARRETT - PEOPLE BEFORE PROFIT";
				candidateTitles[1] = "HEALY-RAE - NON-PARTY";
				candidateTitles[2] = "HOWLIN - THE LABOUR PARTY";
				candidateTitles[3] = "MARTIN - FIANNA FÁIL";
				candidateTitles[4] = "McDONALD - SINN FÉIN";
				candidateTitles[5] = "McGRATH - NON-PARTY";
				candidateTitles[6] = "MURPHY - SOCIAL DEMOCRATS";
				candidateTitles[7] = "RYAN - GREEN PARTY";
				candidateTitles[8] = "TÓIBÍN - AONTÚ";
				candidateTitles[9] = "VARADKAR - FINE GAEL";
				
				for (int i = 0; i < voteTotals.length; i++) {
					System.out.println(candidateTitles[i] + "\t" + voteTotals[i]);
				}
				
			}
		});
		
		c.add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
	
	}
	
	public void castVote(Vector<Integer> newVote) {
		votesCast.add(newVote);
	}
	
	public static void main(String[] args) {
		VotingSystem vs = new VotingSystem();
		vs.setSize(400,200);
		vs.setVisible(true);
		
	}

}
