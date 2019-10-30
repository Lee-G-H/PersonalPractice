package KakaoQuestion;

import java.io.*;
import java.util.*;

//2019-10-30
//카카오 오픈채팅 문제
//채팅방 출입 등에 대한 문자열 배열이 주어지면 해당 로그들을 완성된 문자열 배열로 바꾸어 반환하는 문제
//한 유저의 닉네임이 바뀌게 되면 이전에 있던 로그의 아이디 내용도 한 번에 다 바뀌어야 하기 때문에 HashMap을 활용하기로 결정했다.
//입력 예시의 입력값은 무제한이기 때문에 종료 조건이 없어 따로 반복 종료를 위한 변수를 하나 두었다.
//해시맵에 다 저장한 후에는 해당 배열에 저장하기 위해 출력하는 과정에서 고민을 조금 길게 하게 되었다.
//Map.entry<>를 반복문에 활용해 요소들의 값을 불러오려 했지만, 정확하게 배열에 따라 진행되지 않고 원하는 때에 곧장 넣으려던
//의도에 맞지 않게 되었고 해당 방식은 버리게 되었다.
//조금은 더 간결함을 버리고 아이디도 따로 배열에 한번 더 저장하는 과정을 거치기로 했다. 결국 이렇게 되면 해시맵을 쓰는 의미가
//거의 없어지게 되지만 일단은 중복을 제거하는데 유용하게 쓰였다는 것으로 위안을 삼기로 했다.
//change명령의 경우 결과 배열에서 문장으로 구성되지 않고 지워지기 때문에 입력 배열과 반환 배열의 크기 차이가 발생하게 된다는
//사실을 깨닫게 되었다. 이를 해결하고자 ArrayList를 도입했다. ArrayList에 저장을 완료한 후에는 마지막으로 배열로 변환하는 과정을 거쳤다.
//결과 배열에 이름이 null이 되는 문제를 발견했고 원인을 파악해보니 HashMap에 키를 저장하는 과정에서 action배열을 저장하는
//실수로 인한 것이었다는 것을 찾게 되었고 정상적으로 id값을 넣어주며 오류를 해결함과 동시에 문제를 해결하게 되었다.
public class OpenChatRoom {

    public static void main(String[] args) {
        init();
    }

    static void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());

            String[] record = new String[n];

            for (int i = 0; i < n; i++)
                record[i] = br.readLine();

            bw.write(Arrays.toString(solution(record)));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String[] solution(String[] record) {
        StringTokenizer st;
        HashMap<String, String> recordMap = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        String[] id = new String[record.length];
        String[] action = new String[record.length];

        for (int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);

            action[i] = st.nextToken();
            id[i] = st.nextToken();

            if (action[i].equals("Leave"))
                continue;

            while (st.hasMoreTokens())
                recordMap.put(id[i], st.nextToken());
        }



        for (int i = 0; i < action.length; i++) {
            if (action[i].equals("Change"))
                continue;

            String name = recordMap.get(id[i]);

            list.add(action[i].equals("Enter") ? name + "님이 들어왔습니다." : name + "님이 나갔습니다.");
        }

        return list.toArray(new String[0]);
    }
}
