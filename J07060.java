import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class A {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("MONTHI.in"));        
        int n = sc.nextInt();
        ArrayList<MonThi> mon = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String ma = sc.next();
            sc.nextLine();
            String ten = sc.nextLine();
            String ht = sc.nextLine();
            mon.add(new MonThi(ma, ten, ht));
        }
        sc.close();
        sc = new Scanner(new File("CATHI.in"));
        n = sc.nextInt();
        ArrayList<CaThi> ca = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            ca.add(new CaThi(sc.next(), sc.next(), sc.next()));
        }   
        sc.close();
        sc = new Scanner(new File("LICHTHI.in"));
        n = sc.nextInt();
        ArrayList<LichThi> lich = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String cc = sc.next();
            String mm = sc.next();
            String gg = sc.next();
            int sl = sc.nextInt();
            for(MonThi m : mon) for(CaThi c : ca) {
                if(m.ma.equals(mm) && c.id.equals(cc)) {
                    lich.add(new LichThi(c.room, m.ten, gg, sl, c.date, c.time, c.id));
                }
            }
        }
        Collections.sort(lich);
        for(LichThi l : lich) {
            System.out.println(l);
        }
        sc.close();
    }
}

class MonThi {
    public String ma, ten, hinhThuc;
    public MonThi(String ma, String ten, String hinhThuc) {
        this.ma = ma;
        this.ten = ten;
        this.hinhThuc = hinhThuc;
    }
}

class CaThi {
    static int cur = 1;
    public String id, date, time, room;
    public CaThi(String date, String time, String room) {
        this.id = "C";
        if(cur < 100) {
            id += 0;
        }
        if(cur < 10) {
            id += 0;
        } 
        this.id += (cur++);
        this.date = date;
        this.time = time;
        this.room = room;
    }
}

class LichThi implements Comparable<LichThi> {
    public String room, mon, group, ma, date, time;
    public int sl;
    D dd;
    public LichThi(String room, String mon, String group, int sl, String date, String time, String ma) {
        dd = new D(date, time);
        this.room = room;
        this.mon = mon;
        this.group = group;
        this.sl = sl;
        this.ma = ma;
        this.date = date;
        this.time = time;
    }
    public int compareTo(LichThi oo) {
        int x = this.dd.compareTo(oo.dd);
        if(x == 0) {
            return this.ma.compareTo(oo.ma);
        }
        return x;
    }
    public String toString() {
        return String.format("%s %s %s %s %s %d", date, time, room, mon, group, sl);
    }
}

class D {
    public int d, m, y, hh, mm;
    public D(String date, String time) {
        d = strToNum(date.substring(0, 2));
        m = strToNum(date.substring(3, 5));
        y = strToNum(date.substring(6, 8));
        hh = strToNum(time.substring(0, 2));
        mm = strToNum(time.substring(3, 5));
    }
    static int strToNum(String s) {
        int ans = 0;
        for(char c : s.toCharArray()) {
            ans = ans * 10 + (c - '0');
        }
        return ans;
    }
    public int compareTo(D o) {
        if(this.y == o.y) {
            if(this.m == o.m) {
                if(this.d == o.d) {
                    if(this.hh == o.hh) {
                        if(this.mm == o.mm) {
                            return 0;
                        }
                        return this.mm - o.mm;
                    }
                    return this.hh - o.hh;
                }
                return this.d - o.d;
            }
            return this.m - o.m;
        }
        return this.y - o.y;
    }
}
// created by: tranDuyAnh
// note: last one before match
