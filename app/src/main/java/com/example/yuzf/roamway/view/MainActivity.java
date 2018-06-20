package com.example.yuzf.roamway.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.yuzf.roamway.R;
import com.example.yuzf.roamway.model.User;
import com.example.yuzf.roamway.tools.CircleImageView;

import java.util.jar.Attributes;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * 主页
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;
    private CircleImageView mimage;
    private TextView mname;
    private View headlayout;
    private Intent intent;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Realm r = Realm.getDefaultInstance();
//        final RealmResults<User> users = r.where(User.class).findAll();
//        r.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                users.deleteAllFromRealm();
//            }
//        });
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
        headlayout =mNavigationView.inflateHeaderView(R.layout.headlayout);
        mimage = headlayout.findViewById(R.id.timage);
        mname = headlayout.findViewById(R.id.mname);
        mimage.setOnClickListener(this);
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
        intent = getIntent();
        if(intent != null&&intent.getStringExtra("username")!=null) {
          //  Log.i("username", intent.getStringExtra("username"));
            mname.setText(intent.getStringExtra("username"));
            mimage .setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.girl));
        }else {
            mname.setText("请登录");
            mimage .setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.beforelogin));
        }
    }

    private void updateItemCheckedView(){  //当点击侧滑栏选项时，将其余
        for(int i = 0; i < 3; i ++){     // 选项设置成未选中
            mNavigationView.getMenu().getItem(i).setChecked(false);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.timage:
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
