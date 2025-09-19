package com.anhao.basic_syntax;

public class LearnString {
    public static void main(String[] args) {
        String a = "a";
        a.concat("b"); //concat: hàm nối chuỗi
//        System.out.println(a); // "a"
        // Vì sao nó chỉ in ra được chữ a mà ko in ra được ab?
        // Vì đối tượng String được sinh ra tại dòng số 6
        // người ta gọi là đối tượng bất biến.

        // You must do it this way
        // This is re-assign, reference variable a point to a new String object
        // .concat() return a new String object
        a = a.concat("a");

        //=====================================

        String tableName="", id="";
        String sql = "SELECT * FROM " + tableName + " WHERE id=" + id;
        // Viết như thế này nghĩa là chúng ta đã tạo ra bao nhiêu đối tượng của lớp String rồi?
        // chúng ta đã vô tình tạo ra 4 đối tượng của class String
        // trong khi đó chúng ta chỉ sử dụng đúng 1 đối tượng duy nhất đói là đối tượng sau cùng
        // nghĩa là chúng ta đã tạo ra được 3 đối tượng RÁC trong bộ nhớ

        a = "a";
        String b = "a";
        // equals và ==
        // equal là so sánh nội dung của 2 objects String
        // == là so sánh địa chỉ của 2 reference variables to a String object
//        System.out.println(a.equals(b)); // true
//        System.out.println(a == b);// true
        // Ra kết quả true true
        // Meaning chỉ sinh ra only one String object, chứa chữ "a"

        // => Java makes String immutable in order to save memory space when having multiple
        // Strings with the same content

        // tức là, nếu người dùng khai báo các chuỗi có nội dung y hệt nhau
        // thì java nó sẽ ko tạo ra đối tượng String mới
        // mà tận dụng lại đối tượng String cũ.
        // Ý tưởng này lúc đầu nghe rất là tuyệt vời
        // nhưng sau đó thì Java nó phát hiện là nó bị sai rồi
        // nên nó sửa sai bằng cách tạo ra StringBuffer và StringBuilder

        StringBuffer sb = new StringBuffer("a");
        sb.append("b");
        System.out.println(sb);

        StringBuilder builder = new StringBuilder("an");
        builder.append(" hao");
        System.out.println(builder);

        // Phải làm như vầy
        StringBuffer sql2 = new StringBuffer("SELECT * FROM ").append(tableName).append(" WHERE id=").append(id);
        
    }
}
