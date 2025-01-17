/*
a. Các f ields dữ liệu:
HashMap<String, Doctor> drList để lưu danh sách các bác sĩ.
b. Method :
1. void add() : thêm 1 bác sĩ vô danh sách drList. Yêu cầu kiểm tra trùng mã .
2. void remove(String drID) : Xóa bác sĩ có mã drID ra khỏi danh sách drList.
3. void display() : In danh sách các bác sĩ thuộc chuyên khoa 2 ra màn hình.
4. void display(StringdrName) : Tìm và in ra ds các bác sĩ có tên chứa trong đối số drName
5. void saveFile() : lưu thông tin danh sach bac si vô tập tin văn bản "doctor.txt"
 */
package data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoctorList {

    HashMap<String, Doctor> drList = new HashMap<>();

    public void add() {
        Doctor d = new Doctor();

        // method dung de dua du lieu vao hash map
        d.input();
        if (drList.containsKey(d.id)) {
            System.out.println("id da ton tai ! Tu choi them moi ! ");
            return; // nếu không return phải viết if-else
        }
        drList.put(d.id, d);
    }

    public void remove(String drID) {
        if (drList.containsKey(drID)) {
            drList.remove(drID);
            System.out.println(" >> da xoa thanh cong ");
        } else {
            System.out.println(" >> khong tim thay id muon xoa !!!");
        }
    }

    public void display() {
        if (drList.isEmpty()) {
            System.out.println("He thong chua co du lieu");
            return;// ket thuc ham
        }
        int cntlv2 = 0;
        for (Doctor lv2 : drList.values()) {
            if (lv2.level.equalsIgnoreCase("LEVEL2")) { //(lv2.level.toUpperCase().equals("LEVEL2"))
                System.out.println(lv2);
                cntlv2++;
            }
        }
        System.out.println("Co " + cntlv2 + " bac si chuyen khoa 2 duoc tim thay");
    }

    public void display(String drName) {
        if (drList.isEmpty()) {
            System.out.println("He thong chua co du lieu");
            return;// ket thuc ham
        }
        int dem = 0;
        String ename = drName.toLowerCase();
        for (Doctor ten : drList.values()) {
            if (ten.name.toLowerCase().contains(ename)) {
                System.out.println(ten);
                dem++;
            }

        }
        if (dem > 0) {
            System.out.println("Tim thay " + dem + " bac si co ten chua " + ename);
        } else {
            System.out.println("khong co bac si nao duoc tim thay");
        }
    }
    
    String tenFile = "doctor.txt";
    public void saveFile() {
        try {
            java.io.PrintWriter pw = new PrintWriter(tenFile);
            // lấy hết dữ liệu bs ra sau đó lưu vô tập tin này
            for (Doctor item : drList.values()) {
                pw.println(item);
                
            }
            pw.close(); // thiếu câu lệnh này, dữ liệu sẽ không được lưu vào trong tệp tin. QUAN TRỌNG
        } catch (Exception ex) {
            System.out.println("Loi sai: " + ex.getMessage());
        }
        
        // sau khi ghi file xong - xem nội dung của file này trong chương trình NOTEPAD
        Runtime r = Runtime.getRuntime();
        try {
            r.exec("notepad "+ tenFile); // notepad phải có khoảng trắng
        } catch (IOException ex) {
            System.out.println("Loi: "+ex.getMessage());
        }
    }
}
