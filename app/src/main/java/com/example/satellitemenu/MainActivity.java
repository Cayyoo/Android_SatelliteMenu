package com.example.satellitemenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用Animation动画实现卫星菜单
 *
 * 慕课网：https://www.imooc.com/learn/300
 */
public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private SrcMenu mSrcMenu;

    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
        initEvent();
    }

    private void initEvent() {
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (mSrcMenu.isOpen()) {
                    mSrcMenu.toggleMenu(600);
                }
            }
        });

        mSrcMenu.setOnMenuItemClickListener(new SrcMenu.OnMenuItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(MainActivity.this, position + ":" + view.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        mDatas = new ArrayList<>();

        for (int i = 'A'; i <= 'Z'; i++) {
            mDatas.add((char) i + "");
        }
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.id_listview);
        mSrcMenu = (SrcMenu) findViewById(R.id.src_menu);

        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDatas));
    }

}
