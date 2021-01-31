package com.example.shoppinglist;

public class ListViewItem {
    private String checkedStr;
    private String checkStr;
    private String priceStr;
    private String countStr;

    public void setChecked(String checked) {
        checkedStr = checked;
    }
    public void setCheck(String check) {
        checkStr = check;
    }
    public void setPrice(String price) {
        priceStr = price;
    }
    public void setCount(String count) {
        countStr = count;
    }

    public String getChecked() {
        return this.checkedStr;
    }
    public String getCheck() {
        return this.checkStr;
    }
    public String getPrice() {
        return this.priceStr;
    }
    public String getCount() {
        return this.countStr;
    }
}
