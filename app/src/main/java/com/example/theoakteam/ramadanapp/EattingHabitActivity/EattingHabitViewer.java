package com.example.theoakteam.ramadanapp.EattingHabitActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.theoakteam.ramadanapp.NavigationDrawerActivity.NavigationDrawerFragment;
import com.example.theoakteam.ramadanapp.R;

/**
 * Created by Sunny_PC on 6/3/2015.
 * this hadith
 */
public class EattingHabitViewer extends ActionBarActivity
{
    private String[] EattingHabitTitle_details;
    private TextView noTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_details);
        Intent myIntent = getIntent();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(getResources().getString(R.string.actionbar_color))));
        int i = Integer.parseInt(myIntent.getStringExtra("indexOfEattingHabit"));

        EattingHabitTitle_details = getResources().getStringArray(R.array.eatting_details);
        noTextView = (TextView) findViewById(R.id.txtview_notification);
        noTextView.setText(EattingHabitTitle_details[i]);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }



}
