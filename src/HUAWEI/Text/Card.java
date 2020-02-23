package HUAWEI.Text;

import java.util.*;
/**
 * @ClassName: T2
 * @Description:
 * @Author:xuwen
 * @Date: 2020/2/19 下午4:17
 **/
public class Card {
    char color;
    Integer number;
    final static HashMap<String, Integer> dic = new HashMap<String, Integer>() {
        {put("1", 1);
            put("2",2);
            put("3", 3);
            put("4", 4);
            put("5", 5);
            put("6",6);
            put("7", 7);
            put("8", 8);
            put("9", 9);
            put("10",10);
            put("J", 11);
            put("Q", 12);

            put("K", 13);
            put("A", 14);
        }
    };
    public static Card read(Scanner sc) {
        String buffer  = sc.next();
        Card card = new Card();
        card.color = sc.next().charAt(0);
        String str = buffer.substring(1);
        card.number = Integer.parseInt(dic.get(str).toString());
        if(card.color == 'J') {
            card.number = -card.number;
        }
        return card;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        int n = sc.nextInt();
        Vector<Card> cards = new Vector<>(n);
        for (int i = 0; i < n; i++) {
            cards.add(read(sc));
        }
        Integer[] w = new Integer[1 << n];
        for (int i = 1; i < (1 << n); i++) {
            Card[] t = new Card[n];
            for (int j = 0; j < n; j++) {
                if((i >> j & 1) != 0) {
                    t[i] = (cards.get(j));
                }
            }
            Arrays.sort(t, 0, t.length - 1);
            w[i] = convert(t);
        }

        Integer[] dp = new Integer[1 << n];

        for(int i = 0; i < (1 << n); i++) {
            for (int j = i; j != 0; j = (j - 1) & i) {
                dp[i] = Math.max(dp[i], dp[i ^ j] + w[j]);
            }
        }
        System.out.println(dp[1 << n - 1]);
    }

    public static int convert(Card[] card) {
        if (card.length == 2 && card[0].number.equals(card[1].number)) return 2;
        if (card.length == 3 && card[0].number.equals(card[1].number) &&
                card[0].number.equals(card[2].number))
            return 4;
        if (card.length == 4 && card[0].number.equals(card[1].number) &&
                card[0].number.equals(card[2].number) &&
                card[0].number.equals(card[3].number))
            return 5;
        if (card.length == 2 && card[0].color == 'J' && card[1].color == 'J')
            return 5;
        if (card.length != 5) return 0;
        for (int i = 1; i < 5; i++) {
            if (card[i].number != card[0].number + i) {
                return 0;
            }
        }
        return 3;
    }

}
