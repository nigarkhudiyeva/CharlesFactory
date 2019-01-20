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

     @Override
    public int hashCode(){
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GoldenTicket other = (GoldenTicket) obj;
        return Objects.equals(this.code, other.code);
    }
    

   
    
    
}
