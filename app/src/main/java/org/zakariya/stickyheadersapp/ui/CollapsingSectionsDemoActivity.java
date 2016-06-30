package org.zakariya.stickyheadersapp.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.core.Chapter;
import com.example.core.Lesson;
import com.google.firebase.database.DataSnapshot;
import com.google.gson.reflect.TypeToken;
import com.lifeofcoding.cacheutlislibrary.CacheUtils;

import org.zakariya.stickyheaders.StickyHeaderLayoutManager;
import org.zakariya.stickyheadersapp.R;
import org.zakariya.stickyheadersapp.adapters.SimpleDemoAdapter;
import org.zakariya.stickyheadersapp.api.AssetGetter;
import org.zakariya.stickyheadersapp.custom.SectionsLoaded;
import org.zakariya.stickyheadersapp.custom.constants;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by shamyl on 6/7/16.
 */
public class CollapsingSectionsDemoActivity extends DemoActivity implements SectionsLoaded {

    SimpleDemoAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String topLevelFolder = null;
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            topLevelFolder = (String) extras.get(constants.FOLDER);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(extras != null){
            topLevelFolder = (String) extras.get(constants.FOLDER);
        }
        if (toolbar != null) {
            toolbar.setTitle(topLevelFolder);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

        progressBar.setVisibility(View.VISIBLE);
   //     LinkedHashMap<String, ArrayList<Lesson>> sections = cacheController.GetFromCache(topLevelFolder);
      //  if(sections == null){
        AssetGetter.GetLessons(topLevelFolder);
      //      cacheController.WriteToCache(topLevelFolder, sections);
    //    }

        adapter = new SimpleDemoAdapter(new ArrayList<Chapter>(), false, true, false);
        recyclerView.setLayoutManager(new StickyHeaderLayoutManager());
        recyclerView.setAdapter(adapter);

        progressBar.setVisibility(View.GONE);

        AssetGetter.ListChapters(this, topLevelFolder);
    }


    @Override
    public void onsectionsLoaded(ArrayList<Chapter> chapters) {

        adapter.AddSections(chapters);
        adapter.notifyDataSetChanged();

        for (int i =0; i < chapters.size(); i++){
            Toast.makeText(this, chapters.get(i).getName(), Toast.LENGTH_LONG).show();
        }
    }
}
