package theoaktroop.appoframadan.EattingHabitActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import theoaktroop.appoframadan.R;

import theoaktroop.appoframadan.NavigationDrawerActivity.NavigationDrawerFragment;

/**
 * Created by Sunny_PC on 6/3/2015.
 */
public class EattingHabitTitleClass
        extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    //upper code need for Drawer


    private String[] EattingHabitTitle;
    private ListView lv;
    private int  flagforFinsh=0;
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences;
        sharedPreferences = getSharedPreferences("RamadanAppData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        int ot = getResources().getConfiguration().orientation;
        if(ot== Configuration.ORIENTATION_LANDSCAPE){
            editor.putInt("flagOETV",1);
            editor.commit();

        }
        else if(ot==Configuration.ORIENTATION_PORTRAIT && sharedPreferences.getInt("flagOETV",0)!=0) {
            editor.putInt("flagOETV",0);
            editor.commit();
        }

        else if(ot==Configuration.ORIENTATION_PORTRAIT && sharedPreferences.getInt("flagOETV",0)==0 )
        {   if(flagforFinsh==0)
        {
            finish();
        }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hadithtitle_xml);
        EattingHabitTitle = getResources().getStringArray(R.array.eatting_title);
        lv=(ListView)findViewById(R.id.list_item_hadith_title);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,EattingHabitTitle);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                flagforFinsh=1;
                Intent detailsHadithIntent=new Intent(EattingHabitTitleClass.this,EattingHabitViewer.class);
                detailsHadithIntent.putExtra("indexOfEattingHabit", String.valueOf(position));
                startActivity(detailsHadithIntent);
            }
        });
        //below code use for drawer
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        //upper code use for drawer

    }
//kkk

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_activity_sehri_and_ifter_short_form);
                break;
            case 2:
                mTitle = getString(R.string.title_activity_hadith);
                break;
            case 3:
                mTitle = getString(R.string.title_activity_masala);
                break;
            case 4:
                mTitle = getString(R.string.title_activity_dua);
                break;
            case 5:
                mTitle = getString(R.string.title_activity_tasbih);
                break;
            case 6:
                mTitle = getString(R.string.title_activity_food_habit);
                break;
            case 7:
                mTitle = getString(R.string.title_settings);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_drawer_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            //write here youre current activity
            ((EattingHabitTitleClass) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.title_activity_food_habit));}




}
