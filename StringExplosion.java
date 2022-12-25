import java.io.*;
import java.util.*;

public class StringExplosion {
    static String str;
    static String boom;
    static Stack<Character> st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        boom = br.readLine();

        st = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            // 입력받은 문자열에서 알파벳으로 나눠서 스택에 넣기
            st.push(str.charAt(i));

            // 스택의 사이즈가 폭발 문자열의 길이보다 길다면
            // 폭발 문자열이 존재할 수 있다.
            if(st.size() >= boom.length()) {
                boolean contain = true; // 폭발 문자열이 있는지를 체크하기 위한 변수

                // 폭발 문자열의 길이만큼 반복
                for(int j = 0; j < boom.length(); j++) {
                    // 스택의 길이 - 폭발 문자열의 길이를 빼고 거기서 부터 시작
                    // 폭발 문자열과 다르면 탈출
                    if(st.get(st.size() - boom.length() + j) != boom.charAt(j)) {
                        contain = false;
                        break;
                    }
                }
                if (contain) {
                    for(int j = 0; j < boom.length(); j++) {
                        st.pop();
                    }
                }
            }
        }

        // 쪼개져있는 문자들을 문자열로 만들어주기
        StringBuilder sb = new StringBuilder();
        for(Character c : st) {
            sb.append(c);
        }

        // 문자열의 길이가 0이라면 FRULA 출력, 아니라면 문자열 출력
        System.out.println(sb.length() == 0? "FRULA" : sb.toString());
    }
}