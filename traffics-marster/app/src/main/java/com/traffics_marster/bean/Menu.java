
package com.traffics_marster.bean;


/**
 * @ClassName: Menu
 * @Description: 系统菜单配置
 */
public class Menu {
    public String getIcomText() {
        return icomText;
    }

    public void setIcomText(String icomText) {
        this.icomText = icomText;
    }

    public int getIcomDraw() {
        return icomDraw;
    }

    public void setIcomDraw(int icomDraw) {
        this.icomDraw = icomDraw;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    private String icomText;
    private int icomDraw;
    private String title;
    private Class<?> clazz;

    public Menu(String icomText, int icomDraw, String title, Class<?> clazz) {
        super();
        this.icomText = icomText;
        this.icomDraw = icomDraw;
        this.title = title;
        this.clazz = clazz;
    }



}
