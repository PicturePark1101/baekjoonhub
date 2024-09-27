import java.util.*;
class Solution {
    
    static class User {
        private int n;
        private int discount;
        private int price;
        public User(int n, int discount, int price) {
            this.n = n;
            this.discount = discount;
            this.price = price;
        }
    }
    
    private int[] fixedDiscount = {10, 20, 30, 40};
    private int[] answer = new int[2];
    private int[] bucket;
    private User[] userInfo;
    public int[] solution(int[][] users, int[] emoticons) {
        userInfo = new User[users.length];
        bucket = new int[emoticons.length];
        for (int i = 0; i < users.length; i++) {
            userInfo[i] = new User(i, users[i][0], users[i][1]);
        }
        
        dfs(0, emoticons);
        return answer;
    }
    
    private void dfs(int depth, int[] emoticons) {
        if (depth == emoticons.length) {
            buyEmoticons(emoticons);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            bucket[depth] = fixedDiscount[i];
            dfs(depth + 1, emoticons);
        }
        
    }
    
    private void buyEmoticons(int[] emoticons) {
        int[] buyInfo = new int[2];
        int joinCount = 0;
        int priceCount = 0;
        for (int i = 0; i < userInfo.length; i++) {
            int userDiscount = userInfo[i].discount;
            int userPrice = userInfo[i].price;
            int total = 0;
            for (int j = 0; j < emoticons.length; j++) {
                if (bucket[j] < userDiscount) continue;
                total += calcDiscountPrice(emoticons[j], bucket[j]);
                if (total >=  userPrice) {
                    total = 0;
                    joinCount++;
                    break;
                }

            }
            priceCount += total;
        }
        
        if (answer[0] < joinCount) {
            answer[0] = joinCount;
            answer[1] = priceCount;
        } else if (answer[0] == joinCount && answer[1] < priceCount) {
            answer[1] = priceCount;
        }
    }
    
    private int calcDiscountPrice(int emoticonPrice, int discountRate) {
        return emoticonPrice * (100 - discountRate) / 100;
    }
    
    
}