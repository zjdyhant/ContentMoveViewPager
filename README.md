# ContentMoveViewPager

ViewPager里面的内容跟着移动。看到miui系统屏保效果，自己实现一下.

##效果
![](https://github.com/zjdyhant/ContentMoveViewPager/blob/master/app/src/main/res/raw/contentmove.gif?raw=true)

###实现很简单
用viewPager实现图片切换，对PagerAdapter设置OnPageChangeListener监听，onPageScrolled方法里，不停的对MyScrollImageView设置偏移量。<br>
* onPageScrolled方法
```Java
public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mList.get(position).setOffset(1 - positionOffset, positionOffsetPixels);
                if (position + 1 < mList.size()) {
                    mList.get(position + 1).setOffset(positionOffset, -(mWindowWidth - positionOffsetPixels));
                }
            }
```
* MyScrollImageView类
```Java
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
```

