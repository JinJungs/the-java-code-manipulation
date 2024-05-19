package me.whiteship.section2;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App {

    public static void main(String[] args) throws ClassNotFoundException {
        /* 클래스 가져오기 */
        /* (1) heap 메모리에 로드된 클래스 정보에서 가져오기 */
        Class<Book> bookClass = Book.class;

        /* (2) 인스턴스에서 가져오기 */
        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        /* (3) 문자열로 가져오기 */
        Class<?> bClass = Class.forName("me.whiteship.section2.Book");

        /* 멤버 가져오기 */
        /* getFields - public field 만 가져옴 */
        Arrays.stream(bookClass.getFields()).forEach(System.out::println); // d

        /* getDeclaredFields - 접근제한자 상관없이 다 가져옴 */
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true); // 리플렉션으로 접근제한자 무시
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        });

        /* getMethods - 메서드 가져오기 */
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        /* 부모클래스 */
        System.out.println(MyBook.class.getSuperclass());

        /* 상속받은 인터페이스 */
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        /* 접근제한자 확인 */
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });
    }
}
