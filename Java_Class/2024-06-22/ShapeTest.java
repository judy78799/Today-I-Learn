package Test_chap10;

import java.util.ArrayList;
import java.util.List;


public class ShapeTest {
	
	
	public static void main(String[] args) {
		

		
		//면적이 12.0 이하인 빨간색 도형이 나타나도록 main 메서드 작성.
		
		//사각형
		List<Shape> area12Under = findShapeByType(Shape.shapes, "사각형");
		
		
		//면적
		List<Shape> shapeRectangle = findShapesByColorNArea(Shape.shapes, "빨간색", 12.0);
		
		//최종 출력 결과
		System.out.println("사각형 : " + area12Under);
		

		//최종 출력 결과
		System.out.println("빨간 도형 (면적<=12.0) : " + shapeRectangle);
		
		

		
	}//메인 메서드 끝
	
	
	
	
	
	
	
	//findShapeByType 메서드 -> type 값 반
	static List<Shape> findShapeByType(List<Shape> shapes, String type){
		//빈 리스트 초기화
		List<Shape> result = new ArrayList<Shape>();
		
		//배열을 하나씩 꺼내줌
		//shape 안에 shapes 배열을 담아줌
		for(Shape shape : shapes) {

			//면적이 12.0 이하인 빨간색 도형이 나타나도록 main 메서드 작성.
			if (shape.getType().equals("사각형")) {
				//빈 배열에 shape를 담아줘
				result.add(shape);
//				System.out.println(result);
			}
		}
		return result;
	}
	
	
	
	//findShapesByColorNArea 메서드 -> color와 area 값 반환
	static List<Shape> findShapesByColorNArea(List<Shape> shapes, String color, double area){
		
	List<Shape> result = new ArrayList<Shape>();
		
		//배열을 하나씩 꺼내줌
		for(Shape shape : shapes) {

			//면적이 12.0 이하인 빨간색 도형이 나타나도록 main 메서드 작성.
			if (shape.getColor().equals(color) && shape.getArea() <= area) {
				//빈 배열에 car를 담아줘
				result.add(shape);
//				System.out.println(result);
			}
		}
		return result;
		
		
	}
	
	
	
	//메서드
	
	static List<Shape> findShapes(List<Shape> shapes, String type, String color, Double area){
		
		//반환 할 List객체를 생성하고 리턴해줌
		List<Shape> result = new ArrayList<Shape>();
		
		System.out.println("사각형 : " + type);
		
	
		return result;
	}

}
