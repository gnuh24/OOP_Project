package Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DocGhiFile {

    public static ArrayList<String> docDuLieuFile(String tenFile) {
        ArrayList<String> duLieu = new ArrayList<>();
        try{
            File fileDoiTuong = new File(tenFile);
            Scanner fileReader = new Scanner(fileDoiTuong);
            while(fileReader.hasNextLine()){
                String dong = fileReader.nextLine();
                duLieu.add(dong);
            }
        } catch (IOException e) {
            System.out.println("Lỗi trong việc đọc file !!");
            e.printStackTrace();
        }
        return duLieu;
    }
    public static boolean ghiDuLieuFile(String tenFile, String dongDuLieu) {
        try{
            FileWriter fileDoiTuong = new FileWriter(tenFile,true);
            fileDoiTuong.write(dongDuLieu);
            fileDoiTuong.close();
            return true;
        } catch (IOException e) {
            System.out.println("Lõi trong việc viết file !!");
            e.printStackTrace();
        }
        return false;
    }

    public static boolean ghiDuLieuFile(String tenFile, ArrayList<String> duLieu) {
        try{
            FileWriter fileDoiTuong = new FileWriter(tenFile,false);
            for(String dongDuLieu:duLieu){
                fileDoiTuong.write(dongDuLieu);
            }
            fileDoiTuong.close();
            return true;
        } catch (IOException e) {
            System.out.println("Lõi trong việc viết file !!");
            e.printStackTrace();
        }
        return false;
    }
    
}