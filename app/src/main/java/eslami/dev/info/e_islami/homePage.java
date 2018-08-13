package eslami.dev.info.e_islami;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import java.util.List;

import eslami.dev.info.e_islami.Fragments.AllItemFragement;
import eslami.dev.info.e_islami.Fragments.MyListFragment;
import eslami.dev.info.e_islami.Fragments.PlayListFragment;
import eslami.dev.info.e_islami.Models.ApiGlobalModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class homePage extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        /**
         * this for the toolbare
         */
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.title_toolbar);

        /**
         * this for the viewpager and tabs
         */
        ViewPager viewPager=findViewById(R.id.viewPager);
        TabLayout tabLayout=findViewById(R.id.tab);

        /**
         * this for the adapter add the fragmet to the home page
         */

        Adapter adapter=new Adapter(getSupportFragmentManager());
        adapter.addFragment(new MyListFragment(),"Favorite");
        adapter.addFragment(new PlayListFragment(),"Quran");
        adapter.addFragment(new PlayListFragment(),"Ananchid");
        adapter.addFragment(new AllItemFragement(),"Audio");

        /**
         * add the adapter to the view pager and tabs
         */

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);




    }
}
