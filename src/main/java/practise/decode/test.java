package practise.decode;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        final BASE64Encoder encoder = new BASE64Encoder();
        final BASE64Decoder decoder = new BASE64Decoder();
        final String text = "字串文字";
        final byte[] textByte = text.getBytes("UTF-8");
//编码
        final String encodedText = encoder.encode(textByte);
        System.out.println(encodedText);
//解码
        System.out.println(new String(decoder.decodeBuffer(encodedText), "UTF-8"));

    }
}
