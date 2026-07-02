class Solution:
    def findSafeWalk(self, grid: List[List[int]], health: int) -> bool:
        R = len(grid)
        c = len(grid[0])
        INF = 10 ** 20

        q = collections.deque()
        distances = [[INF] * c for _ in range(R)]
        q.append((0,0))
        distances[0][0] = grid[0][0]

        directions = (
            (1,0), (0,1), (0,-1), (-1, 0)
        )
        
        while len(q) > 0:
            x,y = q.popleft()

            for dx, dy in directions:
                nx, ny = x + dx, y + dy

                if 0 <= nx < R and 0 <= ny < c:
                    delta = grid[nx][ny]
                    if distances[nx][ny] > distances[x][y]+delta:
                        if delta == 0:
                            q.appendleft((nx,ny))
                        else:
                            q.append((nx, ny))
                        distances[nx][ny] = distances[x][y] + delta
        
        return health > distances[R-1][c-1]