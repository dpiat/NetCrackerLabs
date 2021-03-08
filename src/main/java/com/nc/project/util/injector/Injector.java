package com.nc.project.util.injector;

import com.nc.project.exception.InjectException;
import com.nc.project.util.CountSortersException;
import com.nc.project.util.CountSortersException;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

@Configuration(packages = {"com.nc.project.sorter.slow", "com.nc.project.util.validator.validatorsImpl"})
public class Injector {
    private static ArrayList<Class> configurationClasses;

    public Injector() throws InjectException {
        configurationClasses = new ArrayList<>();
        String[] pathPackages = this.getClass().getAnnotation(Configuration.class).packages();
        for (String pathPackage : pathPackages) {
            Class[] classes = ImplementationFinder.getImplementationClasses(pathPackage);
            configurationClasses.addAll(Arrays.asList(classes));
        }
    }

    /**
     * Метод этого класса принимает объект, если поле этого объекта имеет
     * анотацию "@AutoInjectable", то ищет реализацию в указанных пакетах,
     * создает и записывают ссылку на экземпляр созданного объекта
     *
     * @param <T> - тип передаваемого объекта
     * @param object - объект, который требует инъекции
     */
    public <T> T inject(T object) throws InjectException {
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
                            Object o = null;
                            try {
                                o = cl.newInstance();
                            } catch (InstantiationException | IllegalAccessException e) {
                                throw new InjectException(e.getMessage());
                            }
                            arrayList.add(o);
                        }
                    }
                    try {
                        field.set(object, arrayList);
                    } catch (IllegalAccessException e) {
                        throw new InjectException(e.getMessage());
                    }

                } else {
                    int cnt = 0;
                    Object o = null;
                    for (Class cl : configurationClasses) {
                        if (field.getType().isAssignableFrom(cl)) {
                            try {
                                o = cl.newInstance();
                            } catch (InstantiationException | IllegalAccessException e) {
                                throw new InjectException(e.getMessage());
                            }
                            cnt++;
                            if (cnt != 1) {
                                throw new InjectException("Found more than one implementation class");
                            }
                        }
                    }
                    if (o != null) {
                        try {
                            field.set(object, o);
                        } catch (IllegalAccessException e) {
                            throw new InjectException(e.getMessage());
                        }
                    }
                }
            }
        }
        return object;
    }


}
