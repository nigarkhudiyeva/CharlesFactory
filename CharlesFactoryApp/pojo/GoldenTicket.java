package pojo;

import java.util.Date;
import java.util.Objects;

public class GoldenTicket {
    private String code;
    private Date raffled;

    public GoldenTicket() {
    }

    public GoldenTicket(String code, Date raffled) {
        this.code = code;
        this.raffled = raffled;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getRaffled() {
        return raffled;
    }

    public void setRaffled(Date raffled) {
        this.raffled = raffled;
    }
    
    public boolean isRaffled(){
        return raffled != null;
    }

    @Override
    public String toString() {
        return  "GoldenTicket code: " + code + ", raffled: " + raffled;
    }

   
    
    
}
