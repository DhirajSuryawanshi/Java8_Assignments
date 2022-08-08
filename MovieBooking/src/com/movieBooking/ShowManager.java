package com.movieBooking;

import java.util.List;

import com.exceptions.InvalidSeatNumberException;
import com.exceptions.SeatNotAvailableException;
import com.exceptions.UnknownShowException;
import com.model.Show;

public interface ShowManager {
	public void populate(Show show);

	public void bookShow(List<Show> showList, String showName, String showTime, int noOfSeats)
			throws InvalidSeatNumberException, SeatNotAvailableException, UnknownShowException;
}
