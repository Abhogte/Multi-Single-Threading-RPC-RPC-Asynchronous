import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
class RpcSideServer
{
	public static void main(String[] args)
	{
		try
		{
		
			ServerSocket server = new ServerSocket(6777);
			Socket se = server.accept();
			
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

				DataInputStream secondNumberComingFromUser = new DataInputStream(se.getInputStream());
				String storingSecondNumber = secondNumberComingFromUser.readUTF();
				int second = Integer.parseInt(storingSecondNumber);
				System.out.println(second);

				int result = first + second;
				String addResult = Integer.toString(result);
				DataOutputStream sendingResultToUser = new DataOutputStream(se.getOutputStream());
				sendingResultToUser.writeUTF(addResult);
				System.out.println("Connection End");
				break;

				case "CP":
				System.out.println("Inside Pi");
				DataInputStream iterationFromUser = new DataInputStream(se.getInputStream());
				String storingIterationNumber = iterationFromUser.readUTF();
				// Chnage variable of pi functionality
				double xi = Double.parseDouble(storingIterationNumber);
				System.out.println(xi);
				
				double pi = 1.0;
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
				System.out.println(4*pi);
				double resultOfPi = 4*pi;
				String resultOfPiToUser = Double.toString(resultOfPi);
				DataOutputStream sendingPiResultToUser = new DataOutputStream(se.getOutputStream());
				sendingPiResultToUser.writeUTF(resultOfPiToUser);
				break;
				case "SA":
				
				System.out.println("Inside Sorting Array");
				DataInputStream fistNumberComingFromUser = new DataInputStream(se.getInputStream());
				String storingFirstNumbers = fistNumberComingFromUser.readUTF();
				System.out.println(storingFirstNumbers);
				int x = Integer.parseInt(storingFirstNumbers);
				System.out.println("Value converted to int: " + x);
				int y[] = new int[x];
				int j = 0;
				for(int i=0; i<x; i++)
				{
					DataInputStream stringToGetUserInputerValue = new DataInputStream(se.getInputStream());
					String stringToGetUserInput = stringToGetUserInputerValue.readUTF(); 
					int z =  Integer.parseInt(stringToGetUserInput);
					y[i] = z;	
				}

				for(int i = 0; i<x; i++)
				{	
					
					System.out.println("The value of array is: " +y[i]);
			
				}
				Arrays.sort(y);
				for(int i = 0; i<x; i++)
				{
					System.out.println(y[i]);
				}
				;
				for(int i = 0; i<x; i++)
				{
					int b = y[i];
					String a = String.valueOf(b);
					DataOutputStream sendingSortedarray = new DataOutputStream(se.getOutputStream());
					sendingSortedarray.writeUTF(a);
					
				}	
				break;
				/*
				for(int j = 0; j<x+1; j++)
				{
					System.out.println("The value in array is: " +y[j]);
					break;
				}*/
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
				int firstRowFirstColumn = aa*jj  + aa*mm + aa*pp;
				int firstRowSecondColumn = bb*jj + bb*mm + bb*pp;
				int firstRowThirdColumn = cc*jj + cc*mm + cc*pp;
				System.out.println(firstRowFirstColumn);
				System.out.println(firstRowSecondColumn);
				System.out.println(firstRowThirdColumn);

				

				int secondRowFirstColumn = dd*kk + dd*nn + dd*qq;
				int secondRowSecondColumn = ee*kk + ee*nn + ee*qq;
				int secondRowThirdColumn = ff*kk + ff*nn + ff*qq;
				System.out.println(secondRowFirstColumn);
				System.out.println(secondRowSecondColumn);
				System.out.println(secondRowThirdColumn);

				int thirdRowFirstColumn = gg*ll + gg*oo + gg*rr;
				int thirdRowSecondColumn = hh*ll + hh*oo + hh*rr;
				int thirdRowThirdColumn = ii*ll + ii*oo + ii*rr;
				System.out.println(thirdRowFirstColumn);
				System.out.println(thirdRowSecondColumn);
				System.out.println(thirdRowThirdColumn);

				//FirstRowFirstColumb
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
			System.out.println("Connection End");

		} 
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
