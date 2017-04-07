package com.example.nhungnguyen.firstproject.API;

import com.example.nhungnguyen.firstproject.Interface.SOService;

/**
 * Copy right asiantech
 * Created by asiantech on 4/5/17.
 */

public class ApiUtils {
    private static final String BASE_URL="https://api.stackexchange.com/2.2/";
    public static SOService getSOService(){
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
