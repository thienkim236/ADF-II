/*
Thêm 1 lớp học mới (Batch) vô bảng [tbBatch] của CSDL [sem2_demo]
 */
package demo;
import data.*;
import java.util.*;
public class Vidu2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Batch b = new Batch();
        System.out.println("Nhập thông tin lớp học mới: ");
        System.out.print("Nhập mã lớp: ");
        b.batchNo = sc.nextLine().trim();
        System.out.print("Nhập chương trình: ");
        b.desc = sc.nextLine().trim();
        System.out.print("Nhập học phí: ");
        b.fee = Integer.parseInt(sc.nextLine().trim());
        
        int kq = BatchDAO.insert(b);
        
        if (kq>0) {
            System.out.println("Thêm 1 lớp học mới thành công !");
        }
        else{
            System.out.println("Thêm lớp học: thất bại !!!");
        }
    }
    
}
