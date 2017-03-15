/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userio;

import java.io.IOException;

/**
 *
 * @author nnd2890
 */
public class View {
    public static void main(String[] args) throws IOException {
        while (true) {
            int choice; 
            System.out.println("===================================");
            System.out.println("=|   Phần mềm quản lí User       |=");
            System.out.println("|         1. Doc thong tin tu File|");
            System.out.println("|         2. Ghi thong tin ra File|");
            System.out.println("|         3. Xoa File             |");
            System.out.println("|         4. Thoat.               |");
            System.out.println("| =============================== |");
            System.out.println("|      Nhập lựa chọn của bạn:     ");
            
            // Input variable
            
            choice = Scanner_ulti.getInt();
            
            switch (choice){
                case 1:
                    System.out.println("Doc thong tin tu File.");
                    IoUserController.ReadUser();
                    break;
                case 2:
                    System.out.println("Ghi thong tin ra File.");
                    IoUserController.WriteUser();
                    IoUserController.ReadUser();
                    break;
                case 3:
                    IoUserController.deleteFile();
                    break;
                case 4:
                    System.out.println("Thoat");
                    break;
                default:
                    System.out.println("Lựa chọn sai. Vui lòng lựa chọn trong khoảng từ 1 đến 4");
                    break;          
            } if (choice == 4) {
                break;
            }
            
            
        }
    }
}
