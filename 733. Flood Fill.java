//Runtime: 3 ms, faster than 13.26% of Java online submissions for Flood Fill.
//Memory Usage: 44.9 MB, less than 27.08% of Java online submissions for Flood Fill.

  
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int srMax = image.length;
        int scMax = image[0].length;
        int currColor = image[sr][sc];
        Queue<pixel> floodPixels = new LinkedList<>();
        pixel curr = new pixel(sr,sc);
        floodPixels.add(curr);
        while( !floodPixels.isEmpty() ){
            curr = floodPixels.remove();
            image[curr.sr][curr.sc] = newColor;
            for (pixel i: getNeighbour(image,curr,srMax,scMax,currColor)){
                if (image[i.sr][i.sc] != newColor){
                    floodPixels.add(i);
                }
            }
        }
        return image;
    }
    
    private List<pixel> getNeighbour( int[][] image,pixel curr, int srMax, int scMax,int currColor){
        List<pixel> neighbours = new LinkedList<>();
        int sr = curr.sr;
        int sc = curr.sc;
        if(curr.sr+1 < srMax && image[sr+1][sc] == currColor){
            neighbours.add(new pixel(sr+1,sc));
        }
        if(curr.sr-1 >= 0 && image[sr-1][sc] == currColor){
            neighbours.add(new pixel(sr-1,sc));
        }
        if(curr.sc+1 < scMax && image[sr][sc+1] == currColor){
            neighbours.add(new pixel(sr,sc+1));
        }
        if(curr.sc-1 >= 0 && image[sr][sc-1] == currColor){
            neighbours.add(new pixel(sr,sc-1));
        }
        return neighbours;
            
    }
    
    class pixel{
        public int sr=0;
        public int sc=0;
        
        pixel(int i, int j){
            this.sr = i;
            this.sc = j;
        }
    }
}
