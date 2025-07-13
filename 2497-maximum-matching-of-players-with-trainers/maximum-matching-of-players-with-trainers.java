class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int ans = 0;
        
        int pp = 0; int tp = 0;

        while(pp !=  players.length && tp != trainers.length)
        {
            if(players[pp] > trainers[tp])
            {
                tp++;
            }
            else
            {
                tp++;
                pp++;
                ans++;
            }
        }

        return ans;
    }
}