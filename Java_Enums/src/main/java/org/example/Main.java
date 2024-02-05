package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Weekday day = Weekday.SUNDAY;

//        System.out.println(day.name());

//        System.out.println(day.isWeekend());

//        System.out.println(Weekday.isWeekend(Weekday.SUNDAY));

//        for (Weekday day : Weekday.values()) {
//            System.out.println(String.format("Day is %s", day.name()));
//            System.out.println(String.format("Day's ordinal number is: %d", day.ordinal()));
//        }

        // use static utility method to check a bulk of values to be a weekend day or not
//        List<Boolean> daysAreWeekend = Weekday.areWeekendDays(Weekday.SATURDAY, Weekday.MONDAY, Weekday.THURSDAY);
//
//        for (boolean isWeekendDay : daysAreWeekend) {
//            System.out.println(isWeekendDay);
//        }
//
//        System.out.println(Util.joinStrings(", ","peter", "mary", "john"));
//
//        List<String> names = List.of("peter", "paul", "mary");
//        List<Integer> ages = List.of(12, 25, 33);
//        System.out.println(Util.joinNamesAndAges(ages, names));


        System.out.println(Elements.H.getLabel());
        System.out.println(Elements.HE.getLabel());

        // The constant name of some of the elements in the Elements Enum coming from a DB or whatever
        String elementNameFromTheDatabase = "F";

        /*
        * If an Element can't be found by the identifier an exception is thrown.
        * Make sure the program doesn't crash due to this.
        */
        try {
            // Access the enum constant by its identifier
            Elements foundElement = Elements.valueOf(elementNameFromTheDatabase);

            // Print the label-value assigned to the found enum constant
            System.out.println(foundElement.getLabel());

        } catch (IllegalArgumentException e) {
            System.err.printf("Element %s could not have been found!%n", elementNameFromTheDatabase);
        }

        String elementLabelFromSomewhere = "Oxygen";

        try {
            Elements element = Elements.valueOfLabel(elementLabelFromSomewhere);
            System.out.println(element.getLabel());
            System.out.println(element.getAtomicNumber());
            System.out.println(element.getAtomicWeight());

        } catch (IllegalArgumentException e) {
            System.err.printf("Element %s could not have been found!%n", elementLabelFromSomewhere);
        }
    }


    enum Weekday {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

        // Instance utility method for checking whether the instantiated value of Weekday is on the weekend
//        public boolean isWeekend() {
//            return this == SATURDAY || this == SUNDAY;
//        }

        // Static utility method for checking whether provided instance of Weekday is on the weekend
        public static boolean isWeekend(Weekday day) {
            return day == SATURDAY || day == SUNDAY;
        }

        /**
         * Static utility method for checking a bulk of Weekday values to be a weekend day or not
         * @param days Varargs for an optional bulk of Weekdays
         * @return a list of boolean values telling if it's a weekend day or not in the according order
         */
        public static List<Boolean> areWeekendDays(Weekday... days) {
            // loop through all the days values and check if it's a weekend day
            // and create a new stream out of the results
            // and return it as a List of Boolean values
            return Arrays.stream(days).map(Weekday::isWeekend).toList();
        }

    }


    class Util {
        public static String joinStrings(String delim, String... strings) {
            return String.join(delim, strings);
        }

        public static String joinNamesAndAges(List<Integer> ages, List<String> names) {
            // throw if the both list sizes differ from each other
            if (ages.size() != names.size()) throw new IllegalArgumentException("The lists need to be the same length");

//            StringBuilder sb = new StringBuilder();
//
//            for (int index = 0; index < names.size(); index++) {
//                String nameAndAge = String.format("%s(%d)", names.get(index), ages.get(index));
//
//                sb.append(nameAndAge);
//            }
//
//            // TODO find a way to separate the strings
//            return sb.toString();

            List<String> namesAndAges = new ArrayList<>();
            for (int index = 0; index < names.size(); index++) {
                String nameAndAge = String.format("%s(%d)", names.get(index), ages.get(index));

                namesAndAges.add(nameAndAge);
            }

            return String.join(", ", namesAndAges);
        }
    }
}