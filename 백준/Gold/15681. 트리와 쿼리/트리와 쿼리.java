import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static List<Integer>[] tree;
	private static boolean[] visited;
	private static int[] subtreeSize;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		tree = new List[N + 1];
		subtreeSize = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			tree[n1].add(n2);
			tree[n2].add(n1);
		}

		visited = new boolean[N + 1];
		dfs(R, 0, false);
		for (int i = 0; i < Q; i++) {
			int q = Integer.parseInt(br.readLine());
			sb.append(subtreeSize[q]).append("\n");
		}
		System.out.println(sb);

		br.close();
	}

	private static int dfs(int n, int subDepth, boolean isMeet) {

		visited[n] = true;
		int size = 1;

		for (int t : tree[n]) {
			if (visited[t]) continue;
			size += dfs(t,subDepth + 1, isMeet);
		}

		subtreeSize[n] = size;
		return size;

	}
}
