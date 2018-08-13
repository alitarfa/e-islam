package eslami.dev.info.e_islami;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import eslami.dev.info.e_islami.Models.ApiModel;
import eslami.dev.info.e_islami.Models.FileModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class detailsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    public AdapterDetails adapterDetails;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        progressBar=findViewById(R.id.progressBar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        /**
         * for recycvle view
         */

        recyclerView=findViewById(R.id.recycle_details);
        adapterDetails=new AdapterDetails(this);
        recyclerView.setAdapter(adapterDetails);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        /**
         * get the param of intent and call the method to get the information from the Api service
         */

        String id =getIntent().getExtras().getString("identifier");
        getListItemFromService(id);

    }

    // TODO: 7/29/18 add the vector for kitikat


    public void getListItemFromService(String identifier){
        Log.e("identifier from ali",identifier.trim());

        ApiArchiveService service = RetrofitClientInstance.getRetrofitInstance().create(ApiArchiveService.class);
        Call<ApiModel> call = service.getPlayListById(identifier);

        call.enqueue(new Callback<ApiModel>() {
            @Override
            public void onResponse(Call<ApiModel>  call, Response<ApiModel> responses) {

                ArrayList<FileModel> fileModels=new ArrayList<>();
                fileModels= (ArrayList<FileModel>) responses.body().getFiles();
                Toast.makeText(detailsActivity.this, ""+responses.body().getFiles().size(), Toast.LENGTH_SHORT).show();

                /**
                 * filter the item of List get it from the Api
                 */
                String dir= responses.body().getDir();
                adapterDetails.setList(Utils.filterList((ArrayList<FileModel>) responses.body().getFiles()),dir);
                adapterDetails.notifyDataSetChanged();
                progressBar.setVisibility(View.INVISIBLE);


            }

            @Override
            public void onFailure(Call<ApiModel> call, Throwable t) {

                Toast.makeText(detailsActivity.this, ""+t.getCause().toString(), Toast.LENGTH_SHORT).show();

                Log.e("error",t.getMessage());
            }
        });


    }
}
