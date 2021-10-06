// This app needs class Die.java in the root directory
// Susan 10/21

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoDiceGUI extends JFrame implements ActionListener
{
	// instance variables / graphical components for this class
	Font mainFont = new Font("Impact", Font.PLAIN, 32);
	JLabel title = new JLabel("Two Dice Game");
	JLabel playerLabel = new JLabel("The player's roll was:");
	JLabel comLabel = new JLabel("The computer's roll was:");
	JLabel result = new JLabel("");
	JTextField pRoll = new JTextField(4);
	JTextField cRoll = new JTextField(4);
	JButton button = new JButton("Click to Play!");

	// custom constructor for this class
	public TwoDiceGUI()
	{
		super("Two Dice Game");
		setBounds(450, 450, 300, 240);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new FlowLayout());
		setVisible(true);

		title.setFont(mainFont);
		result.setFont(mainFont);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);

		add(title);
		add(playerLabel);
		add(pRoll);
		add(comLabel);
		add(cRoll);
		add(button);
		add(result);

		// add the event listener to the button component
		button.addActionListener(this);
	}

	// event handling method for this class
	@Override
	public void actionPerformed(ActionEvent evt)
	{
		// create two objects from Die.java class
		Die playerDie = new Die();
		Die comDie = new Die();
		String outcome;

		// Processing phase to decide the outcome of the game
		if(playerDie.getDieValue() == comDie.getDieValue())
		{
			outcome = "We have a tie!";
			result.setForeground(Color.BLUE);
		}
		else if(playerDie.getDieValue() > comDie.getDieValue())
		{
			outcome = "The player wins!";
			result.setForeground(Color.GREEN);
		}
		else
		{
			outcome = "The computer wins!";
			result.setForeground(Color.RED);
		}

		// output to the GUI
		pRoll.setText("" + playerDie.getDieValue());
		cRoll.setText("" + comDie.getDieValue());
		result.setText(outcome);
		button.setText("Play Again?");
	}

	public static void main(String[] args)
	{
		TwoDiceGUI frame = new TwoDiceGUI();
	}
}