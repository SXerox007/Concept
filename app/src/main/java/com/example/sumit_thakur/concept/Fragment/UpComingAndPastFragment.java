package com.example.sumit_thakur.concept.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sumit_thakur.concept.Constants.Constants;
import com.example.sumit_thakur.concept.R;

/**
 * upcoming and past Fragment
 */
public class UpComingAndPastFragment extends Fragment implements Constants {
    private String mMode;
    private ViewPager viewPager;
    private Button btnFirstPressed, btnSecondPressed;

    /**
     * @param mMode mode
     */
    public UpComingAndPastFragment(final String mMode) {
        this.mMode = mMode;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.up_coming_and_past, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.vpSwipe);
        btnFirstPressed = (Button) view.findViewById(R.id.btnFirst);
        btnSecondPressed = (Button) view.findViewById(R.id.btnSecond);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                if (position == 0) {
                    btnFirstPressed.setText("Pending");
                    btnSecondPressed.setText("Accepted");
                    btnFirstPressed.setBackgroundResource(R.color.colorPrimary);
                    btnSecondPressed.setBackgroundResource(R.color.colorPrimaryDark);
                } else {
                    btnFirstPressed.setText("Cenceld");
                    btnSecondPressed.setText("Completed");
                    btnFirstPressed.setBackgroundResource(R.color.colorPrimaryDark);
                    btnSecondPressed.setBackgroundResource(R.color.colorPrimary);
                }
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                if (position == 0) {
                    return new PendingAcceptandCompleteCancel(UP_COMING);
                } else {
                    return new PendingAcceptandCompleteCancel(PAST);
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
        viewPager.setAdapter(fragmentStatePagerAdapter);

        return view;
    }

    @Override
    public void extra() {

    }

}
