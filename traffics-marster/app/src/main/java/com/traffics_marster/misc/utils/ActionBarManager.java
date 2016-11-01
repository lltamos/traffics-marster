
package com.traffics_marster.misc.utils;


import android.support.v7.app.ActionBar;

/**
  * @ClassName: ActionBarManager
  * @Description: 对ActionBar管理
  * @author Comsys-wuxianling
  * @date 2015年5月27日 下午3:59:00
  */
public class ActionBarManager {
	
	/**
	 * 设置居中标题
	 */
	public static void initTitleCenterActionBar(ActionBar actionBar){
		actionBar.setDisplayShowCustomEnabled(false);
		actionBar.setDisplayUseLogoEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayHomeAsUpEnabled(false);
	}


	/**
	 * 订制一个返回+标题的标题栏
	 */
	public static void initBackTitle(ActionBar actionBar){
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setDisplayShowCustomEnabled(true);

	}

}
