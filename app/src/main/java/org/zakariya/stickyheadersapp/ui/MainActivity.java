package org.zakariya.stickyheadersapp.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.zakariya.stickyheaders.SectioningAdapter;
import org.zakariya.stickyheaders.StickyHeaderLayoutManager;
import org.zakariya.stickyheadersapp.R;
import org.zakariya.stickyheadersapp.adapters.DemoAdapter;
import org.zakariya.stickyheadersapp.api.ItemClickListener;
import org.zakariya.stickyheadersapp.model.DemoModel;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	TabLayout tabs;
	ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		toolbar.setTitle("Cracking the Code Interview");
		toolbar.setSubtitle("by Gayle Laakmann McDowell");
        toolbar.setTitleTextColor(Color.parseColor("#444444"));
        toolbar.setSubtitleTextColor(Color.parseColor("#666666"));
		tabs = (TabLayout) findViewById(R.id.tabs);
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		viewPager.setAdapter(new MainActivityViewsPager(getSupportFragmentManager()));
		tabs.setupWithViewPager(viewPager);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	class MainActivityViewsPager extends FragmentPagerAdapter {

		public MainActivityViewsPager(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
				case 0:
					return new MainPageFragment();
				case 1:
					return new AboutPageFragment();
				default:
					return null;
			}
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
				case 0:
					return getString(R.string.activity_main_pager_main);
				case 1:
					return getString(R.string.activity_main_pager_about);
				default:
					return null;
			}
		}

		@Override
		public int getCount() {
			return 2;
		}
	}

	public static class MainPageFragment extends Fragment {

		private static final String TAG = MainPageFragment.class.getSimpleName();
		private static final String SCROLL_STATE = "MainPageFragment.SCROLL_STATE";

		RecyclerView recyclerView;

		@Nullable
		@Override
		public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.fragment_main, container, false);
			recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
			setupDemoRecyclerView();

			if (savedInstanceState != null) {
				recyclerView.getLayoutManager().onRestoreInstanceState(savedInstanceState.getParcelable(SCROLL_STATE));
			}

			return view;
		}

		@Override
		public void onSaveInstanceState(Bundle outState) {
			outState.putParcelable(SCROLL_STATE, recyclerView.getLayoutManager().onSaveInstanceState());
			super.onSaveInstanceState(outState);
		}

		void setupDemoRecyclerView() {
			DemoModel[] demos = {
					new DemoModel(getString(R.string.demo_list_item_addressbook_title),
							getString(R.string.demo_list_item_addressbook_description),
							AddressBookDemoActivity.class),
//
//					new DemoModel(getString(R.string.demo_list_item_callbacks_title),
//							getString(R.string.demo_list_item_callbacks_description),
//							HeaderCallbacksDemoActivity.class),

					new DemoModel(getString(R.string.demo_list_item_collapsing_headers_title),
							getString(R.string.demo_list_item_collapsing_headers_description),
							CollapsingSectionsDemoActivity.class)

//					new DemoModel(getString(R.string.demo_list_item_stress_test_title),
//							getString(R.string.demo_list_item_stress_test_description),
//							StressTestDemoActivity.class),

//					new DemoModel(getString(R.string.demo_list_item_sections_title),
//							getString(R.string.demo_list_item_sections_description),
//							SectioningAdapterDemoActivity.class)
			};

			recyclerView.setAdapter(new DemoAdapter(getContext(), demos, new ItemClickListener() {
				@Override
				public void onItemClick(DemoModel demoModel) {
					startActivity(new Intent(getActivity(), demoModel.getActivityClass()));
				}
			}));
			recyclerView.setLayoutManager(new StickyHeaderLayoutManager());
		}







	}

	public static class AboutPageFragment extends Fragment {
		@Nullable
		@Override
		public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
			return inflater.inflate(R.layout.fragment_about, container, false);
		}
	}
}
