package com.traffics_marster.misc.weiget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.traffics_marster.R;

/**
 * Created by Litao-pc on 2016/9/8.
 */
public class IconTextView extends LinearLayout {

    private Drawable iconSrc;
    private CharSequence iconText;
    private TextView textView;
    private ImageView imageView;
    private ImageView check_icon;

    public IconTextView(Context context) {
        this(context, null);
    }

    public IconTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IconTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconTextVIew);

        try {
            iconSrc = a.getDrawable(R.styleable.IconTextVIew_icon);
            iconText = a.getText(R.styleable.IconTextVIew_text);

        } finally {
            a.recycle();
        }

        LayoutInflater.from(context).inflate(R.layout.text_drawable_layout, this, true);

        bindView();

    }

    private void bindView() {
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        check_icon = (ImageView) findViewById(R.id.check_icon);
        check_icon.setImageDrawable(this.iconSrc);
        textView.setText(this.iconText);
    }

    public void setDrawable(ShapeDrawable drawable) {

        imageView.setImageDrawable(drawable);
    }

    public void setIconSrc(Drawable iconSrc) {
        check_icon.setImageDrawable(iconSrc);
        check_icon.setVisibility(VISIBLE);
        imageView.setVisibility(GONE);
    }

    public String getIconText() {
        return textView.getText().toString();
    }

    public void setIconText(String iconText) {
        textView.setText(iconText);
    }
}
