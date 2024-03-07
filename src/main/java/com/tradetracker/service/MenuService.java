package com.tradetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradetracker.repository.MenuRepository;

import com.tradetracker.model.Menu;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;

	public List<Menu> getMenusForUser(Integer userId) {
		return menuRepository.findMenusByUserId(userId);
	}
}