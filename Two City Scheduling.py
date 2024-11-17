class Solution(object):
    def twoCitySchedCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        total_cost = 0
        costs.sort(key = lambda x: x[0] - x[1])
        num = len(costs)
        for i in range(num // 2):
            total_cost = total_cost + costs[i][0] + costs[num - i - 1][1]
        return total_cost
        
        
