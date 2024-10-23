package com.digitalojt.web.form;

import com.digitalojt.web.validation.CategoryInfoFormValidator;

import lombok.Data;

/**
 * 在庫センター情報画面のフォームクラス
 * 
 * @author KaitoDokan
 *
 */
@Data
@CategoryInfoFormValidator
public class CategoryInfoForm {

	/**
	 * センター名
	 */
	private String categoryName;

}
