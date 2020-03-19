package diceRoller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class DiceRoller extends JFrame {
	private String[] dice = {"D3", "D4", "D6", "D8", "D10", "D20"};
	private int[] diceNum = {3,4,6,8,10,20};
	private int[] results = new int[20];
	

	private JPanel contentPane;
	private JTextField numTxtField;
	private JComboBox<String> diceCombo;
	private JLabel lblRollOnes = new JLabel("Number of 1's");
	private JLabel lblRollTwos = new JLabel("Number of 2's");
	private JLabel lblRollThrees = new JLabel("Number of 3's");
	private JLabel lblRollFours = new JLabel("Number of 4's");
	private JLabel lblRollFives = new JLabel("Number of 5's");
	private JLabel lblRollSixs = new JLabel("Number of 6's");
	private JLabel lblRollSevens = new JLabel("Number of 7's");
	private JLabel lblRollEights = new JLabel("Number of 8's");
	private JLabel lblRollNines = new JLabel("Number of 9's");
	private JLabel lblRollTens = new JLabel("Number of 10's");
	private JLabel lblRollElevens = new JLabel("Number of 11's");
	private JLabel lblRollTwelves = new JLabel("Number of 12's");
	private JLabel lblRollThirteens = new JLabel("Number of 13's");
	private JLabel lblRollFourteens = new JLabel("Number of 14's");
	private JLabel lblRollFifteen = new JLabel("Number of 15's");
	private JLabel lblRollSixteen = new JLabel("Number of 16's");
	private JLabel lblRollSeventeen = new JLabel("Number of 17's");
	private JLabel lblRollEighteen = new JLabel("Number of 18's");
	private JLabel lblRollNineteen = new JLabel("Number of 19's");
	private JLabel lblRollTwenty = new JLabel("Number of 20's");
	
	private JLabel[] labels = {lblRollOnes, lblRollTwos, lblRollThrees,lblRollFours,lblRollFives,lblRollSixs,lblRollSevens,
							   lblRollEights,lblRollNines,lblRollTens,lblRollElevens,lblRollTwelves,lblRollThirteens,
							   lblRollFourteens,lblRollFifteen,lblRollSixteen,lblRollSeventeen,lblRollEighteen,
							   lblRollNineteen,lblRollTwenty};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiceRoller frame = new DiceRoller();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DiceRoller() {
		setTitle("Roll20's!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel northPnl = createNorthPanel();
		contentPane.add(northPnl, BorderLayout.NORTH);
		
		JButton RollBtn = createRollButton();
		contentPane.add(RollBtn, BorderLayout.SOUTH);
		
		JPanel centerPanel = createCenterPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
	}

	/**
	 * Creates a button on the south part of layout holds the logic
	 * to roll numbers and populate labels
	 * @return
	 */
	private JButton createRollButton() {
		JButton RollBtn = new JButton("Roll It!");
		RollBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num;
				int dice = diceNum[diceCombo.getSelectedIndex()];
				String input = numTxtField.getText();
				Random rand = new Random();
				
				for(int i = 0; i < results.length; i++) {
					results[i] = 0;
				}
				
				try {
					 num = Integer.parseInt(input);
					 if(num > 0 && num <=100) {
						 for(int i = 0; i < num; i++) {
							 results[rand.nextInt(dice)]++;
						 }
					 }else if(num <= 0) {
						 JOptionPane.showConfirmDialog(null,
					                "Must be a positive number between 1-100",
					                "Invalid Input",
					                JOptionPane.DEFAULT_OPTION,
					                JOptionPane.PLAIN_MESSAGE);
					 }else if(num > 100) {
						 JOptionPane.showConfirmDialog(null,
					                "Must be a positive number between 1-100",
					                "Invalid Input",
					                JOptionPane.DEFAULT_OPTION,
					                JOptionPane.PLAIN_MESSAGE);
					 }
				}catch(NumberFormatException n){
					JOptionPane.showConfirmDialog(null,
			                "Must enter a number between 1-100",
			                "Invalid Input",
			                JOptionPane.DEFAULT_OPTION,
			                JOptionPane.PLAIN_MESSAGE);
				}
				//table.addColumn("Dice");
				for(int i = 0; i < 20; i++) {
					labels[i].setText("");
					String temp ="" + results[i];
					labels[i].setText(temp); 
				}
				
			}
		});
		return RollBtn;
	}

	/**
	 * Creates panels and labels that populate the center
	 * of the gui
	 * @return
	 */
	private JPanel createCenterPanel() {
		JPanel centerPanel = new JPanel();
		
		JPanel leftPanel = createLeftPanel();
		
		centerPanel.add(leftPanel);
		
		JPanel rightPanel = createRightPanel();
		centerPanel.add(rightPanel);
		return centerPanel;
	}

	/**
	 * Creates the right panel in the center panel
	 * @return
	 */
	private JPanel createRightPanel() {
		JPanel rightPanel = new JPanel();
		
		rightPanel.setLayout(new GridLayout(21, 0, 0, 1));
		
		JLabel lblRoll = new JLabel("Number of Rolls");
		lblRoll.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRoll);
		
		lblRollOnes.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollOnes);
		
		
		lblRollTwos.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollTwos);
		
		
		lblRollThrees.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollThrees);
		
		
		lblRollFours.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollFours);
		
		
		lblRollFives.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollFives);
		
		
		lblRollSixs.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollSixs);
		
		
		lblRollSevens.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollSevens);
		
		
		lblRollEights.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollEights);
		
		
		lblRollNines.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollNines);
		
		
		lblRollTens.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollTens);
		
		
		lblRollElevens.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollElevens);
		
		
		lblRollTwelves.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollTwelves);
		
		
		lblRollThirteens.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollThirteens);
		
		
		lblRollFourteens.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollFourteens);
		
		
		lblRollFifteen.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollFifteen);
		
		
		lblRollSixteen.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollSixteen);
		
		
		lblRollSeventeen.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollSeventeen);
		
		
		lblRollEighteen.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollEighteen);
		
		
		lblRollNineteen.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollNineteen);
		
		
		lblRollTwenty.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblRollTwenty);
		return rightPanel;
	}

	/**
	 * Creates the left panel in the center panel
	 * @return
	 */
	private JPanel createLeftPanel() {
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftPanel.setLayout(new GridLayout(21, 0, 0, 1));
		
		JLabel diceRow = new JLabel("Dice Number");
		leftPanel.add(diceRow);
		
		JLabel lblOne = new JLabel("1:       -");
		lblOne.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblOne);
		
		JLabel lblTwo = new JLabel("2:       -");
		lblTwo.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblTwo);
		
		JLabel lblThree = new JLabel("3:       -");
		lblThree.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblThree);
		
		JLabel lblFour = new JLabel("4:       -");
		lblFour.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblFour);
		
		JLabel lblFive = new JLabel("5:       -");
		lblFive.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblFive);
		
		JLabel lblSix = new JLabel("6:       -");
		lblSix.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblSix);
		
		JLabel lblSeven = new JLabel("7:       -");
		lblSeven.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblSeven);
		
		JLabel lblEight = new JLabel("8:       -");
		lblEight.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblEight);
		
		JLabel lblNine = new JLabel("9:       -");
		lblNine.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblNine);
		
		JLabel lblTen = new JLabel("10:     -");
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblTen);
		
		JLabel lblEleven = new JLabel("11:     -");
		lblEleven.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblEleven);
		
		JLabel lblTwelve = new JLabel("12:     -");
		lblTwelve.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblTwelve);
		
		JLabel lblThirteen = new JLabel("13:     -");
		lblThirteen.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblThirteen);
		
		JLabel lblFourteen = new JLabel("14:     -");
		lblFourteen.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblFourteen);
		
		JLabel lblFifteen = new JLabel("15:     -");
		lblFifteen.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblFifteen);
		
		JLabel lblSixteen = new JLabel("16:     -");
		lblSixteen.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblSixteen);
		
		JLabel lblSeventeen = new JLabel("17:     -");
		lblSeventeen.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblSeventeen);
		
		JLabel lblEighteen = new JLabel("18:     -");
		lblEighteen.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblEighteen);
		
		JLabel lblNineteen = new JLabel("19:     -");
		lblNineteen.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblNineteen);
		
		JLabel lblTwenty = new JLabel("20:     -");
		lblTwenty.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblTwenty);
		return leftPanel;
	}

	/**
	 * Creates the north panel that holds the dice
	 * selections
	 * @return
	 */
	private JPanel createNorthPanel() {
		JPanel northPnl = new JPanel();
		
		northPnl.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel DiceLbl = new JLabel("Dice:");
		DiceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		northPnl.add(DiceLbl);
		
		diceCombo = new JComboBox<String>(dice);
		northPnl.add(diceCombo);
		
		JLabel numLbl = new JLabel("Number of Dice:");
		numLbl.setHorizontalAlignment(SwingConstants.CENTER);
		northPnl.add(numLbl);
		
		numTxtField = new JTextField();
		numTxtField.setText("1-100");
		northPnl.add(numTxtField);
		numTxtField.setColumns(10);
		return northPnl;
	}

}
