package org.zakariya.stickyheadersapp.ui;

import android.os.Bundle;
import android.view.View;

import com.google.gson.reflect.TypeToken;
import com.lifeofcoding.cacheutlislibrary.CacheUtils;

import org.zakariya.stickyheaders.StickyHeaderLayoutManager;
import org.zakariya.stickyheadersapp.adapters.SimpleDemoAdapter;
import org.zakariya.stickyheadersapp.api.AssetGetter;
import org.zakariya.stickyheadersapp.custom.AssetsLoaded;
import org.zakariya.stickyheadersapp.custom.cacheController;
import org.zakariya.stickyheadersapp.model.Lesson;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by shamyl on 6/7/16.
 */
public class CollapsingSectionsDemoActivity extends DemoActivity implements AssetsLoaded {

    SimpleDemoAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressBar.setVisibility(View.VISIBLE);
        String topLevelFolder = "CTCI";
        LinkedHashMap<String, ArrayList<Lesson>> sections = cacheController.GetFromCache(topLevelFolder);
        if(sections == null){
           sections = AssetGetter.GetLessonsAssets(this, topLevelFolder);
            cacheController.WriteToCache(topLevelFolder, sections);
        }

        adapter = new SimpleDemoAdapter(sections, false, true, false);
        recyclerView.setLayoutManager(new StickyHeaderLayoutManager());
        recyclerView.setAdapter(adapter);

        progressBar.setVisibility(View.GONE);
        //new LoadAssetsAsync(this, topLevelFolder).execute();
    }



    @Override
    public void onAssetsLoadingCompleted(LinkedHashMap<String, ArrayList<Lesson>> sections) {
        adapter.AddSections(sections);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }



}
