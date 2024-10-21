package com.digitalojt.web.controller;



import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.digitalojt.web.consts.Category;
import com.digitalojt.web.consts.UrlConsts;
import com.digitalojt.web.service.CategoryInfoService;

import lombok.RequiredArgsConstructor;

/**
 * 分類情報画面コントローラークラス
 * 
 * @author haruka matano
 *
 */
@Controller
@RequiredArgsConstructor
public class CategoryInfoController 
{
	
	/** センター情報 サービス */
	private final CategoryInfoService categoryInfoService;
	
	/**
	 * 初期表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(UrlConsts.CLASS_INFO)
	public String index(Model model) 
	{
//		// 分類情報画面に表示するデータを取得
//		List<CategoryInfo> categoryInfoList = categoryInfoService.getCategoryInfoData();
//
//		// 画面表示用に分類情報リストをセット
//		model.addAttribute("categoryInfoList", categoryInfoList);
		
		// カテゴリーEnumをリストに変換
		List<Category> categoryInfoList = Arrays.asList(Category.values());

		// 分類情報をセット
		model.addAttribute("categoryInfoList", categoryInfoList);
		
		return "admin/categoryInfo/index";
	}
}
