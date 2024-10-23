package com.digitalojt.web.controller;



import java.util.Arrays;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.digitalojt.web.consts.Category;
import com.digitalojt.web.consts.UrlConsts;
import com.digitalojt.web.entity.CategoryInfo;
import com.digitalojt.web.form.CategoryInfoForm;
import com.digitalojt.web.service.CategoryInfoService;
import com.digitalojt.web.util.MessageManager;

import jakarta.validation.Valid;
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

	/** メッセージソース */
	private final MessageSource messageSource;
	
	
	/**
	 * 初期表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(UrlConsts.CATEGORY_INFO)
	public String index(Model model) 
	{;	
	// 在庫センター情報画面に表示するデータを取得
	List<CategoryInfo> categoryInfoList = categoryInfoService.getCategoryInfoData();

	// 画面表示用に商品情報リストをセット
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
	public String search(Model model,@Valid CategoryInfoForm form, BindingResult bindingResult) {
//
		// Valid項目チェック
		if (bindingResult.hasErrors()) 
		{
			// エラーメッセージをプロパティファイルから取得
			String errorMsg = MessageManager.getMessage(messageSource, bindingResult.getGlobalError().getDefaultMessage());
			model.addAttribute("errorMsg", errorMsg);
			
			// カテゴリーEnumをリストに変換
			List<Category> categoryInfoEnum = Arrays.asList(Category.values());

			// 分類情報をセット
			model.addAttribute("categoryInfoEnum", categoryInfoEnum);
			
			// 分類情報画面に表示するデータを取得
			List<CategoryInfo> categoryInfoList = categoryInfoService.getCategoryInfoData();

			// 画面表示用に商品情報リストをセット
			model.addAttribute("categoryInfoList", categoryInfoList);
			
			return "admin/categoryInfo/index";
		}
		
		// 分類情報画面に表示するデータを取得
		List<CategoryInfo> categoryInfoList = categoryInfoService.getCategoryInfoData(form.getCategoryName());

		// 画面表示用に分類情報リストをセット
		model.addAttribute("categoryInfoList", categoryInfoList);
		
		// カテゴリーEnumをリストに変換
		List<Category> categoryInfoEnum = Arrays.asList(Category.values());
		
		// 検索条件をセット
		model.addAttribute("categoryInfoEnum", categoryInfoEnum);
		
		return "admin/categoryInfo/index";
	}
//	
	
}
