package lk.ijse.dep.fx.view.util;

import java.util.ArrayList;

public class ViewOrdersTM {

    private String orderId ;
    private String customerid;
    private String customername;
    private String date;


    public ViewOrdersTM(String orderId,String customerid,String date  ,String customername ,ArrayList<Place_OrderTM> place_orderTMS) {
        this.orderId = orderId;
        this.date = date;
        this.customerid = customerid;
        this.customername = customername;
    }

    public ViewOrdersTM(String x, String y, String z, String a) {
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String dtae) {
        this.date = date;
    }
}
