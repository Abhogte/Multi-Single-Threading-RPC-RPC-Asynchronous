
import java.text.*;
import java.io.*;   
import java.net.*; 
import java.util.*;

public class Server
{
	public static void main(String[] args) throws IOException  
    	{
	
			ServerSocket ss = new ServerSocket(5056);
			while (true)
			{
				Socket s = null; 
				{
					try
					{
						s = ss.accept();
				
						System.out.println("A new Client is Added for the process:");
						

						DataInputStream dis = new DataInputStream(s.getInputStream()); 
                				DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

						System.out.println("Assigning new thread for the new client");
						
						Thread t = new ClientHandler(s, dis, dos); 
						t.start();
						
					}
					catch(Exception e)
					{
						s.close();
					}
				}
			}
	}
}	
class ClientHandler extends Thread
{

	final DataInputStream dis; 
 	final DataOutputStream dos; 
	final Socket s; 
		
	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)

	{ 
        	this.s = s; 
		this.dis = dis; 
        	this.dos = dos; 
    	}
	
	public void run()  
	{ 
        	String received; 
        	String toreturn; 
        	while (true)  
        	{
			try 
				{ 
				DataInputStream dis = new DataInputStream(s.getInputStream());
				String msg = dis.readUTF();
				switch(msg)
					{
					case "R":
				
					System.out.println("Inside Rename");
					DataInputStream oldFileName = new DataInputStream(s.getInputStream());
					String oldFile = dis.readUTF();
					System.out.println(oldFile);
					DataOutputStream data1 = new DataOutputStream(s.getOutputStream());
					data1.writeUTF("Enter the new File name");
					DataInputStream newFileNameFromClient2 = new DataInputStream(s.getInputStream());
					String saveNewFileName = dis.readUTF();
					System.out.println(saveNewFileName);
					File old = new File(oldFile);
					File newFile = new File(saveNewFileName);
					old.renameTo(newFile);
					break;

					case "D":
				
					System.out.println("Inside Delete");
					DataInputStream fileNameToDelete = new DataInputStream(s.getInputStream());
					String deleteFile = dis.readUTF();
					System.out.println(deleteFile);
					File deletedFile = new File(deleteFile);
					if(deletedFile.delete())
					{
						System.out.println("File" + deleteFile + " Deleted from Directory location");
					
					}
					else
					{
						System.out.println("Failed to delete this File");
					}
					break;
					
					case "Do":
					System.out.println("Inside Download");
					DataInputStream fileNameToDownload = new DataInputStream(s.getInputStream());
					String downloadThisFile = dis.readUTF();
					System.out.println(downloadThisFile);
					// Change the variables below
					FileInputStream fr = new FileInputStream(downloadThisFile);
					byte b[] = new byte[20009];
					fr.read(b, 0, b.length);
					OutputStream os = s.getOutputStream();
					os.write(b, 0, b.length);
					System.out.println(downloadThisFile);
					System.out.println("File Downloaded to the Client");
					System.out.println("Connection Ended");
					break;

					case "U":
					System.out.println("Inside Upload");
					InputStream is = s.getInputStream();
					DataInputStream fileNameToUpload = new DataInputStream(s.getInputStream());
					String saveUploadName = dis.readUTF();
					byte[] d = new byte[20002];
					FileOutputStream hr = new FileOutputStream(saveUploadName);
					is.read(d, 0, d.length);
					hr.write(d, 0, d.length);
					System.out.println("File Uploaded to the server side");
					System.out.println("Connection Ended");
					break;
		
					}
					
				//Write the Server code here
				dos.writeUTF("Type 'Exit' command to terminate connection.");   	

				received = dis.readUTF();
					
				if(received.equals("Exit"))

				{  
                   	 		System.out.println("Client " + this.s + " sends exit..."); 
                    			System.out.println("Closing this connection Communication Ended"); 
                    			this.s.close(); 
                    			System.out.println("Connection closed"); 
                   			break; 
                		}
	
				
			}
			catch(IOException e)
			{
				System.out.println("Blank");
			}
		}

		try
		{
			this.dis.close(); 
            		this.dos.close();
		}
		catch(IOException e)
		{
			 System.out.println("Blank two");
		}
	}
}   				