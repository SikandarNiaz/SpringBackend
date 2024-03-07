package com.tradetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tradetracker.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

	@Query(value = "SELECT am.id,am.menu_title, am.menu_header, am.link FROM admin_menus am " + "INNER JOIN admin_role_menu arm ON arm.menu_id = am.id "
			+ "INNER JOIN admin_roles ar ON ar.id = arm.admin_type_id " + "INNER JOIN adminprofile ap ON ap.role_id = ar.id "
			+ "WHERE ap.id = :userId AND am.active='Y' AND arm.active='Y'", nativeQuery = true)
	List<Menu> findMenusByUserId(@Param("userId") Integer userId);
}
