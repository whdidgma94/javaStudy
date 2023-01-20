package 제네릭클래스;

class MyArrayList {
	// size() add(삽입) add(추가) set() remove() clear()
	
	boolean checkIdx1(int idx, int[] list) {
		boolean check=true;
		try {
			if(idx<0||idx>=list.length) {
				throw new Exception("인덱스 범위 오류");
			}
		}catch(Exception e) {
			check=false;
			System.err.println(e.getMessage());
		}
		return check;
	}
	
	boolean checkIdx2(int idx, int[] list) {
		boolean check=true;
		try {
			if(idx<0||idx>list.length) {
				throw new Exception("인덱스 범위 오류");
			}
		}catch(Exception e) {
			check=false;
			System.err.println(e.getMessage());
		}
		return check;
	}
	
	String printList(int[] list) {
		if (list == null) {
			return "[]";
		}
		String data = "";
		for (int i = 0; i < list.length; i++) {
			data += list[i];
			if (i != list.length - 1)
				data += ", ";
		}
		return "[" + data + "]";
	}

	int size(int[] list) {
		if (list == null)
			return 0;
		return list.length;
	}

	int[] add(int num, int[] list) {
		if (list == null) {
			list = new int[1];
			list[0] = num;
		} else {
			int[] temp = new int[list.length + 1];
			for (int i = 0; i < list.length; i++) {
				temp[i] = list[i];
			}
			temp[temp.length - 1] = num;
			list = temp;
		}
		return list;
	}

	int[] add(int num, int idx, int[] list) {
		if (checkIdx2(idx, list)) {
			int[] temp = new int[list.length + 1];
			for (int i = 0; i < list.length; i++) {
				if (i == idx) {
					temp[i] = num;
					temp[i + 1] = list[i];
				} else if (i < idx) {
					temp[i] = list[i];
				} else {
					temp[i + 1] = list[i];
				}
			}
			if(idx==list.length) {
				temp[list.length]=num;
			}
			return temp;
		} else {
			return list;
		}
	}

	void set(int idx, int num, int[] list) {
		if (checkIdx1(idx, list)) {
			list[idx] = num;
		}
	}

	int[] remove(int idx, int[] list) {

		if (checkIdx1(idx, list)) {

			int[] temp = new int[list.length - 1];
			int tIdx = 0;
			for (int i = 0; i < list.length; i++) {
				if (i != idx) {
					temp[tIdx] = list[i];
					tIdx++;
				}
			}
			return temp;
		} else {
			return list;
		}
	}

	int[] clear(int[] list) {
		return null;
	}
}

public class 어레이리스트예제 {

	public static void main(String[] args) {

		MyArrayList myList = new MyArrayList();
		int[] arr = null;
		System.out.println(myList.size(arr)); // 0
		arr = myList.add(10, arr);
		System.out.println(myList.printList(arr)); // [10]
		arr = myList.add(20, arr);
		System.out.println(myList.printList(arr)); // [10,20]
		System.out.println(myList.size(arr)); // 2
		arr = myList.add(100, 2, arr);
		System.out.println(myList.printList(arr)); // [10,20,100]
		arr = myList.add(200, 0, arr);
		System.out.println(myList.printList(arr)); // [200,10,20,100]
		arr = myList.remove(0, arr);
		System.out.println(myList.printList(arr)); // [10,20,100]
		arr = myList.clear(arr);
		System.out.println(myList.printList(arr)); // []
		System.out.println(myList.size(arr)); // 0
		arr = myList.add(10, arr);
		System.out.println(myList.printList(arr));
		arr = myList.add(10, -1,arr);
		
	}

}
