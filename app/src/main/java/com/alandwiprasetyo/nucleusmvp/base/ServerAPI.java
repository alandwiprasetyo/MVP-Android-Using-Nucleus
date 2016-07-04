package com.alandwiprasetyo.nucleusmvp.base;

/**
 * Created by root on 04/07/16.
 */

import android.text.Html;

import com.google.gson.annotations.SerializedName;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface ServerAPI {

    String END_POINT = "http://api.icndb.com";

    class Item {
        @SerializedName("joke")
        public String text;

        @Override
        public String toString() {
            return Html.fromHtml(text).toString();
        }
    }

    class Response {
        @SerializedName("value")
        public Item[] items;
    }

    @GET("/jokes/random/10")
    Observable<Response> getItems(@Query("firstName") String firstName, @Query("lastName") String lastName);
}
