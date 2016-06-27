package org.zakariya.stickyheadersapp.custom;

import android.content.Context;
import android.os.AsyncTask;

import com.example.core.Lesson;

import org.zakariya.stickyheadersapp.api.AssetGetter;

import java.util.ArrayList;
import java.util.LinkedHashMap;


public class LoadAssetsAsync extends AsyncTask<Void, Void, LinkedHashMap<String, ArrayList<Lesson>>> {

    String folder = null;
    private AssetsLoaded delegate;

    public LoadAssetsAsync(AssetsLoaded delegate, String folder) {
        this.folder = folder;
        this.delegate = delegate;
    }

    @Override
    protected LinkedHashMap<String, ArrayList<Lesson>> doInBackground(Void... voids) {

        // Object records = GetFromCache(this.folder);
        //  if(records == null){

        //get
        LinkedHashMap<String, ArrayList<Lesson>> records = AssetGetter.GetLessonsAssets((Context) this.delegate, this.folder);
        //add to cache
        //     CacheUtils.writeObjectFile(this.folder, records );
        // }
        return records;
    }

    @Override
    protected void onPostExecute(LinkedHashMap<String, ArrayList<Lesson>> sectionInfo) {
        delegate.onAssetsLoadingCompleted(sectionInfo);

    }


}