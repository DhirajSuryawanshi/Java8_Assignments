package com.movieBooking;

import java.util.LinkedList;
import java.util.List;

import com.exceptions.InvalidSeatNumberException;
import com.exceptions.SeatNotAvailableException;
import com.exceptions.UnknownShowException;
import com.model.Show;

public class ShowManagerImpl implements ShowManager {
	public static volatile List<Show> shows;

	@Override
	public void populate(Show show) {
		shows.add(show);

	}

	@Override
	public void bookShow(List<Show> showList, String showName, String showTime, int noOfSeats)
			throws InvalidSeatNumberException, SeatNotAvailableException, UnknownShowException {
		boolean nameCheck = false;
		boolean timeCheck = false;
		boolean seatsCheck = false;
		for (Show show : shows) {
			if (show.getShowName().equalsIgnoreCase(showName)) {
				nameCheck = true;
				if (show.getShowTime().equals(showTime)) {
					timeCheck = true;
					if (show.getSeatsAvailable() >= noOfSeats) {
						show.setSeatsAvailable(show.getSeatsAvailable() - noOfSeats);
						seatsCheck = true;
						System.out.println("/n you have successfully booked " + show.getShowName() + " show.");
						System.out.println("Remaining seats available:" + show.getSeatsAvailable());
					}
				}
				break;
			}
		}
		if (!nameCheck) {
			throw new UnknownShowException("The movie show " + showName + " is not available for booking.");
		} else if (!timeCheck) {
			throw new UnknownShowException("The movie show " + showName + " is not available at the time " + showTime);
		} else if (!seatsCheck) {
			throw new SeatNotAvailableException(
					"All seats are already booked. The show is housefull, sorry for the inconvenience.");
		}
	}@SuppressWarnings({"serial","unused"})
	private static List<Show> populateShows(){
		return new LinkedList<>() {
			
		};
	}

}
