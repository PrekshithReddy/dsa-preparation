class Solution {
    private List<Integer> generateRow(int rows)
    {
        long ans=1;
        List<Integer> ansRow=new ArrayList<>();
        ansRow.add(1);
        for(int col=1;col<rows;col++)
        {
            ans=ans*(rows-col);
            ans=ans/col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }
    
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        for(int i=1;i<=numRows;i++)
        {
            result.add(generateRow(i));
        }
        return result;
    }
}