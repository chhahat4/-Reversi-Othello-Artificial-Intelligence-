
package othello.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import othello.util.Coin;
import javax.swing.JButton;


public class GUIStarter implements ActionListener {

	private JFrame frame;
	private JRadioButton rdbtnWhite;
	private JRadioButton rdbtnBlack;
	@SuppressWarnings("rawtypes")
	private JComboBox playerComboBox, difficultyComboxBox;
	private JRadioButton rdbtnMinimax;
	private JRadioButton rdbtnAlphaBeta;
	
	private GUIConfig config;
	private JButton btnPlay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIStarter window = new GUIStarter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIStarter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		config = new GUIConfig();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 296, 209);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		GUIUtil.centreWindow(frame);
		frame.setTitle("Othello - Starter");
		
		JLabel lblPlayAs = new JLabel("Play as");
		lblPlayAs.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblPlayAs);
		
		rdbtnWhite = new JRadioButton("White");
		rdbtnWhite.addActionListener(this);
		rdbtnWhite.setSelected(true);
		rdbtnWhite.setBounds(106, 7, 61, 23);
		frame.getContentPane().add(rdbtnWhite);
		
		rdbtnBlack = new JRadioButton("Black");
		rdbtnBlack.addActionListener(this);
		rdbtnBlack.setBounds(169, 7, 109, 23);
		frame.getContentPane().add(rdbtnBlack);
		
		JLabel lblPlayAgainst = new JLabel("Play against");
		lblPlayAgainst.setBounds(10, 40, 71, 14);
		frame.getContentPane().add(lblPlayAgainst);
		
		playerComboBox = new JComboBox();
		playerComboBox.setModel(new DefaultComboBoxModel(othello.gui.PlayerType.values()));
		playerComboBox.setSelectedItem(PlayerType.SequentialPlayer);
		playerComboBox.addActionListener(this);
		playerComboBox.setBounds(116, 37, 141, 20);
		frame.getContentPane().add(playerComboBox);
		
		JLabel lblAlgorithm = new JLabel("Algorithm");
		lblAlgorithm.setBounds(10, 68, 46, 14);
		frame.getContentPane().add(lblAlgorithm);
		
		rdbtnMinimax = new JRadioButton("Minimax");
		rdbtnMinimax.addActionListener(this);
		rdbtnMinimax.setEnabled(false);
		rdbtnMinimax.setBounds(106, 64, 76, 23);
		frame.getContentPane().add(rdbtnMinimax);
		
		rdbtnAlphaBeta = new JRadioButton("Alpha Beta");
		rdbtnAlphaBeta.addActionListener(this);
		rdbtnAlphaBeta.setEnabled(false);
		rdbtnAlphaBeta.setSelected(true);
		rdbtnAlphaBeta.setBounds(184, 64, 109, 23);
		frame.getContentPane().add(rdbtnAlphaBeta);
		
		btnPlay = new JButton("Play!");
		btnPlay.addActionListener(this);
		btnPlay.setBounds(93, 125, 89, 23);
		frame.getContentPane().add(btnPlay);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setBounds(10, 97, 46, 14);
		frame.getContentPane().add(lblDifficulty);
		
		difficultyComboxBox = new JComboBox();
		difficultyComboxBox.setModel(new DefaultComboBoxModel(othello.gui.DifficultyLevel.values()));
		difficultyComboxBox.setSelectedItem(DifficultyLevel.medium);
		difficultyComboxBox.addActionListener(this);
		difficultyComboxBox.setEnabled(false);
		difficultyComboxBox.setBounds(116, 94, 141, 20);
		frame.getContentPane().add(difficultyComboxBox);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(rdbtnWhite)) {
			rdbtnBlack.setSelected(false);
			config.setHumanPlayer(Coin.white);
		} else if(event.getSource().equals(rdbtnBlack)) {
			rdbtnWhite.setSelected(false);
			config.setHumanPlayer(Coin.black);
		} else if(event.getSource().equals(playerComboBox)) {
			config.setPlayerType((PlayerType) playerComboBox.getSelectedItem());
			if(config.getPlayerType() == PlayerType.IdealPlayer) {
				rdbtnAlphaBeta.setEnabled(true);
				rdbtnMinimax.setEnabled(true);
				difficultyComboxBox.setEnabled(true);
			} else {
				rdbtnAlphaBeta.setEnabled(false);
				rdbtnMinimax.setEnabled(false);
				difficultyComboxBox.setEnabled(false);
			}
		} else if(event.getSource().equals(rdbtnMinimax)) {
			rdbtnAlphaBeta.setSelected(false);
		} else if(event.getSource().equals(rdbtnAlphaBeta)) {
			rdbtnMinimax.setSelected(false);
		} else if(event.getSource().equals(btnPlay)) {
			startPlaying();
		} else if(event.getSource().equals(difficultyComboxBox)) {
			config.setDifficultyLevel((DifficultyLevel) difficultyComboxBox.getSelectedItem()); 
		}
	}

	private void startPlaying() {
		frame.setVisible(false);
        frame.dispose();
        new GUIBoard(new GUIConsole(), config);
	}
}
