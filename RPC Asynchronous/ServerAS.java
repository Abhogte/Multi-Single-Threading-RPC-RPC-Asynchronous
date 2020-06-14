import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
class ServerAS
{
	public static void main(String[] args)
	{
		try
		{
			String addResult = " ";
			double normalPi = 0;
			double pi;
			String a = " ";
			
			int firstRowFirstColumn = 0;
			int firstRowSecondColumn = 0;
			int firstRowThirdColumn = 0;

			int secondRowFirstColumn = 0;
			int secondRowSecondColumn = 0;
			int secondRowThirdColumn = 0;

			int thirdRowFirstColumn = 0;
			int thirdRowSecondColumn = 0;
			int thirdRowThirdColumn = 0;
				
			

			ServerSocket server = new ServerSocket(6777);
			Socket se = server.accept();
			
			while(true)
			{
				DataInputStream dis = new DataInputStream(se.getInputStream());
				String msg = dis.readUTF();
				
				
				System.out.println(msg);
				switch(msg)
				{
					case "A":
					System.out.println("Inside Addition");
					DataInputStream fistNumberComingFromUsers = new DataInputStream(se.getInputStream());
					String storingFirstNumber = fistNumberComingFromUsers.readUTF();
					int first = Integer.parseInt(storingFirstNumber);
					System.out.println(first);

					DataInputStream secondNumberComingFromUsers = new DataInputStream(se.getInputStream());
					String storingSecondNumbers = secondNumberComingFromUsers.readUTF();
					int second = Integer.parseInt(storingSecondNumbers);
					System.out.println(second);

					int result = first + second;
					
					addResult = Integer.toString(result);
					System.out.println(addResult);
					break;

					case "CP":
					System.out.println("Inside Pi");
					DataInputStream iterationFromUser = new DataInputStream(se.getInputStream());
					String storingIterationNumbers = iterationFromUser.readUTF();
					// Chnage variable of pi functionality
					double xi = Double.parseDouble(storingIterationNumbers);



					System.out.println(xi);
					
					pi = 1.0;
					int s = 1; 
					double ji;
					for(ji = xi; ji < 10000.0; ji = ji+2);
					{
						if(s % 2 == 0)
							pi = pi + (1/ji);
						else
							pi = pi - (1/ji);
						s = s + 1;
					}
					normalPi = 4*pi;
					System.out.println(normalPi);
					System.out.println("Connection End");
					break;

					case "SA":
					
					System.out.println("Inside Sorting Array");
					DataInputStream fistNumberComingFromUser = new DataInputStream(se.getInputStream());
					String firstNumber = fistNumberComingFromUser.readUTF();
					System.out.println(firstNumber);
					int n = Integer.parseInt(firstNumber);
					System.out.println("Value converted to int: " + n);
					int y[] = new int[n];
					//int j = 0;
					for(int i=0; i<n; i++)
					{
						DataInputStream stringToGetUserInputerValue = new DataInputStream(se.getInputStream());
						String stringToGetUserInput = stringToGetUserInputerValue.readUTF(); 
						int z =  Integer.parseInt(stringToGetUserInput);
						y[i] = z;	
					}

					for(int i = 0; i<n; i++)
					{	
						
						System.out.println("The value of array is: " +y[i]);
				
					}
					Arrays.sort(y);
					for(int i = 0; i<n; i++)
					{
						System.out.println(y[i]);
					}
					
					for(int i = 0; i<n; i++)
					{
						int b = y[i];
						a = String.valueOf(b);
						//DataOutputStream sendingSortedarray = new DataOutputStream(se.getOutputStream());
						//sendingSortedarray.writeUTF(a);
						break;
					}	
					System.out.println(" ");
					


					case "AR":
					DataInputStream reqDisplay = new DataInputStream(se.getInputStream());
					String isd = reqDisplay.readUTF();
					System.out.println(isd);
					System.out.println(); 
					System.out.println("Inside AR");
					String addResults = addResult; 
					DataOutputStream sendingResultToUser = new DataOutputStream(se.getOutputStream());
					sendingResultToUser.writeUTF(addResults);
					System.out.println("Connection End");
					break;	


					case "PI":
					DataInputStream PIDisplay =new DataInputStream(se.getInputStream());
					String pi1=PIDisplay.readUTF();
					double sendNormalPi = normalPi;
					System.out.println("I am here" + sendNormalPi);
					String sendNormalPiResult = Double.toString(sendNormalPi);
					System.out.println(sendNormalPiResult);
					DataOutputStream sendingresultofpitouser = new DataOutputStream(se.getOutputStream());
					sendingresultofpitouser.writeUTF(sendNormalPiResult);
					System.out.println("The End");
					break;  


				/*	case "Array result":
						DataInputStream ArrayDisplay =new DataInputStream(se.getInputStream());
						String Array1=ArrayDisplay.readUTF();
						System.out.println(Array1);
						String arrayresult = ; 
						DataOutputStream sendingResultToUserofArray = new DataOutputStream(se.getOutputStream());
						sendingResultToUserofArray.writeUTF(Arrayresult); 
						System.out.println("Connection End");
						break;	
							*/
				
					case "RA":
					System.out.println("Inside ArrayResult");
					DataOutputStream sendingSortedarray = new DataOutputStream(se.getOutputStream());
					sendingSortedarray.writeUTF(a);
					break;

				case "M":
				System.out.println("Inside Matrix Multiply");
				DataInputStream fistNumberComingFromUserForMatrix = new DataInputStream(se.getInputStream());
				String valueOne = fistNumberComingFromUserForMatrix.readUTF();
				System.out.println(valueOne);
				int aa = Integer.parseInt(valueOne);

				DataInputStream secondNumberComingFromUserForUser = new DataInputStream(se.getInputStream());
				String valueTwo = secondNumberComingFromUserForUser.readUTF();
				System.out.println(valueTwo);
				int bb = Integer.parseInt(valueTwo);

				DataInputStream thirdNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueThree = thirdNumberComingFromUser.readUTF();
				System.out.println(valueThree);
				int cc = Integer.parseInt(valueThree);

				DataInputStream fourthNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueFour = fourthNumberComingFromUser.readUTF();
				System.out.println(valueFour);
				int dd = Integer.parseInt(valueFour);


				DataInputStream fifthNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueFive = fifthNumberComingFromUser.readUTF();
				System.out.println(valueFive);
				int ee = Integer.parseInt(valueFive);


				DataInputStream sixthNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueSix = sixthNumberComingFromUser.readUTF();
				System.out.println(valueSix);
				int ff = Integer.parseInt(valueSix);

				DataInputStream seventhNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueSeven = seventhNumberComingFromUser.readUTF();
				System.out.println(valueSeven);
				int gg = Integer.parseInt(valueSeven);

				DataInputStream eighthNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueEight = eighthNumberComingFromUser.readUTF();
				System.out.println(valueEight);
				int hh = Integer.parseInt(valueEight);
				
				DataInputStream ninthNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueNine = ninthNumberComingFromUser.readUTF();
				System.out.println(valueNine);
				int ii = Integer.parseInt(valueNine);

				DataInputStream tenNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueTen = tenNumberComingFromUser.readUTF();
				System.out.println(valueTen);
				int jj = Integer.parseInt(valueTen);

				DataInputStream elevenNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueEleven = elevenNumberComingFromUser.readUTF();
				System.out.println(valueEleven);
				int kk = Integer.parseInt(valueEleven);
				
				DataInputStream twelveNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueTwelve = twelveNumberComingFromUser.readUTF();
				System.out.println(valueTwelve);
				int ll = Integer.parseInt(valueTwelve);

				
				DataInputStream thirteenNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueThirteen = thirteenNumberComingFromUser.readUTF();
				System.out.println(valueThirteen);
				int mm = Integer.parseInt(valueThirteen);

				DataInputStream fourteenNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueFourteen = fourteenNumberComingFromUser.readUTF();
				System.out.println(valueFourteen);
				int nn = Integer.parseInt(valueFourteen);

				DataInputStream fifteenNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueFifteen = fifteenNumberComingFromUser.readUTF();
				System.out.println(valueFifteen);
				int oo = Integer.parseInt(valueFifteen);

				DataInputStream sixteenNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueSixteen = sixteenNumberComingFromUser.readUTF();
				System.out.println(valueSixteen);
				int pp = Integer.parseInt(valueSixteen);

				DataInputStream seventeenNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueSeventeen = seventeenNumberComingFromUser.readUTF();
				System.out.println(valueSeventeen);
				int qq = Integer.parseInt(valueSeventeen);

				DataInputStream eighteenNumberComingFromUser = new DataInputStream(se.getInputStream());
				String valueEighteen = eighteenNumberComingFromUser.readUTF();
				System.out.println(valueEighteen);
				int rr = Integer.parseInt(valueEighteen);

				System.out.println("Perfrom operation");
				firstRowFirstColumn = aa*jj  + aa*mm + aa*pp;
				firstRowSecondColumn = bb*jj + bb*mm + bb*pp;
				firstRowThirdColumn = cc*jj + cc*mm + cc*pp;
				System.out.println(firstRowFirstColumn);
				System.out.println(firstRowSecondColumn);
				System.out.println(firstRowThirdColumn);

				

				secondRowFirstColumn = dd*kk + dd*nn + dd*qq;
				secondRowSecondColumn = ee*kk + ee*nn + ee*qq;
				secondRowThirdColumn = ff*kk + ff*nn + ff*qq;
				System.out.println(secondRowFirstColumn);
				System.out.println(secondRowSecondColumn);
				System.out.println(secondRowThirdColumn);

				thirdRowFirstColumn = gg*ll + gg*oo + gg*rr;
				thirdRowSecondColumn = hh*ll + hh*oo + hh*rr;
				thirdRowThirdColumn = ii*ll + ii*oo + ii*rr;
				System.out.println(thirdRowFirstColumn);
				System.out.println(thirdRowSecondColumn);
				System.out.println(thirdRowThirdColumn);
				break;

				//FirstRowFirstColumb
				case "MR":
				DataOutputStream firstRowAndAllColumb = new DataOutputStream(se.getOutputStream());

				String frfc = String.valueOf(firstRowFirstColumn);
				

				//FirstRowSecondColumb
				//DataOutputStream firstRowAndSecondColumb = new DataOutputStream(se.getOutputStream());

				String frsc = String.valueOf(firstRowSecondColumn);
				String frtc = String.valueOf(firstRowThirdColumn);
				//firstRowAndSecondColumb.writeUTF(frsc);
				firstRowAndAllColumb.writeUTF(frfc + "  " + frsc + "  " + frtc);



				//DataOutputStream firstRowAndThirdColumb = new DataOutputStream(se.getOutputStream());
				//firstRowAndThirdColumb.writeUTF(frtc);
				
				

				DataOutputStream secondRowAndAllColumb = new DataOutputStream(se.getOutputStream());

				String srfc = String.valueOf(secondRowFirstColumn);
				String srsc = String.valueOf(secondRowSecondColumn);
				String srtc = String.valueOf(secondRowThirdColumn);
				secondRowAndAllColumb.writeUTF(srfc + "  " + srsc + "  " + srtc);


				DataOutputStream thirdRowAndAllColumb = new DataOutputStream(se.getOutputStream());
				
				String trfc = String.valueOf(thirdRowFirstColumn);
				String trsc = String.valueOf(thirdRowSecondColumn);
				String trtc = String.valueOf(thirdRowThirdColumn);

				thirdRowAndAllColumb.writeUTF(trfc + "  " + trsc + "  " + trtc);
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

