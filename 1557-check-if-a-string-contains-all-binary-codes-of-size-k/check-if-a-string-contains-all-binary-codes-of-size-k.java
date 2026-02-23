class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> codes = new HashSet<String>();
        String format = "%" + k + "s";
        for(int i=k;i<=s.length();i++)
        {
            codes.add(s.substring(i-k,i));
        }
        System.out.print(codes);
        int l = (int)Math.pow(2,k);
        for(int i=0;i<l;i++)
        {
            String f = Integer.toBinaryString(i);
           if(!codes.contains(String.format(format, f).replace(' ', '0')))
           {
            return false;
           }
        }
        return true;
    }
    /*public Map<String,Integer> generate_codes(int n)
    {
        Map<String, Integer> code = new HashMap<String, Integer>();
        code.put("00",0);
        code.put("01",0);
        for(int i=2;i<2*n;i++)
        {
            code.put(Integer.toBinaryString(i),0);
        }
        return code;
    }*/
}