package mawa.com.pl.springmvc.controller;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")
public class SessionClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cnt;

	private int maxIdleTime = 5 * 1000;
	private long lastAccessed;
	
	public void touch(){
		lastAccessed = System.currentTimeMillis();
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public boolean isValid(){
		return maxIdleTime > (System.currentTimeMillis() - lastAccessed);
	}
	
	public void reset(){
		cnt = 0;
		touch();
		
	}
}
