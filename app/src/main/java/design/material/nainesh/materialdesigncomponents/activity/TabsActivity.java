package design.material.nainesh.materialdesigncomponents.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import design.material.nainesh.materialdesigncomponents.R;

/**
 * Created by nainesh on 28/09/16.
 */
public class TabsActivity  extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

//set adapter to your ViewPager
        //viewPager.setAdapter(new TabPagerAdapter(getFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
