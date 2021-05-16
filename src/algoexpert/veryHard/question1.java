package algoexpert.veryHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class question1 {

    public static void main(String[] args) {
        ArrayList<List<Integer>> input = new ArrayList<List<Integer>>();
        input.add(Arrays.asList(1,3,10));
        input.add(Arrays.asList(2,5,15));
        input.add(Arrays.asList(5,7,6));
      //  mergeInterval(input).forEach(x -> System.out.println(x));
        System.out.println(mergeInterval(input));
    }

    // O(c1 + c2) time | O(c1 + c2) space - where c1 and c2 are the respective num
    // in calendar1 and calendar2
    public static Integer mergeInterval(
        List<List<Integer>> input) {
        List<Integer> mergedCalendar = new ArrayList<>();
        for(int i = 1; i < input.size(); i++ ) {
            for(int j = 0; j < i; j++)
            mergedCalendar.add(mergeCalendars(input.get(j), input.get(i)));
        }
        Collections.sort(mergedCalendar, Collections.reverseOrder());
        return mergedCalendar.get(0);
    }
    public static Integer mergeCalendars(List<Integer> first, List<Integer> second) {
        int sum = 0;
        if (first.get(1) < second.get(0)) {
            sum = first.get(2) + second.get(2);
        }
        return sum;
    }
    public static List<Meeting> flattenCalendar(List<Meeting> calendar) {
        List<Meeting> flattened = new ArrayList<Meeting>();
        flattened.add(calendar.get(0));
        for (int i = 1; i < calendar.size(); i++) {
            Meeting currentMeeting = calendar.get(i);
            Meeting previousMeeting = flattened.get(flattened.size() - 1);
            if (previousMeeting.end >= currentMeeting.start) {
                Meeting newPreviousMeeting =
                        new Meeting(previousMeeting.start, Math.max(previousMeeting.end, currentMeeting.end));
                flattened.set(flattened.size() - 1, newPreviousMeeting);
            } else {
                flattened.add(currentMeeting);
            }
        }
        return flattened;
    }
    public static List<StringMeeting> getMatchingAvailabilities(
            List<Meeting> calendar, int meetingDuration) {
        List<Meeting> matchingAvailabilities = new ArrayList<Meeting>();
        for (int i = 1; i < calendar.size(); i++) {
            int start = calendar.get(i - 1).end;
            int end = calendar.get(i).start;
            int availabilityDuration = end - start;
            if (availabilityDuration >= meetingDuration) {
                matchingAvailabilities.add(new Meeting(start, end));
            }
        }
        List<StringMeeting> matchingAvailabilitiesInHours = new ArrayList<StringMeeting>();
        for (int i = 0; i < matchingAvailabilities.size(); i++) {
            matchingAvailabilitiesInHours.add(
                    new StringMeeting(
                            minutesToTime(matchingAvailabilities.get(i).start),
                            minutesToTime(matchingAvailabilities.get(i).end)));
        }
        return matchingAvailabilitiesInHours;
    }
    public static int timeToMinutes(String time) {
        int delimiterPos = time.indexOf(":");
        int hours = Integer.parseInt(time.substring(0, delimiterPos));
        int minutes = Integer.parseInt(time.substring(delimiterPos + 1, time.length()));
        return hours * 60 + minutes;
    }
    public static String minutesToTime(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        String hoursString = Integer.toString(hours);
        String minutesString = mins < 10 ? "0" + Integer.toString(mins) : Integer.toString(mins);
        return hoursString + ":" + minutesString;
    }
    static class StringMeeting {
        public String start;
        public String end;
        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
    static class Meeting {
        public int start;
        public int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}