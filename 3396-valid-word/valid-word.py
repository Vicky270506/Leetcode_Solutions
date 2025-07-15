class Solution(object):
    def isValid(self, word):
        """
        :type word: str
        :rtype: bool
        """
        if len(word) < 3:
            return False
        letters = [chr(i) for i in range(65,91)]
        letters.extend(chr(i) for i in range(97,123))
        numbers = [str(i) for i in range(0,10)]
        v,c = 0,0
        for ch in word:
            if ch not in letters and ch not in numbers:
                return False
            elif ch in ['A','E','I','O','U','a','e','i','o','u']:
                v += 1
            elif ch in letters and ch not in ['A','E','I','O','U','a','e','i','o','u']:
                c += 1
        if(v>0 and c>0):
            return True
        else:
            return False
        