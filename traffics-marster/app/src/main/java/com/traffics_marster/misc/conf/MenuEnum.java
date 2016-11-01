package com.traffics_marster.misc.conf;

import com.traffics_marster.bean.Menu;
import com.traffics_marster.ui.act.BGMapActivity;
import com.traffics_marster.ui.act.SettingActivity;
import com.traffics_marster.ui.act.ToolActivity;

/**
 * Created by Litao-pc on 2016/9/12.
 */
public enum MenuEnum {

    Tool_fr(new Menu[]{
            new Menu("Tool", 0, "设置", ToolActivity.class),
            new Menu("New", 0, "新建地图", ToolActivity.class),
            new Menu("Exp", 0, "导出地图", ToolActivity.class),
            new Menu("Help", 0, "关于", ToolActivity.class),
    }, "0"),

    Tool_ac(new Menu[]{
            new Menu("dafult", 0, "采集设置", SettingActivity.class),
            new Menu("dafult", 0, "背景地图设置", BGMapActivity.class),
            new Menu("dafult", 0, "公路地图", SettingActivity.class),
    }, "1");








    private MenuEnum(Menu[] menus, String sysCode) {
        this.sysCode = sysCode;
        this.menus = menus;
    }

    private MenuEnum(String sysCode) {
        this.sysCode = sysCode;
    }

    private String sysCode;
    private Menu[] menus;


    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    // 普通方法
    public static Menu[] getName(String sysCode) {
        for (MenuEnum c : MenuEnum.values()) {
            if (c.getSysCode() == sysCode) {
                return c.menus;
            }
        }
        return null;
    }
}
