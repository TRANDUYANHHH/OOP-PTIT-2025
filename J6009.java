import java.util.*;
import java.io.*;
public class A {
    public static void main(String[] args) throws IOException {
        Scanner khin = new Scanner(new File("KH.in"));
        Scanner mhin = new Scanner(new File("MH.in"));
        Scanner hdin = new Scanner(new File("HD.in"));
//        Scanner sc = new Scanner(System.in);
        int na = khin.nextInt();
        ArrayList<KH> khs = new ArrayList<>();
        khin.nextLine();
        for(int i = 0; i < na; i++){
            String ten = khin.nextLine();
            String gioiTinh = khin.next();
            String ngaySinh = khin.next();
            khin.nextLine();
            String diaChi = khin.nextLine();
            khs.add(new KH(i + 1, ten, gioiTinh, ngaySinh, diaChi));
        }
        int nb = mhin.nextInt();
        ArrayList<MH> mhs = new ArrayList<>();
        for(int i = 0; i < nb; i++){
            mhin.nextLine();
            String ten = mhin.nextLine();
            String dvi = mhin.next();
            int giaMua = mhin.nextInt();
            int giaBan = mhin.nextInt();
            mhs.add(new MH(i + 1, ten, dvi, giaMua, giaBan));
        }
        System.out.println("done");
        int nc = hdin.nextInt();
        for(int i = 0; i < nc; i++){
            String id = "HD";
            if(i + 1 < 100) id += "0";
            if(i + 1 < 10) id += "0";
            id += (i + 1);
            String idKH = hdin.next();
            String idMH = hdin.next();
            int sl = hdin.nextInt();
            System.out.print(id + " ");
            for(int x = 0; x < na; x++){
                if(khs.get(x).getId().equals(idKH)){
                    System.out.print(khs.get(x).getTen() + " ");
                    System.out.print(khs.get(x).getDiaChi() + " ");
                    break;
                }
            }
            for(int y = 0; y < nb; y++){
                if(mhs.get(y).getId().equals(idMH)){
                    System.out.print(mhs.get(y).getTen() + " ");
                    System.out.print(mhs.get(y).getDv() + " ");
                    System.out.print(mhs.get(y).getGiaMua() + " ");
                    System.out.print(mhs.get(y).getGiaBan() + " ");
                    System.out.print(sl + " ");
                    System.out.println((long)mhs.get(y).getGiaBan() * (long)sl);
                    break;
                }
            }
        }
    }
}

class KH {
    private String id, ten, gioiTinh, ngaySinh, diaChi;
    public KH(int id, String ten, String gioiTinh, String ngaySinh, String diaChi){
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.id = "KH";
        if(id < 100) this.id += "0";
        if(id < 10) this.id += "0";
        this.id += id;
    }

    public String getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }
    
    
}
class MH {
    private String id, ten, dv;
    private int giaMua, giaBan;

    public MH(int id, String ten, String dv, int giaMua, int giaBan) {
        this.ten = ten;
        this.dv = dv;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        this.id = "MH";
        if(id < 100) this.id += "0";
        if(id < 10) this.id += "0";
        this.id += id;
    }

    public String getId() {
        return id;
    }

    public String getDv() {
        return dv;
    }

    public String getTen() {
        return ten;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public int getGiaBan() {
        return giaBan;
    }
    
}
