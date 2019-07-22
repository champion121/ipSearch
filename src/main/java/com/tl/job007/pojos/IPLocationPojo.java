package com.tl.job007.pojos;

import java.io.Serializable;

import com.tl.job007.utils.IPUtil;

/**
 * ip-location对象的封装类
 * 
 * @author tianliang
 *
 * @date 2019年6月3日
 */
public class IPLocationPojo implements Comparable<IPLocationPojo>, Serializable {

	@Override
	public String toString() {
		return "IPLocationPojo [startIP=" + startIP + ", endIP=" + endIP
				+ ", location=" + location + ", startIPLong=" + startIPLong
				+ ", endIPLong=" + endIPLong + "]";
	}

	@Override
	public int compareTo(IPLocationPojo o) {
		return this.startIPLong - o.startIPLong > 0 ? 1 : 0;
		// return new Long(this.startIPLong).compareTo(new Long(o.startIPLong));
	}

	private String startIP;
	private String endIP;
	private String location;

	private long startIPLong;
	private long endIPLong;

	public long getStartIPLong() {
		return startIPLong;
	}

	public void setStartIPLong(long startIPLong) {
		this.startIPLong = startIPLong;
	}

	public long getEndIPLong() {
		return endIPLong;
	}

	public void setEndIPLong(long endIPLong) {
		this.endIPLong = endIPLong;
	}

	public IPLocationPojo(String startIP, String endIP, String location) {
		super();
		this.startIP = startIP;
		this.endIP = endIP;
		this.location = location;
		// 同时把startIP的long形式转化出来，并赋值给startIPLong
		this.startIPLong = IPUtil.ipToLong(this.startIP);
		this.endIPLong = IPUtil.ipToLong(this.endIP);
	}

	public String getStartIP() {
		return startIP;
	}

	public void setStartIP(String startIP) {
		this.startIP = startIP;
	}

	public String getEndIP() {
		return endIP;
	}

	public void setEndIP(String endIP) {
		this.endIP = endIP;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
