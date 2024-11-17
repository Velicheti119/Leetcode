class UndergroundSystem(object):

    def __init__(self):
        # map1 has <id, <stationName, t>> as the <k,v> pair
        self.map1 = {}
        # map2 has <<startStation, endStation>, <avgTime, count>> as <k,v> pair
        self.map2 = {}
        

    def checkIn(self, id, stationName, t):
        """
        :type id: int
        :type stationName: str
        :type t: int
        :rtype: None
        """
        self.map1[id] = [stationName, t]
        return

        

    def checkOut(self, id, stationName, t):
        """
        :type id: int
        :type stationName: str
        :type t: int
        :rtype: None
        """
        checkinDets = self.map1[id]
        stationPair = (checkinDets[0], stationName)
        if stationPair not in self.map2:
            self.map2[stationPair] = [(t - checkinDets[1]), 1]
            return
        prevResults = self.map2[stationPair]
        self.map2[stationPair] = [float((prevResults[0] * prevResults[1]) + (t - checkinDets[1])) / (prevResults[1] + 1), prevResults[1] + 1]
        return
        

    def getAverageTime(self, startStation, endStation):
        """
        :type startStation: str
        :type endStation: str
        :rtype: float
        """
        res = self.map2[(startStation, endStation)]
        return res[0]
        


# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)
