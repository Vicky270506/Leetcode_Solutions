class Solution:
    def minTimeToReach(self, moveTime: list[list[int]]) -> int:
        import heapq
        n, m = len(moveTime), len(moveTime[0])
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
        
        visited = [[[float('inf')] * 2 for _ in range(m)] for _ in range(n)]
    
        pq = [(0, 0, 0, 0)]  # (time, x, y, parity)
        visited[0][0][0] = 0
    
        while pq:
            time, x, y, parity = heapq.heappop(pq)
            if (x, y) == (n-1, m-1):
                return time
    
            next_cost = 1 if parity == 0 else 2
            next_parity = 1 - parity
    
            for dx, dy in dirs:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m:
                    wait_time = max(time, moveTime[nx][ny])
                    arrive_time = wait_time + next_cost
                    if arrive_time < visited[nx][ny][next_parity]:
                        visited[nx][ny][next_parity] = arrive_time
                        heapq.heappush(pq, (arrive_time, nx, ny, next_parity))