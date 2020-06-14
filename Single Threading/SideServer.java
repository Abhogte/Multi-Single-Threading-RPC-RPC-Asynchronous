import java.net.*;
import java.io.*;
import java.util.Scanner;
class SideServer
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
				case "R":
				
				System.out.println("Inside Rename");
				DataInputStream oldFileName = new DataInputStream(se.getInputStream());
				String oldFile = dis.readUTF();
				System.out.println(oldFile);
				DataOutputStream data1 = new DataOutputStream(se.getOutputStream());
				data1.writeUTF("Enter the new File name");
				DataInputStream newFileNameFromClient2 = new DataInputStream(se.getInputStream());
				String saveNewFileName = dis.readUTF();
				System.out.println(saveNewFileName);
				File old = new File(oldFile);
				File newFile = new File(saveNewFileName);
				old.renameTo(newFile);
				System.out.println("Connection Ended");
				break;
		
				case "D":
				
				System.out.println("Inside Delete");
				DataInputStream fileNameToDelete = new DataInputStream(se.getInputStream());
				String deleteFile = dis.readUTF();
				System.out.println(deleteFile);
				File deletedFile = new File(deleteFile);
				if(deletedFile.delete())
				{
					System.out.println("File" + deleteFile + "Deleted from Directory");
					
				}
				else
				{
					System.out.println("Failed to delete this File");
				}
				System.out.println("Connection Ended");
				break;
			
				case "Do":
				System.out.println("Inside Download");
				DataInputStream fileNameToDownload = new DataInputStream(se.getInputStream());
				String downloadThisFile = dis.readUTF();
				System.out.println(downloadThisFile);
				// Change the variables below
				FileInputStream fr = new FileInputStream(downloadThisFile);
				byte b[] = new byte[20009];
				fr.read(b, 0, b.length);
				OutputStream os = se.getOutputStream();
				os.write(b, 0, b.length);
				System.out.println(downloadThisFile);
				System.out.println("File Downloaded to the Client");
				System.out.println("Connection Ended");
				break;

				case "U":
				System.out.println("Inside Upload");
				InputStream is = se.getInputStream();
				DataInputStream fileNameToUpload = new DataInputStream(se.getInputStream());
				String saveUploadName = dis.readUTF();
				byte[] d = new byte[20002];
				FileOutputStream hr = new FileOutputStream(saveUploadName);
				is.read(d, 0, d.length);
				hr.write(d, 0, d.length);
				System.out.println("File Uploaded to the server side");
				System.out.println("Connection Ended");
				break;

			}
		
		}
		catch(Exception e)
		{
		}
	}
}