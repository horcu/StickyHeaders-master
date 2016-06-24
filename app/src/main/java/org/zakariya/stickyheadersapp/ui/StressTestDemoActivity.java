package org.zakariya.stickyheadersapp.ui;

import android.os.Bundle;

import org.zakariya.stickyheaders.StickyHeaderLayoutManager;
import org.zakariya.stickyheadersapp.adapters.SimpleDemoAdapter;
import org.zakariya.stickyheadersapp.api.AssetGetter;
import org.zakariya.stickyheadersapp.custom.cacheController;
import org.zakariya.stickyheadersapp.model.Lesson;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by shamyl on 6/5/16.
 */
public class StressTestDemoActivity extends DemoActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		recyclerView.setLayoutManager(new StickyHeaderLayoutManager());

		String topLevelFolder = "CTCI";
        LinkedHashMap<String, ArrayList<Lesson>> sections = cacheController.GetFromCache(topLevelFolder);
        if(sections == null){
            sections = AssetGetter.GetLessonsAssets(this, topLevelFolder);
            cacheController.WriteToCache(topLevelFolder, sections);
        }
		recyclerView.setAdapter(new SimpleDemoAdapter(sections, false, false, false));
	}
}
