package com.example.sumit_thakur.concept;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import com.example.sumit_thakur.concept.BaseActivity.BaseActivity;
import com.example.sumit_thakur.concept.Fragment.UpComingAndPastFragment;

/**
 * Last Final Activity
 */
public class FinalActivity extends BaseActivity {
    private ViewPager viewPager;
    private Button btnUpCommingPressed, btnPastPressed;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        init();
        viewPager = (ViewPager) findViewById(R.id.vpSwipe);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                if (position == 0) {
                    btnUpCommingPressed.setBackgroundResource(R.color.colorPrimary);
                    btnPastPressed.setBackgroundColor(getResources().getColor(R.color.colorAccent));


                } else {
                    btnUpCommingPressed.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    btnPastPressed.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                }

            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                if (position == 0) {
                    return new UpComingAndPastFragment(UP_COMING);
                }
                return new UpComingAndPastFragment(PAST);
            }

            @Override
            public int getCount() {
                return 2;
            }

        };
        viewPager.setAdapter(fragmentStatePagerAdapter);
    }
    /**
     * initilization
     */
    private void init() {
        btnUpCommingPressed = (Button) findViewById(R.id.btnUpComing);
        btnPastPressed = (Button) findViewById(R.id.btnPast);
    }
}
