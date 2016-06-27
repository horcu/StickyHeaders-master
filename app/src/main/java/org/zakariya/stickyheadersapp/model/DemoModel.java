package org.zakariya.stickyheadersapp.model;

public class DemoModel {
	        private String title;
			private String description;
			private Class activityClass;

			public DemoModel(String title, String description, Class activityClass) {
				this.title = title;
				this.description = description;
				this.activityClass = activityClass;
			}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Class getActivityClass() {
		return activityClass;
	}

	public void setActivityClass(Class activityClass) {
		this.activityClass = activityClass;
	}
}