class UndergroundSystem {

    // Store check-in data: id -> (stationName, time)
    private Map<Integer, CheckInInfo> checkInMap;

    // Store journey stats: startStation#endStation -> (totalTime, tripCount)
    private Map<String, JourneyInfo> journeyMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        journeyMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String endStation, int t) {
        CheckInInfo checkIn = checkInMap.remove(id);
        String routeKey = checkIn.stationName + "#" + endStation;
        int travelTime = t - checkIn.time;

        JourneyInfo journey = journeyMap.getOrDefault(routeKey, new JourneyInfo());
        journey.totalTime += travelTime;
        journey.tripCount++;
        journeyMap.put(routeKey, journey);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "#" + endStation;
        JourneyInfo journey = journeyMap.get(routeKey);
        return (double) journey.totalTime / journey.tripCount;
    }

    private static class CheckInInfo {
        String stationName;
        int time;

        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private static class JourneyInfo {
        int totalTime = 0;
        int tripCount = 0;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */