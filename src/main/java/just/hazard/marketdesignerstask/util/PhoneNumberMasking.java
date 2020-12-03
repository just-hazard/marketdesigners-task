package just.hazard.marketdesignerstask.util;

public class PhoneNumberMasking {

    public static String masking(String phoneNumber) {
        char[] ch = phoneNumber.toCharArray();
        for(int i = 10; i < ch.length - 1; i ++){
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }
}
