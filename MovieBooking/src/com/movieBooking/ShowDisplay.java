package com.movieBooking;

import java.util.List;

import com.model.Show;

public class ShowDisplay implements ShowDetails {
	@Override
	public List<Show> displayAllShows() {
		return ShowManagerImpl.shows;
	}
}
