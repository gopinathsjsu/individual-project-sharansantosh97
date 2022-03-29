package com.modelclasses;

public class BillingItem {
    private String invoiceItemName;
    private int itemQuantity;
    private String creditCardInfo;
    private double price;

    public BillingItem(String invoiceItemName, int itemQuantity, String creditCardInfo, double price) {
        this.invoiceItemName = invoiceItemName;
        this.itemQuantity = itemQuantity;
        this.creditCardInfo = creditCardInfo;
        this.price = price;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInvoiceItemName() {
        return invoiceItemName;
    }

    public void setInvoiceItemName(String invoiceItemName) {
        this.invoiceItemName = invoiceItemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(String creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

	@Override
	public String toString() {
		return "InvoiceItems [invoiceItemName=" + invoiceItemName + ", itemQuantity=" + itemQuantity
				+ ", creditCardInfo=" + creditCardInfo + ", price=" + price + "]";
	}


    

}
