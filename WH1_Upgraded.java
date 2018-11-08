import java.util.Random;

import javax.swing.JOptionPane;

public class WH1_Upgraded {

	public static void main(String[] args) {
		// This game made by David Zherdenovsky Ltd. all rights reserved!
		
		String player1 ="";
		String player2 ="";
		int minNumber =0;
		int maxNumber =0;
		// Game description:
		JOptionPane.showMessageDialog(null, "Hello and welcome to my game! \n"
				+ "In this game your goal is to guess the number i will choose for you, the first to guess the number wins!\n"
				+ "The game made by David Zherdenovsky.");
		
		//The players are now choosing names:
			
		player1 = JOptionPane.showInputDialog(null,"Player 1, please type your name below:");
		player2 = JOptionPane.showInputDialog(null,"Player 2, please type your name below:");
		int chosenLevel=0;//for some reason using boolean didn't work so i used an int, i don't really care what var is it as long as it works.
		//=========================================space for easy reading
		
		do {
			String level = JOptionPane.showInputDialog(null,"Please choose a difficulty level:\n'E' for Easy (number between 1-10)\n"
					+ "'M' for Medium (number between 1-100)\n'H' for Hard (number between 1-1000)\n"
					+ "'C' for custom game (you choose the numbers range)");
			if (level.equals("E") || level.equals("e")) {
				//as an upgrade i added the option to skip choosing range by just choosing a difficulty level
				minNumber =1;
				maxNumber =10;
				chosenLevel=1;//as long this number isn't 2 the loop ends, so 1 isn't really important as long as it is not 2.
			}
			else if (level.equals("M") || level.equals("m")) {
				minNumber =1;
				maxNumber =100;
				chosenLevel=1;
			}
			else if (level.equals("H") || level.equals("h")) {
				minNumber =1;
				maxNumber =1000;
				chosenLevel=1;
			}
			else if (level.equals("C") || level.equals("c")) {
				String minRange;
				String maxRange;
				
				do {
					
					  
						  minRange=JOptionPane.showInputDialog(null, "Hi "+player1+" and "+player2+"! Please choose the minimal number in the range:");
						  minNumber = Integer.parseInt(minRange);
	//=====================================================================================the note is just for easy reading
						  maxRange=JOptionPane.showInputDialog(null, "Please choose the maximal number in the range:");
						  maxNumber = Integer.parseInt(maxRange);
							
					  
					  maxNumber = Integer.parseInt(maxRange);
				    	// making sure the minimal number is lower than the maximal.
					if (minNumber>=maxNumber) {
						JOptionPane.showMessageDialog(null, "Please make sure that the minimal number is lower than the maximal number!\n and the input is numbers only!");
						continue;
					}
				}while(minNumber>=maxNumber);
				chosenLevel=1;
			}else {
				JOptionPane.showMessageDialog(null, "Sorry, you didn't choose any of the difficulties, please try again!");
				chosenLevel=2;//in this case we want to restart and give another chance to choose difficulty so we use the 2 to "continue" the loop
			}
		}while(chosenLevel==2);
		//=========================================end of level choosing loop
			Random randomNumber = new Random();
			// Java choosing random number
			int answer = randomNumber.nextInt(maxNumber - minNumber) + minNumber;
			JOptionPane.showMessageDialog(null, "I chose a number between " + minNumber + " and " + maxNumber + ", now you need to guess it, good luck!");
			// making sure i got all the vars ready before the loop, i don't want to search for var bugs in such a long loop...
			boolean guessRight = false;
			boolean p1turn = true;
			boolean p2turn = false;//I could say p1turn=false, but i think its more understandable to say p2turn=true
			int pick1 =0;
			int pick2=0;
			int p1count =0;
			int p2count =0;
			while(guessRight=true) {
				if (p1turn = true) {
					if(p1count==0) {//if it is the first turn i need to makes sure the program won't add
						           //any unnecessary text.
						String pickStr = JOptionPane.showInputDialog(null, player1 + " please guess a number!");
						pick1 = Integer.parseInt(pickStr);
					}else {//here we use the hints in case it's not his first turn
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
					//----------------------here we get all the options available as input of player1
					if (pick1 == answer) {
						JOptionPane.showMessageDialog(null, "WOW "+player1+"! You did it! it's the number i chose! \nIt took you "+(p1count+1)+" turns to catch me!");
						System.exit(0);
					}else if(pick1<answer){
						p1count ++;
						
						p2turn = true;
						p1turn = false;
					}else {
						p1count++;
						
						p2turn = true;
						p1turn = false;
					}
					//-----------------------here we control player2 activity
					if (p2turn = true) {/*all goes again for player 2 
						(i could use if(p1turn=false) but i wanted to make sure i will find my self faster and easier)*/
						if (pick1>answer) {//i know he plays second so anyway he will get a hint doesn't matter if it's his first turn or not....
							String pickStr2 = JOptionPane.showInputDialog(null, player2 + " please guess a number, and don't forget that "+pick1+" is higher than my number.");
							pick2 = Integer.parseInt(pickStr2);
						}else if(pick1<answer) {
							String pickStr2 = JOptionPane.showInputDialog(null, player2 + " please guess a number, and don't forget that "+pick1+" is lower than my number.");
							pick2 = Integer.parseInt(pickStr2);
						}
						
						if (pick2 == answer) {//all the options available 
							JOptionPane.showMessageDialog(null, "WOW "+player2+"! You did it! it's the number i chose! \nIt took you "+(p2count+1)+" turns to catch me!");
							System.exit(0);
						}else if(pick2<answer){
							p2count++;
							
							p1turn = true;
							p2turn = false;
						}else {
							p2count++;
							
							p1turn = true;
							p2turn = false;
						}
					}
				}
			}
				
			
	}
		
}

				
		


		
		
		
	


			
			
		

	