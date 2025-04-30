import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static class Node {
		private char n;
		private Node left;
		private Node right;

		public Node(char n) {
			this.n = n;
		}
	}
	private static int N;
	private static StringBuilder sb = new StringBuilder();
	private static Node[] tree = new Node[26];


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char m = st.nextToken().charAt(0);
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);

			if (tree[m - 'A'] == null) {
				tree[m - 'A'] = new Node(m);
			}

			if (l != '.') {
				tree[l - 'A'] = new Node(l);
				tree[m - 'A'].left = tree[l - 'A'];
			}

			if (r != '.') {
				tree[r - 'A'] = new Node(r);
				tree[m - 'A'].right = tree[r - 'A'];
			}
		}
		preorder(tree[0]);
		sb.append("\n");
		inorder(tree[0]);
		sb.append("\n");
		postorder(tree[0]);
		System.out.println(sb);
		br.close();
	}

	private static void preorder(Node node) {
		if (node == null) {
			return;
		}
		sb.append(node.n);
		preorder(node.left);
		preorder(node.right);
	}

	private static void inorder(Node node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		sb.append(node.n);
		inorder(node.right);
	}

	private static void postorder(Node node) {
		if (node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		sb.append(node.n);
	}
}
