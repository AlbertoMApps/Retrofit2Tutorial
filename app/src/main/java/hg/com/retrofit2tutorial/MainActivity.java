package hg.com.retrofit2tutorial;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import hg.com.retrofit2tutorial.model.Song;
import hg.com.retrofit2tutorial.rest.ISongs;
import hg.com.retrofit2tutorial.rest.RestClient;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ProgressDialog dialog = ProgressDialog.show(this, "", "loading...");
        RestClient restClient = new RestClient();
        ISongs service = restClient.getClient();

        Call<Song> call = service.getSongs();
        call.enqueue(new Callback<Song>() {
            @Override
            public void onResponse(Response<Song> response) {
                dialog.dismiss();

                Log.d("MainActivity", "Status Code = " + response.code());
                Log.d("MainActivity", "response = " + new Gson().toJson(response.body()));

                Log.d("Artist name: ", response.body().getResults().get(0).getArtistName());
                Log.d("Artist name: ", response.body().getResults().get(1).getArtistName());

            }

            @Override
            public void onFailure(Throwable t) {

                dialog.dismiss();


            }
        });


    }
}
