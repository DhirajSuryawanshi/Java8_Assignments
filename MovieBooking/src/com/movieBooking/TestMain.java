package com.movieBooking;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.model.Show;

public class TestMain {
	public static void main(String[] args) {
		List<Show> list = ShowManagerImpl.shows;
		ShowManagerImpl showManagerImpl = new ShowManagerImpl();
		Scanner scanner = new Scanner("C:\\Users\\DhirajS4\\Downloads\\JavaTask2\\show.txt");
		while (scanner.hasNextLine()) {
			String str = scanner.nextLine();
			String[] split = str.split(",");
			String showName = split[0];
			String showTime = split[1];
			String seatsAvailable = split[2];

			showManagerImpl.populate(new Show(showName, showTime, Integer.parseInt(seatsAvailable)));
		}
		list = new ShowDisplay().displayAllShows();
		System.out.println("Available show for booking: \n");
		list.stream().sorted(Comparator.comparing(Show::getShowName)).forEach(x -> System.out.println(x));
		try {
			showManagerImpl.bookShow(list, "Sahi re Sahi", "03:30", 3);
			list = ShowManagerImpl.shows;
		} catch (Exception e) {
			e.printStackTrace();
		}
		;
		scanner.close();
	}
}
