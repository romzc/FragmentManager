package com.example.fragmentmanager.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentmanager.R;
import com.example.fragmentmanager.callbacks.FragmentCallbacks;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReceiverFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReceiverFragment extends Fragment implements FragmentCallbacks {

    private static final String RECEIVER1 = "RECEIVER1";
    TextView textView;

    public ReceiverFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ReceiverFragment newInstance(String param1, String param2) {
        ReceiverFragment fragment = new ReceiverFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receiver, container, false);
        textView = view.findViewById(R.id.text_first_receiver);
        return view;
    }

    @Override
    public void onMsgFromMainToFragment(String msg) { textView.setText(msg); }
}