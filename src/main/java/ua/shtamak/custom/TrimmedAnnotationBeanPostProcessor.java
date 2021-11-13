package ua.shtamak.custom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import ua.shtamak.custom.annotation.Trimmed;

public class TrimmedAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Trimmed.class)) {
            var enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);
            enhancer.setInterfaces(beanClass.getInterfaces());
            MethodInterceptor interceptor = (object, method, args, methodProxy) -> {
                for (int i = 0; i < args.length; i++) {
                    if (args[i].getClass() == String.class) {
                        args[i] = ((String) args[i]).trim();
                    }
                }
                var response = methodProxy.invokeSuper(object, args);
                if (response != null && response.getClass() == String.class) {
                    return ((String) response).trim();
                }
                return response;
            };
            enhancer.setCallback(interceptor);
            return beanClass.cast(enhancer.create());
        }
        return bean;
    }

}
