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
    // 할인율은 10, 20, 30, 40 중 하나임 
    // 이모지들이 선택할 수 있는 할인율은 저 4개 중 한개..
    // 이모지의 최대 길이는 7임. 
    // 서비스 가입자가 가장 우선시 되는 목표임.
    // 가입자가 같다면 이모티콘 판매액이 그 다음 모교
    
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
            // 이모지 순회
            int total = 0;
            for (int j = 0; j < emoticons.length; j++) {
                // 할인률 안맞으면 아예 안삼
                if (bucket[j] < userDiscount) continue;
                
                // 산다. 기존가격과 할인률로
                total += calcDiscountPrice(emoticons[j], bucket[j]);
                if (total >=  userPrice) { // 만약 가격이 유저의 가격보다 높다면 가입함.
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
            answer[0] = joinCount;
            answer[1] = priceCount;
        }
    }
    
    private int calcDiscountPrice(int emoticonPrice, int discountRate) {
        return emoticonPrice * (100 - discountRate) / 100;
    }
    
    
}