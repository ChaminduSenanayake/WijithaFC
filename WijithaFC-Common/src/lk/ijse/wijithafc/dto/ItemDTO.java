/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.dto;

/**
 *
 * @author ASUS
 */
public class ItemDTO extends SuperDTO {

    private String itemCode;
    private String description;
    private String category;
    private double unitPrice;
    private int qtyOnHand;
    private int discountQTY;
    private double discount;

    public ItemDTO() {
    }

    public ItemDTO(String itemCode, String description, String category, double unitPrice, int qtyOnHand, int discountQTY, double discount) {
        this.itemCode = itemCode;
        this.description = description;
        this.category = category;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
        this.discountQTY = discountQTY;
        this.discount = discount;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the qtyOnHand
     */
    public int getQtyOnHand() {
        return qtyOnHand;
    }

    /**
     * @param qtyOnHand the qtyOnHand to set
     */
    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    /**
     * @return the discountQTY
     */
    public int getDiscountQTY() {
        return discountQTY;
    }

    /**
     * @param discountQTY the discountQTY to set
     */
    public void setDiscountQTY(int discountQTY) {
        this.discountQTY = discountQTY;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "ItemDTO{" + "itemCode=" + getItemCode() + ", description=" + getDescription() + ", category=" + getCategory() + ", unitPrice=" + getUnitPrice() + ", qtyOnHand=" + getQtyOnHand() + '}';
    }

}
