package org.zakariya.stickyheadersapp.custom;
import android.os.AsyncTask;

import com.example.core.Chapter;

import org.zakariya.stickyheadersapp.model.DemoModel;

import java.util.ArrayList;

public class LoadAssetsAsync extends AsyncTask<Void, Void, ArrayList<Chapter>> {

    String folder = null;
    private SectionsLoaded delegate;

    public LoadAssetsAsync(SectionsLoaded delegate, String folder) {
        this.folder = folder;
        this.delegate = delegate;
    }

    @Override
    protected ArrayList<Chapter> doInBackground(Void... voids) {

        // Object records = GetFromCache(this.folder);
        //  if(records == null){

        //get
     //   MainActivity.MainPageFragment.DemoModel[] records = AssetGetter.GetLessonsAssets((Context) this.delegate, this.folder);
        //add to cache
        //     CacheUtils.writeObjectFile(this.folder, records );
        // }
        return null;// records;
    }

    @Override
    protected void onPostExecute(ArrayList<Chapter> chapters) {
        delegate.onsectionsLoaded(chapters);

    }


}