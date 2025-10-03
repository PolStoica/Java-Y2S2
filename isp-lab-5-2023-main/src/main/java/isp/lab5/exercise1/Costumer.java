package isp.lab5.exercise1;

public class Costumer extends Order{ ;
    private String costumerId;
    private String name;
    private String phone;

    public Costumer(String costumerId, String name, String phone){
        this.costumerId= costumerId;
        this.name= name;
        this.phone= phone;
    }
    public Costumer(){
        this.costumerId= null;
        this.name= null;
        this.phone= null;
    }
}
