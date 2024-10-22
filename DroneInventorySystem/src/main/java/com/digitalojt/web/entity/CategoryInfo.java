package com.digitalojt.web.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 分類情報Entity
 * 
 * @author haruka matano
 *
 */
@Data
@Getter
@Setter
@Entity

public class CategoryInfo 
{

	/**
	 * 分類ID
	 */
	@Id
	private int categoryId;
	
	/**
	 * 名前
	 */
	private String categoryName;
	
	/**
	 * 削除フラグ
	 */
	private String deleteFlag;

	/**
	 * 作成日付
	 */
	private Timestamp createDate;
	
	/**
	 * 更新日付
	 */
	private Timestamp updateDate;
	
	
}
