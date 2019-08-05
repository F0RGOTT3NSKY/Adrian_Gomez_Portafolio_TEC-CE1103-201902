package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args)
	{
	   if (args.length != 2)
	   {
	      System.err.println("usage: java Copy srcfile dstfile");
	      return;
	   }

	   try
	   {
	      copy(args[0], args[1]);
	   }
	   catch (IOException ioe)
	   {
	      System.err.println("I/O error: " + ioe.getMessage());
	   }
	}

	static void copy(String srcFile, String dstFile) throws IOException
	{
	   FileInputStream fis = null;
	   FileOutputStream fos = null;
	   try
	   {
	      fis = new FileInputStream(srcFile);
	      fos = new FileOutputStream(dstFile);
	      int c;
	      while ((c = fis.read()) != -1)
	         fos.write(c);
	   }
	   finally
	   {
	      if (fis != null)
	         try
	         {
	            fis.close();
	         }
	         catch (IOException ioe)
	         {
	            System.err.println(ioe.getMessage());
	         }

	      if (fos != null)
	         try
	         {
	            fos.close();
	         }
	         catch (IOException ioe)
	         {
	            System.err.println(ioe.getMessage());
	         }
	   }
	}
		   
}

