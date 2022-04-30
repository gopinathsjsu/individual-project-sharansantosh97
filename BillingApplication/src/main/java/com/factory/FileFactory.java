package com.factory;

public class FileFactory 
{
	public FileInterface getFileWriter(boolean flag)
	{
	      	
	      if(flag == false)
	      {
	         return new SuccessFile();
	         
	      } else if(flag == true)
	      {
	         return new ErrorFile();
	         
	      }
	      
	      return null;
	   }
}
