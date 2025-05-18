class Solution:
    def colorTheGrid(self, m: int, n: int) -> int:
        MOD = 10 ** 9 + 7
        def generate_rows():
            rows = []

            def backtrack(row, col, prev_color):
                if col == m:
                    rows.append(tuple(row))
                    return
                for color in range(3):
                    if color != prev_color:
                        row.append(color)
                        backtrack(row, col + 1, color)
                        row.pop()

            backtrack([], 0, -1)
            return rows

        # Generate all valid row configurations
        row_configs = generate_rows()
        n_configs = len(row_configs)

        # Build adjacency: which configs can follow which?
        adjacency = [[] for _ in range(n_configs)]
        for i, config1 in enumerate(row_configs):
            for j, config2 in enumerate(row_configs):
                if all(config1[k] != config2[k] for k in range(m)):
                    adjacency[i].append(j)

        # Initialize DP
        dp = [1] * n_configs

        # For each next row (n - 1 times)
        for _ in range(n - 1):
            new_dp = [0] * n_configs
            for i in range(n_configs):
                for j in adjacency[i]:
                    new_dp[j] = (new_dp[j] + dp[i]) % MOD
            dp = new_dp

        return sum(dp) % MOD