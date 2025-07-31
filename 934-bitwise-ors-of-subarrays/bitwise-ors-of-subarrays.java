class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> cur = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();

        for(int num : arr)
        {
            Set<Integer> news = new HashSet<>();
            news.add(num);

            for(int prev: cur)
            {
                news.add(num | prev);
            }
            cur = news;
            res.addAll(cur);
            
        }
        return res.size();
    }
}