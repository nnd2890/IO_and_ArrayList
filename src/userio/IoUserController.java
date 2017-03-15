/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author nnd2890
 */
public class IoUserController {
     // 1. Ghi thông tin admin ra file.
    public static void WriteUser() throws IOException {
        String choice = null;
        ArrayList<User> list = new ArrayList<>();
        do {            
           // ArrayList<User> list = new ArrayList<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Vui lòng nhập account: ");
            String account = br.readLine();
            System.out.println("Vui lòng nhập password: ");
            String password = br.readLine();
            System.out.println("Vui lòng nhập email: ");
            String email = br.readLine();
            list.add(new User(account, password, email));
            System.out.print("Ban co muon them danh sach (y/n): ");
            choice = Scanner_ulti.getString();
            if ("n".equals(choice)) {
                break;
            }
        } while (true);
        try (BufferedWriter bos = new BufferedWriter(new FileWriter("userList.txt",true))) {
                for (User user : list) {
                    bos.write(user.toString());
                    bos.newLine();
                }
                bos.close();
        }        
        System.out.println(list.toString());
    }
    
    // 2. Đọc thông tin từ file và in ra console.
     public static void ReadUser() throws IOException {
        System.out.println("------------------------------");
        System.out.println("Danh sach Users");
        FileReader fr = new FileReader("userList.txt");
        BufferedReader br1 = new BufferedReader(fr);
        String line = br1.readLine();
        while(line != null){
            System.out.println(line);
            line = br1.readLine();
        }
        System.out.println("------------------------------");
    }
     
    // 3. Xóa File.
    public static void deleteFile() {
        String s = "userList.txt";
        System.err.println("Are you sure to delete file" + s + "?(y/n)");
        String choice = Scanner_ulti.getString();
        if ("y".equals(choice)) {
            File file = new File(s);
            file.delete();
            System.out.println("The File was deleted.");
        } else {
            System.out.println("The File still exists.");  
        }
        
    }
}
