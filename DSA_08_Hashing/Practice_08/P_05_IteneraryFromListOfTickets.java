package DSA_08_Hashing.Practice_08;

import java.util.HashMap;
import java.util.HashSet;

public class P_05_IteneraryFromListOfTickets {

    static String itineraryStart(HashMap<String, String> tickets) {
        HashSet<String> toSet = new HashSet<>();
        for (String from : tickets.keySet()) {
            toSet.add(tickets.get(from));
        }
        for (String from : tickets.keySet()) {
            if (!toSet.contains(from)) {
                return from;
            }
        }
        return null;
    }
    static void itineraryPrint(String start, HashMap<String, String> tickets) {
        String current = start;
        while (tickets.containsKey(current)) {
            System.out.print(current + " -> ");
            current = tickets.get(current);
        } System.out.println(current);
    }
    public static void main(String[] args) {
        // topological sort of graph

        // hashing and reverse hashmap
        // search start point
        
    }
}
