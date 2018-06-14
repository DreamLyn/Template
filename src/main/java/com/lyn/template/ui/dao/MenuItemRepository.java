package com.lyn.template.ui.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lyn.template.ui.entity.MenuItem;

import net.bytebuddy.description.field.FieldDescription.InGenericShape;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
	List<MenuItem> findByLevelOrderBySequenceAsc(int level);
	List<MenuItem> findByLevelAndParentIdOrderBySequenceAsc(int level,long parentId);
}
