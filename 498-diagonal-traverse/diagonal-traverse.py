class Solution(object):
    def findDiagonalOrder(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[int]
        """
        if not mat or not mat[0]:
            return [ ]
        # The number of rows and columns
        M, N = len(mat), len(mat[0])
        # A dictionary to group elements by diagonal
        diagonals = defaultdict (list)
        # Populate the dictionary
        for i in range(M):
            for j in range(N):
                diagonals[i+j].append(mat[i][j])
        # The final result array
        result = []
        # Iterate through the diagonals
        for i in range(M + N - 1):
            if i % 2 == 0:
        # For even-indexed diagonals, reverse the list
                diagonals[i].reverse()
            
            result.extend(diagonals [i])
        return result
        