
/**
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

 

示例 1：


输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
输出：["eat","oath"]
示例 2：


输入：board = [["a","b"],["c","d"]], words = ["abcb"]
输出：[]
 

提示：

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] 是一个小写英文字母
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] 由小写英文字母组成
words 中的所有字符串互不相同


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//解法一 :深搜+回溯
class Solution {
   
    public List<String> findWords(char[][] board, String[] words) {
        boolean[][] isUsed= new  boolean[board.length][board[0].length];
        List<String> list =new ArrayList<>();
        for(int i= 0; i< words.length;i++){
            if(dfs(words[i],board,isUsed)){
                list.add(words[i]);
            }
        }
        return list;
    }
    
    
    public boolean dfs(boolean [][] isUsed,String word,int  i,int j,int index,char[][] board){
        if(i<0||i>=board.length||j<0||j>=board[0].length) return false;
        if(isUsed[i][j]==true||board[i][j]!=word.charAt(index)) return false;
        if(word.charAt(index)==board[i][j]&&index == word.length()-1) return true;

        isUsed[i][j]=true;
        boolean res  =dfs(isUsed,word,i-1,j,index+1,board)
            ||dfs(isUsed,word,i+1,j,index+1,board)
            ||dfs(isUsed,word,i,j-1,index+1,board)
            ||dfs(isUsed,word,i,j+1,index+1,board);
        
        isUsed[i][j]=false;
        return res;
        
    }
    public boolean dfs(String word,char[][] board,boolean [][] isUsed){
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(board[i][j]==word.charAt(0)&&dfs(isUsed,word,i,j,0,board)){
                    return true;
                }
            }
        }
        return false;
    }
}

//解法二: 前缀树(字典树) + 回溯
class Trie{
    int id;
    Trie[] son;
    public Trie(){
        son = new Trie[26];
        id =-1;
    }
    public void insert(String word,int id){
        Trie p = this;
        for(char s : word.toCharArray()){
            int i = s-'a';
            if(p.son[i]==null) p.son[i]=new Trie();
            p=p.son[i];
        }
        p.id=id;
        
    }
}
class Solution {
    Trie trie = new Trie();
    Set<Integer>  ids = new HashSet<>();
    char b [][];
    public List<String> findWords(char[][] board, String[] words) {
        b = board;
        //将所有单词插入到字典树中
       for(int i =0 ;i < words.length;i++){
           trie.insert(words[i],i);
       }     
        
        for(int i =0 ;i < b.length;i++){
            for(int j = 0 ;j < b[0].length ;j++){
                int  u = b[i][j] -'a';
                if(trie.son[u]!=null) dfs(trie.son[u],i,j); 
            }
        }
        List<String> res = new ArrayList<>();
        for(Integer i : ids){
            res.add(words[i]);
        }
                          return res;
        

    }
    int [] dx = {-1,1,0,0};
    int [] dy = {0,0,-1,1};
    public void  dfs(Trie root,int x,int y){
        if(root.id!=-1) ids.add(root.id); 
        char t = b[x][y];
        b[x][y] = '.';
     for(int i =0 ;i < 4 ;i++){
         int ax =x+dx[i];
         int by = y+dy[i];
         if(ax >=0 && ax < b.length && by >= 0&& by < b[0].length && b[ax][by]!='.'){
             int u = b[ax][by]-'a';
             if(root.son[u]!=null) dfs(root.son[u],ax,by);
         }
     }
        b[x][y]=t;
        
        
    }
}