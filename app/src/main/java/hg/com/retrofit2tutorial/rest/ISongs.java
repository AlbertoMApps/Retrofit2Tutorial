package hg.com.retrofit2tutorial.rest;

import hg.com.retrofit2tutorial.model.Song;
import retrofit.Call;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Hurman on 17/02/2016.
 */
public interface ISongs {

    @GET("/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50")
    Call<Song> getSongs();


}
