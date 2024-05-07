package me.whiteship;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa {

    public static void main(String[] args) {
        /* 이걸 실행하면 소스코드와 상관없이 바이트코드가 바뀌어있기 때문에 이제 Rabbit이 나오게 됨 */
//        try {
//            new ByteBuddy().redefine(Moja.class)
//                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
//                    .make().saveIn(new File("/Users/jung-eui-jin/myProjects/lecture/the-java-code-manipulation/target/classes/"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(new Moja().pullOut());
    }
}

