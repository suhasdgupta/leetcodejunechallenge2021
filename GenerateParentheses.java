class GenerateParentheses {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        
        String[] str = new String[n*2];
        generateParenthesis(str, n, 0, 0, 0);
        return list;
    }
    
    private void generateParenthesis(String[] str, int n, int pos, int open, int close){
        if(close == n){
            StringBuilder builder = new StringBuilder();
            for(String s : str){
                builder.append(s);
            }
            list.add(builder.toString());
            return;
        }else{
            if(close<open){
                str[pos]=")";
                generateParenthesis(str, n, pos+1, open, close+1);
            }
            if(open<n){
                str[pos]="(";
                generateParenthesis(str, n, pos+1, open+1, close);
            }
        }
    }
}
