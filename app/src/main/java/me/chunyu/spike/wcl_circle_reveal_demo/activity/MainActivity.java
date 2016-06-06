package me.chunyu.spike.wcl_circle_reveal_demo.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.xys.libzxing.zxing.activity.CaptureActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.chunyu.spike.wcl_circle_reveal_demo.R;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.fab)
    FloatingActionButton mFab;
    private ListView listView;
    private String[] data;
    private TextView result_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initData();

        initView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 5) {
                    startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), 0);

                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            result_tv.setText(result);

        }
    }
    private void initView() {
        result_tv = (TextView)findViewById(R.id.result_id);
        listView = (ListView) findViewById(R.id.function_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
    }

    private void initData() {
        data = new String[]{"创建书库", "添加图书", "更新图书", "查询图书",
                "删除图书", "条形码扫描"};
    }


    // Fab的跳转事件
    public void startOtherActivity(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options =
                    ActivityOptions.makeSceneTransitionAnimation(this, mFab, mFab.getTransitionName());
            startActivity(new Intent(this, ShowActivity.class), options.toBundle());
        } else {
            startActivity(new Intent(this, ShowActivity.class));
        }
    }


}
