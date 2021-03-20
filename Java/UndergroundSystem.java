import java.util.*;

class UndergroundSystem {
    Map<Integer, Integer> checkInTimeMap;
    Map<Integer, String> checkInStationMap;
    Map<String, List<Integer>> dict;

    public UndergroundSystem() {
        checkInTimeMap = new HashMap<>();
        checkInStationMap = new HashMap<>();
        dict = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        if (!checkInTimeMap.containsKey(id)) {
            checkInTimeMap.put(id, t);
            checkInStationMap.put(id, stationName);
        } else {
            checkInTimeMap.remove(id);
            checkInStationMap.remove(id);
        }
    }
    
    public void checkOut(int id, String stationName, int t) {
        if (checkInTimeMap.containsKey(id)) {
            int cost = t - checkInTimeMap.get(id);
            String checkInStation = checkInStationMap.get(id);
            checkInTimeMap.remove(id);
            checkInStationMap.remove(id);

            String key = new String(checkInStation + ":" + stationName);
            if (!dict.containsKey(key)) {
                dict.put(key, new ArrayList<>());
            }
            dict.get(key).add(cost);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        List<Integer> costs = dict.getOrDefault(startStation+":"+endStation, new ArrayList<>());
        return costs.stream().reduce((a, b) -> a+b).map(s -> ((double)s)/costs.size())
        .orElse(0d);
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));       // return 14.00000. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.00000. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.00000
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 12.00000
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */