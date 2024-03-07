package com.tradetracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admin_menus")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "menu_header")
	private String menuHeader;

	@Column(name = "menu_title")
	private String menuTitle;

	@Column(name = "link")
	private String link;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuHeader() {
		return menuHeader;
	}

	public void setMenuHeader(String menuHeader) {
		this.menuHeader = menuHeader;
	}

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}