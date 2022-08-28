import Entity.*;

import java.util.Scanner;

public class MainRun {

    private static GiangVien[] GIANGVIEN=new GiangVien[100];
    private static MonHoc[] MONHOC=new MonHoc[100];

    private static QLKeKhaiGiangDay[] QLKEKHAIGIANGDAY=new QLKeKhaiGiangDay[100];


    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu(){
        DulieuGiangvien();
        DulieuMonhoc();
        while (true){
            int functionChoice=functionChoice();
            switch (functionChoice){
                case 1:
                    NhapMonhoc();
                    break;
                case 2:
                    HienThiMonHoc();
                    break;
                case 3:
                    NhapGiangVien();
                    break;
                case 4:
                    HienThiGiangVien();
                    break;
                case 5:
                    CreateQLKeKhaiGiangDay();
                    showQLKeKhaiGiangDay();
                    break;
                case 6:
                    showQLKeKhaiGiangDay();
                    break;
                case 7:
                    sapXepDSTheoTen();
                    showQLKeKhaiGiangDay();
                    break;
                case 8:
                    sapXepDSTheoSoTietGiangDay();
                    showQLKeKhaiGiangDay();
                    break;
                case 9:
                    lapBangTinhLuong();
                    break;
            }
        }
    }

    private static int functionChoice(){
        Scanner sc=new Scanner(System.in);
        System.out.println("========= Chương trình quản lý trả lương cho giảng viên============ ");
        System.out.println("1.Nhập danh sách môn học mới");
        System.out.println("2.Hiển thị danh sách môn học");
        System.out.println("3.Nhập danh sách giảng viên mới");
        System.out.println("4.Hiển thị danh sách giảng viên");
        System.out.println("5.Kê khai giảng dạy");
        System.out.println("6.Bảng kê khai giảng dạy");
        System.out.println("7.Sắp xếp danh sách kê khai theo tên");
        System.out.println("8.Sắp xếp danh sách kê khai theo số tiết");
        System.out.println("9.Bảng tiền công cho giảng viên ");
        System.out.println("10.Thoát");
        System.out.println("Mời bạn chọn: ");
        int choice=-1;
        do {
            choice=sc.nextInt();
            if(choice<9&&choice>=1){
                break;
            }
        }while (choice>9||choice<1);
        return choice;

    }


    public static void DulieuGiangvien(){
        GiangVien gv1=new GiangVien(100,"minh","KhoaiChau","09875554","PGS-TS");
        GIANGVIEN[0]=gv1;
        GiangVien gv2=new GiangVien(101,"truong","Hanoi","09778172","Giang vien chih");
        GIANGVIEN[1]=gv2;
        GiangVien gv3=new GiangVien(102,"duc","hung yen","0332131","Thạc sĩ");
        GIANGVIEN[2]=gv3;
    }

    public static void DulieuMonhoc(){
        MonHoc gv1=new MonHoc(100,"Toán",5,3,1000);
        MONHOC[0]=gv1;
        MonHoc gv2=new MonHoc(101,"Văn",6,4,2000);
        MONHOC[1]=gv2;
    }

    private static void NhapMonhoc(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số môn học muốn thêm");
        int slmonhoc=sc.nextInt();
        for (int i = 0; i < slmonhoc; i++) {
            System.out.println("Nhập thông tin môn học thứ "+i+" : ");
            MonHoc monHoc=new MonHoc();
            monHoc.nhapThongTinMonHoc();

            //lưu thông tin môn học
            SaveMonHoc(monHoc);
        }
    }
    private static void SaveMonHoc(MonHoc monHoc){
        for (int i = 0; i < MONHOC.length; i++) {
            if(MONHOC[i]==null){
                MONHOC[i]=monHoc;
                break;
            }
        }
    }

    private static void HienThiMonHoc(){
        for (int i = 0; i < MONHOC.length; i++) {
            if(MONHOC[i]==null){
                continue;
            }
            System.out.println(MONHOC[i]);
        }
    }

    private static void NhapGiangVien(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số lượng giảng viên muốn thêm: ");
        int slgiangvien=sc.nextInt();
        for (int i = 0; i < slgiangvien; i++) {
            System.out.println("Nhập thông tin giảng viên thứ "+i+" ");
            GiangVien gv=new GiangVien();
            gv.nhapThongTinGV();

            //Save thông tin giảng viên

            SaveGiangVien(gv);
        }
    }

    private static void SaveGiangVien(GiangVien gv){
        for (int i = 0; i < GIANGVIEN.length; i++) {
            if(GIANGVIEN[i]==null){
                GIANGVIEN[i]=gv;
                break;
            }
        }
    }



    private static void HienThiGiangVien(){
        for (int i = 0; i < GIANGVIEN.length; i++) {
            if(GIANGVIEN[i]==null){
                continue;
            }
            System.out.println(GIANGVIEN[i]);
        }
    }


