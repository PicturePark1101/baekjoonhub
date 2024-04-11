import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    ArrayList<Person> list = new ArrayList<>();

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();
      list.add(new Person(age, name));
    }

    list.sort(new Comparator<Person>() {
      @Override
      public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
      }
    });

    for (Person n : list) {
      bw.write(n.getAge()+ " "+n.getName()+"\n");
    }

    bw.flush();
    bw.close();
    br.close();

  }

}

//record는 자바 16부터 가능..ㅜ 백준에선 지원을 안한다.
class Person {
  int age;
  String name;

  public Person(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }
}
