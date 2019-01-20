
package pojo;

public abstract class Being{

    protected String name;
    protected int code;

    public Being(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Being name: " + name + ", code: " + code;
    }

   
    
}