package theoaktroop.appoframadan.DistrictActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import theoaktroop.appoframadan.R;


public class DistrictAllTimeShow extends ActionBarActivity {


    TextView districtNameTextView;
    TextView ramadanDateTextView;
    TextView englishDateTextView;
    TextView sehriTimeTextView;
    TextView iftarTimeTextView;
    String districtName;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_all_time_show);



        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(getResources().getString(R.string.actionbar_color))));
        Bundle bundle = this.getIntent().getExtras();
        String[] allSehriTime = bundle.getStringArray("allSehri");
        String[] allIftarTime = bundle.getStringArray("allIftar");
        String[] allDate = bundle.getStringArray("allDate");
        districtName = bundle.getString("districtName");

        initialize();
addVisibile();
        for (int i = 1; i <= 30; i++) {
            ramadanDateTextView.append(i + "\n\n");
            englishDateTextView.append(allDate[i] + "\n\n");
            sehriTimeTextView.append(allSehriTime[i] + "\n\n");
            iftarTimeTextView.append(allIftarTime[i] + "\n\n");

        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void addVisibile() {

        LinearLayout adLinearLayout=(LinearLayout)findViewById(R.id.addViewDistimfullshow);
        if(isNetworkAvailable()) {
            adLinearLayout.setVisibility(View.VISIBLE);
            AdView mAdView;
            mAdView = (AdView) findViewById(R.id.adView1);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }
        else {
            adLinearLayout.setVisibility(View.GONE);
        }
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.second_activity_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



    private void initialize() {

        sharedPreferences = getSharedPreferences("RamadanAppData", Context.MODE_PRIVATE);
        //districtName = sharedPreferences.getString("DefaultDistrictName", "Not Found");

        districtNameTextView = (TextView) findViewById(R.id.districtNameTextView);
        ramadanDateTextView = (TextView) findViewById(R.id.ramadanDateTextView);
        englishDateTextView = (TextView) findViewById(R.id.englishDateTextView);
        sehriTimeTextView = (TextView) findViewById(R.id.sehriTimeTextView);
        iftarTimeTextView = (TextView) findViewById(R.id.iftarTimeTextView);


        districtNameTextView.setText(districtName.substring(0, 1).toUpperCase() + districtName.substring(1) + " " + getString(R.string.district_name_all));



    }


//for chessck
}
