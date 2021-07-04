package com.howtodoinjava.rest.model;

import java.util.List;

public class Photo {

    public Photo() {

    }

    public Photo(String assetName, String title,List<Item> assetItems) {
        super();
        this.assetName = assetName;
        this.title = title;
        this.assetPackage="";
        this.caption="";
        this.assetItems=assetItems;
    }
 
    private String assetName;
    private String title;
    private String assetPackage;
    private List<Item> assetItems;
    public List<Item> getAssetItems() {
		return assetItems;
	}

	public void setAssetItems(List<Item> assetItems) {
		this.assetItems = assetItems;
	}

	public String getAssetPackage() {
		return assetPackage;
	}

	public void setAssetPackage(String assetPackage) {
		this.assetPackage = assetPackage;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	private String caption;
  
  
    public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
    public String toString() {
        return "Photo [assetName=" + assetName + ", title=" + title + "]";
    }
}
