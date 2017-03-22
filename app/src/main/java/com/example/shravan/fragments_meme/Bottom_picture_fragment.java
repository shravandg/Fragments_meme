package com.example.shravan.fragments_meme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Bottom_picture_fragment extends Fragment{

    private static TextView topText;
    private static TextView bottomText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.bottom_picture_fragment,container,false);
        topText = (TextView) v.findViewById(R.id.myTV1);
        bottomText = (TextView) v.findViewById(R.id.myTV2);
        return v;
    }

    public void setMemeText(String t, String b)
    {
        topText.setText(t);
        bottomText.setText(b);
    }
}
