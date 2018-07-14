package shahzaib.com.onboardingapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private slideAdaptor slideAdaptor;
    private TextView[] dots;
    private Button backbtn;
    private Button nextbtn;

    private int currentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backbtn = findViewById(R.id.prevbtn);
        nextbtn = findViewById(R.id.nextbtn);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        linearLayout = (LinearLayout) findViewById(R.id.linear);
        slideAdaptor = new slideAdaptor(this);

        viewPager.setAdapter(slideAdaptor);
        addDots(0);
        viewPager.addOnPageChangeListener(viewpagerlistner);


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPage-1);
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPage +1);
                    }

                });



            }


    public void addDots(int pos) {

        dots =new  TextView[3];
        linearLayout.removeAllViews();

        for(int i = 0; i <dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorTransformWhite));
            linearLayout.addView(dots[i]);
        }

        if(dots.length > 0) {
            dots[pos].setTextColor(getResources().getColor(R.color.colorWhite));

        }

    }

    ViewPager.OnPageChangeListener viewpagerlistner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(final int position) {
            addDots(position);

            currentPage = position;

            if(position == 0) {
                nextbtn.setEnabled(true);
                backbtn.setEnabled(false);
                backbtn.setVisibility(View.INVISIBLE);

                nextbtn.setText("Next");
                backbtn.setText("");

            } else if (position == dots.length - 1) {


                nextbtn.setEnabled(true);
                backbtn.setEnabled(true);
                backbtn.setVisibility(View.VISIBLE);

                nextbtn.setText("Finish");
                backbtn.setText("Back");






            } else {
                nextbtn.setEnabled(true);
                backbtn.setEnabled(true);
                backbtn.setVisibility(View.VISIBLE);

                nextbtn.setText("Next");
                backbtn.setText("Back");


            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
