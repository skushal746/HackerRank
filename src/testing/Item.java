package testing;

import java.math.BigDecimal;
import java.util.List;

public class Item {
	
	public Item(int id, String name, BigDecimal price, List<String> categories) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.categories = categories;
	}

	private final int id;
	private final String name;
	private final BigDecimal price;
	private final List<String> categories;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public List<String> getCategories() {
		return categories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}
