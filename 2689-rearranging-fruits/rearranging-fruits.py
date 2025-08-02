class Solution(object):
    def minCost(self, basket1, basket2):
        """
        :type basket1: List[int]
        :type basket2: List[int]
        :rtype: int
        """
        freq = collections.Counter(basket1)
        freq.subtract(collections.Counter(basket2))
        swap = []
        for freq_cost, count in freq.items():
            if count % 2 != 0:
                return -1

            for _ in range(abs(count)//2):
                swap.append(freq_cost)

        swap.sort()
        min_available_fruit = min(basket1+basket2)
        cost = 0
        for i in range(len(swap)//2):
            direct_swap = swap[i]

            indirect_swap = 2 * min_available_fruit

            cost += min(direct_swap,indirect_swap)

        return cost