import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static String answer;
	private static boolean existAnswer = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		dfs(N, 0, "");
		System.out.println(answer);
		br.close();
	}

	private static void dfs(int N, int depth, String str) {

		if (N == depth) {
			answer = str;
			existAnswer = true;
			return;
		}

		for (int i = 1; i <= 3; i++) {
			if (isValid(str + String.valueOf(i))) {
				dfs(N, depth + 1, str + String.valueOf(i));
			}

			if (existAnswer) return;
		}
	}

	private static boolean isValid(String temp) {
		int length = temp.length();

		for (int i = 1; i <= length / 2; i++) {
			String str1 = temp.substring(length - i, length);
			String str2 = temp.substring(length - 2 * i, length - i);

			if (str1.equals(str2)) {
				return false;
			}
		}
		return true;

	}

}
