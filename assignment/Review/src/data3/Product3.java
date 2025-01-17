package data3;

public class Product3 implements Comparable<Product3>{
    public String id, name;
    public int price;

    @Override
    public String toString() {
        return String.format("%s, %s, %d ", id, name, price);
    }

    //ck noi dung
    @Override
    public boolean equals(Object obj) {
        Product3 p = (Product3) obj;
        return this.id.equals(p.id);
    }
    
    //ck bo nho
    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public int compareTo(Product3 o) {
        return this.id.compareTo(o.id);
    }
    
    
}
