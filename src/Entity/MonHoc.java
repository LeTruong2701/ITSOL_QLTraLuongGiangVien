package Entity;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Scanner;

public class MonHoc {

    private int maMonHoc;
    private String tenMonhoc;
    private int tongSoTiet;
    private int soTietLyThuyet;
    private double mucKinhPhi;

    private int AUTO_ID=-1;


    public MonHoc(){
        if(AUTO_ID==-1){
            AUTO_ID=100;
            this.maMonHoc=AUTO_ID;
            return;
        }
        this.maMonHoc=++AUTO_ID;
    }



    public MonHoc( int maMonHoc,String tenMonhoc, int tongSoTiet, int soTietLyThuyet, double mucKinhPhi) {

        this.maMonHoc=maMonHoc;
        this.tenMonhoc = tenMonhoc;
        this.tongSoTiet = tongSoTiet;
        this.soTietLyThuyet = soTietLyThuyet;
        this.mucKinhPhi = mucKinhPhi;
    }

    public int getMaMonHoc(){
        return maMonHoc;
    }

    public String getTenMonhoc(){
        return tenMonhoc;
    }

    public void setTenMonhoc(String tenMonhoc){
        this.tenMonhoc=tenMonhoc;
    }

    public int getTongSoTiet(){
        return tongSoTiet;
    }

    public void setTongSoTiet(int tongSoTiet){
        this.tongSoTiet=tongSoTiet;
    }

    public int getSoTietLyThuyet(){
        return soTietLyThuyet;
    }

    public void setSoTietLyThuyet(int soTietLyThuyet){
        this.soTietLyThuyet=soTietLyThuyet;
    }

    public double getMucKinhPhi(){
        return mucKinhPhi;
    }

    public void setMucKinhPhi(double mucKinhPhi){
        this.mucKinhPhi=mucKinhPhi;
    }


    @Override
    public String toString(){
        return "entity.monHoc{" +
                "maMonhoc"+maMonHoc+
                ", tenMonhoc='"+tenMonhoc+'\''+
                ", tongSoTiet='"+tongSoTiet+'\''+
                ", soTietLyThuyet='"+soTietLyThuyet+'\''+
                ",mucKinhPhi='"+mucKinhPhi+'\''+
                '}';
    }

    public void nhapThongTinMonHoc(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập tên môn học: ");
        this.tenMonhoc=sc.nextLine();
        System.out.print("Nhập tổng số tiết: ");
        this.tongSoTiet=sc.nextInt();
        System.out.print("Nhập số tiết lý thuyết: ");
        this.soTietLyThuyet=sc.nextInt();
        System.out.print("Mức kinh phí: ");
        this.mucKinhPhi=sc.nextDouble();

    }

}
