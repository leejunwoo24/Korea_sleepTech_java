package chapter10.practice02.repository;

import java.util.HashSet;
import java.util.Set;

import chapter10.practice02.entity.Item;

// 데이터 처리에 대한 메서드 : DB를 대신하는 저장소 역할
public class InMemoryItemRepository implements ItemRepository {
	private Set<Item> items = new HashSet<>();
	
	
	@Override
	public void addItem(Item item) {
		items.add(item);
		
	}

	@Override
	public void removeItem(String itemId) {
		Item target = null;
		
		for (Item item: items) {
			if(item.getId().equals(itemId)) {
				target = item; // 제거하고자하는 요소를 저장
				break;
			}
		}
		if(target != null) {
			items.remove(target);
		}
	}

	@Override
	public Item findById(String itemId) {
		for (Item item: items) {
			if(item.getId().equals(itemId)) {
				return item;
			}
		}
		return null;
	}

	@Override
	public Set<Item> findAll() {
		return items;
	}
	
}
