package com.example.shravan.fragments_meme;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;//to let the fragemnt talk to main activity
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TopSectionFragment extends Fragment{
    @Nullable
    private static EditText et1;
    private static EditText et2;

    TopSectionListener activityCommander; //activityCommander is the name of the interface object

    //whenever you want to talk to the top section fragment, in order to do that, you need
    //to implement this interface. later we implement this interface from MainActivity
    //So, whenever we implement this interface, what main activity does is,  it promises that it creates
    //the method createMeme()
    //we need to ensure that this method is created

    //to communicate this top fragment in the main activity we need this interface
    //this interface is implemented by main activity to ensure that u have this function (createMeme) implemented
    public interface TopSectionListener{
        public void createMeme(String top, String bottom);
    }

    @Override
    //press alt+insert and then press overwrite methods and overwrite this method
    //gets called whenever we attach the fragment to the activity
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            //interface is created here
            activityCommander = (TopSectionListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }//super.onAttach(context);
    }

    @Override
//this gets called as sson as the fragment is created
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //to tell android that u are using one of the layouts(xml files) as fragements..we must use inflater
        //container is a view group object..we need to pass it
       View v = inflater.inflate(R.layout.top_section_fragment,container,false);
        et1= (EditText) v.findViewById(R.id.myTop);
        et2=(EditText) v.findViewById(R.id.myBottom);
        final Button btn = (Button)v.findViewById(R.id.myB);

        btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        btnClicked(v);
                    }
                }
        );
        return v;
    }
    //this is called when the button is clicked
    public void btnClicked(View v)
    {
        //(contd.) so if we want to talk to main activity and we pass along this information,
        //and it dont have a method called createMeme(), then that causes trouble...
        // So whenever we attach this fragment on main activity, then we are going to create the interface
        //and sends that we created this.. and so when we click the button, we go to mainactivity and
        //call the createMeme() whith two piexes of strings

        //here we are talking to main activity
        activityCommander.createMeme(et1.getText().toString(),et2.getText().toString());
    }
}
