class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        R = len(matrix)
        C = len(matrix[0])
        prefix = [[0] * (C+1)]

        for i in range(R):
            prefix.append([0])
            for j in range(C):
                prefix[i+1].append(prefix[i+1][j] + int(matrix[i][j]) + prefix[i][j+1] - prefix[i][j])
        def submatrix_sum(ax, ay, bx, by):
            return prefix[bx+1][by+1] - prefix[ax][by+1] - prefix[bx+1][ay] + prefix[ax][ay]
        
        best = 0
        for top in range(R):
            for bot in range(top,R):
                streak = 0
                full = bot-top +1
                for y in range(C):
                    if submatrix_sum(top,y,bot,y) == full:
                        streak += 1
                        best = max(best, streak * full)
                    else:
                        streak = 0
        
        return best