package com.nc.project.util.injector;

import com.nc.project.exception.InjectException;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

public class ImplementationFinder {
    /**
     * Метод принимает название пакета и ищет в нем
     * имплементирующие классы
     *
     * @param packageName название пакета
     * @return имплементирующие классы
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static Class[] getImplementationClasses(String packageName)
            throws InjectException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = null;
        try {
            resources = classLoader.getResources(path);
        } catch (IOException e) {
            throw new InjectException(e.getMessage());
        }
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<Class>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes.toArray(new Class[classes.size()]);
    }

    /**
     * Рекурсивный метод, используемый для поиска всех классов в данном каталоге и подкаталогах
     *
     * @param directory директория
     * @param packageName название пакета
     * @return имплементирующие классы
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName) throws InjectException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                try {
                    classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
                } catch (ClassNotFoundException e) {
                    throw new InjectException(e.getMessage());
                }
            }
        }
        return classes;
    }

}
