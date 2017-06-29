package com.ids.appsubasta.subasta;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.ids.appsubasta.subasta.R.id.ImagenesID;
import static com.ids.appsubasta.subasta.R.id.ImagenesID2;
import static com.ids.appsubasta.subasta.R.id.ImagenesID3;

public class Slider_Adapter extends PagerAdapter {

    private int[] image_resources = {R.drawable.iphonee, R.drawable.collar_perlas, R.drawable.gorra};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public Slider_Adapter (Context ctx){
        this.ctx=ctx;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate (R.layout.activity_slider, container,false);

        ImageView imageView = (ImageView)item_view.findViewById(R.id.slider_image);

        imageView.setImageResource(image_resources[position]);
        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem (ViewGroup container, int position, Object object){
        container.removeView((LinearLayout) object);
    }

}
