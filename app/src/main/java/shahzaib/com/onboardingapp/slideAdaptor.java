package shahzaib.com.onboardingapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by shahzaib on 7/15/2018.
 */

public class slideAdaptor extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public slideAdaptor(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return slideheading.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==  object;
    }

    public int[] slideimages= {

    R.drawable.cat,
    R.drawable.coffee,
    R.drawable.user
    };

    public String[] slideheading = {
            "EAT",
            "SLEEP",
            "CODE",

    };

    public String[] dics = {
            "how to the whole. The four elements essential to good paragraph writing are: unity, order, coherence, and completeness.",
            "how to the whole. The four elements essential to good paragraph writing are: unity, order, coherence, and completeness.",
            "how to the whole. The four elements essential to good paragraph writing are: unity, order, coherence, and completeness."

    };

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_show,container,false);

        ImageView imageView = view.findViewById(R.id.imageView2);
        TextView heading = view.findViewById(R.id.slide_heading);
        TextView discription = view.findViewById(R.id.slide_discr);

        imageView.setImageResource(slideimages[position]);
        heading.setText(slideheading[position]);
        discription.setText(dics[position]);

        container.addView(view);


        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);

    }
}
