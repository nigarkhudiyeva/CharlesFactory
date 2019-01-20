package pojo;

import java.util.Objects;

public class Product {

    private String description;
    private long barcode;
    private String serialNumber;
    private GoldenTicket prizeTicket;

    //If the Prize Ticket has a GoldenTicket it means that the product has a prize,
    //otherwise it should be null
    public Product(String description, long barcode, String serialNumber, GoldenTicket prizeTicket) {
        this.description = description;
        this.barcode = barcode;
        this.serialNumber = serialNumber;
        this.prizeTicket = prizeTicket;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public GoldenTicket getPrizeTicket() {
        return prizeTicket;
    }

    public void setPrizeTicket(GoldenTicket prizeTicket) {
        this.prizeTicket = prizeTicket;
    }

    @Override
    public String toString() {
        return  "Product description: " + description + ", barcode: " + barcode + ", serialNumber: " + serialNumber + ", prizeTicket: " + prizeTicket;
    }

    
}
