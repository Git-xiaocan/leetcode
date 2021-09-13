class Solution {
	public int numberOfBoomerangs(int[][] p) {
        int count = 0;
        for(int i =0; i < p.length;i++){
            Map<Integer,Integer> map = new HashMap<>();
            for(int j = 0;j < p.length;j++){
                if(i!=j){
                    int dx =p[i][0]-p[j][0];
                    int dy = p[i][1]-p[j][1];
                    int dis  = dx*dx+dy*dy;
                    map.put(dis,map.getOrDefault(dis,0)+1);
                 
                }
               
            } 
            for(Map.Entry<Integer,Integer> n : map.entrySet()){
                        //在 n个元素中选择两个元素排列组合 有 n*(n-1)种
                        count+=n.getValue()*(n.getValue()-1);

                }

        }
        return count;

	}
}