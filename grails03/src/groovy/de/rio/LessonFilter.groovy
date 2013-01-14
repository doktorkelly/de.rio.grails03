package de.rio

import java.text.DateFormat;
import java.text.SimpleDateFormat

class LessonFilter {
	String courseId;
	String date;
	
	LessonFilter(Map params) {
		fromParams(params);
	}
	
	@Override
	String toString() {
		return "${courseId} | ${date}";
	}
	
	public void fromParams(Map params) {
		if (params?.courseId) {
			courseId = params.courseId;
		}
		if (params?.date) {
			date = params.date;
		}
	}
	
	public Map<String,Object> toParams() {
		Map<String,Object> params = new HashMap<String,Object>();
		if (courseId) {
			params.courseId = courseId;
		}
		if (date) {
			params.date = date;
		}
		return params;
	}
	
	static boolean hasFilter(Map params) {
		if (params?.courseId || params?.date) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
