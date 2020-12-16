package com.nc.project.util.injector;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

@Configuration(packages = {"com.nc.project.sorter.slow", "com.nc.project.util.validator.validatorsImpl"})
public class Injector {
    private static ArrayList<Class> configurationClasses;

    public Injector() throws IOException, ClassNotFoundException {
        configurationClasses = new ArrayList<>();
        String[] pathPackages = this.getClass().getAnnotation(Configuration.class).packages();
        for (String pathPackage : pathPackages) {
            Class[] classes = ImplementationFinder.getImplementationClasses(pathPackage);
            configurationClasses.addAll(Arrays.asList(classes));
        }
    }

    /**
     * Метод этого класса принимает репозиторий, если поле имеет
     * анотацию "@AutoInjectable", то ищет реализацию в файле properties,
     * создает и записывают ссылку на экземпляр нужного класса
     *
     * @param <T> - тип передаваемого объекта
     * @param object - объект, который требует инъекции
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public <T> T inject(T object) throws Exception {
        Class<? extends Object> objectClass = object.getClass();
        Field[] fields = objectClass.getDeclaredFields();
        for (Field field : fields) {
            Annotation annotation = field.getAnnotation(AutoInjectable.class);
            field.setAccessible(true);
            if (annotation != null) {
                if (field.getType().isAssignableFrom(ArrayList.class)) {
                    ArrayList<Object> arrayList = new ArrayList<>();
                    for (Class cl : configurationClasses) {
                        if (field.getAnnotation(AutoInjectable.class).parameter().isAssignableFrom(cl)) {
                            Object o = cl.newInstance();
                            arrayList.add(o);
                        }
                    }
                    field.set(object, arrayList);

                } else {
                    int cnt = 0;
                    Object o = null;
                    for (Class cl : configurationClasses) {
                        if (field.getType().isAssignableFrom(cl)) {
                            o = cl.newInstance();
                            cnt++;
                            if (cnt != 1) {
                                throw new Exception ( "Find more than one implementation class" );
                            }
                        }
                    }
                    if (o != null)
                        field.set(object, o);
                }
            }
        }
        return object;
    }


}
