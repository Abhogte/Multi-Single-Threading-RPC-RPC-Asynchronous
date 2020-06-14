import java.io.*;
import java.net.*;
import java.util.Scanner;

class ClientAS
{
	public static void main(String[] args) throws Exception
	{
		try
		{
			Socket se = new Socket("localhost",6777);
			while(true)
			{
				Scanner input = new Scanner(System.in);
				System.out.println(" ");
				System.out.println("Do you Add, Sort Array, Calculate pi, matrix calculation");
				System.out.println("A - Add, SA - Sort array, CP - calculate Pi, M - Matrix calculation");
				System.out.println("Press AR  for Adition result, PI for Pi result, 'RA' for the value of sorted array 'MR' for the result of Matrix");
				String value = input.nextLine();
				DataOutputStream data = new DataOutputStream(se.getOutputStream()); 
				data.writeUTF(value);
				switch(value)
				{
					case "A":
					Scanner user1 = new Scanner(System.in);

					System.out.println("Enter the First Number for Addition");
					String UserFisrtNumber = user1.nextLine();
					DataOutputStream sendingFirstNumberToServer = new DataOutputStream(se.getOutputStream());
					//int xy = Integer.parseInt(UserFisrtNumber);
					sendingFirstNumberToServer.writeUTF(UserFisrtNumber);
					System.out.println("Enter the Second Number for Addition");
					String UserSecondNumber = user1.nextLine();

					DataOutputStream sendingSecondNumberToServer = new DataOutputStream(se.getOutputStream());
					sendingSecondNumberToServer.writeUTF(UserSecondNumber);

					System.out.println("Connection End");
					break;

					case "CP":
					Scanner user2 = new Scanner(System.in);
					System.out.println("Enter how much time you want to iterate the pi loop");
					String userIterationNumber = user2.nextLine();
					
					DataOutputStream sendingIterationNumber = new DataOutputStream(se.getOutputStream());
					sendingIterationNumber.writeUTF(userIterationNumber);
					System.out.println("Connection End");
					break; 

					case "SA":
					Scanner user3 = new Scanner(System.in);
					System.out.println("Enter the size of an array");
					String userIterationValue = user3.nextLine();
					DataOutputStream sendingIterationValue = new DataOutputStream(se.getOutputStream());
					sendingIterationValue.writeUTF(userIterationValue);
					int x = Integer.parseInt(userIterationValue);
					int y[] = new int[x];
					for(int i=0; i <x; i++)
					{
						
						System.out.println("Enter the value in an array");
						String userArrayValue = user3.nextLine();
						DataOutputStream gettingValueFromUSer = new DataOutputStream(se.getOutputStream());
						gettingValueFromUSer.writeUTF(userArrayValue); 
					}
					System.out.println();
					//System.out.println("The sorted value of an array is: ");
					/*for(int i = 0; i<x; i++)
					{
						DataInputStream gettingSortedData = new DataInputStream(se.getInputStream());
						String displaySortedArray = gettingSortedData.readUTF();

						System.out.println(displaySortedArray);
					}
					System.out.println("Connection End");*/
					break;
					
					case "AR":
					DataOutputStream reqforFirstOperation = new DataOutputStream(se.getOutputStream());
					reqforFirstOperation.writeUTF("Request for result");
					DataInputStream additionResult = new DataInputStream(se.getInputStream());
					String displayResult = additionResult.readUTF();
					//int rel = Integer.parseInt(displayResult);
					System.out.println("The addition of First and Second Number is: " + displayResult);
					break;


					case "PI":  
					DataOutputStream reqforpi = new DataOutputStream(se.getOutputStream());
					reqforpi.writeUTF("request of Pi Result");
					DataInputStream piresultt = new DataInputStream(se.getInputStream());
					String pr = piresultt.readUTF();
					System.out.println(" ");
					System.out.println("The result of pi is:" +pr);
					break;

					case "RA":
					System.out.println("Array result");
					DataInputStream resultForSortArray = new DataInputStream(se.getInputStream());
					String displayResulForArraySort = resultForSortArray.readUTF();
					System.out.println(" ");
					System.out.println("The result of sorted array is: " +displayResulForArraySort);
					break;

					case "M":
					//Remove indentation once you implied the matrix code
		/*			System.out.println("Matrix Result");
					DataInputStream gettingResultFirstRow = new DataInputStream(se.getInputStream());
					String displayingResultFirstRow = gettingResultFirstRow.readUTF();
					System.out.println(displayingResultFirstRow);

					DataInputStream gettingResultSecondRow = new DataInputStream(se.getInputStream());
					String displayResultSecondRow = gettingResultSecondRow.readUTF();
					System.out.println(displayResultSecondRow);

					DataInputStream gettingResultThirdRow = new DataInputStream(se.getInputStream());
					String displayResultThirdRow = gettingResultThirdRow.readUTF();
					System.out.println(displayResultThirdRow);      */

					Scanner user4 = new Scanner(System.in);
					System.out.println("Enter the First Element");
					String one = user4.nextLine();
					DataOutputStream first = new DataOutputStream(se.getOutputStream());
					first.writeUTF(one);

					System.out.println("Enter the Second Element");
					String two = user4.nextLine();
					DataOutputStream second = new DataOutputStream(se.getOutputStream());
					second.writeUTF(two);

					System.out.println("Enter the Third Element");
					String three = user4.nextLine();
					DataOutputStream third = new DataOutputStream(se.getOutputStream());
					second.writeUTF(three);


					System.out.println("Enter the Fourth Element");
					String four = user4.nextLine();
					DataOutputStream fourth  = new DataOutputStream(se.getOutputStream());
					second.writeUTF(four);


					System.out.println("Enter the Fifth Element");
					String five = user4.nextLine();
					DataOutputStream fifth = new DataOutputStream(se.getOutputStream());
					second.writeUTF(five);


					System.out.println("Enter the sixth Element");
					String six = user4.nextLine();
					DataOutputStream sixth = new DataOutputStream(se.getOutputStream());
					second.writeUTF(six);


					System.out.println("Enter the Seventh Element");
					String seven = user4.nextLine();
					DataOutputStream seventh = new DataOutputStream(se.getOutputStream());
					second.writeUTF(seven);


					System.out.println("Enter the Eighth Element");
					String eight = user4.nextLine();
					DataOutputStream eighth = new DataOutputStream(se.getOutputStream());
					second.writeUTF(eight);


					System.out.println("Enter the nineth Element");
					String nine = user4.nextLine();
					DataOutputStream nineth = new DataOutputStream(se.getOutputStream());
					second.writeUTF(nine);

					System.out.println("Enter the Tenth Element");
					String ten = user4.nextLine();
					DataOutputStream tenth = new DataOutputStream(se.getOutputStream());
					second.writeUTF(ten);


					System.out.println("Enter the Eleventh Element");
					String eleven = user4.nextLine();
					DataOutputStream eleventh = new DataOutputStream(se.getOutputStream());
					second.writeUTF(eleven);

					System.out.println("Enter the Twelveth Element");
					String twelve = user4.nextLine();
					DataOutputStream twelveth = new DataOutputStream(se.getOutputStream());
					second.writeUTF(twelve);

					System.out.println("Enter the Thirteenth Element");
					String thirteen = user4.nextLine();
					DataOutputStream thirteenth = new DataOutputStream(se.getOutputStream());
					second.writeUTF(thirteen);

					System.out.println("Enter the Fourteenth Element");
					String fourteen = user4.nextLine();
					DataOutputStream fourteenth = new DataOutputStream(se.getOutputStream());
					second.writeUTF(fourteen);	

					System.out.println("Enter the Fifteenth Element");
					String fifteen = user4.nextLine();
					DataOutputStream fifteenth = new DataOutputStream(se.getOutputStream());
					second.writeUTF(fifteen);

					System.out.println("Enter the Sixteenth Element");
					String sixteen = user4.nextLine();
					DataOutputStream sixteenth = new DataOutputStream(se.getOutputStream());
					second.writeUTF(sixteen);

					System.out.println("Enter the Seventeenth Element");
					String seventeen = user4.nextLine();
					DataOutputStream seventeenth = new DataOutputStream(se.getOutputStream());
					second.writeUTF(seventeen);

					System.out.println("Enter the Eighteenth Element");
					String eighteen = user4.nextLine();
					DataOutputStream eighteenth = new DataOutputStream(se.getOutputStream());
					second.writeUTF(eighteen);
					break;

					case "MR":
					DataInputStream gettingResultFirstRow = new DataInputStream(se.getInputStream());
					String displayingResultFirstRow = gettingResultFirstRow.readUTF();
					System.out.println(displayingResultFirstRow);

					DataInputStream gettingResultSecondRow = new DataInputStream(se.getInputStream());
					String displayResultSecondRow = gettingResultSecondRow.readUTF();
					System.out.println(displayResultSecondRow);

					DataInputStream gettingResultThirdRow = new DataInputStream(se.getInputStream());
					String displayResultThirdRow = gettingResultThirdRow.readUTF();
					System.out.println(displayResultThirdRow);
					break;


	
				}	
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}