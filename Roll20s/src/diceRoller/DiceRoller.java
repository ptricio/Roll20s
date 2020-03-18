package diceRoller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class DiceRoller extends JFrame {
	private String[] dice = {"D3", "D4", "D6", "D8", "D10", "D20"};
	private int[] diceNum = {3,4,6,8,10,20};
	private String[] nums = {"1","2","3","4","5","6", "7", "8","9","10",
							"11","12","13","14","15","16","17","18","19","20"};
	private String[] col = {"Dice Roll", "Amount of Rolls"};
	private int[] results = new int[20];

	private JPanel contentPane;
	private JTextField numTxtField;
	private JTable table;
	private JComboBox diceCombo;

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
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel northPnl = createNorthPanel();
		contentPane.add(northPnl, BorderLayout.NORTH);
		
		JButton RollBtn = new JButton("Roll It!");
		RollBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num;
				int dice = diceNum[diceCombo.getSelectedIndex()];
				String input = numTxtField.getText();
				Random rand = new Random();
				try {
					 num = Integer.parseInt(input);
					 if(num > 0 && num <=100) {
						 for(int i = 0; i < num; i++) {
							 results[rand.nextInt(dice)]++;
						 }
					 }
					 for(int el: results) {
						 System.out.println(el);
					 }
				}catch(NumberFormatException n){
					//TODO pop up must be a number entered
				}
				table.addColumn("Dice");
				for(int i = 0; i < 20; i++) {
					table.add(i, i+1);
				}
				
			}
		});
		contentPane.add(RollBtn, BorderLayout.SOUTH);
		
		JPanel centerPanel = createCenterPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
	}

	private JPanel createCenterPanel() {
		JPanel centerPanel = new JPanel();
		
		
		table = new JTable();
		centerPanel.add(table);
		//table.setTableHeader("Dice number", "Numer of Rolls");
		return centerPanel;
	}

	private JPanel createNorthPanel() {
		JPanel northPnl = new JPanel();
		
		northPnl.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel DiceLbl = new JLabel("Dice:");
		DiceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		northPnl.add(DiceLbl);
		
		diceCombo = new JComboBox(dice);
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
