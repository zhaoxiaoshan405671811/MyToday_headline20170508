package com.example.a1.mytoday_headline20170508;

import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import fragment.Left_Fragment;
import fragment.Right_Fragment;

public class MainActivity extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_zhuye);
       //设置左右侧拉
        set_LeftRight();
    }

    private void set_LeftRight() {
        Left_Fragment left_fragment = new Left_Fragment();
        //设置侧滑菜单布局
        setBehindContentView(R.layout.left);
        getSupportFragmentManager().beginTransaction().replace(R.id.left,left_fragment).commit();
        SlidingMenu menu = getSlidingMenu();
        //设置滑动方式
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //设置阴影的宽度
        menu.setShadowWidthRes(R.dimen.shadow_width);
        //设置slidingMenu边界的阴影图片
        menu.setShadowDrawable(R.drawable.shadow);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        //设置右边（二级）侧滑菜单
        Right_Fragment right_fragment = new Right_Fragment();
        //设置右边侧拉菜单的布局
        menu.setSecondaryMenu(R.layout.right);
        getSupportFragmentManager().beginTransaction().replace(R.id.right,right_fragment).commit();

    }
}
