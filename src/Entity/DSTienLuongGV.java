package Entity;

public class DSTienLuongGV {

    private double tienLuong;

    private MonHoc monHoc;

    private GiangVien giangVien;

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public void setTienLuong(int soLop,int tongSoTiet,int soTietLyThuyet,double mucKinhPhi){
        this.tienLuong=((mucKinhPhi*soTietLyThuyet)+(mucKinhPhi*0.7*(tongSoTiet-soTietLyThuyet)))*soLop;

    }
    public void setTienLuong(){
        this.tienLuong=tienLuong;
    }

    @Override
    public String toString() {
        return "DS tien luong{" +
                "Giang vien=" + giangVien +
                ", Tien Luong=" + tienLuong +
                '}';
    }
}
