import java.util.*;
public class A {
    private static void solve(Scanner sc) {
        TreeMap<O, Integer> mp = new TreeMap<>();
        int[] a = new int[6];
        for(int i = 0; i < 6; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = new int[6];
        for(int i = 0; i < 6; i++) {
            b[i] = sc.nextInt();
        }
        mp.put(new O(a), 0);
        LinkedList<O> q = new LinkedList<>();
        q.addLast(new O(a));
        while(q.size() != 0) {
            O f = q.getFirst();
            q.removeFirst();
            int dep = mp.get(f);
            int[] na = new int[6];
            na[0] = f.arr[3];
            na[1] = f.arr[0];
            na[2] = f.arr[2];
            na[3] = f.arr[4];
            na[4] = f.arr[1];
            na[5] = f.arr[5];
            O nA = new O(na);

            if(!mp.containsKey(nA)) {
                mp.put(nA, dep + 1);
                q.addLast(nA);
            }
            int[] nb = new int[6];
            nb[0] = f.arr[0];
            nb[1] = f.arr[4];
            nb[2] = f.arr[1];
            nb[3] = f.arr[3];
            nb[4] = f.arr[5];
            nb[5] = f.arr[2];
            O nB = new O(nb);
            if(!mp.containsKey(nB)) {
                mp.put(nB, dep + 1);
                q.addLast(nB);
            }
        }
        System.out.println(mp.get(new O(b)));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            solve(sc);
        }
    }
}

class O implements Comparable<O> {
    int[] arr;
    public O(int a[]) {
        arr = new int[6];
        for(int i = 0; i < 6; i++) {
            arr[i] = a[i];
        }
    }
    public int compareTo(O oo) {
        for(int i = 0; i < 6; i++) {
            if(this.arr[i] != oo.arr[i]) {
                return this.arr[i] - oo.arr[i];
            }
        }
        return 0;
    }
}
// using BFS algo to solve!!!
