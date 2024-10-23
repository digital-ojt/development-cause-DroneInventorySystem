package com.digitalojt.web.validation;

import org.thymeleaf.util.StringUtils;

import com.digitalojt.web.consts.ErrorMessage;
import com.digitalojt.web.consts.SearchParams;
import com.digitalojt.web.form.CategoryInfoForm;
import com.digitalojt.web.util.ParmCheckUtil;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CategoryInfoFormValidatorImpl implements ConstraintValidator<CategoryInfoFormValidator, CategoryInfoForm>
{
	/**
	 * バリデーションチェック
	 */
	@Override
	public boolean isValid(CategoryInfoForm form, ConstraintValidatorContext context) 
	{

		// バリデーションチェックの前に
		System.out.println("入力: " + form.getCategoryName());
		
		boolean allFieldsEmpty = StringUtils.isEmpty(form.getCategoryName());

		System.out.println("フィールドが空かを確認中");		
		// フィールドが空かをチェック
		if (allFieldsEmpty) 
		{
			System.out.println("フィールドは空です。"); 
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(ErrorMessage.CATEGORY_EMPTY_ERROR_MESSAGE)
					.addConstraintViolation();
			return false;
		}
		else 
		{
	        System.out.println("フィールドは空ではありません。"); 
	    }
		
		// 分類名のチェック
		if (form.getCategoryName() != null) {
			
			System.out.println("不正文字列かを確認中");
			// 不正文字列チェック
			if (ParmCheckUtil.isParameterInvalid(form.getCategoryName())) 
			{
				System.out.println("不正文字列が検出されました。"); 
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(ErrorMessage.CATEGORY_INVALID_INPUT_ERROR_MESSAGE)
						.addConstraintViolation();
				return false;
			}
			else 
			{
	            System.out.println("不正文字列はありません。"); 
	        }
			
			System.out.println("規定文字数か確認中");
			// 文字数チェック
			if (form.getCategoryName().length() > SearchParams.MAX_LENGTH) 
			{
				System.out.println("文字数が規定を超えています。"); 
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(ErrorMessage.CATEGORY_LENGTH_ERROR_MESSAGE)
						.addConstraintViolation();
				return false;
			}
			else 
			{
	            System.out.println("文字数は問題ありません。"); 
	        }
		}

		// その他のバリデーションに問題なければtrueを返す
		return true;
	}
}
