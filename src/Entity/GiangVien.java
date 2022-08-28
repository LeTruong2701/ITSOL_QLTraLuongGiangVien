package Entity;

import java.util.Scanner;

public class GiangVien extends CongNhan{

    private static final String GS_TS="GS-TS";
    private static final String PGS_TS="PGS-TS";
    private static final String GV_CHINH="Giảng viên chính";
    private static final String THAC_SI="Thạc sĩ";




    private static  int AUTO_maGV=-1;
    private int maGV;
//    private String hoTen;
//    private String diaChi;
//    private String sdt;
    private String trinhDo;

    private double tienLuong;

    public GiangVien(){
        if (AUTO_maGV==-1){
            AUTO_maGV=100;
            this.maGV=AUTO_maGV;
            return;
        }
        this.maGV=++AUTO_maGV;
    }



    public GiangVien(int maGV,String hoTen, String diaChi, String sdt, String trinhDo) {

        this.maGV = maGV;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trinhDo = trinhDo;
    }

    public int getMaGV(){
        return maGV;
    }

    @Override
    public String getHoTen(){
        return hoTen;
    }
    @Override
    public void setHoTen(String hoTen){
        this.hoTen=hoTen;
    }
    @Override
    public String getDiaChi(){
        return diaChi;
    }
    @Override
    public void setDiaChi(String diaChi){
        this.diaChi=diaChi;
    }
    @Override
    public String getSdt(){
        return sdt;
    }
    @Override
    public void setSdt(String sdt){
        this.sdt=sdt;
    }

    public  String getTrinhDo(){
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo){
        this.trinhDo=trinhDo;
    }




    @Override
    public String toString(){
        return "entity.Giangvien{" +
                "maGV"+this.maGV+
                ", hoTen='"+this.hoTen+'\''+
                ", diaChi='"+this.diaChi+'\''+
                ", sdt='"+this.sdt+'\''+
                ",trinhDo='"+this.trinhDo+'\''+
                '}';
    }

    public void nhapThongTinGV(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập tên Giảng Viên: ");
        this.hoTen=sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.diaChi=sc.nextLine();
        System.out.println("Nhập SĐT: ");
        this.sdt=sc.nextLine();
        System.out.println("Trình độ thuộc 1 trong 4 lựa chọn dưới đây");
        System.out.println("1.GS_TS");
        System.out.println("2.PGS-TS");
        System.out.println("3.Giang Viên chính");
        System.out.println("4.Thạc sĩ");
        System.out.print("Mời bạn chọn: ");
        int choice=-1;
        do {
            choice=sc.nextInt();
            if(choice<4&&choice>1){
                break;
            }
            System.out.println("Chỉ lựa chọn 1 trong 4 lựa chọn trên");
        }while (choice>4||choice<1);
        switch (choice){
            case 1:
                this.trinhDo=GiangVien.GS_TS;
                break;
            case 2:
                this.trinhDo=PGS_TS;
                break;
            case 3:
                this.trinhDo=GV_CHINH;
                break;
            case 4:
                this.trinhDo=THAC_SI;
        }
    }
}
