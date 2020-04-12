package com.neusoft.core.task;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.task.AsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * <p>异步线程池</p>
 * <p>创建日期：2018-04-27</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class ScAsyncTaskExecutor implements AsyncTaskExecutor, InitializingBean, DisposableBean {

    private final AsyncTaskExecutor executor;

    public ScAsyncTaskExecutor(AsyncTaskExecutor executor) {
        this.executor = executor;
    }

    @Override
    public void destroy() throws Exception {
        if (executor instanceof DisposableBean) {
            DisposableBean bean = (DisposableBean) executor;
            bean.destroy();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (executor instanceof InitializingBean) {
            InitializingBean bean = (InitializingBean) executor;
            bean.afterPropertiesSet();
        }
    }

    @Override
    public void execute(Runnable task, long startTimeout) {
        executor.execute(task, startTimeout);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return executor.submit(task);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return executor.submit(task);
    }

    @Override
    public void execute(Runnable task) {
        executor.execute(task);
    }
}
