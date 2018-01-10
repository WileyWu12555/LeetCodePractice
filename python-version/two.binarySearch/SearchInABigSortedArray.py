class ArrayReader:

    def get(self, index):
         # this would return the number on the given index
         # return -1 if index is less than zero.
         nums = [1, 2, 3, 4, 5, 6, 7, 8]

         if(index < 0 | index >= nums.length):
              return -1;
         else:
              return nums[index];


# @param {ArrayReader} reader: An instance of ArrayReader
# @param {int} target an integer
# @return {int} an integer
def searchBigSortedArray(reader, target):
        index = 0
        while reader.get(index) < target:
            index = index * 2 + 1

        start, end = 0, index
        while start + 1 < end:
            mid = (start + end) // 2
            if reader.get(mid) >= target:
                end = mid
            else:
                start = mid

        if reader.get(start) == target:
            return start
        if reader.get(end) == target:
            return end
        return -1

reader = ArrayReader()
target = 4
result = searchBigSortedArray(reader, target)
print(result)