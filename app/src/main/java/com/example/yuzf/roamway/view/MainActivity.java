package com.example.yuzf.roamway.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.yuzf.roamway.R;

/**
 * 主页
 */
public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAll();
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override    //NavigationView的点击侦听，这里监听了菜单的点击
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                updateItemCheckedView();
                switch (item.getItemId()){
                    case R.id.zhihu:
                        Toast.makeText(MainActivity.this,"点击了知乎",Toast.LENGTH_SHORT).show();
                        item.setChecked(true);
                        break;
                    case R.id.wangyi:
                        Toast.makeText(MainActivity.this,"点击了网易",Toast.LENGTH_SHORT).show();
                        item.setChecked(true);
                        break;
                    case R.id.meiri:
                        Toast.makeText(MainActivity.this,"点击了每日",Toast.LENGTH_SHORT).show();
                        item.setChecked(true);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }



    /**
     * 初始化及绑定变量
     */
    private void initAll() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mNavigationView = findViewById(R.id.nav_view);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,R.string.open,R.string.close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);  //===这里真正进行将DrawerLayout与ToolBar绑定
        mDrawerToggle.syncState();
    }

    private void updateItemCheckedView(){  //当点击侧滑栏选项时，将其余
        for(int i = 0; i < 3; i ++){     // 选项设置成未选中
            mNavigationView.getMenu().getItem(i).setChecked(false);
        }
    }
}
