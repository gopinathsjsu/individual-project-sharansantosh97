package com.factory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import com.modelclasses.BillingItem;

public interface FileInterface 
{
	public void FileWriter (Path path, ArrayList<BillingItem> itemList) throws IOException;
    public void setContent(ArrayList<String> content);
    
    

}
