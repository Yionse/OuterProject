import org.springframework.util.DigestUtils;

public class Test {

    @org.junit.jupiter.api.Test
    public void UploadTest(){
        String s = "12313213"+".jpg";
        System.out.println(s);

    }
    @org.junit.jupiter.api.Test
    public void encodeMd5(){
        String Md5Infore = " myth have shock rather retreat another wreck daughter cancel coffee cement wing";
        String s = DigestUtils.md5DigestAsHex(Md5Infore.getBytes());
        System.out.println(s);
        System.out.println();
        System.out.println();
    }
}
