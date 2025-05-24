class Solution(object):
    def findWordsContaining(self, words, x):
        """
        :type words: List[str]
        :type x: str
        :rtype: List[int]
        """
        ind = []
        for index, word in enumerate(words):
            if x in word:
                ind.append(index)
        return ind

        