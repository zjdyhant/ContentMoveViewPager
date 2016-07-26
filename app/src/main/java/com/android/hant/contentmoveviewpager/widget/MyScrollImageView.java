package com.android.hant.contentmoveviewpager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.hant.contentmoveviewpager.R;

public class MyScrollImageView extends RelativeLayout {

    private ImageView mImageView;
    private TextView mTextViewTitle;
    private TextView mTextViewContent;

    public MyScrollImageView(Context context, String title, String content, int resId) {
        this(context, null);
        mTextViewTitle.setText(title);
        mTextViewContent.setText(content);
        mImageView.setImageResource(resId);
    }

    public MyScrollImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyScrollImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.layout_scroll_imageview, this, true);
        mImageView = (ImageView) findViewById(R.id.image_view);
        mTextViewTitle = (TextView) findViewById(R.id.txt_title);
        mTextViewContent = (TextView) findViewById(R.id.txt_content);
    }

    public void setOffset(float positionOffset, int positionOffsetPixels) {
        mTextViewTitle.setAlpha(positionOffset);
        mTextViewContent.setAlpha(positionOffset);
        mImageView.setTranslationX(positionOffsetPixels / 2);
        invalidate();
    }

}
