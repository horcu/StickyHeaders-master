package org.zakariya.stickyheadersapp.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.core.Chapter;
import com.example.core.Lesson;
import com.example.core.Section;

import org.zakariya.stickyheadersapp.adapters.SimpleDemoAdapter;
import org.zakariya.stickyheadersapp.api.AssetGetter;
import org.zakariya.stickyheadersapp.custom.cacheController;

import java.util.ArrayList;
import java.util.LinkedHashMap;


/**
 * Created by shamyl on 4/26/16.
 */
public class SectioningAdapterDemoActivity extends DemoActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		recyclerView.setLayoutManager(new LinearLayoutManager(this));

		String topLevelFolder = "CTCI";
        LinkedHashMap<String, ArrayList<Lesson>> sections = cacheController.GetFromCache(topLevelFolder);
        if(sections == null){
            sections = AssetGetter.GetLessonsAssets(this, topLevelFolder);
            cacheController.WriteToCache(topLevelFolder, sections);
        }
		recyclerView.setAdapter(new SimpleDemoAdapter(new ArrayList<Section>(), false, false, false));
	}
}
