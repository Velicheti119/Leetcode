class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        sortedintervals = sorted(intervals, key=lambda x:x[0])
        mergedintervals = []
        for interval in sortedintervals:
            added = False
            if not mergedintervals:
                mergedintervals.append(interval)
                continue
            for i in range(len(mergedintervals)):
                # Check for conflict
                merged = mergedintervals[i]
                if interval[0] <= merged[1]:
                    newinterval = [min(interval[0],merged[0]), max(interval[1], merged[1])]
                    mergedintervals[i] = newinterval
                    added = True
                    break
            if not added:
                mergedintervals.append(interval)
        return mergedintervals
    
