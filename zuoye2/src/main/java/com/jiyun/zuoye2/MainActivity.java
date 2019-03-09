package com.jiyun.zuoye2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jiyun.zuoye2.fragment.NewsFragment;
import com.jiyun.zuoye2.fragment.WxFragment;

public class MainActivity extends AppCompatActivity {

    /**
     * 知乎日报
     */
    private TextView mToolTitle;
    private Toolbar mToolbar;
    private FrameLayout mContainer;
    private NavigationView mNv;
    private DrawerLayout mDl;
    private FragmentManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mManager = getSupportFragmentManager();
        initView();
        addShowFragment();
    }

    private void addShowFragment() {
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.container,new NewsFragment());
        transaction.show(new NewsFragment());
        transaction.commit();
    }

    private void initView() {
        mToolTitle = (TextView) findViewById(R.id.tool_title);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mContainer = (FrameLayout) findViewById(R.id.container);
        mNv = (NavigationView) findViewById(R.id.nv);
        mDl = (DrawerLayout) findViewById(R.id.dl);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        mNv.setItemIconTintList(null);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDl, mToolbar, R.string.app_name, R.string.app_name);
        mDl.addDrawerListener(toggle);
        toggle.syncState();

        mNv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = mManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.item1:

                        break;
                    case R.id.item2:
                        transaction.replace(R.id.container,new NewsFragment());
                        mToolTitle.setText("知乎日报");
                        mDl.closeDrawer(Gravity.LEFT);
                        transaction.commit();
                        break;
                    case R.id.item3:
                        transaction.replace(R.id.container,new WxFragment());
                        mToolTitle.setText("微信精选");
                        mDl.closeDrawer(Gravity.LEFT);
                        transaction.commit();
                        break;
                    case R.id.item4:
                        mToolTitle.setText("干货集中营");
                        mDl.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.item5:
                        mToolTitle.setText("稀土掘金");
                        mDl.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.item6:
                        mToolTitle.setText("V2EX");
                        mDl.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.item7:

                        mDl.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.item8:
                        mToolTitle.setText("收藏");
                        mDl.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.item9:
                        mToolTitle.setText("设置");
                        mDl.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.item10:
                        mToolTitle.setText("关于");
                        mDl.closeDrawer(Gravity.LEFT);
                        break;
                }
                return false;
            }

        });
    }
}
