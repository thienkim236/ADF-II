/*
Su dung function interface [ICasio] va bieu thuc lambda
 */
package demo;

import java.util.Scanner;


public class Vidu2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap so thu 1: ");
        int a = Integer.parseInt(sc.nextLine().trim());
        System.out.print("nhap so thu 2: ");
        int b = Integer.parseInt(sc.nextLine().trim());
        
        // 1. basic lambda
        ICasio f1 = (int n1, int n2)-> System.out.printf("%d + %d = %d \n", n1, n2, n1 + n2);
        
        // 2. lamba with inferred type
        ICasio f2 = (n1, n2) -> System.out.printf("%d - %d = %d \n", n1, n2, n1 - n2);
        
        // thuc hien bieu thuc f1, f2
        f1.calculate(a, b);
        f2.calculate(a, b);
    }
    
}
