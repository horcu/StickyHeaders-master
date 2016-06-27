package org.zakariya.stickyheadersapp.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.DrawableRes;

import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.core.Lesson;
import com.example.core.Section;

import org.zakariya.stickyheaders.SectioningAdapter;
import org.zakariya.stickyheadersapp.R;
import org.zakariya.stickyheadersapp.custom.constants;
import org.zakariya.stickyheadersapp.ui.CodeView;
import org.zakariya.stickyheadersapp.ui.PdfView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * SimpleDemoAdapter, just shows demo data
 */
public class SimpleDemoAdapter extends SectioningAdapter {

	static final String TAG = SimpleDemoAdapter.class.getSimpleName();
	static final boolean USE_DEBUG_APPEARANCE = false;



	public class ItemViewHolder extends SectioningAdapter.ItemViewHolder implements View.OnClickListener {
		TextView textView;
		TextView adapterPositionTextView;

		public ItemViewHolder(View itemView) {
			super(itemView);
			textView = (TextView) itemView.findViewById(R.id.textView);
			adapterPositionTextView = (TextView) itemView.findViewById(R.id.adapterPositionTextView);

			textView.setOnClickListener(this);
			if (!SimpleDemoAdapter.this.showAdapterPositions) {
				adapterPositionTextView.setVisibility(View.GONE);
			}
		}

		@Override
		public void onClick(View v) {
			int adapterPosition = getAdapterPosition();
			final int section = SimpleDemoAdapter.this.getSectionForAdapterPosition(adapterPosition);
			final int item = SimpleDemoAdapter.this.getPositionOfItemInSection(section, adapterPosition);

            Lesson lesson = GetLessonForSection(item, section);
			ArrayList<Section> sections = GetSectionsForSection(section);
			Intent intent = new Intent(v.getContext(), CodeView.class);

			intent.putExtra(constants.CODE, lesson.getSolution());
			intent.putExtra(constants.SECTIONS, sections);
			(v.getContext()).startActivity(intent);
        }
	}

    private Lesson GetLessonForSection(int itemIndex, int sectIndex) {

        Section section = sections.get(sectIndex);
        return section.getLessons().get(itemIndex);
    }

	private ArrayList<Section> GetSectionsForSection( int sectIndex) {

		Section section = sections.get(sectIndex);
		return section.getSections();
	}

    public class HeaderViewHolder extends SectioningAdapter.HeaderViewHolder implements View.OnClickListener {
		TextView textView;
		TextView adapterPositionTextView;
			ImageButton collapseButton;

		public HeaderViewHolder(View itemView) {
			super(itemView);
			textView = (TextView) itemView.findViewById(R.id.textView);
			adapterPositionTextView = (TextView) itemView.findViewById(R.id.adapterPositionTextView);

			collapseButton = (ImageButton) itemView.findViewById(R.id.collapseButton);
			collapseButton.setOnClickListener(this);

			if (!SimpleDemoAdapter.this.showCollapsingSectionControls) {
				collapseButton.setVisibility(View.GONE);
			}
            textView.setOnClickListener(new HeaderOpenPdfClickListener());
		}

		void updateSectionCollapseToggle(boolean sectionIsCollapsed) {
			@DrawableRes int id = sectionIsCollapsed
					? R.drawable.ic_expand_more_black_24dp
					: R.drawable.ic_expand_less_black_24dp;

			collapseButton.setImageDrawable(ContextCompat.getDrawable(collapseButton.getContext(), id));
		}

		@Override
		public void onClick(View v) {
			int position = getAdapterPosition();
			final int section = SimpleDemoAdapter.this.getSectionForAdapterPosition(position);
			if (v == collapseButton) {
				SimpleDemoAdapter.this.onToggleSectionCollapse(section);
				updateSectionCollapseToggle(SimpleDemoAdapter.this.isSectionCollapsed(section));
			}
		}
	}