    private static void CreateQLKeKhaiGiangDay(){
        Scanner sc=new Scanner(System.in);
        if(!CheckData()){
            System.out.println("Hiện tại chưa có danh sách, vui lòng thêm dữ liêu");
            return;
        }
        System.out.print("Nhập số lượng kê khai giảng viên:");
        int slkekhai=sc.nextInt();
        for (int i = 0; i < slkekhai; i++) {
            QLKeKhaiGiangDay qlkkgd=new QLKeKhaiGiangDay();
            GiangVien gv=nhapGiangVienKeKhai(i);

            qlkkgd.setGiangVien(gv);

            ChiTietGiangDay[] chiTietGiangDays=CreateChiTietGiangDay();
            qlkkgd.setChiTietGiangDay(chiTietGiangDays);
            //lưu kê khai

            SaveQLGD(qlkkgd);


        }
    }



    private static void showQLKeKhaiGiangDay(){
        for (int i = 0; i <QLKEKHAIGIANGDAY.length ; i++) {
            QLKeKhaiGiangDay QLKKGD=QLKEKHAIGIANGDAY[i];
            if(QLKKGD!=null){
                System.out.println("Giang viên "+QLKKGD.getGiangVien().getHoTen()+"đã chọn môn học sau:");
                for (int j = 0; j < QLKKGD.getChiTietGiangDay().length; j++) {
                    System.out.println(QLKKGD.getChiTietGiangDay()[j]);

                }
                System.out.println("===================");
            }
        }
    }





    private static void SaveQLGD(QLKeKhaiGiangDay qlkkgd){
        for (int i = 0; i < QLKEKHAIGIANGDAY.length; i++) {
            if(QLKEKHAIGIANGDAY[i]==null){
                QLKEKHAIGIANGDAY[i]=qlkkgd;
                return;
            }
        }
    }




    private static GiangVien nhapGiangVienKeKhai(int index){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập mã giảng viên thứ "+(index+1)+"muốn kê khai:");
        int maGiangVien;
        GiangVien giangVien;
        do {
            maGiangVien=sc.nextInt();
            giangVien=searchGiangVienByID(maGiangVien);
            if(searchGiangVienByID(maGiangVien)!=null){
                break;
            }
            System.out.println("Không tồn tại mã giảng viên");
        }while (true);

        return giangVien;
    }

    private static MonHoc nhapMonHoc(int index){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập mã môn học thứ "+(index+1)+":");
        int maMonhoc;
        MonHoc monHoc;
        do {
            maMonhoc=sc.nextInt();
            monHoc=searchMonHocByID(maMonhoc);
            if(searchMonHocByID(maMonhoc)!=null){
                break;
            }
            System.out.println("Không tồn tại mã môn học");
        }while (true);
        return monHoc;
    }

    private static GiangVien searchGiangVienByID(int maGV){
        for (int i = 0; i <GIANGVIEN.length ; i++) {
            GiangVien gv=GIANGVIEN[i];
            if(gv!=null&&gv.getMaGV()==maGV){
                return gv;
            }
        }
        return null;
    }

    private static MonHoc searchMonHocByID(int maMonhoc){
        for (int i = 0; i < MONHOC.length; i++) {
            MonHoc monHoc=MONHOC[i];
            if(monHoc!=null&&monHoc.getMaMonHoc()==maMonhoc){
                return monHoc;
            }
        }
        return null;
    }
    private static boolean CheckData(){
        boolean coDulieuGiangvien=false;

        for (int i = 0; i < GIANGVIEN.length; i++) {
            if(GIANGVIEN[i]!=null){
                coDulieuGiangvien=true;
                break;
            }
        }

        boolean coDulieuMonhoc=false;
        for (int i = 0; i <MONHOC.length ; i++) {
            if(MONHOC[i]!=null);
            coDulieuMonhoc=true;
            break;
        }
        return coDulieuMonhoc&&coDulieuGiangvien;
    }




