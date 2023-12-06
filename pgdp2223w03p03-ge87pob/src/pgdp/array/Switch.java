package pgdp.array;

import javax.imageio.stream.ImageInputStream;

public class Switch {

	public static String locationOfLectureHall(String hall) {
		// TODO
		return switch(hall) {
			case "MI HS 2", "Interims I 1" -> "Informatik";
			case "MW0001", "MW2001" -> "Maschinenwesen";
			case "Interims II 2" -> "Chemie";
			case "Carl-von-Linde", "N1190" -> "Innenstadt";
			default -> "Unbekannter Hörsaal";
		};
	}

	public static int inclusions(char c) {
		return switch (c) {
			case 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
					'L', 'M', 'N', 'S', 'T', 'U', 'V', 'W',
					'X', 'Y', 'Z',
					'c', 'f', 'h', 'i', 'j', 'k', 'l', 'm',
					'n', 'r', 's', 't', 'u', 'v', 'w', 'x',
					'y', 'z',
					'1', '2', '3', '5', '7'
					-> 0;
			case 'A', 'D', 'O', 'P', 'Q', 'R',
					'a', 'b', 'd', 'e', 'o', 'p', 'q',
					'4', '6', '9'
					-> 1;
			case 'B', 'g', '0', '8' -> 2;
			default -> -1;
		};
	}

	public static String formatDate(int day, int month, int weekday) {
		boolean wellDefined = true;
		String monthName = switch(month) {
			case 1 -> "Januar";
			case 2 -> "Februar";
			case 3 -> "März";
			case 4 -> "April";
			case 5 -> "Mai";
			case 6 -> "Juni";
			case 7 -> "Juli";
			case 8 -> "August";
			case 9 -> "September";
			case 10 -> "Oktober";
			case 11 -> "November";
			case 12 -> "Dezember";
			default -> {
				wellDefined = false;
				yield "";
			}
		};

		String weekdayName = switch(weekday) {
			case 1 -> "Montag";
			case 2 -> "Dienstag";
			case 3 -> "Mittwoch";
			case 4 -> "Donnerstag";
			case 5 -> "Freitag";
			case 6 -> "Samstag";
			case 7 -> "Sonntag";
			default -> {
				wellDefined = false;
				yield "";
			}
		};

		if(!wellDefined) {
			return "Undefiniertes Datum";
		}

		return weekdayName + ", den " + day + ". " + monthName;
	}

	public static int daysInFebruary(int year) {
		return switch(year % 4) {
			case 0 -> switch(year % 100) {
				case 0 -> switch(year % 400) {
					case 0 -> 29;
					default -> 28;
				};
				default -> 29;
			};
			default -> 28;
		};
	}

	public static int daysLeftInYearAfter(int day, int month, int year) {
		// TODO
		int days = 0;
		switch(month) {
			case 1: days += 31;
			case 2: days += daysInFebruary(year);
			case 3: days += 31;
			case 4: days += 30;
			case 5: days += 31;
			case 6: days += 30;
			case 7: days += 31;
			case 8: days += 31;
			case 9: days += 30;
			case 10: days += 31;
			case 11: days += 30;
			case 12: days += 31 - day; break;
			default:
				days = -1;
		}
		return days;

	}

	public static void main(String[] args) {
		System.out.print(daysLeftInYearAfter(02,  11, 2022 ));
	}

}
