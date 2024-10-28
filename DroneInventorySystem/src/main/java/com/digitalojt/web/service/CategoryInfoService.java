package com.digitalojt.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalojt.web.entity.CategoryInfo;
import com.digitalojt.web.repository.CategoryInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * 分類情報画面のサービスクラス
 *
 * @author haruka matano
 */
@Service
@RequiredArgsConstructor
public class CategoryInfoService {

    /** 分類情報テーブル リポジトリー */
    private final CategoryInfoRepository repository;

    /**
     * 分類情報を全件検索で取得
     *
     * @return
     */
    public List<CategoryInfo> getCategoryInfoData() {
        // MySQLからすべてのカテゴリ情報を取得
        return repository.findAll();
    }

    /**
     * 引数に合致する分類情報を取得
     *
     * @param category
     * @return
     */
    public List<CategoryInfo> getCategoryInfoData(String category) {
        // MySQLから指定されたカテゴリ名でフィルタリングして取得
        return repository.findByCategoryName(category);
    }
}
