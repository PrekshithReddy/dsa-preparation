class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List <Integer> result=new ArrayList<>();
        if(matrix==null || matrix.length==0)
        return result;
        int startRow=0,startCol=0,endCol=matrix[0].length-1,endRow=matrix.length-1;
//top
while(startRow<=endRow && startCol<=endCol){
for(int i=startCol;i<=endCol;i++)
{
result.add(matrix[startRow][i]);

}
//right
for(int i=startRow+1;i<=endRow;i++)
{
result.add(matrix[i][endCol]);

}
//bottom
for(int i=endCol-1;i>=startCol;i--)
{
if(startRow==endRow)
{
break;
}
result.add(matrix[endRow][i]);
}
//left
for(int i=endRow-1;i>=startRow+1;i--)
{
if(startCol==endCol)
{
break;
}
result.add(matrix[i][startCol]);
}
startRow++;
startCol++;
endRow--;
endCol--;
}
return result;
    }
}