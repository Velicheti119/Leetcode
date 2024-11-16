class RandomizedSet(object):

    def __init__(self):
        self.map = {}
        self.arr = []

    def insert(self, val):
        if val in self.map:
            return False
        self.map[val] = len(self.arr)
        self.arr.append(val)
        return True
        

    def remove(self, val):
        if val not in self.map:
            return False
        temp_idx = self.map[val]
        last_val = self.arr[-1]
        self.arr[temp_idx] = last_val
        self.map[last_val] = temp_idx
        self.arr.pop()
        del self.map[val]
        return True        
        

    def getRandom(self):
        return self.arr[random.randint(0, len(self.arr) - 1)]


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
