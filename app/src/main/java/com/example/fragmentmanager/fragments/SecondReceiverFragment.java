package com.example.fragmentmanager.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fragmentmanager.R;
import com.example.fragmentmanager.callbacks.FragmentCallbacks;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondReceiverFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondReceiverFragment extends Fragment implements FragmentCallbacks {
    private TextView textView;

    public SecondReceiverFragment() { }

    public static SecondReceiverFragment newInstance( ) {
        SecondReceiverFragment fragment = new SecondReceiverFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_receiver, container, false);
        textView = view.findViewById(R.id.text_second_receiver);
        return view;
    }

    @Override
    public void onMsgFromMainToFragment(String msg) {
        textView.setText(msg);
    }
}