/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subastas.Logic;

/**
 *
 * @author Xelop
 */
public class Auction {
    private String _ItemName;
    private String _Description;
    private String _Image;
    private String _SubCategory;
    private String _Category;
    private String _DeliverDetails;
    private String _LastDate;
    private int _Price;
    
    public Auction(String pItem,String  pDescription,String  pImage,String  pSubcategory,String  pCategory,String  pDeliverDetails, String pDate, int pPrice){
        _ItemName = pItem;
        _Description = pDescription;
        _Image = pImage;
        _SubCategory = pSubcategory;
        _Category = pCategory;
        _DeliverDetails = pDeliverDetails;
        _LastDate =  pDate;
        _Price = pPrice;
    }

    /**
     * @return the _ItemName
     */
    public String getItemName() {
        return _ItemName;
    }

    /**
     * @param _ItemName the _ItemName to set
     */
    public void setItemName(String _ItemName) {
        this._ItemName = _ItemName;
    }

    /**
     * @return the _Description
     */
    public String getDescription() {
        return _Description;
    }

    /**
     * @param _Description the _Description to set
     */
    public void setDescription(String _Description) {
        this._Description = _Description;
    }

    /**
     * @return the _Image
     */
    public String getImage() {
        return _Image;
    }

    /**
     * @param _Image the _Image to set
     */
    public void setImage(String _Image) {
        this._Image = _Image;
    }

    /**
     * @return the _SubCategory
     */
    public String getSubCategory() {
        return _SubCategory;
    }

    /**
     * @param _SubCategory the _SubCategory to set
     */
    public void setSubCategory(String _SubCategory) {
        this._SubCategory = _SubCategory;
    }

    /**
     * @return the _Category
     */
    public String getCategory() {
        return _Category;
    }

    /**
     * @param _Category the _Category to set
     */
    public void setCategory(String _Category) {
        this._Category = _Category;
    }

    /**
     * @return the _DeliverDetails
     */
    public String getDeliverDetails() {
        return _DeliverDetails;
    }

    /**
     * @param _DeliverDetails the _DeliverDetails to set
     */
    public void setDeliverDetails(String _DeliverDetails) {
        this._DeliverDetails = _DeliverDetails;
    }

    /**
     * @return the _Price
     */
    public int getPrice() {
        return _Price;
    }

    /**
     * @param _Price the _Price to set
     */
    public void setPrice(int _Price) {
        this._Price = _Price;
    }

    /**
     * @return the _LastDate
     */
    public String getLastDate() {
        return _LastDate;
    }

    /**
     * @param _LastDate the _LastDate to set
     */
    public void setLastDate(String _LastDate) {
        this._LastDate = _LastDate;
    }
}
