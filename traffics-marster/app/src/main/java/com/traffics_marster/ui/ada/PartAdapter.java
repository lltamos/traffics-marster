package com.traffics_marster.ui.ada;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.traffics_marster.bean.Menu;
import com.traffics_marster.misc.weiget.IconTextView;
import com.traffics_marster.misc.weiget.TextDrawable;

/**
 * Created by Litao-pc on 2016/9/7.
 */
public class PartAdapter extends BaseAdapter {
    Context mC;
    int color;
    Menu[] data;
    private TextDrawable drawable;
    private TextDrawable.IShapeBuilder iShapeBuilder;

    public PartAdapter(Context c, Menu[] data) {
        this.mC = c;
        this.data = data;
        iShapeBuilder = TextDrawable.builder()
                .beginConfig()
                .width(60)  // width in px
                .height(60) // height in px
                .withBorder(1)
                .fontSize(16)
                .endConfig();
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return data[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (i % 2 == 0) {
            color = Color.parseColor("#056f00");
        } else if (i % 3 == 0) {
            color = Color.parseColor("#0fff00");
        } else {
            color = Color.RED;
        }

        if (view == null) {
            view = new IconTextView(mC);
        }
        if (data[i] != null) {
            drawable = iShapeBuilder.buildRound(data[i].getIcomText(), color);
            ((IconTextView) view).setIconText(data[i].getTitle());
            ((IconTextView) view).setDrawable(drawable);
            Drawable d = data[i].getIcomDraw() == 0 ? null : ContextCompat.getDrawable(mC,data[i].getIcomDraw());
            if (d != null) {
                ((IconTextView) view).setIconSrc(d);
            }
        }
        return view;
    }


}
