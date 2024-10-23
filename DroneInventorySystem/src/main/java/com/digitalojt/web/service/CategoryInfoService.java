package com.digitalojt.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalojt.web.entity.CategoryInfo;
import com.digitalojt.web.repository.CategoryInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * 分類情報画面のサービスクラス
 *
 * @author haruka matano
 * 
 */
@Service
@RequiredArgsConstructor
public class CategoryInfoService 
{
	/** 分類情報テーブル リポジトリー */
	private final CategoryInfoRepository repository;
	
	/**
	 * 分類情報を全件検索で取得
	 * 
	 * @return
	 */
	public List<CategoryInfo> getCategoryInfoData() {

		// 分類情報作成
		List<CategoryInfo> categoryInfoList = createCategoryInfo();

		return categoryInfoList;
	}
	
	/**
	 * 引数に合致する分類情報を取得
	 * 
	 * @param categoryName
	 * @param category
	 * @param storageCapacityFrom 
	 * @param storageCapacityTo
	 * @return 
	 */
	public List<CategoryInfo> getCategoryInfoData(String category) {

		// 分類情報作成
		List<CategoryInfo> categoryInfoList = createCategoryInfo();

		// 検索処理
		categoryInfoList = searchCategoryInfoData(categoryInfoList, category);

		return categoryInfoList;
	}
	
	/**
	 * 検索処理
	 * 
	 * @param categoryInfoList
	 * @param category
	 * @return
	 */
	private List<CategoryInfo> searchCategoryInfoData(List<CategoryInfo> categoryInfoList, String category)
	{

		List<CategoryInfo> hitCategoryInfoList = new ArrayList<>();
		
		// 引数の文字列と合致する要素のみリストに追加
		categoryInfoList.forEach(item -> 
		{
			if (category.equals(item.getCategoryName()))
			{
				hitCategoryInfoList.add(item);
			}
		});

		return hitCategoryInfoList;
	}
	
	
	/**
	 * 分類情報作成
	 * 
	 * @return
	 */
	private List<CategoryInfo> createCategoryInfo() 
	{

		List<CategoryInfo> categoryInfoList = new ArrayList<>();

		// 1コード目作成
		CategoryInfo categoryInfo = new CategoryInfo();
		categoryInfo.setCategoryName("フレーム");
		categoryInfoList.add(categoryInfo);

		// 2コード目作成
		categoryInfo = new CategoryInfo();
		categoryInfo.setCategoryName("プロペラ");
		categoryInfoList.add(categoryInfo);

		// 3コード目作成
		categoryInfo = new CategoryInfo();
		categoryInfo.setCategoryName("電動モーター");
		categoryInfoList.add(categoryInfo);

		// 4コード目作成
		categoryInfo = new CategoryInfo();
		categoryInfo.setCategoryName("電子速度調整器");
		categoryInfoList.add(categoryInfo);

		// 5コード目作成
		categoryInfo = new CategoryInfo();
		categoryInfo.setCategoryName("バッテリー");
		categoryInfoList.add(categoryInfo);

		// 6コード目作成
		categoryInfo = new CategoryInfo();
		categoryInfo.setCategoryName("フライトコントローラー");
		categoryInfoList.add(categoryInfo);

		// 7コード目作成
		categoryInfo = new CategoryInfo();
		categoryInfo.setCategoryName("リモートコントローラー");
		categoryInfoList.add(categoryInfo);

		// 8コード目作成
		categoryInfo = new CategoryInfo();
		categoryInfo.setCategoryName("受信機");
		categoryInfoList.add(categoryInfo);

		// 9コード目作成
		categoryInfo = new CategoryInfo();
		categoryInfo.setCategoryName("GPSモジュール");
		categoryInfoList.add(categoryInfo);

		// 10コード目作成
		categoryInfo = new CategoryInfo();
		categoryInfo.setCategoryName("カメラ/センサー");
		categoryInfoList.add(categoryInfo);

		return categoryInfoList;
	}
}
