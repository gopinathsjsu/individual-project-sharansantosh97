package com.factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.modelclasses.BillingItem;

public class FileUtil {
    Path filePath;
    
    private ArrayList<String> fileContent = new ArrayList<String>();

    public FileUtil(String filePath) {
        this.filePath = Paths.get(filePath);
    }

    public void reader(boolean ignoreFirst) throws IOException {
        if (Files.notExists(filePath)) {
            new IOException();
        }
        BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()));
        String contentLine = "";
        while ((contentLine = br.readLine()) != null) {
            if (ignoreFirst) {
                ignoreFirst = false;
                continue;
            }
            fileContent.add(contentLine);

        }
    }

    public ArrayList<String> getFileContent() {
        return fileContent;
    }

    public void writer(ArrayList<String> message, boolean checkIfError, ArrayList<BillingItem> itemList) throws IOException 
    {
    	FileFactory fileFactory = new FileFactory();
    	FileInterface fileInterface = fileFactory.getFileWriter(checkIfError);
    	fileInterface.setContent(message);
    	fileInterface.FileWriter(filePath, itemList);

    }
}
