package com.ploy.polyshop.uint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;

public class ImageFromSystem {
    Class<?> currentClass = getClass();
    public ImageIcon getImage(String path){
        return new ImageIcon(currentClass.getResource(path));
    }
    
    public boolean saveFile(String directoryPath, String fileName, byte[] data) {
        // Tạo một đối tượng File để biểu diễn thư mục và tệp
        URL url = currentClass.getResource(directoryPath);
        
        File directory = new File(url.getPath());
        System.out.println(url.getPath());
        File file = new File(directory, fileName);

        try {
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Tạo một đối tượng FileOutputStream để ghi dữ liệu vào tệp
            try (FileOutputStream outputStream = new FileOutputStream(file)) {
                // Ghi dữ liệu vào file
                outputStream.write(data);
            }

            System.out.println("File has been saved successfully.");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
