package com.example.fragmentmanager.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.fragmentmanager.R;
import com.example.fragmentmanager.callbacks.ActivityCallbacks;
import com.example.fragmentmanager.fragments.ReceiverFragment;
import com.example.fragmentmanager.fragments.SecondReceiverFragment;
import com.example.fragmentmanager.fragments.SenderFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements ActivityCallbacks {
    private Fragment currentFragment;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            handleBottomNavigation(item);
            return true;
        });
    }

    private void handleBottomNavigation( MenuItem item) {
        switch (item.getItemId()) {
            case R.id.firstItem:
                currentFragment = new ReceiverFragment();
                changeFragment(currentFragment);
                break;
            case R.id.secondItem:
                currentFragment = new SecondReceiverFragment();
                changeFragment(currentFragment);
                break;
        }
    }

    // first loading for fragments.
    private void loadFragment() {
        SenderFragment senderFragment = SenderFragment.newInstance();
        currentFragment = new ReceiverFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.sender_fragment_container, senderFragment);
        fragmentTransaction.replace(R.id.receiver_fragment_container, currentFragment);
        fragmentTransaction.commit();

    }

    // replace fragment in receiver fragment container.
    private void changeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.receiver_fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onMsgFromFragToMain(String sender, String message) {
        if( currentFragment == null ) {
            Log.d("ERROR", "Message is empty");
        }
        if( sender.equals(SenderFragment.SENDER)) {
            Log.d(TAG, message);
            if ( currentFragment instanceof ReceiverFragment) {
                ((ReceiverFragment) currentFragment).onMsgFromMainToFragment(message);
            }
            else if ( currentFragment instanceof SecondReceiverFragment) {
                ((SecondReceiverFragment) currentFragment).onMsgFromMainToFragment(message);
            }
        }
    }
}