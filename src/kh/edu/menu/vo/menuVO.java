package kh.edu.menu.vo;

public class menuVO {
	
	private int menuNum;
	private String name;
	private int price;
	private String menuType;
	
	public menuVO() {}
	
	public menuVO(int menuNum, String name, int price, String menuType) {
		this.menuNum = menuNum;
		this.name = name;
		this.price = price;
		this.menuType = menuType;
	}

	public int getMenuNum() {
		return menuNum;
	}

	public void setMenuNum(int menuNum) {
		this.menuNum = menuNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	@Override
	public String toString() {
		return "menuVO [menuNum=" + menuNum + ", name=" + name + ", price=" + price + ", menuType=" + menuType + "]";
	}
	
	
}


