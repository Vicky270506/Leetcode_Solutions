class Solution:
    def earliestAndLatest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        @cache
        def dp(players, round):
            # Convert bitmask to list of player indices (1-based)
            active = [i + 1 for i in range(n) if (players & (1 << i))]
            m = len(active)
            
            # Check if firstPlayer and secondPlayer are paired
            for i in range((m + 1) // 2):
                pos1 = i + 1
                pos2 = m + 1 - pos1
                player1 = active[pos1 - 1]
                player2 = active[pos2 - 1] if pos1 != pos2 else None
                if (player1 == firstPlayer and player2 == secondPlayer) or \
                (player1 == secondPlayer and player2 == firstPlayer):
                    return (round, round)
            
            # If only firstPlayer and secondPlayer remain, they must meet
            if m == 2 and firstPlayer in active and secondPlayer in active:
                return (round, round)
            
            # Simulate the round
            winners = []
            if m % 2 == 1:
                # Middle player advances
                middle = active[m // 2]
                winners.append(middle)
            
            # Process pairs
            results = []
            def backtrack(i, curr_winners):
                if i == (m + 1) // 2:
                    # Sort winners by original index
                    next_players = 0
                    for w in sorted(curr_winners):
                        next_players |= (1 << (w - 1))
                    if next_players:
                        min_r, max_r = dp(next_players, round + 1)
                        results.append((min_r, max_r))
                    return
                
                pos1 = i + 1
                pos2 = m + 1 - pos1
                if pos1 == pos2:
                    backtrack(i + 1, curr_winners)
                    return
                
                player1 = active[pos1 - 1]
                player2 = active[pos2 - 1]
                
                # If firstPlayer or secondPlayer is involved, they win
                if player1 == firstPlayer or player1 == secondPlayer:
                    backtrack(i + 1, curr_winners + [player1])
                elif player2 == firstPlayer or player2 == secondPlayer:
                    backtrack(i + 1, curr_winners + [player2])
                else:
                    # Try both outcomes
                    backtrack(i + 1, curr_winners + [player1])
                    backtrack(i + 1, curr_winners + [player2])
            
            backtrack(0, winners)
            
            if not results:
                return (float('inf'), -float('inf'))
            
            min_round = min(r[0] for r in results)
            max_round = max(r[1] for r in results)
            return (min_round, max_round)
        
        # Initialize with all players
        players = (1 << n) - 1  # Bitmask with all n bits set
        min_round, max_round = dp(players, 1)
        return [min_round, max_round]
        