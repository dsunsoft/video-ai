package com.dsunsoft.core.lock;

/**
 * 锁定回调接口
 * 
 * @author ygm
 *
 */
public interface LockedCallback {

	public Object onGetLock() throws InterruptedException, Exception;

	public Object onTimeout() throws InterruptedException;
}
