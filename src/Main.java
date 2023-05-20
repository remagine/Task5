import Todo.TodoService;
import commandandtag.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        String inputString = "21\n" +
                "create\n" +
                "create\n" +
                "create\n" +
                "create\n" +
                "execute 11\n" +
                "create\n" +
                "create\n" +
                "create\n" +
                "create\n" +
                "create\n" +
                "create\n" +
                "execute 2\n" +
                "create\n" +
                "execute 2\n" +
                "execute 11\n" +
                "execute 2\n" +
                "execute 5\n" +
                "execute 5\n" +
                "execute 2\n" +
                "execute 5\n" +
                "execute 5";

        // 입력
        byte[] bytes = inputString.getBytes(StandardCharsets.UTF_8);
        InputStream is = new ByteArrayInputStream(bytes);
        // 버퍼처리
        BufferedInputStream bs = new BufferedInputStream(is, 8192);
        // 인코딩처리
        InputStreamReader isr = new InputStreamReader(bs, StandardCharsets.UTF_8);
        // 버퍼처리
        BufferedReader br = new BufferedReader(isr, 8192);
        TodoService todoService = TodoService.getTaskService();
        // 자원의 해제
        try (is; bs; isr; br) {
            int count = Integer.parseInt(br.readLine());
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                // line을 처리의 입력으로 변환해야 한다
                // 입력의 유효성을 체크하는 것은
                // line마다 분할하였을때 그 갯수가 1개이거나 2개인가이다.
                String[] inputArray = line.split(" ");
                if (inputArray.length != 1 && inputArray.length != 2) {
                    throw new IllegalArgumentException("입력이 유효하지 않습니다.");
                }
                // 처리의 입력은 command와 tag로 구성되어 있다.
                // command는 필수, tag는 nullable
                // inputArray를 command와 tag로 변환한다.
                Command command = Command.from(inputArray[0]);
                Tag tag = EmptyTag.EMPTY_TAG;
                if (command.equals(Command.EXECUTE)) {
                    tag = Tag.from(inputArray[1]); // could be catch index error
                }

                // 처리의 입력을 생성
                CommandAndTag commandAndTag = new CommandAndTag(command, tag);
                // 처리
                //CommandAndTag.execute();
                // 처리 컨텍스트로 입력을 전달한다.

                todoService.doTask(commandAndTag);

            }
            // 출력
            todoService.printTodoHistory();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}