package com.digitalojt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.digitalojt.web.consts.UrlConsts;

/**
 * 在庫一覧画面コントローラークラス
 * 
 * @author haruka matano
 *
 */
@Controller
public class ClassInfoController extends AbstractController {

	/**
	 * 初期表示
	 * 
	 * @return String(path)
	 */
	@GetMapping(UrlConsts.CLASS_INFO)
	public String index() {

		return "admin/classInfo/index";
	}
}
