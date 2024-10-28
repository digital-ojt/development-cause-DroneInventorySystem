package com.digitalojt.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalojt.web.entity.CategoryInfo;

public interface CategoryInfoRepository extends JpaRepository<CategoryInfo, Integer> 
{
    // カテゴリ名でフィルタリングするメソッドを追加
    List<CategoryInfo> findByCategoryName(String categoryName);
}
