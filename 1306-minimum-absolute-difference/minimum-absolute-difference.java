class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++)
        {
            min = Math.min(min, arr[i]-arr[i-1]);
        }
        System.out.print(min);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i+1]-arr[i] == min)
            {
                result.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return result;
    }
}