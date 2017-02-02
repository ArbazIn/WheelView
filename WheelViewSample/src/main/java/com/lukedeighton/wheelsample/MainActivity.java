package com.lukedeighton.wheelsample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.lukedeighton.wheelsample.adapter.MyWheelListAdapter;
import com.lukedeighton.wheelsample.model.WheelListMain;
import com.lukedeighton.wheelview.WheelView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private static final int ITEM_COUNT = 6;
    ArrayList<WheelListMain> wheelListMainArrayList = new ArrayList<>();
    MyWheelListAdapter wheelListAdapter;
    WheelListMain wheelListMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WheelView wheelView = (WheelView) findViewById(R.id.wheelview);
        for (int i = 0; i < 6; i++) {
            wheelListMain = new WheelListMain("MAS:-" + " " + i, R.drawable.ic_launcher);
            wheelListMainArrayList.add(wheelListMain);
        }

        wheelView.setWheelItemCount(wheelListMainArrayList.size());
        wheelListAdapter = new MyWheelListAdapter(wheelListMainArrayList, MainActivity.this);
        wheelView.setAdapter(wheelListAdapter);

        wheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {
            @Override
            public void onWheelItemClick(WheelView parent, int position, boolean isSelected) {
                String msg = String.valueOf(position) + " " + isSelected;
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });


    }


}