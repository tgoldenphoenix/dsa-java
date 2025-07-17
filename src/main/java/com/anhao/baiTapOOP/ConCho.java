package com.anhao.baiTapOOP;

import java.util.ArrayList;
import java.util.List;

// Việt Trí Đạo video so #02 seri OOP
public class ConCho {
    public String ten;
    public int tuoi;

    public void tuToChucSinhNhat() {
      System.out.println(ten + " da tự to chuc sinh nhat");
      tuoi++;
    }

     public void toChucSinhNhatConChoKhac(ConCho conCho) {
        System.out.println("to chức sinh nhat cho: " + conCho.ten);
        conCho.tuoi++;
     }

     public void anXuong(CucXuong cucXuong) {
       System.out.println(ten + " dang an " + cucXuong.ten);
     }

      public void anNhieuXuong(List<CucXuong> listXuong) {
        for (CucXuong cucXuong : listXuong) {
          System.out.println(ten + " dang an " + cucXuong.ten);
        }
      }

//     public List<CucPhan> anXuong3(List<CucXuong> listXuong) {
//
//     }

    public static void main(String[] args) {
      ConCho cho1 = new ConCho();
      cho1.ten = "Lu";
      cho1.tuoi = 2;

      ConCho cho2 = new ConCho();
      cho2.ten = "Bin";
      cho2.tuoi = 3;

//      cho2.tuToChucSinhNhat();
//      System.out.println(cho2.tuoi);

      CucXuong cucXuong = new CucXuong();
      cucXuong.ten = "T-bone";
      CucXuong cucXuong2 = new CucXuong();
      cucXuong2.ten = "a hard bone";
      CucXuong cucXuong3 = new CucXuong();
      cucXuong3.ten = "a soft bone";

//      cho1.anXuong(cucXuong);

      ArrayList<CucXuong> listXuong = new ArrayList<>();
      listXuong.add(cucXuong);
      listXuong.add(cucXuong2);
      listXuong.add(cucXuong3);

//      cho1.anNhieuXuong(listXuong);
    }
}

class CucXuong {
  public String ten;
}

class CucPhan {
  public String ten;
}
