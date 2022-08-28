package Entity;

public class QLKeKhaiGiangDay {

    private GiangVien giangVien;
    private MonHoc monHoc;


    private ChiTietGiangDay ctgd;

    public ChiTietGiangDay getCtgd(){
        return ctgd;
    }
    private ChiTietGiangDay[] chitietgiangday;


    private DSTienLuongGV[] danhsachtienluonggv;


    public void setGiangVien(GiangVien giangVien){
        this.giangVien=giangVien;
    }
    public GiangVien getGiangVien(){
        return giangVien;
    }

    public MonHoc getMonHoc(){
        return monHoc;
    }



    public ChiTietGiangDay[] getChiTietGiangDay(){
        return chitietgiangday;
    }


    public void setChiTietGiangDay(ChiTietGiangDay[] chitietgiangday){
        this.chitietgiangday=chitietgiangday;
    }

    public DSTienLuongGV[] getDanhsachtienluonggv(){
        return danhsachtienluonggv;
    }

    public void setDanhsachtienluonggv(DSTienLuongGV[] danhsachtienluonggv){
        this.danhsachtienluonggv=danhsachtienluonggv;
    }

}
