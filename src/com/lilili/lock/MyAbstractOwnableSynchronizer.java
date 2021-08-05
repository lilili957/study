package com.lilili.lock;

import java.io.Serializable;

/**
 * @Author LiYuan
 * @Date 2021/8/5
 **/
public abstract class MyAbstractOwnableSynchronizer implements Serializable {
    private static final long serialVersionUID = -8607520135494674885L;

    private transient Thread exclusiveOwnerThread;

    protected Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }

    protected void setExclusiveOwnerThread(Thread exclusiveOwnerThread) {
        this.exclusiveOwnerThread = exclusiveOwnerThread;
    }
}
