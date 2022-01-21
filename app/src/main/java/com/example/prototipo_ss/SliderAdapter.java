package com.example.prototipo_ss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class SliderAdapter extends PagerAdapter {

    private Context Mcontext;
    private List<Slide_Item> theSlideItemsModelClassList;

    public SliderAdapter(Context Mcontext, List<Slide_Item> theSlideItemsModelClassList) {
        this.Mcontext = Mcontext;
        this.theSlideItemsModelClassList = theSlideItemsModelClassList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        /* Creamos una instancia de un archivo XML slider_item con sus objetos de vista correspondientes
        y obtenendo el layout de activity */
        LayoutInflater inflater = (LayoutInflater) Mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout = inflater.inflate(R.layout.slider_item,null);
        /*Establceiendo el textview para el slider y agegandolo al lista*/
        TextView caption_title = sliderLayout.findViewById(R.id.textshow);
        caption_title.setText(theSlideItemsModelClassList.get(position).getNewsText());
       /* Agragando el texto al slider y retornandolo*/
        container.addView(sliderLayout);
        return sliderLayout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
    /*Obtenindo el tamano de la lista de objetos que va contener el slider*/
    @Override
    public int getCount() {
        return theSlideItemsModelClassList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
