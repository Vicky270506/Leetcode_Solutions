class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        t.add(1);
        List<Integer> copyOfList1 = new ArrayList<>(t);
        ans.add(copyOfList1);
        System.out.print(ans);
        for(int i=0;i< numRows-1; ++i)
        {
            List<Integer> temp = new ArrayList<>();
            t.add(0,0);
            t.add(0);
            int left = 0, right =1;
            while(right<t.size())
            {
                temp.add(t.get(left++)+t.get(right++));
            }
            List<Integer> c = new ArrayList<>(temp);
            ans.add(c);
            System.out.println(ans);
            t.clear();
            t.addAll(temp);
            
        }
        return ans;
    }
}