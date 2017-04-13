package com.example.nhungnguyen.firstproject.Interface;

import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.sharedpreferences.DefaultRes;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Copy right asiantech
 * Created by asiantech on 4/12/17.
 */
@SharedPref(SharedPref.Scope.APPLICATION_DEFAULT)
public interface Mypre {
    @DefaultRes(R.string.username)
    String user();
    @DefaultRes(R.string.pass)
    String pass();
}
