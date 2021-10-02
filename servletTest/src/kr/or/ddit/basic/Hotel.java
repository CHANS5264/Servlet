package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.util.Scanner;;

public class Hotel {

	private HashMap<Integer, Room> hotelMap;
	private String fileName = "D:/D_Other/김찬미_호텔경영.dat";
	private boolean dataChange;
	private Scanner sc;
	
	public Hotel(){
		hotelMap = load();
		sc = new Scanner(System.in);
		if(hotelMap == null) {
			hotelMap = new HashMap<>();
			
			for(int i = 2; i <= 4; i++){
				String roomType = null;
				switch(i){
				case 2:
					roomType = "싱글룸";
					break;
				case 3:
					roomType = "더블룸";
					break;
				case 4:
					roomType = "스위트룸";
					break;
				}
				for(int j = 1; j <= 9; j++){
					int roomNum = i * 100 + j;
					Room r = new Room(roomNum, roomType);
					hotelMap.put(roomNum, r);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new Hotel().hotelStart();
	}

	public int displayMenu(){
		System.out.println("-------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인   2.체크아웃   3.객실상태   0.업무종료");
		System.out.println("-------------------------------------------");
		System.out.print("선택 > ");
		
		int num = sc.nextInt();
		
		return num;
	}
	
	public void hotelStart(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*******************************************");
		System.out.println("	  호텔문을 열었습니다. 어서오세요!");
		System.out.println("*******************************************");
		System.out.println();
		
		while(true){
			int choice = displayMenu();
			switch(choice){
			case 1:	//체크인
				checkIn();
				break;
			case 2:	//체크아웃
				sheckOut();
				break;
			case 3:	//객실상태
				showRoom();
				break;
			case 0:
				if(dataChange == true) {
					System.out.println("데이터를 저장합니다.");
					save();
				}
				System.out.println("*******************************************");
				System.out.println("	            호텔문을 닫았습니다.");
				System.out.println("*******************************************");
				System.exit(0);
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요.");
			}
		}

	}
	
	//파일 읽어오기
	@SuppressWarnings("unchecked")
	private HashMap<Integer, Room> load() {
		HashMap<Integer, Room> hMap = null;
		File file = new File(fileName);
		if(!file.exists()) {
			return null;
		}
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(fileName))
			);
			hMap = (HashMap<Integer, Room>)ois.readObject();
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
			}
		}
		return hMap;
	}

	
	//저장
	private void save() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(fileName))
			);
			//Map객체를 파일로 저장한다.
			oos.writeObject(hotelMap);
			System.out.println();
			System.out.println("저장이 완료되었습니다.");
			
			dataChange = false;	//파일내용과 Map의 내용이 같아지므로 변경여부를 false로 설정한다.
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//사용했던 스트림 닫기
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//객실 상태
	private void showRoom(){
		System.out.println("-------------------------------------------");
		System.out.println("현재 객실 상태");
		System.out.println("-------------------------------------------");
		System.out.println("방 번호\t방 종류\t투숙객 이름");
		System.out.println("-------------------------------------------");
		
		ArrayList<Integer> roomNumList = new ArrayList<>(hotelMap.keySet());
		Collections.sort(roomNumList);	//방 번호를 오름차순으로 정렬
		for(int roomNum: roomNumList){
			Room r = hotelMap.get(roomNum);
			System.out.print(r.getRoomNum() + "\t" + r.getRoomType() + "\t");
			System.out.println(r.getGuestName() == null ? "   -" : r.getGuestName());
		}
		System.out.println("-------------------------------------------");
	}

	//체크인
	private void checkIn(){
		System.out.println("-------------------------------------------");
		System.out.println("		체크인 작업");
		System.out.println("-------------------------------------------");
		System.out.println("* 201 ~ 209: 싱글룸");
		System.out.println("* 301 ~ 309: 더블룸");
		System.out.println("* 401 ~ 409: 스위트룸");
		System.out.println("-------------------------------------------");
		System.out.print("방 번호 입력 >> ");
		int num = sc.nextInt();
		System.out.println();
		
		if(!hotelMap.containsKey(num)){
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		}
		
		if(hotelMap.get(num).getGuestName() != null){
			System.out.println(num + "호 객실은 이미 손님이 있습니다.");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 >> ");
		String name = sc.next();
		
		hotelMap.get(num).setGuestName(name);
		System.out.println("체크인이 완료되었습니다.");	
		dataChange = true;
		
	}

	//체크아웃
	private void sheckOut() {
		System.out.println("-------------------------------------------");
		System.out.println("		체크아웃 작업");
		System.out.println("-------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.print("방 번호 입력 >> ");
		int num = sc.nextInt();
		System.out.println();
		
		if(!hotelMap.containsKey(num)){
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		}
		
		if(hotelMap.get(num).getGuestName() == null){
			System.out.println(num + "호 객실에는 체크인한 손님이 없습니다.");
			return;
		}
		
		String name = hotelMap.get(num).getGuestName();
		hotelMap.get(num).setGuestName(null);
		System.out.println(num + "호 객실의 " + name + "님의 체크아웃을 완료하였습니다.");
		dataChange = true;
	}
}

class Room implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int roomNum;
	private String roomType;
	private String guestName;



	public Room(int roomNum, String roomType) {
		super();
		this.roomNum = roomNum;
		this.roomType = roomType;
	}


	public int getRoomNum() {
		return roomNum;
	}



	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}



	public String getRoomType() {
		return roomType;
	}



	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}



	public String getGuestName() {
		return guestName;
	}



	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}


	@Override
	public String toString() {
		return "member [roomNum=" + roomNum + ", roomName=" + roomType
				+ ", memName=" + guestName + "]";
	}

}
