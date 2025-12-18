import java.util.*;

// using segment tree hehe
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            SegTree seg = new SegTree(a);
            seg.build(0, 0, n);
            for(int i = 0; i < n; i++) {
                int lo = 1, hi = (i + 1);
                while(lo < hi) {
                    int m = (lo + hi + 1) / 2;
                    if(seg.get(0, 0, n, i - m + 1, i) == a[i]) {
                        lo = m;
                    } else {
                        hi = m - 1;
                    }
                }
                System.out.print(hi + " ");
            }
            System.out.println();
        }
    }
}

class SegTree {
    private int sz;
    int[] T;
    int[] A;
    public SegTree(int[] a) {
        sz = a.length;
        A = new int[sz + 10];
        for(int i = 0; i < sz; i++) {
            A[i] = a[i];
        }
        T = new int[sz * 4 + 10];
    }

    public void build(int i, int l, int r) {
        if(l == r) {
            T[i] = A[l];
            return;
        }
        int m = (l + r) / 2;
        build(i * 2 + 1, l, m);
        build(i * 2 + 2, m + 1, r);
        T[i] = Math.max(T[i * 2 + 1], T[i * 2 + 2]);
    }

    public int get(int i, int l, int r, int L, int R) {
        if(l > R || L > r) {
            return -1_000_000_005;
        }
        if(l >= L && r <= R) {
            return T[i];
        }
        int m = (l + r) / 2;
        return Math.max(get(i * 2 + 1, l, m, L, R), get(i * 2 + 2, m + 1, r, L, R));
    }
}
