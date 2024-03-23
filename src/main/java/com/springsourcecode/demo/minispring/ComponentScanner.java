package com.springsourcecode.demo.minispring;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class ComponentScanner {
    public static void scan(BeanFactory beanFactory) throws Exception {
        String url = "com/springsourcecode/test";
        List<File> classFile = getClassFile(url);
        for (File file : classFile) {
            String absolutePath = file.getAbsolutePath();
            String substring = absolutePath.substring(absolutePath.lastIndexOf("com"), absolutePath.lastIndexOf(".class"));
            String replace = substring.replace('/', '.');
            System.out.println(replace);

            Class<?> clz = Class.forName(replace);
            if (clz.isAnnotationPresent(Component.class)) {
                beanFactory.register(clz);
            }
        }
    }

    private static List<File> getClassFile(String url) throws Exception {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(url);
        Path path = Path.of(resource.toURI());

        try (Stream<Path> walk = Files.walk(path)) {
            List<File> list = walk.filter(p -> p.toString().endsWith(".class"))
                    .map(p -> p.toFile())
                    .toList();
            return list;
        } catch (IOException e) {
            throw new Exception(e);
        }
    }
}
