package com.example.fragmentmanager.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragmentmanager.R;
import com.example.fragmentmanager.activities.MainActivity;

public class SenderFragment extends Fragment {

    public static String SENDER = "SENDER";
    private MainActivity mainActivity;
    private EditText editText;
    private Button sendButton;


    public SenderFragment() {
        // Required empty public constructor
    }
    public static SenderFragment newInstance() {
        SenderFragment fragment = new SenderFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sender, container, false);
        editText = view.findViewById(R.id.sender_text);
        sendButton = view.findViewById(R.id.send_button);
        sendButton.setOnClickListener(sendClickListener);
        return view;
    }

    private View.OnClickListener sendClickListener = new View.OnClickListener () {
        @Override
        public void onClick(View view) {
            String message = editText.getText().toString();
            mainActivity.onMsgFromFragToMain(SENDER, message);
        }
    };
}