	public class FooterViewHolder extends SectioningAdapter.FooterViewHolder {
		TextView textView;
		TextView adapterPositionTextView;

		public FooterViewHolder(View itemView) {
			super(itemView);
			textView = (TextView) itemView.findViewById(R.id.textView);
			adapterPositionTextView = (TextView) itemView.findViewById(R.id.adapterPositionTextView);

			if (!SimpleDemoAdapter.this.showAdapterPositions) {
				adapterPositionTextView.setVisibility(View.GONE);
			}
		}
	}


	ArrayList<Section> sections = new ArrayList<>();
	boolean showModificationControls;
	boolean showCollapsingSectionControls;
	boolean showAdapterPositions;

	public SimpleDemoAdapter(LinkedHashMap<String, ArrayList<Lesson>> sectionInfo, boolean showModificationControls, boolean showCollapsingSectionControls, boolean showAdapterPositions) {
		this.showModificationControls = showModificationControls;
		this.showCollapsingSectionControls = showCollapsingSectionControls;
		this.showAdapterPositions = showAdapterPositions;

         AddSections(sectionInfo);
	}

	public SimpleDemoAdapter(LinkedHashMap<String, ArrayList<Section>> sections) {
		AddSections(sections, true);
	}

    public void AddSections(LinkedHashMap<String, ArrayList<Lesson>> sectionInfo) {
        sections = null;
        sections = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(sectionInfo.keySet());
        ArrayList<List<Lesson>> values = new ArrayList<List<Lesson>>(sectionInfo.values());

        for (int i = 0; i < sectionInfo.keySet().size(); i++) {
            String currentKey = keys.get(i);

            Section section = new Section();
            section.setHeader(currentKey);
            section.setFooter("End of : " + currentKey);
            section.setIndex(i);
            section.getLessons().addAll(values.get(i));
			appendSection(i, section);
		}
    }

	public void AddSections(LinkedHashMap<String, ArrayList<Section>> sectionInfo, boolean hasChildren) {
		sections = null;
		sections = new ArrayList<>();
		ArrayList<String> keys = new ArrayList<>(sectionInfo.keySet());
		ArrayList<List<Section>> values = new ArrayList<List<Section>>(sectionInfo.values());

		for (int i = 0; i < sectionInfo.keySet().size(); i++) {
			String currentKey = keys.get(i);

			Section section = new Section();
			section.setHeader(currentKey);
			section.setFooter("End of : " + currentKey);
			section.setIndex(i);
			section.getSections().addAll(values.get(i));
			appendSection(i, section);
		}
	}

    void appendSection(int index,Section section) {
		sections.add(index, section);
	}

	void onToggleSectionCollapse(int sectionIndex) {
		Log.d(TAG, "onToggleSectionCollapse() called with: " + "sectionIndex = [" + sectionIndex + "]");
		setSectionIsCollapsed(sectionIndex, !isSectionCollapsed(sectionIndex));
	}

	void onDeleteSection(int sectionIndex) {
		Log.d(TAG, "onDeleteSection() called with: " + "sectionIndex = [" + sectionIndex + "]");
		sections.remove(sectionIndex);
		notifySectionRemoved(sectionIndex);
	}

	void onCloneSection(int sectionIndex) {
//		Log.d(TAG, "onCloneSection() called with: " + "sectionIndex = [" + sectionIndex + "]");
//
//		Section s = sections.get(sectionIndex);
//		Section d = s.duplicate();
//		sections.add(sectionIndex + 1, d);
//		notifySectionInserted(sectionIndex + 1);
	}

	void onDeleteItem(int sectionIndex, int itemIndex) {
		Log.d(TAG, "onDeleteItem() called with: " + "sectionIndex = [" + sectionIndex + "], itemIndex = [" + itemIndex + "]");
		Section s = sections.get(sectionIndex);
		s.getLessons().remove(itemIndex);
		notifySectionItemRemoved(sectionIndex, itemIndex);
	}

