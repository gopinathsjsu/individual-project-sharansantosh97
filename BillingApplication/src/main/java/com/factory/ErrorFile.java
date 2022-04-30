package com.factory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.modelclasses.BillingItem;

public class ErrorFile implements FileInterface
{
    private ArrayList<String> filetext;
    
    public void setContent(ArrayList<String>errorMessage)
    {
        filetext=errorMessage;
    }
    
    public void FileWriter(Path filePath, ArrayList<BillingItem> itemList)throws IOException
    {
        
    	Path p = Paths.get(""); 
        String directoryName = p.toAbsolutePath().toString();
        File f = new File(directoryName+"/src/main/java/Output/"+"/errorFile.txt");
        
        
        FileWriter errorFile=new FileWriter(f);
        for(String contentLine:filetext)
            errorFile.write(contentLine+"\n");
        errorFile.close();
    }


}
