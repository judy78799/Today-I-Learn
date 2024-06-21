package com.keduit;

public class _01_Rectangle implements Comparable<_01_Rectangle>{
	
	private int width;
	private int height;
	
	_01_Rectangle(int width,int height){
		this.width = width;
		this.height = height;
	}
	
	//면적 구하는 메서드
	public int findArea() {
		return width * height;
	}
	
	
	@Override
	public String toString() {
		return String.format("사각형[폭=%d, 높이=%d]", width, height);
	}

	@Override
	public int compareTo(_01_Rectangle o) {
//		return this.findArea() > o.findArea() ? 1 : (this.findArea() < o.findArea() ? -1 : 0);
		
//		return this.findArea() - o.findArea();	//오름차순 (asc)
		return o.findArea() - this.findArea();	//내림차순 (desc)
	}
	
	



}
