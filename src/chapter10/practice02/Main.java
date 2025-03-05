package chapter10.practice02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chapter10.practice02.entity.Electronics;
import chapter10.practice02.entity.Furniture;
import chapter10.practice02.entity.Item;
import chapter10.practice02.repository.InMemoryItemRepository;
import chapter10.practice02.repository.ItemRepository;
import chapter10.practice02.service.InventoryService;
import chapter10.practice02.service.InventoryServiceImpl;

/*
 	== Inventory Management System ==
 	: 다양한 상품을 관리하는 재고 관리 시스템
 	
 	1) 프로젝트 구조
 	- Main 파일
 		: 프로그램 실행의 진입점	
 	- entity 폴더 (데이터 모델 정의)
 		: 데이터(상품)를 표현하는 클래스 정의 - 객체의 속성과 동작을 포
 	- service 폴더 (비즈니스 로직 처리)
 		: 상품 추가, 조회, 수정, 삭제와 같은 비즈니스로직을 처리(직접적인 데이터 조작)
 	- repository 폴더 (데이터 저장소 역할)
  		: 데이터를 저장하고 검색하는 기능을 제공하는 클래스 정의
  
  	2) 요구사항
  	- 기능
  		상품(Item) 추가, 수정, 삭제, 카테고리 상품 검색, 가격 또는 이름 등으로 정렬
  	- 사용 컬렉션 프레임워크
  		set: 상품 관리(중복 상품 방지)
  		Map: 카토고레별 상품 분류(Key: 카테고리명, Value: 상품 목록)
  	- 추상 클래스
  		Item: 모든 상품의 공통 필드 포함
  	- 인터페이스
  		Discountable: 할인 로직 제공
 */
public class Main {
	public static void main(String[] args) {
//		ItemRepository repository = new InMemoryItemRepository();
//		InventoryService inventoryService = new InventoryService
		InventoryService inverntoryService = new InventoryServiceImpl(new InMemoryItemRepository());
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println();
			System.out.println("=== Inventory Management System ===");
			System.out.println("1. Add Item");
			System.out.println("2. Update Item Price");
			System.out.println("3. Delete Item");
			System.out.println("4. View Item by Category");
			System.out.println("5. View All Items");
			System.out.println("6. Exit");
			System.out.println("choose an option: ");
			
			try {
				int choice = Integer.parseInt(sc.nextLine());
				
				switch (choice) {
				case 1:
					addItem(inverntoryService, sc);
					break;
				case 2:
					updateItemPrice(inverntoryService, sc);
					break;
				case 3:
					deleteItem(inverntoryService, sc);
					break;
				case 4:
					viewItemsByCategory(inverntoryService, sc);
					break;
				case 5:
					viewAllItems(inverntoryService);
					break;
				case 6:
					System.out.println("=== Exiting ===");
					sc.close();
					return;
				default:
					System.out.println("Invalid choice, please try again");
				}
				
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			
		}
	}

	private static void addItem(InventoryService inventoryService, Scanner sc) {
		System.out.println("Enter Item Id: ");
		String id = sc.nextLine();
		System.out.println("Enter Item Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Item Price");
		int price = sc.nextInt();
		System.out.println("Enter Item Quantity");
		int Quantity = sc.nextInt();
		sc.nextLine(); // 버퍼 소비
		System.out.println("Enter Item category");
		String category = sc.nextLine();
		
		if(category.equalsIgnoreCase("Electronics")) {
			System.out.println("Enter Barnd: ");
			String brand = sc.nextLine();
			System.out.println("Enter Warranty (months) ");
			int warranty = sc.nextInt();
			Item electronics = new Electronics(id, name, price, Quantity, brand, warranty);
			inventoryService.addItem(electronics);
		} else if (category.equalsIgnoreCase("Furniture")) {
		 	System.out.println("Enter Material: ");
		 	String material = sc.nextLine();
		 	System.out.println("Enter Size: ");
		 	String size = sc.nextLine();
		 	Item furniture = new Furniture(id, name, price, Quantity, material, size);
		 	inventoryService.addItem(furniture);
		} else{
			System.out.println("Invalid category, Item not added");
		}
	}
	
	private static void updateItemPrice(InventoryService inventoryService, Scanner sc) {
		System.out.println("Enter Item ID to update price");
		String id = sc.nextLine();
		System.out.println("Enter Item new Price: ");
		int newPrice = sc.nextInt();
		sc.nextLine();
		inventoryService.updateItemPrice(id, newPrice);
		System.out.println("Item price updated successfully");
	}
	
	private static void deleteItem(InventoryService inventoryService, Scanner sc) {
		System.out.println("Enter Item ID to delete");
		String id = sc.nextLine();
		inventoryService.deleteItem(id);
		System.out.println("Item deleted successfully");
	}
	
	private static void viewItemsByCategory(InventoryService inventoryService, Scanner sc) {
		System.out.println("Enter Category to View (Electronics/Furniture)");
		String category = sc.nextLine();
		List<Item> items = inventoryService.getItemByCategory(category);
		
		if(items.isEmpty()) {
			System.out.println("No items found in this category");
		} else {
			System.out.println("Items in category: " + category + " >>> ");
			for(Item item: items) {
				System.out.println(item);
			}
		}
	}
	
	private static void viewAllItems(InventoryService inventoryService) {
		List<Item> allItems = new ArrayList<Item>(inventoryService.getItemByCategory("Electronics"));
		
		// 컬렉션타입데이터A.addAll(컬렉션타입데이터B);
		// : A의 구조에 B의 데이터를 각각 요소로 삽입
		
		// a = [1, 2, 3]
		// b = [4, 5, 6]
		// a.add(b)
		// : [1, 2, 3, [4, 5, 6]]
		// : [1, 2, 3, 4, 5, 6]
		allItems.addAll(inventoryService.getItemByCategory("Furniture"));
		
		if(allItems.isEmpty()) {
			System.out.println("No items available");
		} else {
			System.out.println("=== All Items ===");
			for (Item item: allItems) {
				System.out.println(item);
			}
		}
	}
}
