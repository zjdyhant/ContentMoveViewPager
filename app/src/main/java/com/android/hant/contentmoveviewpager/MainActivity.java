package com.android.hant.contentmoveviewpager;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.android.hant.contentmoveviewpager.widget.MyScrollImageView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<MyScrollImageView> mList;
    private int mWindowWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mWindowWidth = getResources().getDisplayMetrics().widthPixels;
        initView();
    }

    private void initImageViews() {

        mList = new ArrayList<>();
        MyScrollImageView image1 = new MyScrollImageView(this,"111111","放松放松法放松法第三方的身份双方的首发",R.drawable.a);
        MyScrollImageView image2 = new MyScrollImageView(this,"222222","放松放松法放松法第三方的身份双方的首发",R.drawable.b);
        MyScrollImageView image3 = new MyScrollImageView(this,"333333","放松放松法放松法第三方的身份双方的首发",R.drawable.c);
        MyScrollImageView image4 = new MyScrollImageView(this,"444444","放松放松法放松法第三方的身份双方的首发",R.drawable.d);
        mList.add(image1);
        mList.add(image2);
        mList.add(image3);
        mList.add(image4);
    }

    private void initView() {
        initImageViews();
        ViewPager mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new MyViewPagerAdapter(mList));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mList.get(position).setOffset(1 - positionOffset, positionOffsetPixels);
                if (position + 1 < mList.size()) {
                    mList.get(position + 1).setOffset(positionOffset, -(mWindowWidth - positionOffsetPixels));
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public class MyViewPagerAdapter extends PagerAdapter{
        private List<MyScrollImageView> list;
        public MyViewPagerAdapter(List<MyScrollImageView> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }
    }
}
