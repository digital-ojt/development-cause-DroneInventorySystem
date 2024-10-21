package com.digitalojt.web.consts;

/**
 * カテゴリー Enumクラス
 * 
 * @author haruka matano
 */

public enum Category 
{	
	
    FRAME("フレーム"),
    PROPELLER("プロペラ"),
    MOTOR("電動モーター"),
    CONTROLLER("電子速度調整器"),
    BATTERY("バッテリー"),
    FLIGHT_CONTROLLER("フライトコントローラー"),
    REMOTE_CONTROLLER("リモートコントローラー"),
    RECEIVER("受信機"),
    MODULE("GPSモジュール"),
    CAMERA_SENSOR("カメラ/センサー");
	
	
	private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
