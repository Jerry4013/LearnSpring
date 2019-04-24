package springioc.class003;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IoCContainer {

    private Map<String, Object> beans = new ConcurrentHashMap<>();

    public Object getBean(String beanId){
        return beans.get(beanId);
    }

    public void setBeans(Class<?> clazz, String beanId, String... paramBeanId){
        Object[] paramValues = new Object[paramBeanId.length];
        for (int i = 0; i < paramBeanId.length; i++) {
            paramValues[i] = beans.get(paramBeanId[i]);
        }

        Object bean = null;

        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean = constructor.newInstance(paramValues);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        if (bean == null) {
            throw new RuntimeException("Cannot find proper constructor to create bean");
        }
        beans.put(beanId, bean);

    }
}
