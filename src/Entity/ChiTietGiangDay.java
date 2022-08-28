package Entity;

public class ChiTietGiangDay {
    private MonHoc monhoc;

    private int soLop;

    private double tienLuong;


    public MonHoc getMonHoc(){
        return monhoc;
    }


    
    public void setMonhoc(MonHoc monhoc){
        this.monhoc=monhoc;

    }

    public int getSoLop(){
        return soLop;
    }


    public void setSoLop(int soLop ){
        this.soLop=soLop;
    }



    @Override
    public String toString() {
        return "ChitietGiangDay{" +
                "monHoc=" + monhoc +
                ", soLopGiangDay=" + soLop +
                '}';
    }

}
