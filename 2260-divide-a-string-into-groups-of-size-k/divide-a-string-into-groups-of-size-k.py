class Solution:
    def divideString(self, s: str, k: int, fill: str) -> List[str]:
        
        N = len(s)
        ans = []

        for i in range(0,N,k):
            st = s[i:i+k]

            if len(st) < k:
                lt = list(st)
                for i in range(k - len(st)):
                    lt.append(fill)
                st = "".join(lt)
            
            ans.append(st)
        
        return ans