package 스트림연습;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 스트림연습2 {
	public static List<Item> setData(){
		
		List<Item> itemList = new ArrayList<>();
		itemList.add(new Item(1001,"과자","새우깡",1500));
		itemList.add(new Item(1002,"음료수","사이다",1000));
		itemList.add(new Item(1003,"과자","고래밥",3000));
		itemList.add(new Item(1004,"음료수","콜라",500));
		itemList.add(new Item(1005,"고기","닭고기",18000));
		itemList.add(new Item(1006,"고기","돼지고기",20000));
		itemList.add(new Item(1004,"음료수","콜라",500));
		itemList.add(new Item(1005,"고기","닭고기",18000));
		itemList.add(new Item(1006,"고기","돼지고기",20000));
		
		return itemList;
		
	}
	
	public static void main(String[] args) {
		List<Item> itemList = setData();
		
		// 문제 1번 전체 출력
		System.out.println("================문제1================");
		itemList.stream()
				.forEach(System.out::println);
		System.out.println("================문제2================");
		// 문제 2번 중복된 데이터 제거 후 출력 
		itemList.stream()
				.distinct()
				.forEach(System.out::println);
		System.out.println("================문제3================");
		// 문제 3번 카테고리가 과자인 itemList 출력
		System.out.println("3-1");
		itemList.stream()
				.filter((item) -> item.getCategorayName().equals("과자"))
				.forEach(System.out::println);
		System.out.println("3-2");
		itemList.stream()
				.forEach(item -> {
					if (item.getCategorayName().equals("과자")) {
						System.out.println(item);
					}
				});
		System.out.println("================문제4================");
		// 문제 4번 카테고리가 고기인 item 갯수 출력
		int cnt =(int)itemList.stream()
							  .filter((item)-> item.getCategorayName().equals("고기"))
							  .count();
		System.out.println(cnt);
		System.out.println("================문제5================");
		// 문제 5번 가격이 10000원 이상인 값들의 아이템 list 만들기
		List<Item> temp = itemList.stream()
								  .filter((item)->(item.getPrice()>=10000))
								  .collect(Collectors.toList());
		temp.stream().forEach(System.out::println);
		System.out.println("================문제6================");
		// 문제 6번 카테고리가 고기인 아이템 이름들만 가져와서 String 배열로 만들기
		List<String> meat = itemList.stream()
								  .filter((item)->item.getCategorayName().equals("고기"))
								  .map(item->item.getItemName())
								  .collect(Collectors.toList());
		meat.stream().forEach(System.out::println);
		
	}
}