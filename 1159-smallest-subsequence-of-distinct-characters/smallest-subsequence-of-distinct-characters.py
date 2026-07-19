class Solution:
    def smallestSubsequence(self, s: str) -> str:
        # 1. Store the last seen index for every character.
        # This gives us our "future knowledge".
        last_occurrence = {char: i for i, char in enumerate(s)}
        
        stack = []
        visited = set()
        
        for i, char in enumerate(s):
            # If we've already securely placed this character in our stack, skip it.
            if char in visited:
                continue
                
            # THE CORE LOGIC:
            # While there are characters in our stack, AND
            # the current character is alphabetically smaller than the top of the stack, AND
            # the character at the top of the stack appears again later in the string...
            while stack and char < stack[-1] and last_occurrence[stack[-1]] > i:
                # ...we can safely throw away the top of the stack!
                removed_char = stack.pop()
                visited.remove(removed_char)
                
            # Add the current character to the stack and mark it as visited
            stack.append(char)
            visited.add(char)
            
        return "".join(stack)