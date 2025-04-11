import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer>[] tree;
	private static int[] priceCount;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		tree = new List[N + 1];
		priceCount = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n == -1) continue;
			tree[n].add(i);
		}


		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			priceCount[n] += w;
		}

		dfs(1);

		for (int i = 1; i <= N; i++) {
			sb.append(priceCount[i]).append(" ");
		}
		System.out.println(sb);
		br.close();
	}

	private static void dfs(int n) {
		visited[n] = true;

		for (int t : tree[n]) {
			if(visited[t]) continue;
			priceCount[t] += priceCount[n];
			dfs(t);
		}
	}
}
