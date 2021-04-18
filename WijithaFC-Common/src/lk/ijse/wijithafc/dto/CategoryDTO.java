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
public class CategoryDTO extends SuperDTO{
    private int catID;
    private String category;

    public CategoryDTO() {
    }

    public CategoryDTO(int catID, String category) {
        this.catID = catID;
        this.category = category;
    }

    public CategoryDTO(String category) {
        this.category = category;
    }

    /**
     * @return the catID
     */
    public int getCatID() {
        return catID;
    }

    /**
     * @param catID the catID to set
     */
    public void setCatID(int catID) {
        this.catID = catID;
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
    
}
