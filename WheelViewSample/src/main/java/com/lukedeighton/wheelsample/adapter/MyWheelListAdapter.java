package com.lukedeighton.wheelsample.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lukedeighton.wheelsample.R;
import com.lukedeighton.wheelsample.model.WheelListMain;
import com.lukedeighton.wheelview.adapter.WheelArrayAdapter;

import java.util.ArrayList;

/**
 * Created by arbaz on 1/2/17.
 */

public class MyWheelListAdapter extends WheelArrayAdapter<WheelListMain> {
    ArrayList<WheelListMain> wheelListMainArrayList;
    Context context;
    View v;
    ImageView ivPMenuImg;
    TextView tvPMenuTxt;
    WheelListMain wheelListMain;

    public MyWheelListAdapter(ArrayList<WheelListMain> wheelListMainArrayList, Context context) {
        super(wheelListMainArrayList);
        this.wheelListMainArrayList = wheelListMainArrayList;
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        v = inflater.inflate(R.layout.wheel_list_row, null, true);
        tvPMenuTxt = (TextView) v.findViewById(R.id.tvPMenuTxt);
        ivPMenuImg = (ImageView) v.findViewById(R.id.ivPMenuImg);

    }


    @Override
    public Drawable getDrawable(int position) {
        wheelListMain = wheelListMainArrayList.get(position);
        tvPMenuTxt.setText(wheelListMain.getWheelName());

        if (position == 0) {
            ivPMenuImg.setImageResource(R.drawable.ic_applied_games);
        } else if (position == 1) {
            ivPMenuImg.setImageResource(R.drawable.ic_feedback);
        } else if (position == 2) {
            ivPMenuImg.setImageResource(R.drawable.ic_history);
        } else if (position == 3) {
            ivPMenuImg.setImageResource(R.drawable.ic_logout);
        } else if (position == 4) {
            ivPMenuImg.setImageResource(R.drawable.ic_notifications);
        } else if (position == 5) {
            ivPMenuImg.setImageResource(R.drawable.ic_filter);
        }
        Drawable drawable = new BitmapDrawable(context.getResources(), getBitmapFromView(v));
      //  ColorDrawable cd = new ColorDrawable(0xFFFF6666);
        return drawable;
    }

    public static Bitmap getBitmapFromView(View view) {
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.draw(canvas);
        return bitmap;
    }
}
