package lk.ijse.dep.fx.view.util;

import java.util.ArrayList;

public class Order2_TM {
    private String code;
    private String desc;
    private String qty;

    public Order2_TM(String code, String desc, String qty, String unitPrice, String total) {
        this.code = code;
        this.desc = desc;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    private String unitPrice;
    private String total;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}