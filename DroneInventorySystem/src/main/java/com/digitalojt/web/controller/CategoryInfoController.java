package com.digitalojt.web.controller;



import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.digitalojt.web.consts.Category;
import com.digitalojt.web.consts.UrlConsts;

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
	
	/**
	 * 初期表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(UrlConsts.CATEGORY_INFO)
	public String index(Model model) 
	{;	
		// カテゴリーEnumをリストに変換
		List<Category> categoryInfoList = Arrays.asList(Category.values());

		// 分類情報をセット
		model.addAttribute("categoryInfoList", categoryInfoList);
		
		return "admin/categoryInfo/index";
	}
	
	/**
	 * 検索結果表示
	 * 
	 * @param model
	 * @param form
	 * @return
	 */
	
	@PostMapping(UrlConsts.CATEGORY_INFO_SEARCH)
	public String search(Model model) {
//
//
//		// 在庫センター情報画面に表示するデータを取得
//		List<CenterInfo> centerInfoList = centerInfoService.getCenterInfoData(form.getCenterName(), form.getRegion());
//
		
//		↓のリストに検索条件を反映させる必要がある。
		
		// カテゴリーEnumをリストに変換
		List<Category> categoryInfoList = Arrays.asList(Category.values());
		// 分類情報をセット
		model.addAttribute("categoryInfoList", categoryInfoList);
//
		return "admin/categoryInfo/index";
	}
//	
	
}
