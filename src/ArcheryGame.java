import java.security.SecureRandom;  		

import java.util.Scanner;					


public class ArcheryGame {					
	
   final static int MAX_ROUND = 10;			
   final static int MAX_SCORE = 30;

   public static void main (String [] args) { 
	
	    int round = 1;
	    int experience = 0;
	    int randomNumber1;
	    int randomNumber2;
	    char endOfGame = 'y';
	    int choice = 0;
	    int j =0; int k =0;
	    
	SecureRandom random= new SecureRandom();
	
	Scanner input = new Scanner (System.in);
	
	System.out.println("*****CHALLENGE THE ARCHERY CHAMP*****"); 

	System.out.println("\nBeat the champ(computer) by scoring higher than the champ's score but not more than 30 points.\nIf you score more than 30 you will lose!");

	System.out.println("\nYou have to start game by shooting 2 arrows first. \n");
	
	
	while(round <= MAX_ROUND ) {	//While loop starts loop 1
		
		while(endOfGame != 'n') {		//nested loop sentinel while control statement  loop 2
			
			//declaring variables
			int sum1 =0;
		    int sum2 =0;
		    int shot =0;
		    int shot1=0;
		    
			j++;
			k++;
			
	        System.out.println("\n*****Round"+ round++ + "*****"); 
	        System.out.println("\nChallenger has "+ experience++ +" experience\n");
	        
	            for(int i = 0; i<2;i++) { 		//for loop which is a nested loop  loop 3
	            	
	            	randomNumber1 = j + random.nextInt(11-j);
		           
		           if(randomNumber1 <6) { 				//conditional statement
		        	   randomNumber1=0;
			         System.out.println("Shot"+ ++shot + "....Challenger misses board....no points!");
		           }
		           
		           else {
	                 System.out.println("Shot"+ ++shot +"....Challenger shots...." + randomNumber1);
		           }
	                 sum1+=randomNumber1;
	               }							//for loop ends loop 3 
	
	                System.out.println("\nCHALLENGER'S SCORE...."+ sum1+"\n");
	
	                
	           while(sum1<MAX_SCORE && sum1>sum2 ) {	//while loop loop 4
	
		               System.out.println("\nMake Choice: \n1.Shoot another arrow.\n2.Challenge the champ.");
		            
		               System.out.print("\nChoice: ");
		            
		               choice = input.nextInt();  		//user input 
		       
		            if(choice == 1) {					//Conditional statement
			        
		            	randomNumber1 = k + random.nextInt(11-k);
			            System.out.println("\nShot"+ ++shot +"....Challanger shots...."+randomNumber1);
			        
			            sum1+=randomNumber1;
			        
			            System.out.println("\nCHALLANGER'S SCORE...."+ sum1+"\n");
			
			            if (sum1>= MAX_SCORE) {			//Conditional statement
			            	
				           System.out.println("YOU LOSE! "+ sum1+" is over the max score.");
				
			             }								
		           }									
	
	
			       if(choice == 2) {					//Conditional statement 
					
				        while (sum2<=sum1) {			//while loop starts loop 5
				        	
						randomNumber2 = (6+random.nextInt(5));
						
					    System.out.println("Shot"+ ++shot1+"....Champion shots...."+randomNumber2);
					    
				     	sum2+=randomNumber2;
				        }								//while loop ends loop 5
				
					    System.out.println("\nCHAMPION'S SCORE...."+ sum2+"\n");
					    
				  if (sum2>= MAX_SCORE) {	
						System.out.println("YOU WON! Champion score "+sum2+" is over the max.");
				  }							
					  
			      else if (sum2<sum1) {		
				        System.out.println("YOU WON! "+sum1+" is greater than "+ sum2+"."); 
				  }							
				  
			      else if(sum2>sum1) {	
				        System.out.println("YOU LOSE! "+sum2+" is greater than "+ sum1+".");
			      }						
			 
			      else if (sum2==sum1) { 	
				        System.out.println("Match is tied!!! "+ sum2 + " is equals to "+ sum1);
			      }							
			    }							//Conditional statement
	        }								//while loop ends loop 4
			
		  if(round>MAX_ROUND) {		
			 System.out.print("\nYou have reached the maximum limit of Rounds! Press 'n' to quit : ");
		  }							//if ends
		  System.out.print("Do you want to play another round? Press 'y' to play or 'n' to quit : ");	
	     endOfGame = input.next().charAt(0);			// input in char
	     
         if(endOfGame == 'n') {		
    	     System.out.println("\n\nThanks for playing the game.\n\nYou end with Level "+ (experience-1)+" experience.");
          }							
  
       }		//end of nested while sentinel control loop  loop 2
      }			//end of while loop loop 1
    }			
  }				