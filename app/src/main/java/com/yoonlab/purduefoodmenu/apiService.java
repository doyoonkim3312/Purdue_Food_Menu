package com.yoonlab.purduefoodmenu;

import com.yoonlab.purduefoodmenu.Models.Menu;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface apiService {

    @Headers({"Accept: application/xml"})
    @GET("menus/v2/locations/{location}/{date}")
    Call<Menu> getMenu(@Path("location") String location, @Path("date") String date);
}
