class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        d = {}

        nums = arr.copy()
        nums.sort()
        i = 1
        for j in nums:
            if j not in d.keys():
                d[j] = i
                i += 1

        print(d)
        l = []
        print(arr)
        for i in arr:
            l.append(d[i])

        return l