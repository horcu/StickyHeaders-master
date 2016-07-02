package org.zakariya.stickyheadersapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.core.Section;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import org.zakariya.stickyheaders.StickyHeaderLayoutManager;
import org.zakariya.stickyheadersapp.R;
import org.zakariya.stickyheadersapp.adapters.SimpleDemoAdapter;
import org.zakariya.stickyheadersapp.api.AssetGetter;
import org.zakariya.stickyheadersapp.custom.SectionsLoaded;
import org.zakariya.stickyheadersapp.custom.constants;
import java.util.ArrayList;

/**
 * Created by shamyl on 6/7/16.
 */
public class CollapsingSectionsDemoActivity extends DemoActivity implements SectionsLoaded{

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
       // AssetGetter.GetLessons(topLevelFolder);
      //      cacheController.WriteToCache(topLevelFolder, sections);
    //    }

        ArrayList<Section> test = new ArrayList<>();

        Section sect = new Section(0,2,1,false,false,0,0,"test","tester");
        Section sect2 = new Section(1,2,1,false,false,0,0,"test","tester");
        Section sect3 = new Section(2,2,1,false,false,0,0,"test","tester");
        Section sect4 = new Section(3,2,1,false, false,0,0,"test","tester");
        Section sect5 = new Section(4,2,1,false,false,0,0,"test","tester");
        Section sect6 = new Section(5,2,1,false,false,0,0,"test","tester");
        test.add(sect);
        test.add(sect2);
        test.add(sect3);
        test.add(sect4);
        test.add(sect5);
        test.add(sect6);

        adapter = new SimpleDemoAdapter(test,false,true,false);
        recyclerView.setLayoutManager(new StickyHeaderLayoutManager());
        recyclerView.setAdapter(adapter);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        Query allChapters = mDatabase.child("/directory/Cracking the Code/" + topLevelFolder);
        allChapters.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ArrayList<Section> Book = null;
                Object object = null;
                try {
                    object =  dataSnapshot.getValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Gson gson = new Gson();
                String json = gson.toJson(object);
                Book = AssetGetter.BuildSectionAndLessonsFromJson(json);

                //new data to the subscriber
                adapter = new SimpleDemoAdapter(Book,false,true,false);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                if(progressBar.getVisibility() != View.GONE)
                    progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "failed to load sections", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onsectionsLoaded(final ArrayList<Section> chapters) {
//
//                Log.d("UI thread", "I am the UI thread");
//                adapter.AddSections(chapters);
//                recyclerView.setAdapter(adapter);
//                adapter.notifyDataSetChanged();
//                progressBar.setVisibility(View.GONE);
//                if(progressBar.getVisibility() != View.GONE)
//                    progressBar.setVisibility(View.GONE);
//
//            Toast.makeText(this, "returned list of " + chapters.size() + " products", Toast.LENGTH_LONG).show();
    }
}
