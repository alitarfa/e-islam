package eslami.dev.info.e_islami.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import eslami.dev.info.e_islami.AdapterGrideView;
import eslami.dev.info.e_islami.ApiArchiveService;
import eslami.dev.info.e_islami.Models.ApiGlobalModel;
import eslami.dev.info.e_islami.Models.MetaDataModel;
import eslami.dev.info.e_islami.Models.docModel;
import eslami.dev.info.e_islami.R;
import eslami.dev.info.e_islami.RetrofitClientInstance;
import eslami.dev.info.e_islami.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayListFragment extends Fragment {

    public RecyclerView recyclerView;
    public ProgressBar progressBar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_play_list,container,false);

        recyclerView=view.findViewById(R.id.recycle_play_list);
        final AdapterGrideView adapterGrideView=new AdapterGrideView(getContext());
        recyclerView.setAdapter(adapterGrideView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        progressBar=view.findViewById(R.id.progressBar2);


        ApiArchiveService service = RetrofitClientInstance.getRetrofitInstance().create(ApiArchiveService.class);
        Call<ApiGlobalModel> call = service.getObjectSound();

        call.enqueue(new Callback<ApiGlobalModel>() {
            @Override
            public void onResponse(Call< ApiGlobalModel>  call, Response< ApiGlobalModel> responses) {
                ArrayList<docModel> docModels=new ArrayList<>();
                docModels= (ArrayList<docModel>) responses.body().getResponse().getDocs();
                adapterGrideView.setList(docModels);
                adapterGrideView.notifyDataSetChanged();
                progressBar.setVisibility(View.INVISIBLE);
            }


            @Override
            public void onFailure(Call<ApiGlobalModel> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getContext(), "Problem Connection !", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }



}
