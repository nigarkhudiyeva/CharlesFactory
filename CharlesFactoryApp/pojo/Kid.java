package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Kid extends Being{

    private Date birthday;
    private ArrayList<Product> purchasedProducts;
    private String placeOfBirth;

    public Kid (int code, String name, Date birthday, String placeOfBirth){
        super(code, name);
        this.birthday = birthday;
        this.placeOfBirth = placeOfBirth;
        purchasedProducts = new ArrayList<>();
    }

    public void addProduct(Product product){
        purchasedProducts.add(product);
    }

    public ArrayList<Product> getPurchasedProducts(){
        return purchasedProducts;
    }

    @Override
    public String toString() {
        return "Kid code: " + code + ", name: " + name + ", birthday: " + birthday + ", purchasedProducts: " + purchasedProducts + ", placeOfBirth: " + placeOfBirth;
    }
    
}