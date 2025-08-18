class Solution(object):
    def combine(self, N, K):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        ans = []
        def backtrack(start, p):
            if len(p) == K:
                ans.append(p[:])
                return
            
            for i in range(start, N+1):
                p.append(i)
                backtrack(i+1,p)
                p.pop()
        
        backtrack(1,[])
        return ans