package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Test countVietnameseAccentedChars
        String input = "hwfdawhwhcoomddfgwdc";
        int count = countVietnameseAccentedChars(input);
        System.out.println("Number of Vietnamese accented characters: " + count);
    }

    public static int countVietnameseAccentedChars(String input) {
        // Tạo từ điển ánh xạ từ kiểu gõ telex đến chữ cái có dấu
        Map<String, String> telexToAccented = new HashMap<>();
        telexToAccented.put("aw", "ă");
        telexToAccented.put("aa", "â");
        telexToAccented.put("dd", "đ");
        telexToAccented.put("ee", "ê");
        telexToAccented.put("oo", "ô");
        telexToAccented.put("ow", "ơ");
        telexToAccented.put("w", "ư");

        int count = 0;

        // Duyệt qua chuỗi nhập vào để tìm và đếm các chữ cái có dấu
        for (int i = 0; i < input.length(); i++) {
            // Kiểm tra từng mẫu của kiểu gõ telex từ dài đến ngắn
            for (Map.Entry<String, String> entry : telexToAccented.entrySet()) {
                String telex = entry.getKey();
                if (i + telex.length() <= input.length() && input.substring(i, i + telex.length()).equals(telex)) {
                    count++;
                    i += telex.length() - 1; // Di chuyển chỉ số để bỏ qua phần đã khớp
                    break;
                }
            }
        }

        return count;
    }
}
