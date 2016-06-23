package org.zakariya.stickyheadersapp.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.lifeofcoding.cacheutlislibrary.CacheUtils;

import org.zakariya.stickyheaders.StickyHeaderLayoutManager;
import org.zakariya.stickyheadersapp.adapters.SimpleDemoAdapter;
import org.zakariya.stickyheadersapp.api.AssetGetter;
import org.zakariya.stickyheadersapp.model.Lesson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by shamyl on 6/7/16.
 */
public class CollapsingSectionsDemoActivity extends DemoActivity {

    SimpleDemoAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String topLevelFolder = "CTCI";


        adapter = new SimpleDemoAdapter(new LinkedHashMap<String, ArrayList<Lesson>>(), false, true, false);

        recyclerView.setLayoutManager(new StickyHeaderLayoutManager());
        recyclerView.setAdapter(adapter);

		new LoadAssetsAsync(this, topLevelFolder).execute();
	}

	class LoadAssetsAsync extends AsyncTask<Void, Void, LinkedHashMap<String, ArrayList<Lesson>>> {

        String folder = null;
        Context ctx = null;
        public LoadAssetsAsync(Context ctx, String folder){
            this.folder = folder;
            this.ctx = ctx;
        }

		@Override
		protected LinkedHashMap<String, ArrayList<Lesson>> doInBackground(Void... voids) {

            //show the spinner

          // Object records = GetFromCache(this.folder);
          //  if(records == null){

                //get
            LinkedHashMap<String, ArrayList<Lesson>> records = AssetGetter.GetLessonsAssets(this.ctx, this.folder);
                //add to cache
           //     CacheUtils.writeObjectFile(this.folder, records );
           // }
            return  records;
		}

		@Override
		protected void onPostExecute(LinkedHashMap<String, ArrayList<Lesson>> sectionInfo) {

        adapter = new SimpleDemoAdapter(new LinkedHashMap<String, ArrayList<Lesson>>(), false, true, false);
        recyclerView.setAdapter(adapter);
        adapter.notifyAllSectionsDataSetChanged();
		}
	}

    private Object GetFromCache(String folder) {
     return CacheUtils.readDataMapFile(folder);
    }
}
