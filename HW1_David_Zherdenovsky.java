import javax.swing.JOptionPane;
import java.util.Random;
public class HW1_David_Zherdenovsky {

	public static void main(String[] args) {
		// This game made by David Zherdenovsky Ltd. all rights reserved!
		
		String player1 ="";
		String player2 ="";
		int minNumber =0;
		int maxNumber =0;
		// Game description:
		JOptionPane.showMessageDialog(null, "Hello and welcome to my game! \nIn this game your goal is to guess the number i will choose for you, the first to guess the number wins!\nThe game made by David Zherdenovsky.");
		
		//The players are now choosing names:
		String nameChoise;
		player1 = JOptionPane.showInputDialog("Player 1, please type your name below:");
		player2 = JOptionPane.showInputDialog("Player 2, please type your name below:");
		
		
		do {
		  
		  String rangeChoise;
		  String minRange=JOptionPane.showInputDialog(null, "Hi "+player1+" and "+player2+"! Please choose the minimal number in the range:");
		  minNumber = Integer.parseInt(minRange);
		  String maxRange=JOptionPane.showInputDialog(null, "Please choose the maximal number in the range:");
		  maxNumber = Integer.parseInt(maxRange);
	    	// making sure the minimal number is lower than the maximal.
		  if (minNumber >= maxNumber) {
			  JOptionPane.showMessageDialog(null, "please make sure the maximal number is greater than the minimal!");
			  continue;
		  }
		}while(minNumber >= maxNumber);
		Random randomNumber = new Random();
		// Java choosing random number
		int answer = randomNumber.nextInt(maxNumber - minNumber) + minNumber;
		JOptionPane.showMessageDialog(null, "I chose a number between " + minNumber + " and " + maxNumber + ", now you need to guess it, good luck!");
		// Guess loop starts here.
		boolean guessRight = false;
		boolean p1turn = true;
		boolean p2turn = false;
		int pick1=0;
		int pick2=0;
		int p1count =0;
		int p2count =0;
		while(!guessRight) {
			if (p1turn = true) {
				if(p1count<1) {
					String pickStr = JOptionPane.showInputDialog(null, player1 + " please guess a number!");
					pick1 = Integer.parseInt(pickStr);
				}else {
				if(pick2<answer) {
					String pickStr = JOptionPane.showInputDialog(null, player1 + " please guess a number and don't forget that "+pick2+" is lower than my number.");
					pick1 = Integer.parseInt(pickStr);
				}else if(pick2>answer) {
					String pickStr = JOptionPane.showInputDialog(null, player1 + " please guess a number and don't forget that "+pick2+" is higher than my number.");
					pick1 = Integer.parseInt(pickStr);
				}else {
					String pickStr = JOptionPane.showInputDialog(null, player1 + " please guess a number!");
					pick1 = Integer.parseInt(pickStr);
				}
				}
				//-------------------------------------------------------------------------------------------------------------------------------------------------------------
				if (pick1 == answer) {
					JOptionPane.showMessageDialog(null, "WOW "+player1+"! You did it! it's the number i chose! \nIt took you "+(p1count+1)+" turns to catch me!");
					System.exit(0);
				}else if(pick1<answer){
					p1count ++;
					JOptionPane.showMessageDialog(null, "Sorry "+player1+", my number is higher. "+player2+" it's your turn now!");
					p2turn = true;
					p1turn = false;
				}else {
					p1count++;
					JOptionPane.showMessageDialog(null, "Sorry "+player1+", my number is lower. "+player2+" it's your turn now!");
					p2turn = true;
					p1turn = false;
				}
				//---------------------------------------------------------------------------------------------------------------------------------------------------------------
				if (p2turn = true) {
					if (pick1>answer) {
						String pickStr2 = JOptionPane.showInputDialog(null, player2 + " please guess a number, and don't forget that "+pick1+" is higher than my number.");
						pick2 = Integer.parseInt(pickStr2);
					}else if(pick1<answer) {
						String pickStr2 = JOptionPane.showInputDialog(null, player2 + " please guess a number, and don't forget that "+pick1+" is lower than my number.");
						pick2 = Integer.parseInt(pickStr2);
					}
					
					if (pick2 == answer) {
						JOptionPane.showMessageDialog(null, "WOW "+player2+"! You did it! it's the number i chose! \nIt took you "+(p2count+1)+" turns to catch me!");
						System.exit(0);
					}else if(pick2<answer){
						p2count++;
						JOptionPane.showMessageDialog(null, "Sorry "+player2+", my number is higher. "+player1+" it's your turn now!");
						p1turn = true;
						p2turn = false;
					}else {
						p2count++;
						JOptionPane.showMessageDialog(null, "Sorry "+player2+", my number is lower. "+player1+" it's your turn now!");
						p1turn = true;
						p2turn = false;
					}
				}
			}
		}
		
		
	}

}
