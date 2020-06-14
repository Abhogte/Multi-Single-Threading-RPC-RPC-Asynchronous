import java.util.Scanner;
import java.net.*;
import java.io.*; 
 
 

public class Client
{
	public static void main(String[] args) throws IOException  
    	{ 
        	try
        	{
			Scanner scnre = new Scanner(System.in);
			InetAddress ip = InetAddress.getByName("localhost");
			
			Socket se = new Socket(ip, 5056);
			
			DataInputStream dis = new DataInputStream(se.getInputStream()); 
            		DataOutputStream dos = new DataOutputStream(se.getOutputStream());  
			
			while (true)
			{
				Scanner input = new Scanner(System.in);
				System.out.println("Do you Rename, Delete, Download, Upload");
				System.out.println("R - Rename, D - Delete, Do - Download, U - upload");
				String value = input.nextLine();
				DataOutputStream data = new DataOutputStream(se.getOutputStream());
				data.writeUTF(value);
				switch(value)
				{
				case "R":
				Scanner user = new Scanner(System.in);
				System.out.println("Please enter the Directory path to see all files in it.");
				String fileName = user.nextLine();
				File dir = new File(fileName);
				for(File f: dir.listFiles())
				{	
					if(f.getName().contains(".txt"))
					{
					System.out.println(f.getName());
					}
				}
				System.out.println("Enter the file name you want to Rename");
				String existfileName = user.next();
				DataOutputStream existFileNameServer = new DataOutputStream(se.getOutputStream());
				data.writeUTF(existfileName);
				System.out.println();
				DataInputStream forNewFile = new DataInputStream(se.getInputStream());
				String fromServer1 = forNewFile.readUTF();
				System.out.println(fromServer1);
				String newFileNameFromUser = input.nextLine();
				DataOutputStream newFileNameToServer2 = new DataOutputStream(se.getOutputStream());
				data.writeUTF(newFileNameFromUser);
				break;

				case "D":
				Scanner user1 = new Scanner(System.in);
				System.out.println("Please enter the Directory path to see all files in it.");
				String pathName1 = user1.nextLine();
				File directory = new File(pathName1);
				for(File f: directory.listFiles())
				{	
					if(f.getName().contains(".txt"))
					{
					System.out.println(f.getName());
					}
				}
				System.out.println("Enter the File name you want to delete.");
				String fileNameToDelete = input.nextLine();
				DataOutputStream userFileNameToDelete = new DataOutputStream(se.getOutputStream());
				data.writeUTF(fileNameToDelete);
				break;


				
							
				case "Do":
				Scanner user2 = new Scanner(System.in);
				System.out.println("Please enter the Directory path to see all files in it.");
				String pathName2 = user2.nextLine();
				File pathDirectory = new File(pathName2);
				for(File f: pathDirectory.listFiles())
				{
					if(f.getName().contains(".txt"))
					{
						System.out.println(f.getName());
					}
				}
				InputStream is = se.getInputStream();
				//Scanner input = new Scanner(System.in);
				System.out.println("Enter the File Name You want To Download");
				String fileNameToDownload = input.nextLine();
				System.out.println("Enter the name of file that you downloaded with .txt format");
				String newDownloadFileName = input.nextLine();
				DataOutputStream userFileToDownload = new DataOutputStream(se.getOutputStream());
				userFileToDownload.writeUTF(fileNameToDownload);
				byte[] b = new byte[20002];
				FileOutputStream fr = new FileOutputStream(newDownloadFileName);
				is.read(b, 0, b.length);
				fr.write(b, 0, b.length);
				System.out.println("Connection Ended");
				break;


				case "U":
				Scanner user3 = new Scanner(System.in);
				System.out.println("Please enter the Directory path to see all files in it.");
				String pathName3 = user3.nextLine();
				File DirectoryOfPath = new File(pathName3);
				for(File f: DirectoryOfPath.listFiles())
				{
					if(f.getName().contains(".txt"))
					{
						System.out.println(f.getName());
					}
				}
				System.out.println("Enter the File name You want to Upload");
				String FileNameToUpload = user3.nextLine();
				System.out.println("Enter the File name of uploaded file");
				String uploadFileName = user3.nextLine();
				DataOutputStream newFileNameFromUserUpload = new DataOutputStream(se.getOutputStream());
				newFileNameFromUserUpload.writeUTF(uploadFileName);
				FileInputStream fe = new FileInputStream(FileNameToUpload);
				byte c[] = new byte[20009];
				fe.read(c, 0, c.length);
				OutputStream os = se.getOutputStream();
				os.write(c, 0, c.length);
				System.out.println("Connection Ended");
				break;
				
				
				}

				
				//Code below of multithreading
				System.out.println("Type Exit to end connection"); 
                		String tosend = scnre.nextLine(); 
                		dos.writeUTF(tosend);


				if(tosend.equals("Exit"))
				{
					System.out.println("Closing this connection"); 
                    			se.close(); 
                    			System.out.println("Connection closed"); 
                    			break;
				}
				//String received = dis.readUTF(); 
                		//System.out.println(received);
				
			}

			scnre.close(); 
        	    	dis.close(); 
			dos.close();
						

            	}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}  