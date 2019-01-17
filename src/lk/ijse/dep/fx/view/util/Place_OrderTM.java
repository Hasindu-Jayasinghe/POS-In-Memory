package lk.ijse.dep.fx.view.util;

public class Place_OrderTM {
    private String code;
    private String description;
    private String unitPrice;
    private String qty;
    private String total;
    //private String qty_hand;

    public Place_OrderTM(String code, String description, String unitPrice, String qty,String total) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.total=total;
     //   this.qty_hand=qty_hand;

    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getTotal(){
        return total;
    }

    public void setTotal(String total){
        this.total= total;
    }

  //  public String getQty_Hand(){ return qty_hand;}

   // public void setQty_hand(){this.qty_hand=qty_hand;}
}