    private static ChiTietGiangDay[] CreateChiTietGiangDay(){
        System.out.println("Nhập số lượng môn học giảng viên muốn đăng ký:");
        int slmonhoc=new Scanner(System.in).nextInt();


        ChiTietGiangDay[] chiTietGiangDays=new ChiTietGiangDay[slmonhoc];
        for (int i = 0; i <slmonhoc ; i++) {
            ChiTietGiangDay chiTietGiangDay=new ChiTietGiangDay();
            //xác định giảng viên dạy môn nào
            //yêu cầu nhập mã môn muốn dạy
            MonHoc monHoc=nhapMonHoc(i);

            //lưu đầu sách tìm được vào chi tiết giảng dạy(chi tiết giảng dạy)
            chiTietGiangDay.setMonhoc(monHoc);

            System.out.print("Nhập số lopws muốn dạy:");
            int soLop;
            do {
                soLop=new Scanner(System.in).nextInt();
                if(soLop<10&&soLop>=1){
                    break;
                }
            }while (true);
            chiTietGiangDay.setSoLop(soLop);




            //lưu chitiet giảng dạy vừa nhập
            for (int j = 0; j <chiTietGiangDays.length ; j++) {
                if(chiTietGiangDays[i]==null){
                    chiTietGiangDays[i]=chiTietGiangDay;
                    break;
                }
            }
        }
        return chiTietGiangDays;
    }



//    private static void sapXepQLKKTheoTen(){
//        boolean coDulieuQLKK=false;
//        for (int i = 0; i < QLKEKHAIGIANGDAY.length; i++) {
//            if(QLKEKHAIGIANGDAY[i]!=null){
//                coDulieuQLKK=true;
//            }
//        }
//        if(!coDulieuQLKK){
//            System.out.println("Chưa có dữ liệu trong hệ thống, vui lòng tạo bảng kê khai giảng veien");
//            return;
//        }
//        sapXepDSTheoTen();
//        showQLKeKhaiGiangDay();
//    }

    private static void sapXepDSTheoTen(){
        int n = QLKEKHAIGIANGDAY.length;

        QLKeKhaiGiangDay temp;
        for (int i = 0; i < n; i++) {

            for (int j = i+1; j < n; j++) {
                QLKeKhaiGiangDay qlms1=QLKEKHAIGIANGDAY[i];

                QLKeKhaiGiangDay qlms2=QLKEKHAIGIANGDAY[j];
                if(qlms1 == null || qlms2 == null){
                   break;
                }
                if (qlms1.getGiangVien().getHoTen().compareTo(qlms2.getGiangVien().getHoTen())>0){
                    temp = QLKEKHAIGIANGDAY[i];
                    QLKEKHAIGIANGDAY[i]= QLKEKHAIGIANGDAY[j];
                    QLKEKHAIGIANGDAY[j]= temp;
                }

            }

        }
    }

    private static void sapXepDSTheoSoTietGiangDay(){
        int n = QLKEKHAIGIANGDAY.length;

        QLKeKhaiGiangDay temp;
        for (int i = 0; i < n; i++) {

            for (int j = i+1; j < n; j++) {
                QLKeKhaiGiangDay qlms1=QLKEKHAIGIANGDAY[i];

                ChiTietGiangDay[] chitietGD=qlms1.getChiTietGiangDay();
                ChiTietGiangDay chitiet = chitietGD[i];

                QLKeKhaiGiangDay qlms2=QLKEKHAIGIANGDAY[j];

                ChiTietGiangDay[] chitietGD2=qlms2.getChiTietGiangDay();
                ChiTietGiangDay chitiet2 = chitietGD2[j];
                if(qlms1 == null || qlms2 == null){
                    break;
                }
                if (chitiet.getMonHoc().getTongSoTiet()<chitiet2.getMonHoc().getTongSoTiet()){
                    temp = QLKEKHAIGIANGDAY[i];
                    QLKEKHAIGIANGDAY[i]= QLKEKHAIGIANGDAY[j];
                    QLKEKHAIGIANGDAY[j]= temp;
                }

            }

        }
    }

    private static void lapBangTinhLuong() {
        // kiểm tra xem trong ORDER đã có dữ liệu hay chưa
        boolean coDuLieuDS = false;
        for (int i = 0; i < QLKEKHAIGIANGDAY.length; i++) {
            if (QLKEKHAIGIANGDAY[i] != null) {
                coDuLieuDS = true;
            }
        }
        if (!coDuLieuDS) {
            System.out.println("Chưa có hóa đơn nào trong hệ thống, vui lòng tạo hóa đơn trước khi thực hiện tính năng này.");
            return;
        }

        for (int i = 0; i < QLKEKHAIGIANGDAY.length; i++) {
            QLKeKhaiGiangDay qlkkgd = QLKEKHAIGIANGDAY[i];
            if (qlkkgd == null) {
                continue;
            }
            double TienLuong = 0;
            ChiTietGiangDay[] chitietGD = qlkkgd.getChiTietGiangDay();
            for (int j = 0; j < chitietGD.length; j++) {
                ChiTietGiangDay chitiet = chitietGD[j];
                TienLuong += ((chitiet.getMonHoc().getMucKinhPhi()*chitiet.getMonHoc().getSoTietLyThuyet())
                        +((chitiet.getMonHoc().getMucKinhPhi()*0.7)*(chitiet.getMonHoc().getTongSoTiet()-chitiet.getMonHoc().getSoTietLyThuyet())))*(chitiet.getSoLop());
            }
                System.out.println("Gv " + qlkkgd.getGiangVien().getHoTen() + " Có tiền lương " + TienLuong + "VND");

        }
    }







}