	void onCloneItem(int sectionIndex, int itemIndex) {
//		Log.d(TAG, "onCloneItem() called with: " + "sectionIndex = [" + sectionIndex + "], itemIndex = [" + itemIndex + "]");
//		Section s = sections.get(sectionIndex);
//		s.duplicateItem(itemIndex);
//		notifySectionItemInserted(sectionIndex, itemIndex + 1);
	}

	@Override
	public int getNumberOfSections() {
		return sections.size();
	}

	@Override
	public int getNumberOfItemsInSection(int sectionIndex) {
		return sections.get(sectionIndex).getLessons().size();
	}

	@Override
	public boolean doesSectionHaveHeader(int sectionIndex) {
		return !TextUtils.isEmpty(sections.get(sectionIndex).getHeader());
	}

	@Override
	public boolean doesSectionHaveFooter(int sectionIndex) {
		return !TextUtils.isEmpty(sections.get(sectionIndex).getFooter());
	}

	@Override
	public ItemViewHolder onCreateItemViewHolder(ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View v = inflater.inflate(R.layout.list_item_simple_item, parent, false);
		return new ItemViewHolder(v);
	}

	@Override
	public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View v = inflater.inflate(R.layout.list_item_simple_header, parent, false);
		return new HeaderViewHolder(v);
	}

	@Override
	public FooterViewHolder onCreateFooterViewHolder(ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View v = inflater.inflate(R.layout.list_item_simple_footer, parent, false);
		return new FooterViewHolder(v);
	}

	@SuppressLint("SetTextI18n")
	@Override
	public void onBindItemViewHolder(SectioningAdapter.ItemViewHolder viewHolder, int sectionIndex, int itemIndex) {
		Section s = sections.get(sectionIndex);
		ItemViewHolder ivh = (ItemViewHolder) viewHolder;
		ivh.textView.setText(s.getLessons().get(itemIndex).getTopic());
		ivh.adapterPositionTextView.setText(Integer.toString(getAdapterPositionForSectionItem(sectionIndex, itemIndex)));
	}

	@SuppressLint("SetTextI18n")
	@Override
	public void onBindHeaderViewHolder(SectioningAdapter.HeaderViewHolder viewHolder, int sectionIndex) {
		Section s = sections.get(sectionIndex);
		HeaderViewHolder hvh = (HeaderViewHolder) viewHolder;
		hvh.adapterPositionTextView.setText(Integer.toString(getAdapterPositionForSectionHeader(sectionIndex)));

		if (USE_DEBUG_APPEARANCE) {
			hvh.textView.setText(pad(sectionIndex * 2) + s.getHeader());
			viewHolder.itemView.setBackgroundColor(0x55FF9999);
		} else {
			hvh.textView.setText(s.getHeader());
		}

		hvh.updateSectionCollapseToggle(isSectionCollapsed(sectionIndex));
	}

	@Override
	public void onBindGhostHeaderViewHolder(SectioningAdapter.GhostHeaderViewHolder viewHolder, int sectionIndex) {
		if (USE_DEBUG_APPEARANCE) {
			viewHolder.itemView.setBackgroundColor(0xFF9999FF);
		}
	}

	@SuppressLint("SetTextI18n")
	@Override
	public void onBindFooterViewHolder(SectioningAdapter.FooterViewHolder viewHolder, int sectionIndex) {
		Section s = sections.get(sectionIndex);
		FooterViewHolder fvh = (FooterViewHolder) viewHolder;
		fvh.textView.setText(s.getFooter());
		fvh.adapterPositionTextView.setText(Integer.toString(getAdapterPositionForSectionFooter(sectionIndex)));
	}

	private String pad(int spaces) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < spaces; i++) {
			b.append(' ');
		}
		return b.toString();
	}

    private class HeaderOpenPdfClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), PdfView.class);
            //intent.putExtra(constants.PAGE, view.getTag());
            (view.getContext()).startActivity(intent);
        }
    }
}
