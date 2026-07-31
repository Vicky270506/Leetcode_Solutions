class Solution:
    def minimumPushes(self, word: str) -> int:
        f = collections.Counter(word)
        print(f)
        f = sorted(f, key = f.get, reverse = True)
        keypad = {}
        for k in f:
            keypad[k] = int(len(keypad)/8) + 1
        ans = 0
        for w in word:
            ans += keypad[w]
        print(keypad)
        return ans